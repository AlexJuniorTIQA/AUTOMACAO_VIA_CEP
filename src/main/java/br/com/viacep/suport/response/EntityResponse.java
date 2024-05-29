package br.com.viacep.suport.response;


import br.com.viacep.suport.AutomacaoBusinessException;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class EntityResponse {
   private String statusCode;

   public EntityResponse(String dados){
       List<String> listaObjeto = Arrays.asList(dados.split(","));
       AtomicInteger contador = new AtomicInteger(-1);

       Arrays.stream(this.getClass().getDeclaredFields()).forEach(field -> {
           try{
               field.set(this,listaObjeto.get(contador.incrementAndGet()));
           } catch (IllegalAccessException e) {
               new AutomacaoBusinessException("Erro na recuperacao dos dados: " + e.getMessage());
           }
       });
   }
}
