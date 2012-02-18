/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mike.utils.jnumericfield.component;

import java.awt.Color;
import java.awt.event.KeyEvent;
import mike.utils.jnumericfield.exceptions.NumericFormatException;

/**
 *
 * @author mike
 */
public class JIntegerField extends JNumericField {
    private static final long serialVersionUID = 7616424087071733020L;
    // Properties name
    public static final String PROPERTY_INTEGER = "integer";
    // Properties
    private Integer integer;
    

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
        this.integer = integer;
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
        if (state) {
            return integer;
        }
        throw new NumericFormatException(fieldName);
    }
    public void setInteger(Integer newValue) {
        try {
            Integer oldValue = this.integer;
            this.integer = newValue;
            setText(newValue.toString());
            super.firePropertyChange(PROPERTY_INTEGER, oldValue, newValue);
        }
        catch(RuntimeException ex) {
            
        }
    }
    @Override
    public void keyReleased(KeyEvent arg0) {
        try {
            if (getText().length() < length) {
                integer = Integer.parseInt(getText());
            } else {
                setText(getText().substring(0, length));
                integer = Integer.parseInt(getText());
            }
            setForeground(color);
            state = true;
        } catch (NumberFormatException ex) {
            setForeground(Color.RED);
            state = false;
        }
    }
}
