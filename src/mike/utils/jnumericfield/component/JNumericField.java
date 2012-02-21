package mike.utils.jnumericfield.component;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import javax.swing.JTextField;

/**
 * JNumericField.java
 * 
 * @author Miguel Augusto Caligares
 * @email mcaligares@gmail.com
 * @version 0.1.4
 */
public class JNumericField extends JTextField implements KeyListener, FocusListener {
    private static final long serialVersionUID = -7016382511880655438L;
    // Properties name
    public static final String PROPERTY_FIELD_NAME = "fieldName";
    public static final String PROPERTY_LENGTH = "length";
    public static final String PROPERTY_STATE = "state";
    // Properties
    protected String fieldName;
    protected boolean state;
    protected Color color;
    protected int length;

    // Empty constructor
    public JNumericField() {}
    
    // Getters methods
    public int getLength() {return length;}
    public String getFieldName() {return fieldName;}
    public boolean isState() {return state;}
    
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
    public void setFieldName(String newValue) {
        String oldValue = this.fieldName;
        this.fieldName = newValue;
        super.firePropertyChange(PROPERTY_FIELD_NAME, oldValue, newValue);
    }
    public void setState(boolean newValue) {
        boolean oldValue = state;
        state = newValue;
        if(!state)
            setForeground(Color.RED);
        else
            setForeground(color);
        super.firePropertyChange(PROPERTY_STATE, oldValue, newValue);
    }
    
    @Override
    public void keyTyped(KeyEvent arg0) {}
    @Override
    public void keyPressed(KeyEvent arg0) {}
    @Override
    public void keyReleased(KeyEvent arg0) {
        //TODO implementation code
    }
    @Override
    public void focusGained(FocusEvent arg0) {
        setSelectionStart(0);
        setSelectionEnd(getText().length());
    }
    @Override
    public void focusLost(FocusEvent arg0) {}
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
         super.addPropertyChangeListener(listener);
     }
    @Override
     public void removePropertyChangeListener(PropertyChangeListener listener) {
         super.removePropertyChangeListener(listener);
     }   
}
