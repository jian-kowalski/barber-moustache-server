package br.com.jiankowalski.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ClientInput {
  @NotBlank
  @Size(min = 4, max = 40)
  private String name;

  @Email
  private String email;

  @Size(min = 10, max = 11)
  @NotBlank
  private String phone;
}
