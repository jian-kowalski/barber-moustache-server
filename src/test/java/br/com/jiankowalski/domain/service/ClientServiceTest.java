package br.com.jiankowalski.domain.service;

import br.com.jiankowalski.domain.exception.NotFoundException;
import br.com.jiankowalski.domain.repository.ClientRepository;
import br.com.jiankowalski.util.ClientFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith({SpringExtension.class})
@ContextConfiguration(classes = {ClientService.class})
class ClientServiceTest {
  @Autowired private ClientService clientService;

  @MockBean private ClientRepository clientRepository;

  @Test
  void deleteComSucesso() {
    Mockito.when(clientRepository.findById(Mockito.any(String.class)))
        .thenReturn(ClientFactory.criarClientValido());
    var client = clientService.findById("62b3730b1a9bf76859db5782");
    assertDoesNotThrow(() -> clientService.removeClient(client.getId()));
  }

  @Test
  void deleteNotFound() {
    Mockito.when(clientRepository.findById(Mockito.any(String.class)))
        .thenThrow(NotFoundException.class);
    assertThrows(
        NotFoundException.class, () -> clientService.removeClient("62b3730b1a9bf79999db5782"));
  }

  @Test
  void naoDeveLancarExceptionAoIncluirComValorValido() {
    Mockito.when(clientRepository.findById(Mockito.any(String.class)))
        .thenReturn(ClientFactory.criarClientValido());
    var client = clientService.findById("62b3730b1a9bf76859db5782");
    Assertions.assertDoesNotThrow(() -> clientService.save(client));
  }
}
