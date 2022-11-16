package com.pedido2.domain.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteTestDTO {


    @NotEmpty
    @Length(min = 5, max = 80)
    private String nome;

    @NotBlank
    private String email;

    @NotNull
    private String telefone;
}
