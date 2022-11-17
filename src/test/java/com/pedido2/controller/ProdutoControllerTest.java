package com.pedido2.controller;

import com.pedido2.domain.dto.response.ProdutoSingleResponse;
import com.pedido2.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

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

    @Test
    public void insertWithSuccess() {
        /*
        when(this.produtoService.insert(PRODUTO_REQUEST)).thenReturn(PRODUTO_RESPONSE);

        ResponseEntity<ProdutoSingleResponse> result = this.produtoController.insert(PRODUTO_REQUEST, UriComponentsBuilder.newInstance());

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(result.getClass(), ResponseEntity.class);
        assertEquals(result.getBody().getClass(), ProdutoSingleResponse.class);

         */
    }

}