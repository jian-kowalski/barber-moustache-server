package br.com.jiankowalski;

import br.com.jiankowalski.infrastructure.CustomRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(repositoryBaseClass = CustomRepositoryImpl.class)
public class BarberMoustache {

  public static void main(String[] args) {
    SpringApplication.run(BarberMoustache.class, args);
  }
}
