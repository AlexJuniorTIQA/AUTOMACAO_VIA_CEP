
Feature: VIACEP
Scenario Outline: Valida CEP
    Given envio os dados do cep <cep>
    Then recebo o statuscode <statusCode>

    Examples:
      | cep      | statusCode |
      | 05820205 | 200        |
      | 820205   | 400        |