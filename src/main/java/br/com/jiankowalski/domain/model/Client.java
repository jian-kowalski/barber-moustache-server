package br.com.jiankowalski.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Client {

  public static final int VALOR_MINIMO = 3;

  @EqualsAndHashCode.Include @Id private String id;

  private String name;

  private String email;

  private String phone;
}
