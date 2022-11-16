package com.pedido2.service;

import com.pedido2.config.exception.ObjectNotFountException;
import com.pedido2.domain.dto.request.CategoriaDto;
import com.pedido2.domain.entity.CategoriaProduto;
import com.pedido2.domain.repository.CategoriaProdRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    CategoriaProdRepository categoriaProdRepository;

    @Transactional
    public CategoriaDto insert(CategoriaDto categoriaDto) {
        CategoriaProduto categoriaProduto = modelMapper.map(categoriaDto, CategoriaProduto.class);
        CategoriaProduto categoriaInserida = this.categoriaProdRepository.save(categoriaProduto);

        return this.modelMapper.map(categoriaInserida, CategoriaDto.class);
    }

    public List<CategoriaDto> findByName(String name) {
        List<CategoriaProduto> categorias = null;
        List<CategoriaDto> categoriasDto = new ArrayList<>();
        if (name != null) {
            categorias = this.categoriaProdRepository.findByName(name);
        } else {
            categorias = this.categoriaProdRepository.findAll();
        }

        if (categorias.size() > 0) {
            categorias.forEach(c -> categoriasDto.add(modelMapper.map(c, CategoriaDto.class)));
        }

        return categoriasDto;
    }

    public List<CategoriaDto> findByNameCrit(String name) {
        List<CategoriaProduto> categorias = this.categoriaProdRepository.findByNameCrit(name);
        List<CategoriaDto> categoriasDto = new ArrayList<>();
        categorias.forEach(c -> categoriasDto.add(modelMapper.map(c, CategoriaDto.class)));
        return categoriasDto;
    }

    @Transactional
    public CategoriaDto update(Integer id, CategoriaDto categoriaDto) {
        CategoriaDto categoriaDtoUpdate = null;
        Optional<CategoriaProduto> categoriaProduto = this.categoriaProdRepository.findById(id);

        if (categoriaProduto.isPresent()) {
            categoriaProduto.get().setNome(categoriaDto.getNome());
            categoriaDtoUpdate = modelMapper.map(categoriaProduto.get(), CategoriaDto.class);
        }
        return categoriaDtoUpdate;
    }

    public CategoriaDto getCategoria(Integer id) {
        CategoriaDto categoriaDto = null;
        Optional<CategoriaProduto> categoriaProduto = this.categoriaProdRepository.findById(id);

        if (categoriaProduto.isPresent()) {
            categoriaDto = modelMapper.map(categoriaProduto.get(), CategoriaDto.class);
        }
        return categoriaDto;
    }

    @Transactional
    public void delete(Integer id) {
        Optional<CategoriaProduto> categoriaProduto = this.categoriaProdRepository.findById(id);
        if (categoriaProduto.isPresent()) {
            this.categoriaProdRepository.delete(categoriaProduto.get());
        } else {
            throw new ObjectNotFountException("Objeto não encontrado");
        }

    }

    public CategoriaDto findByIdCrit(Integer id) {
        CategoriaProduto categoriaProduto = this.categoriaProdRepository.findByIdCrit(id);
        CategoriaDto categoriaDto = this.modelMapper.map(categoriaProduto, CategoriaDto.class);

        return categoriaDto;
    }
}
