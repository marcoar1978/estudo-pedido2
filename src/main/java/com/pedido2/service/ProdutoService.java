package com.pedido2.service;

import com.pedido2.domain.dto.request.ProdutoRequest;
import com.pedido2.domain.dto.response.ProdutoSingleResponse;
import com.pedido2.domain.entity.Produto;
import com.pedido2.domain.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class ProdutoService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProdutoRepository produtoRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Produto insert(Produto produto) {
        Produto produtoInsert = this.produtoRepository.save(produto);
        this.entityManager.clear();
        Produto produtoQuery = this.produtoRepository.findById(produtoInsert.getId()).get();
        return produtoQuery;
    }


}
