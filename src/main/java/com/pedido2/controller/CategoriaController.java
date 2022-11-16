package com.pedido2.controller;

import com.pedido2.domain.dto.request.CategoriaDto;
import com.pedido2.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDto> insert(@RequestBody @Valid CategoriaDto categoria, UriComponentsBuilder builder) {
        CategoriaDto categoriaInserida = this.categoriaService.insert(categoria);
        URI uri = builder.path("/categorias/{id}").buildAndExpand(categoriaInserida.getId()).toUri();
        return ResponseEntity.created(uri).body(categoriaInserida);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findByName(@RequestParam(name = "name", required = false) String name) {

        return ResponseEntity.ok().body(this.categoriaService.findByName(name));
    }

    @GetMapping("/criteria")
    public ResponseEntity<List<CategoriaDto>> findByNameCrit(@RequestParam(name = "name", required = false) String name) {
        return ResponseEntity.ok().body(this.categoriaService.findByNameCrit(name));
    }

    @GetMapping("/criteria/{id}")
    public ResponseEntity<CategoriaDto> findByIdCrit(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(this.categoriaService.findByIdCrit(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDto> update(@PathVariable("id") Integer id, @RequestBody @Valid CategoriaDto categoriaDto) {
        CategoriaDto categoriaDtoUpdate = this.categoriaService.update(id, categoriaDto);
        if (categoriaDtoUpdate != null) {
            return ResponseEntity.ok().body(categoriaDtoUpdate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> getCategoria(@PathVariable("id") Integer id) {
        CategoriaDto categoriaDto = this.categoriaService.getCategoria(id);
        if (categoriaDto != null) {
            return ResponseEntity.ok().body(categoriaDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaDto> delete(@PathVariable("id") Integer id){
        this.categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
