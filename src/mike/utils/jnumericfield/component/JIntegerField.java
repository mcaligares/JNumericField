package mike.utils.jnumericfield.component;

import java.awt.Color;
import java.awt.event.KeyEvent;
import mike.utils.jnumericfield.exceptions.NumericFormatException;

/**
 * JIntegerField.java
 * 
 * @author Miguel Augusto Caligares
 * @email mcaligares@gmail.com
 * @version 0.1.4
 */
public class JIntegerField extends JNumericField {
    private static final long serialVersionUID = 7266469091641281550L;
    // Properties name
    public static final String PROPERTY_INTEGER = "integerValue";
    // Properties
    private Integer integerValue;
    
    // Empty constructor
    public JIntegerField() {
        this("field jNumericField", 0, 10, true);
    }
    // Fielname, integer, lenght constructor
    public JIntegerField(String fieldName, Integer integer, int length) {
        this(fieldName, integer, length, true);
    }
    // Constructor
    @SuppressWarnings("LeakingThisInConstructor")
    public JIntegerField(String fieldName, Integer integer, int length, boolean state) {
        this.integerValue = integer;
        this.length = length;
        this.fieldName = fieldName;
        this.color = getForeground();
        this.state = state;
        if(!state) setForeground(Color.RED);
        setText(integer.toString());
        addKeyListener(this);
        addFocusListener(this);
    }
    // Getters methods
    public Integer getInteger() throws NumericFormatException {
        checkInput();
        if (state)
            return integerValue;
        throw new NumericFormatException(fieldName);
    }
    public void setInteger(Integer newValue) {
        try {
            Integer oldValue = this.integerValue;
            this.integerValue = newValue;
            if(newValue!=null)
                setText(newValue.toString());
            else
                setText("");
            super.firePropertyChange(PROPERTY_INTEGER, oldValue, newValue);
        }
        catch(RuntimeException ex) {
            throw new RuntimeException("Error al querer modificar la propiedad "+PROPERTY_INTEGER);
        }
    }
    @Override
    public void keyReleased(KeyEvent arg0) {
        checkInput();
    }
    private void checkInput() {
        try {
            if (getText().length() < length) {
                if(getText().isEmpty())
                    integerValue = 0;
                else
                    integerValue = Integer.parseInt(getText());
            }
            else {
                setText(getText().substring(0, length));
                integerValue = Integer.parseInt(getText());
            }
            setForeground(color);
            state = true;
        }
        catch (NumberFormatException ex) {
            setForeground(Color.RED);
            state = false;
        }
    }
}
