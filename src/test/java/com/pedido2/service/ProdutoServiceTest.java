package com.pedido2.service;

import com.pedido2.domain.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @InjectMocks
    ProdutoService produtoService;

    @Mock
    ModelMapper modelMapper;

    @Mock
    ProdutoRepository produtoRepository;

    @Mock
    EntityManager entityManager;

    @Test
    public void insertWithSuccess(){

    }
}