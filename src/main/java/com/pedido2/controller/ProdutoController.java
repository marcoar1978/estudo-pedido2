package com.pedido2.controller;

import com.pedido2.domain.dto.request.ProdutoRequest;
import com.pedido2.domain.dto.response.ProdutoSingleResponse;
import com.pedido2.service.ProdutoService;
import com.pedido2.service.convert.ProdutoConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import com.pedido2.domain.entity.Produto;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        this.produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoSingleResponse>> getAll(@RequestParam(name = "nome", required = false) String nome) {
        List<ProdutoSingleResponse> produtos = produtoConvert.toListProdutoResponse(this.produtoService.getAll(nome));
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/criteria")
    public ResponseEntity<List<ProdutoSingleResponse>> getByNameCrit(@RequestParam(name = "nome", required = false) String nome) {
        List<ProdutoSingleResponse> produtos = produtoConvert.toListProdutoResponse(this.produtoService.getByNameCrit(nome));
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoSingleResponse> get(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(this.produtoConvert.toProdutoResponse(this.produtoService.get(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoSingleResponse> put(@PathVariable("id") Integer id, @RequestBody @Valid ProdutoRequest produtoRequest) {
        Produto produto = this.produtoService.put(id, this.produtoConvert.toProduto(produtoRequest));
        return ResponseEntity.ok().body(this.produtoConvert.toProdutoResponse(produto));
    }


}
