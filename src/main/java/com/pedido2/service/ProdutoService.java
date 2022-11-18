package com.pedido2.service;

import com.pedido2.config.exception.ObjectNotFountException;
import com.pedido2.domain.entity.Produto;
import com.pedido2.domain.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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

    @Transactional
    public void delete(Integer id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        if (produto.isPresent()) {
            this.produtoRepository.delete(produto.get());
        } else {
            throw new ObjectNotFountException("Objeto não encontrado");
        }
    }

    public List<Produto> getAll(String nome) {
        if (nome != null) {
            return this.produtoRepository.searchbyNome(nome);
        } else {
            return this.produtoRepository.findAll();
        }
    }

    public List<Produto> getByNameCrit(String nome){
        return this.produtoRepository.findByNameCrit(nome);
    }
}
