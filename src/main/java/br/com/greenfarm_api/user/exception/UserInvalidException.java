package br.com.greenfarm_api.user.exception;

public class UserInvalidException extends RuntimeException {
    public UserInvalidException() {
        super("Usuário inválido");
    }
}
