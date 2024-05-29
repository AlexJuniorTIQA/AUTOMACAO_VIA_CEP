package br.com.viacep.suport;

import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

import static br.com.viacep.suport.enums.JsonConstantsEnum.APPLICATION_JSON;
import static br.com.viacep.suport.enums.JsonConstantsEnum.CONTENT_TYPE;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class Request {

    protected Response response;

    public Request validatorStatusCode(Integer statusCode) {
        try {
            String responseBody = response.getBody().asString();
            Log.info("Validação do StatusCode " + "Atual: " + response.getStatusCode() + " Esperado: " + statusCode.toString());
            Log.info("Response: " + responseBody + "\n");
            assertTrue(response.getStatusCode() == statusCode);
        } catch (AssertionError e) {
            assertTrue(false);
        }
        return this;
    }
    public Request post(String url,Object json) {
        Log.info("Enviando requisição POST para host: ".concat(url));
        response = given()
                .log().body()
                .relaxedHTTPSValidation()
                .headers(CONTENT_TYPE.getValue(), APPLICATION_JSON.getValue())
                .body(json).when().post(url);
        return this;
    }
    public Request get(String path, String url) {
        Log.info("Enviando requisição GET para host: ".concat(url).concat(path));
        response = given().relaxedHTTPSValidation().when().get(url.concat(path));
        return this;
    }
    public Request get( String url) {
        Log.info("Enviando requisição GET para host: ".concat(url));
        response = given().relaxedHTTPSValidation().when().get(url);
        return this;
    }

    public Request delete(String url, String path) {
        Log.info("Enviando requisição DELETE para host: ".concat(url).concat(path));
        response = given().relaxedHTTPSValidation().when().delete(url.concat(path));
        return this;}

    public Request put(String url, Object json, String path) {
        Log.info("Enviando requisição PUT para host: ".concat(url).concat(path));
        response = given().log().body().relaxedHTTPSValidation().headers(CONTENT_TYPE.getValue(), APPLICATION_JSON.getValue()).body(json).when().put(url.concat(path));
        return this;}


    public Request validaMensagemDeRetorno(String expectedMessage) {
        boolean assertParam = false;
        String responseBody = response.getBody().asString();
        try {
            if (!expectedMessage.equalsIgnoreCase("semMensagemDeErro")) {
                assertParam = responseBody.contains(expectedMessage);
                try {
                    List<String> listaMsg = Arrays.asList(responseBody.split("\"erros\":"));
                    String msg = listaMsg.get(1);
                    Log.info("Mensagem de erro retornada: " + msg);
                    Log.info("Mensagem de erro esperada: " + expectedMessage);
                    assertTrue(assertParam);
                } catch (AssertionError e) {
                    assertParam = false;
                }

            } else {
                assertParam = true;
                Log.info("Nenhuma mensagem de erro esperada");
            }
        } catch (AssertionError e) {
            assertParam = false;
        }
        return this;

    }


}