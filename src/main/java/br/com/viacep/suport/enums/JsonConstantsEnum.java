package br.com.viacep.suport.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JsonConstantsEnum {
    CONTENT_TYPE("Content-Type"),
    APPLICATION_JSON("application/json"),
    NULL("null"),
    VAZIO("vazio");

    private String value;
}