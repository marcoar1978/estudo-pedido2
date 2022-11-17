package com.pedido2.domain.dto.response;

import com.pedido2.domain.entity.CategoriaProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoSingleResponse {

    private Integer id;

    private String nome;

    private Double valor;

    private Integer desconto;

    private CategoriaProdutoListResponse categoria;
}
