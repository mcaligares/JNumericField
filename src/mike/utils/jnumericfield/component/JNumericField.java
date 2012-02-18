/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mike.utils.jnumericfield.component;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import javax.swing.JTextField;
import mike.utils.jnumericfield.exceptions.NumericFormatException;

/**
 *
 * @author mike
 */
public class JNumericField extends JTextField implements KeyListener, FocusListener {
    private static final long serialVersionUID = 7616424087071733020L;
    // Properties name
    public static final String PROPERTY_FIELD_NAME = "fieldName";
    public static final String PROPERTY_INTEGER = "integer";
    public static final String PROPERTY_LENGTH = "length";
    public static final String PROPERTY_STATE = "state";
    // Properties
    private String fieldName;
    private Integer integer;
    private boolean state;
    private Color color;
    private int length;

    // Empty constructor
    public JNumericField() {
        this("field jNumericField", 0, 10, true);
    }
    // Fielname, integer, lenght constructor
    public JNumericField(String fieldName, Integer integer, int length) {
        this(fieldName, integer, length, true);
    }
    // Constructor
//    @SuppressWarnings("LeakingThisInConstructor")
    public JNumericField(String fieldName, Integer integer, int length, boolean state) {
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
    public int getLength() {
        return length;
    }
    public String getFieldName() {
        return fieldName;
    }
    public Integer getInteger() throws NumericFormatException {
        if (state) {
            return integer;
        }
        throw new NumericFormatException(fieldName);
    }
    public boolean isState() {
        return state;
    }
    
    // Setters methods
    public void setLength(int newValue) {
        int oldValue = length;
        length = newValue;
        if(getText().length()>length)
            setState(false);
        else
            setState(true);
        super.firePropertyChange(PROPERTY_LENGTH, oldValue, newValue);
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
    public void setFieldName(String newValue) {
        String oldValue = this.fieldName;
        this.fieldName = newValue;
        super.firePropertyChange(PROPERTY_FIELD_NAME, oldValue, newValue);
    }
    public void setState(boolean newValue) {
        boolean oldValue = state;
        state = newValue;
        if(state)
            setForeground(Color.RED);
        else
            setForeground(color);
        super.firePropertyChange(PROPERTY_STATE, oldValue, newValue);
    }
    
    @Override
    public void keyTyped(KeyEvent arg0) {
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
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

    @Override
    public void focusGained(FocusEvent arg0) {
        setSelectionStart(0);
        setSelectionEnd(getText().length());
    }

    @Override
    public void focusLost(FocusEvent arg0) {
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
         super.addPropertyChangeListener(listener);
     }

    @Override
     public void removePropertyChangeListener(PropertyChangeListener listener) {
         super.removePropertyChangeListener(listener);
     }
    
}
