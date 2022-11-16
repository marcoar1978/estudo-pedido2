package com.pedido2.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProdutoRequestDto {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull

    @NotNull
    @Min(0)
    private Double valor;

    @NotNull
    @Min(0)
    private Integer desconto;

    @NotNull
    private Integer categoriaProdutoId;
}
