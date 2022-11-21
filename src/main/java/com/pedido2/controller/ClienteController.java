package com.pedido2.controller;

import com.pedido2.domain.dto.request.ClienteRequest;
import com.pedido2.domain.dto.response.ClienteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ClienteController {


    @PostMapping
    public ResponseEntity<ClienteResponse> insert(@RequestBody @Valid ClienteRequest clienteRequest){
        return null;
    }
}
