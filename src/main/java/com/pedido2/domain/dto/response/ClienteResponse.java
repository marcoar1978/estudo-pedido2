package com.pedido2.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private Integer id;
    private String nome;
    private String doc;
    private String email;
    private Boolean desconto;
}
