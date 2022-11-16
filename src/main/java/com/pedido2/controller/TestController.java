package com.pedido2.controller;

import com.pedido2.domain.dto.request.ClienteTestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/testes")
public class TestController {

    @PostMapping("/testeBean")
    public ResponseEntity<ClienteTestDTO> include(@RequestBody @Valid ClienteTestDTO cliente){
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/auth")
    public String auth(){
        return "Teste OK";
    }
}
