package br.com.jiankowalski.util;

import br.com.jiankowalski.api.model.input.ClientInput;
import br.com.jiankowalski.domain.model.Client;

import java.util.Optional;

public class ClientFactory {

  public static ClientInput criarClientInputValido() {
    var clientInput = new ClientInput();
    clientInput.setName("Computador");
    clientInput.setPhone("Ideal para PDV; Baixo consumo de Energia;");
    return clientInput;
  }

  public static Optional<Client> criarClientValido() {
    var client = new Client();
    client.setId("62b3730b1a9bf76859db5782");
    client.setName("Computador");
    return Optional.of(client);
  }

  public static Optional<Client> criarProductInValido() {
    var client = new Client();
    client.setId("62b3730b1a9bf76859db5782");
    client.setName("Computador");
    return Optional.of(client);
  }
}
