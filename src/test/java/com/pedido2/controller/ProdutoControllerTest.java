package com.pedido2.controller;

import com.pedido2.domain.dto.response.ProdutoSingleResponse;
import com.pedido2.domain.entity.Produto;
import com.pedido2.service.ProdutoService;
import com.pedido2.service.convert.ProdutoConvert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.pedido2.constants.MockModels.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoControllerTest {

    @InjectMocks
    ProdutoController produtoController;

    @Mock
    ProdutoService produtoService;

    @Mock
    ProdutoConvert produtoConvert;

    @Test
    public void insertWithSuccess() {
        when(produtoConvert.toProduto(PRODUTO_REQUEST)).thenReturn(PRODUTO);
        when(produtoService.insert(PRODUTO)).thenReturn(PRODUTO);
        when(produtoConvert.toProdutoResponse(PRODUTO)).thenReturn(PRODUTO_RESPONSE);

        ResponseEntity<ProdutoSingleResponse> result = this.produtoController.insert(PRODUTO_REQUEST, UriComponentsBuilder.newInstance());

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(result.getClass(), ResponseEntity.class);
        assertEquals(result.getBody().getClass(), ProdutoSingleResponse.class);
    }

    @Test
    public void whenDeleteThenReturnSuccess() {
        doNothing().when(this.produtoService).delete(anyInt());

        ResponseEntity<?> result = this.produtoController.delete(anyInt());

        assertNotNull(result);
        assertEquals(result.getStatusCode(), HttpStatus.NO_CONTENT);
    }

    @Test
    public void whenGetAllThenReturnList() {
        when(this.produtoService.getAll(anyString())).thenReturn(List.of(PRODUTO));
        when(produtoConvert.toListProdutoResponse(List.of(PRODUTO))).thenReturn(List.of(PRODUTO_RESPONSE));

        ResponseEntity<List<ProdutoSingleResponse>> result = this.produtoController.getAll(anyString());

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(result.getClass(), ResponseEntity.class);
        assertEquals(result.getBody().get(0).getClass(), ProdutoSingleResponse.class);
    }

    @Test
    public void whenGetByNameCritThenReturnListNotEmpty() {
        when(this.produtoService.getByNameCrit(anyString())).thenReturn(List.of(PRODUTO));
        when(produtoConvert.toListProdutoResponse(List.of(PRODUTO))).thenReturn(List.of(PRODUTO_RESPONSE));

        ResponseEntity<List<ProdutoSingleResponse>> result = this.produtoController.getByNameCrit(anyString());

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(result.getClass(), ResponseEntity.class);
        assertEquals(result.getBody().get(0).getClass(), ProdutoSingleResponse.class);
        assertEquals(result.getBody().size(), 1);
    }

    @Test
    public void whenGetByNameCritThenReturnListEmpty() {
        when(this.produtoService.getByNameCrit(anyString())).thenReturn(new ArrayList<Produto>());
        when(produtoConvert.toListProdutoResponse(new ArrayList<Produto>())).thenReturn(new ArrayList<ProdutoSingleResponse>());

        ResponseEntity<List<ProdutoSingleResponse>> result = this.produtoController.getByNameCrit(anyString());

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(result.getClass(), ResponseEntity.class);
        assertEquals(result.getBody().size(), 0);

    }

    @Test
    public void whenGetReturnProdutoResponse() {
        when(this.produtoService.get(anyInt())).thenReturn(PRODUTO);
        when(this.produtoConvert.toProdutoResponse(PRODUTO)).thenReturn(PRODUTO_RESPONSE);

        ResponseEntity<ProdutoSingleResponse> result = this.produtoController.get(anyInt());

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(result.getClass(), ResponseEntity.class);
        assertEquals(result.getBody().getClass(), ProdutoSingleResponse.class);
    }

    @Test
    public void whenPutReturnProdutoResponse() {
        when(this.produtoConvert.toProduto(PRODUTO_REQUEST)).thenReturn(PRODUTO);
        when(this.produtoService.put(1, PRODUTO)).thenReturn(PRODUTO);
        when(this.produtoConvert.toProdutoResponse(PRODUTO)).thenReturn(PRODUTO_RESPONSE);

        ResponseEntity<ProdutoSingleResponse> result = this.produtoController.put(1, PRODUTO_REQUEST);

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(result.getClass(), ResponseEntity.class);
        assertEquals(result.getBody().getClass(), ProdutoSingleResponse.class);
    }


}