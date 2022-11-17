package com.pedido2.controller;


import com.pedido2.domain.dto.request.CategoriaDto;
import com.pedido2.service.CategoriaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static com.pedido2.constants.MockModels.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class CategoriaControllerTest {

    @InjectMocks
    CategoriaController categoriaController;

    @Mock
    CategoriaService categoriaService;

    @Test
    public void insertWithSuccess() {
        when(this.categoriaService.insert(CATEGORIA_DTO_REQUEST)).thenReturn(CATEGORIA_DTO_INSERT);

        ResponseEntity<CategoriaDto> result = this.categoriaController.insert(CATEGORIA_DTO_REQUEST, UriComponentsBuilder.newInstance());

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(ResponseEntity.class, result.getClass());
        assertEquals(result.getBody().getNome(), "Livros");
    }

    @Test
    public void insertWithNomeInvalid() {
        when(this.categoriaService.insert(CATEGORIA_DTO_REQUEST)).thenReturn(CATEGORIA_DTO_INSERT);
        try {
            ResponseEntity<CategoriaDto> result = this.categoriaController.insert(CATEGORIA_DTO_NOME_INVALIDO, UriComponentsBuilder.newInstance());
        } catch (Exception ex) {
            assertNotNull(ex);

        }
    }

    @Test
    public void whenfindByNameReturnList() {
        when(this.categoriaService.findByName(anyString())).thenReturn(List.of(CATEGORIA_DTO_INSERT, CATEGORIA_DTO_INSERT));

        ResponseEntity<List<CategoriaDto>> result = this.categoriaController.findByName(anyString());

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(ResponseEntity.class, result.getClass());
        assertEquals(HttpStatus.OK, result.getStatusCode());

    }

    @Test
    public void whenfindByNameReturnNull() {
        when(this.categoriaService.findByName(anyString())).thenReturn(List.of(CATEGORIA_DTO_INSERT, CATEGORIA_DTO_INSERT));

        ResponseEntity<List<CategoriaDto>> result = this.categoriaController.findByName("");

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(ResponseEntity.class, result.getClass());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void whenFindByNameCritThenReturnList() {
        when(this.categoriaService.findByNameCrit(anyString())).thenReturn(List.of(CATEGORIA_DTO_INSERT, CATEGORIA_DTO_INSERT));

        ResponseEntity<List<CategoriaDto>> result = this.categoriaController.findByNameCrit(anyString());

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(result.getClass(), ResponseEntity.class);
        assertEquals(result.getBody().get(0).getClass(), CategoriaDto.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void whenFindByNameCritThenReturnNull() {
        when(this.categoriaService.findByNameCrit(null)).thenReturn(List.of(CATEGORIA_DTO_INSERT, CATEGORIA_DTO_INSERT));

        ResponseEntity<List<CategoriaDto>> result = this.categoriaController.findByNameCrit(null);

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(result.getClass(), ResponseEntity.class);
        assertEquals(result.getBody().get(0).getClass(), CategoriaDto.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());

    }

    @Test
    public void whenUpdateReturnCategoriaDto() {
        when(this.categoriaService.update(1, CATEGORIA_DTO_REQUEST)).thenReturn(CATEGORIA_DTO_INSERT);

        ResponseEntity<CategoriaDto> result = this.categoriaController.update(1, CATEGORIA_DTO_REQUEST);

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(result.getClass(), ResponseEntity.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void whenUpdateReturnBadRequest() {
        when(this.categoriaService.update(1, CATEGORIA_DTO_REQUEST)).thenReturn(null);

        ResponseEntity<CategoriaDto> result = this.categoriaController.update(1, CATEGORIA_DTO_REQUEST);

        assertNotNull(result);
        assertNull(result.getBody());
        assertEquals(result.getClass(), ResponseEntity.class);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());

    }

    @Test
    public void whenGetCategoriaReturnOK() {
        when(this.categoriaService.getCategoria(anyInt())).thenReturn(CATEGORIA_DTO_INSERT);

        ResponseEntity<CategoriaDto> result = this.categoriaController.getCategoria(anyInt());

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(result.getBody().getClass(), CategoriaDto.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());

    }

    @Test
    public void whenGetCategoriaReturnBadRequest() {
        when(this.categoriaService.getCategoria(anyInt())).thenReturn(null);

        ResponseEntity<CategoriaDto> result = this.categoriaController.getCategoria(anyInt());

        assertNotNull(result);
        assertNull(result.getBody());
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

    @Test
    public void deleteWithSuccess(){
        doNothing().when(this.categoriaService).delete(anyInt());

        ResponseEntity<?> result = this.categoriaController.delete(anyInt());

        assertNotNull(result);
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

    }

    @Test
    public void findByIdCritWithSuccess(){
        when(this.categoriaService.findByIdCrit(anyInt())).thenReturn(CATEGORIA_DTO_INSERT);

        ResponseEntity<CategoriaDto> result = this.categoriaController.findByIdCrit(anyInt());

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }


}