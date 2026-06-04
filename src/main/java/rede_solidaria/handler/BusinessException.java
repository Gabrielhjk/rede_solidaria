package rede_solidaria.handler;

public class BusinessException extends RuntimeException {
    
    // tratamendo de erro para regra de negocios
    public BusinessException(String message) {
        super(message);
    }
}
 