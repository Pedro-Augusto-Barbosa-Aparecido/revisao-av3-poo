public class CraincaNaoEncontrada extends RuntimeException {
    public CraincaNaoEncontrada() {
        super();
    }

    public CraincaNaoEncontrada(String message) {
        super(message);
    }

    public CraincaNaoEncontrada(String message, Throwable cause) {
        super(message, cause);
    }

    public CraincaNaoEncontrada(Throwable cause) {
        super(cause);
    }

    protected CraincaNaoEncontrada(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
