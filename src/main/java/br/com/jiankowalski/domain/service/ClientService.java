package br.com.jiankowalski.domain.service;

import br.com.jiankowalski.domain.exception.NotFoundException;
import br.com.jiankowalski.domain.model.Client;
import br.com.jiankowalski.domain.repository.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
  private final ClientRepository clientRepository;

  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public List<Client> findAll() {
    return clientRepository.findAll();
  }

  public Client findById(String clientId) {
    return clientRepository
        .findById(clientId)
        .orElseThrow(() -> new NotFoundException("client", clientId));
  }

  public Client save(Client client) {
    return clientRepository.save(client);
  }

  public void removeClient(String clientId) {
    clientRepository.delete(findById(clientId));
  }

  public Page<Client> getByPaginable(Pageable pageable) {
    return clientRepository.getByPaginator(pageable);
  }
}
