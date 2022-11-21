package com.pedido2.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    @NotEmpty
    private String nome;

    @NotNull
    private String doc;

    @NotNull
    private String email;

    @NotNull
    private Boolean desconto;
}
