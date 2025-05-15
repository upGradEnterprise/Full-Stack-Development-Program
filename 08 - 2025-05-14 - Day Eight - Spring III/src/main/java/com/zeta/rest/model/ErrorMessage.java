package com.zeta.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data public class ErrorMessage {
    private String message;
    private int errorCode;
}