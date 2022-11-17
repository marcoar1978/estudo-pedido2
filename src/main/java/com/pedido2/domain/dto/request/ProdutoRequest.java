package com.pedido2.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    @NotEmpty
    private String nome;

    @NotNull
    private Double valor;

    @NotNull
    private Integer desconto;

    @NotNull
    private Integer categoriaProdutoId;
}
