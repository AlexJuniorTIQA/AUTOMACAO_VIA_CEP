package br.com.viacep.steps.restricoes;

import br.com.viacep.suport.Request;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static br.com.viacep.suport.enums.urlEnum.VIACEP;


public class validaCepStep extends Request {

    @Given("^envio os dados do cep (\\d+)$")
    public void envio_os_dados_do_cep(String cep){

        get( VIACEP.getUrl() + cep + "/json");
    }

    @Then("recebo o statuscode (\\d+)")
    public void recebo_o_statuscode(int statusCode){
        validatorStatusCode(statusCode);
    }


}