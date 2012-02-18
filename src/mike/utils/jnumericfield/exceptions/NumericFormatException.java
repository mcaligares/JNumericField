/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mike.utils.jnumericfield.exceptions;

/**
 *
 * @author mike
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
