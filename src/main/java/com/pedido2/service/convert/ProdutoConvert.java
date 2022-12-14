package com.pedido2.service.convert;

import com.pedido2.domain.dto.request.ProdutoRequest;
import com.pedido2.domain.dto.response.ProdutoSingleResponse;
import com.pedido2.domain.entity.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoConvert {

    @Autowired
    ModelMapper modelMapper;

    public Produto toProduto(ProdutoRequest produtoRequest){
        Produto produto = this.modelMapper.map(produtoRequest, Produto.class);
        produto.setId(null);
        return produto;
    }

    public ProdutoSingleResponse toProdutoResponse(Produto produto){
        ProdutoSingleResponse produtoSingleResponse = this.modelMapper.map(produto, ProdutoSingleResponse.class);
        return produtoSingleResponse;
    }

    public List<ProdutoSingleResponse> toListProdutoResponse(List<Produto> produtos){
        List<ProdutoSingleResponse> produtosResponse = new ArrayList<>();
        produtos.forEach(p -> {
            produtosResponse.add(modelMapper.map(p, ProdutoSingleResponse.class));
        });
        return produtosResponse;
    }
}
