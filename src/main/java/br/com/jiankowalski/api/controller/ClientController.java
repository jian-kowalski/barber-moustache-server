package br.com.jiankowalski.api.controller;

import br.com.jiankowalski.api.mapper.ClientMappper;
import br.com.jiankowalski.api.model.ClientModel;
import br.com.jiankowalski.api.model.input.ClientInput;
import br.com.jiankowalski.domain.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

  private final ClientMappper clientMappper;

  private final ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientMappper = ClientMappper.INSTANCE;
    this.clientService = clientService;
  }

    @GetMapping
    public List<ClientModel> listClients() {
      return clientMappper.clientsToModel(clientService.findAll());
    }

//  @GetMapping
//  public Page<ClientModel> listClients(Pageable pageable) {
//    return clientMappper.clientsPageToModel(clientService.getByPaginable(pageable));
//  }

  @GetMapping("/{clientId}")
  public ClientModel findById(@PathVariable String clientId) {
    return clientMappper.domaniToModel(clientService.findById(clientId));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ClientModel addClient(@RequestBody @Valid ClientInput clientInput) {
    var client = clientMappper.inputToDomain(clientInput);
    return clientMappper.domaniToModel(clientService.save(client));
  }

  @PutMapping("/{clientId}")
  public ClientModel alterClientById(
      @PathVariable String clientId, @RequestBody @Valid ClientInput clientInput) {
    var client = clientService.findById(clientId);
    clientMappper.updateClient(client, clientInput);
    return clientMappper.domaniToModel(clientService.save(client));
  }

  @DeleteMapping("/{clientId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void removeClientById(@PathVariable String clientId) {
    clientService.removeClient(clientId);
  }
}
