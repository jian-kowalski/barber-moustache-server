package br.com.jiankowalski.domain.repository;

import br.com.jiankowalski.domain.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CustomRepository<Client, String> {}
