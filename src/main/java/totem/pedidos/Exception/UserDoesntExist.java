package totem.pedidos.Exception;

public class UserDoesntExist extends RuntimeException {
    public UserDoesntExist(String message) {
        super(message);
    }
}
