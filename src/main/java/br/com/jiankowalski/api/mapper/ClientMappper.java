package br.com.jiankowalski.api.mapper;

import br.com.jiankowalski.api.model.ClientModel;
import br.com.jiankowalski.api.model.input.ClientInput;
import br.com.jiankowalski.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper
public interface ClientMappper {

  ClientMappper INSTANCE = Mappers.getMapper(ClientMappper.class);

  Client inputToDomain(ClientInput newClient);

  ClientModel domaniToModel(Client client);

  List<ClientModel> clientsToModel(List<Client> clients);

  default Page<ClientModel> clientsPageToModel(Page<Client> clients) {
    return clients.map(this::domaniToModel);
  }

  void updateClient(@MappingTarget Client product, ClientInput newClient);
}
