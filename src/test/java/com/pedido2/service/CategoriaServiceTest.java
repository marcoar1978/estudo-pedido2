package com.pedido2.service;

import com.pedido2.config.exception.ObjectNotFountException;
import com.pedido2.domain.dto.request.CategoriaDto;
import com.pedido2.domain.entity.CategoriaProduto;
import com.pedido2.domain.repository.CategoriaProdRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.pedido2.constants.MockModels.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceTest {

    @InjectMocks
    CategoriaService categoriaService;

    @Mock
    CategoriaProdRepository categoriaProdRepository;

    @Mock
    ModelMapper modelMapper;

    @Test
    public void insertWithSucess() {
        when(this.modelMapper.map(CATEGORIA_DTO_REQUEST, CategoriaProduto.class)).thenReturn(CATEGORIA_PRODUTO);
        when(this.categoriaProdRepository.save(CATEGORIA_PRODUTO)).thenReturn(CATEGORIA_PRODUTO);
        when(this.modelMapper.map(CATEGORIA_PRODUTO, CategoriaDto.class)).thenReturn(CATEGORIA_DTO_INSERT);

        CategoriaDto result = this.categoriaService.insert(CATEGORIA_DTO_REQUEST);

        assertNotNull(result);
        assertEquals(result.getClass(), CategoriaDto.class);
        assertEquals(result.getId(), 1);
        assertEquals(result.getNome(), "Livros");

    }

    @Test
    public void whenFindWithNameReturnList() {
        when(this.categoriaProdRepository.findByName(anyString())).thenReturn(List.of(CATEGORIA_PRODUTO));
        when(this.modelMapper.map(CATEGORIA_PRODUTO, CategoriaDto.class)).thenReturn(CATEGORIA_DTO_INSERT);

        List<CategoriaDto> result = this.categoriaService.findByName(anyString());

        assertNotNull(result);
        assertEquals(result.getClass(), ArrayList.class);
        assertEquals(result.get(0).getId(), 1);
        assertEquals(result.get(0).getNome(), "Livros");
    }

    @Test
    public void whenFindWithNameReturnNull() {
        when(this.categoriaProdRepository.findAll()).thenReturn(List.of(CATEGORIA_PRODUTO, CATEGORIA_PRODUTO));
        when(this.modelMapper.map(CATEGORIA_PRODUTO, CategoriaDto.class)).thenReturn(CATEGORIA_DTO_INSERT);

        List<CategoriaDto> result = this.categoriaService.findByName(null);

        assertNotNull(result);
        assertEquals(result.getClass(), ArrayList.class);
        assertEquals(result.get(0).getId(), 1);
        assertEquals(result.get(0).getNome(), "Livros");

    }

    @Test
    public void whenfindByNameCritReturnList() {
        when(this.categoriaProdRepository.findByNameCrit(anyString())).thenReturn(List.of(CATEGORIA_PRODUTO));
        when(modelMapper.map(CATEGORIA_PRODUTO, CategoriaDto.class)).thenReturn(CATEGORIA_DTO_INSERT);

        List<CategoriaDto> result = this.categoriaService.findByNameCrit(anyString());

        assertNotNull(result);
        assertEquals(result.getClass(), ArrayList.class);
        assertEquals(result.get(0).getId(), 1);
        assertEquals(result.get(0).getNome(), "Livros");
    }

    @Test
    public void whenUpdateReturnCategoriaDto() {
        when(this.categoriaProdRepository.findById(anyInt())).thenReturn(Optional.of(CATEGORIA_PRODUTO));
        when(this.modelMapper.map(CATEGORIA_PRODUTO, CategoriaDto.class)).thenReturn(CATEGORIA_DTO_INSERT);

        CategoriaDto result = this.categoriaService.update(1, CATEGORIA_DTO_REQUEST);

        assertNotNull(result);
        assertEquals(result.getClass(), CategoriaDto.class);

    }

    @Test
    public void whenUpdateReturnNull() {
        when(this.categoriaProdRepository.findById(anyInt())).thenReturn(Optional.ofNullable(null));

        CategoriaDto result = this.categoriaService.update(1, CATEGORIA_DTO_REQUEST);

        assertEquals(result, null);

    }

    @Test
    public void whengetCategoriaReturnCategoriaDto() {
        when(this.categoriaProdRepository.findById(anyInt())).thenReturn(Optional.of(CATEGORIA_PRODUTO));
        when(this.modelMapper.map(CATEGORIA_PRODUTO, CategoriaDto.class)).thenReturn(CATEGORIA_DTO_INSERT);

        CategoriaDto result = this.categoriaService.getCategoria(anyInt());

        assertNotNull(result);
        assertEquals(result.getClass(), CategoriaDto.class);
    }

    @Test
    public void whengetCategoriaReturnNull(){
        when(this.categoriaProdRepository.findById(anyInt())).thenReturn(Optional.ofNullable(null));

        CategoriaDto result = this.categoriaService.getCategoria(anyInt());

        assertNull(result);
     }

     @Test
    public void whenDeleteReturnSuccess(){
        when(this.categoriaProdRepository.findById(anyInt())).thenReturn(Optional.of(CATEGORIA_PRODUTO));
        doNothing().when(this.categoriaProdRepository).delete(CATEGORIA_PRODUTO);

        this.categoriaService.delete(anyInt());

        verify(this.categoriaProdRepository, times(1)).delete(CATEGORIA_PRODUTO);

     }

     @Test
    public void whenDeleteReturnExceptionNotFound(){
         when(this.categoriaProdRepository.findById(anyInt())).thenReturn(Optional.ofNullable(null));
         try{
             this.categoriaService.delete(anyInt());
         } catch (ObjectNotFountException ex){
             assertEquals(ex.getClass(), ObjectNotFountException.class);
         }
     }

     @Test
    public void whenFindByIdCritResultCategoriaDto(){
        when(this.categoriaProdRepository.findByIdCrit(anyInt())).thenReturn(CATEGORIA_PRODUTO);
        when(this.modelMapper.map(CATEGORIA_PRODUTO, CategoriaDto.class)).thenReturn(CATEGORIA_DTO_INSERT);

        CategoriaDto result = this.categoriaService.findByIdCrit(anyInt());

        assertNotNull(result);
        assertEquals(result.getClass(), CategoriaDto.class);
     }


}