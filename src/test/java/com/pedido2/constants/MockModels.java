package com.pedido2.constants;

import com.pedido2.domain.dto.request.CategoriaDto;
import com.pedido2.domain.entity.CategoriaProduto;

public class MockModels {

    public static final CategoriaDto CATEGORIA_DTO_REQUEST = new CategoriaDto(null, "Livros");

    public static final CategoriaDto CATEGORIA_DTO_INSERT = new CategoriaDto(1, "Livros");

    public static final CategoriaDto CATEGORIA_DTO_NOME_INVALIDO = new CategoriaDto(null, "");

    public static final CategoriaProduto CATEGORIA_PRODUTO = new CategoriaProduto(1, "Livros", null);
}
