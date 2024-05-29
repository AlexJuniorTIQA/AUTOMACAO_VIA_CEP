package br.com.viacep.suport.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum urlEnum {

        VIACEP("https://viacep.com.br/ws/");

    private String url;
}
