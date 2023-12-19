package com.matheusc1.ecommerce.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @GetMapping
  public List<ClientModel> getAll() {
    return clientService.getAll();
  }

  @GetMapping("/{id}")
  public ClientModel getById(@PathVariable Long id) {
    return clientService.getById(id);
  }

  @PostMapping
  public ClientModel create(@RequestBody ClientModel client) {
    return clientService.create(client);
  }

  @PutMapping("/{id}")
  public ClientModel update(@PathVariable Long id, @RequestBody ClientModel client) {
    return clientService.update(id, client);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    clientService.delete(id);
  }
}
