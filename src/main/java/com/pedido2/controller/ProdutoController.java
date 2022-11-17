package com.pedido2.controller;

import com.pedido2.domain.dto.request.ProdutoRequest;
import com.pedido2.domain.dto.response.ProdutoSingleResponse;
import com.pedido2.service.ProdutoService;
import com.pedido2.service.convert.ProdutoConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.pedido2.domain.entity.Produto;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ProdutoConvert produtoConvert;

    @PostMapping
    public ResponseEntity<ProdutoSingleResponse> insert(@RequestBody() @Valid ProdutoRequest produtoRequest, UriComponentsBuilder builder) {
        Produto produto = this.produtoService.insert(produtoConvert.toProduto(produtoRequest));
        URI uri = builder.path("produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(produtoConvert.toProdutoResponse(produto));
    }

}
