Projeto de BDD

JAVA + CUCUMBER + SELENIUM + JUNIT

Bibliotecas adicionais:
Apache
Lombok


Projeto desenvolvido em cima do site https://bugbank.netlify.app/

Cenário de teste:
- Teste de Login Com Sucesso




MassaDeDados.xlsx - Massa de dados para consumo do teste, campos com input numérico devem ser inseridos com aspas simples " ' " para conversão do Excel para String

Pasta Report: Contem o arquivo de report do teste e as screenshot da execução


Descrição dos pacotes:

-> Main

-> driver: Este pacote contem as condições da execução do driver, screenshot e MassaDeDados.

-> excel: Este pacote contem a classe que define a forma de consumo da massa de dados.

-> logic: Este pacote contem as classes de lógica do teste, utilizando da boa prática de desenvolvimento e reutilização de código.

-> pages: Este pacote contem as páginas do site e seus respectivos elementos mapeados.

->Teste

-> Runners: Este pacote contem a classe de execução do teste.

-> Steps: Este pacote contem as classes de step dos  testes
