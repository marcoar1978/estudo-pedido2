package com.pedido2.service.convert;

import com.pedido2.domain.dto.response.ProdutoSingleResponse;
import com.pedido2.domain.entity.Produto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

import static com.pedido2.constants.MockModels.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProdutoConvertTest {

    @InjectMocks
    ProdutoConvert produtoConvert;

    @Mock
    ModelMapper modelMapper;


    @Test
    public void whenToProdutoThenReturnProduto(){
        when(this.modelMapper.map(PRODUTO_REQUEST, Produto.class)).thenReturn(PRODUTO);

        Produto result = this.produtoConvert.toProduto(PRODUTO_REQUEST);

        assertNotNull(result);
        assertEquals(result.getClass(), Produto.class);
    }

    @Test
    public void  whenToProdutoResponseThenReturnProdutoResponse(){
        when(this.modelMapper.map(PRODUTO, ProdutoSingleResponse.class)).thenReturn(PRODUTO_RESPONSE);

        ProdutoSingleResponse result = this.produtoConvert.toProdutoResponse(PRODUTO);

        assertNotNull(result);
        assertEquals(result.getClass(), ProdutoSingleResponse.class);
    }

    @Test
    public void whenToListProdutoResponseThenReturnListNotEmpty(){
        when(modelMapper.map(PRODUTO, ProdutoSingleResponse.class)).thenReturn(PRODUTO_RESPONSE);

        List<ProdutoSingleResponse> result = this.produtoConvert.toListProdutoResponse(List.of(PRODUTO));

        assertNotNull(result);
        assertEquals(result.get(0).getClass(), ProdutoSingleResponse.class);
   }

    @Test
    public void whenToListProdutoResponseThenReturnListEmpty(){
        List<ProdutoSingleResponse> result = this.produtoConvert.toListProdutoResponse(new ArrayList<Produto>());

        assertNotNull(result);
        assertEquals(result.size(), 0);

    }


}