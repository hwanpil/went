package exceptions;

public class TooManyConnectorsException extends ComponentConfigurationException {
    public TooManyConnectorsException(String message) {
        super(message);
    }
}
