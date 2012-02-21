package mike.utils.jnumericfield.exceptions;

/**
 * NumericFormatException.java
 * 
 * @author Miguel Augusto Caligares
 * @email mcaligares@gmail.com
 * @version 0.1.4
 */
public class NumericFormatException extends Exception{
    private static final long serialVersionUID = -2118892738213251887L;

    public NumericFormatException(Throwable cause) {
        super(cause);
    }

    public NumericFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumericFormatException(String message) {
        super(message);
    }

    public NumericFormatException() {
    }

    @Override
    public String getLocalizedMessage() {
        return getMessage();
    }
    
    
}
