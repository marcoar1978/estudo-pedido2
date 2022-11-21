package com.pedido2.constants;

import com.pedido2.domain.dto.request.CategoriaDto;
import com.pedido2.domain.dto.request.ProdutoRequest;
import com.pedido2.domain.dto.response.CategoriaProdutoListResponse;
import com.pedido2.domain.dto.response.ProdutoSingleResponse;
import com.pedido2.domain.entity.CategoriaProduto;
import com.pedido2.domain.entity.Produto;

public class MockModels {
    //Categoria
    public static final CategoriaDto CATEGORIA_DTO_REQUEST = new CategoriaDto(null, "Livros");
    public static final CategoriaDto CATEGORIA_DTO_INSERT = new CategoriaDto(1, "Livros");
    public static final CategoriaDto CATEGORIA_DTO_NOME_INVALIDO = new CategoriaDto(null, "");
    public static final CategoriaProduto CATEGORIA_PRODUTO = new CategoriaProduto(1, "Livros");


    //Produto
    public static final ProdutoRequest PRODUTO_REQUEST = new ProdutoRequest("Algoritmos", 44.98, 5, 1);

    public static final ProdutoRequest PRODUTO_REQUEST_NAME_INVALID = new ProdutoRequest("", 44.98, 5, 1);

    public static final ProdutoSingleResponse PRODUTO_RESPONSE = new ProdutoSingleResponse(1,
            "Algoritmos",
            44.98,
            5,
            new CategoriaProdutoListResponse());

    public static final Produto PRODUTO = new Produto(1,
            "Algoritmos",
            new CategoriaProduto(),
            44.98,
            5);

    public static final Produto PRODUTO2 = new Produto(2,
            "A garota do lago",
            new CategoriaProduto(),
            50.0,
            3);





}
