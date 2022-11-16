package com.pedido2.config.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class StandardError {

    LocalDateTime timestamp;
    Integer status;
    String error;
    String path;
}
