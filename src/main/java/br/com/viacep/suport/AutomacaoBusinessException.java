package br.com.viacep.suport;

public class AutomacaoBusinessException extends RuntimeException {

    private static final long serialVersionUID = 7718828512143293558L;

    public AutomacaoBusinessException(String message) {
        super(message);
        Log.info(message);
    }
}