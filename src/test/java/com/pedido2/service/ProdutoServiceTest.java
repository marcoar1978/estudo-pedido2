package com.pedido2.service;

import com.pedido2.config.exception.ObjectNotFountException;
import com.pedido2.domain.entity.Produto;
import com.pedido2.domain.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.pedido2.constants.MockModels.PRODUTO;
import static com.pedido2.constants.MockModels.PRODUTO2;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @InjectMocks
    ProdutoService produtoService;
    @Mock
    ProdutoRepository produtoRepository;
    @Mock
    EntityManager entityManager;

    @Test
    public void insertWithSuccess() {
        when(this.produtoRepository.save(PRODUTO)).thenReturn(PRODUTO);
        doNothing().when(this.entityManager).clear();
        when(this.produtoRepository.findById(PRODUTO.getId())).thenReturn(Optional.of(PRODUTO));

        Produto result = this.produtoService.insert(PRODUTO);

        assertNotNull(result);
        assertEquals(result.getClass(), Produto.class);

    }

    @Test
    public void whenDeleteThenReturnSuccess() {
        when(this.produtoRepository.findById(anyInt())).thenReturn(Optional.of(PRODUTO));
        doNothing().when(this.produtoRepository).delete(PRODUTO);

        this.produtoService.delete(anyInt());

        verify(this.produtoRepository, times(1)).delete(PRODUTO);
    }

    @Test
    public void whenDeleteThenReturnException() {
        when(this.produtoRepository.findById(anyInt())).thenReturn(Optional.ofNullable(null));
        try {
            this.produtoService.delete(anyInt());
        } catch (ObjectNotFountException ex) {
            assertEquals(ex.getClass(), ObjectNotFountException.class);
        }
    }

    @Test
    public void whenGetWithNameReturnList() {
        when(this.produtoRepository.searchbyNome(anyString())).thenReturn(List.of(PRODUTO));

        List<Produto> result = this.produtoService.getAll(anyString());

        assertNotNull(result);
        assertEquals(result.get(0).getClass(), Produto.class);
        assertEquals(result.size(), 1);
    }

    @Test
    public void whenGetWithNameReturnListEmpty() {
        when(this.produtoRepository.searchbyNome(anyString())).thenReturn(new ArrayList<>());

        List<Produto> result = this.produtoService.getAll(anyString());

        assertNotNull(result);
        assertEquals(result.size(), 0);
    }

    @Test
    public void whenGetAll() {
        when(this.produtoRepository.findAll()).thenReturn(List.of(PRODUTO));

        List<Produto> result = this.produtoService.getAll(null);

        assertNotNull(result);
        assertEquals(result.get(0).getClass(), Produto.class);
    }

    @Test
    public void whenGetByNameCritThenReturnListNotEmpty() {
        when(this.produtoRepository.findByNameCrit(anyString())).thenReturn(List.of(PRODUTO));

        List<Produto> result = this.produtoService.getByNameCrit(anyString());

        assertNotNull(result);
        assertEquals(result.get(0).getClass(), Produto.class);
        assertEquals(result.size(), 1);

    }

    @Test
    public void whenGetReturnProduto() {
        when(this.produtoRepository.findById(anyInt())).thenReturn(Optional.of(PRODUTO));

        Produto result = this.produtoService.get(anyInt());

        assertNotNull(result);
        assertEquals(result.getClass(), Produto.class);
    }

    @Test
    public void whenGetReturnException() {
        when(this.produtoRepository.findById(anyInt())).thenReturn(Optional.ofNullable(null));

        try {
            Produto result = this.produtoService.get(anyInt());

        } catch (ObjectNotFountException ex) {
            assertEquals(ex.getClass(), ObjectNotFountException.class);
        }
    }

    @Test
    public void whenPutReturnProduto(){
        when(this.produtoRepository.findById(anyInt())).thenReturn(Optional.of(PRODUTO));

        Produto result = this.produtoService.put(1, PRODUTO2);

        assertNotNull(result);
        assertEquals(result.getClass(), Produto.class);
        assertEquals(result.getNome(), "A garota do lago");

    }

    @Test
    public void whenPutReturnException(){
        when(this.produtoRepository.findById(anyInt())).thenReturn(Optional.ofNullable(null));
        try{
            Produto result = this.produtoService.put(1, PRODUTO2);
        } catch (ObjectNotFountException ex){
            assertEquals(ex.getClass(), ObjectNotFountException.class);
        }


    }

}