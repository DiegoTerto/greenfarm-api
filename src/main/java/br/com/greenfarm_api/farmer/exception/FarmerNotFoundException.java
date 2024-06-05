package br.com.greenfarm_api.farmer.exception;

public class FarmerNotFoundException extends RuntimeException {

    public FarmerNotFoundException() {
        super("Agricultor não encontrado");
    }
}
