package com.pedido2.controller;

import com.pedido2.domain.dto.request.ProdutoRequestDto;
import com.pedido2.domain.entity.Produto;
import com.pedido2.domain.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProdutoRepository produtoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody() @Valid ProdutoRequestDto produtoRequestDto){
        Produto produto = this.modelMapper.map(produtoRequestDto, Produto.class);

        this.produtoRepository.save(produto);
        return ResponseEntity.ok().build();
    }

}
