/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mike.utils.jnumericfield.component;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import mike.utils.jnumericfield.exceptions.NumericFormatException;

/**
 *
 * @author mike
 */
public class JDoubleField extends JNumericField {
    private static final long serialVersionUID = -3780334652509562318L;
    // Properties name
    public static final String PROPERTY_DOUBLE = "doubleValue";
    public static final String PROPERTY_DOUBLE_LENGTH = "doubleLength";
    // Properties
    private Double doubleValue;
    private int doubleLength;

    public JDoubleField() {
        this("Field JNumber", 0.0, 2, 10, true);
    }
    public JDoubleField(String fieldName, Double doubleValue, int doubleLength, int length) {
        this(fieldName, doubleValue, doubleLength, length, true);
    }

    @SuppressWarnings("LeakingThisInConstructor")
    public JDoubleField(String fieldName, Double doubleValue, int doubleLength, int length, boolean state) {
        this.doubleValue = doubleValue;
        this.doubleLength = doubleLength;
        this.length = length;
        this.fieldName = fieldName;
        this.color = getForeground();
        this.state = state;
        if (!state) setForeground(Color.RED);
        setText(doubleValue.toString());
        addKeyListener(this);
        addFocusListener(this);
    }
    
    // Getters methods
    public int getDoubleLength() {
        return doubleLength;
    }
    public Double getDoubleValue() throws NumericFormatException {
        if (state) {
            return doubleValue;
        }
        throw new NumericFormatException(fieldName);
    }
    
    // Setters methods
    public void setDoubleLength(int newValue) {
        int oldValue = doubleLength;
        doubleLength = newValue;
        super.firePropertyChange(PROPERTY_DOUBLE_LENGTH, oldValue, newValue);
    }
    public void setDoubleValue(Double newValue) {
        try {
            Double oldValue = this.doubleValue;
            this.doubleValue = newValue;
            setText(newValue.toString());
            super.firePropertyChange(PROPERTY_DOUBLE, oldValue, newValue);
        }
        catch (RuntimeException ex) {
            throw new RuntimeException("Initialization of component failure.");
        }
    }
    // Key released event
    @Override
    public void keyReleased(KeyEvent arg0) {
        try {
            if (getText().length() < length) {
                doubleValue = toDoubleFormat(Double.parseDouble(getText()));
            }
            else {
                setText(getText().substring(0, length));
                doubleValue = toDoubleFormat(Double.parseDouble(getText()));
            }
            setForeground(color);
            state = true;
        }
        catch (NumberFormatException ex) {
            setForeground(Color.RED);
            state = false;
        }
    }
    //Method toDoubleFormat
    private double toDoubleFormat(double importe) {
        BigDecimal bd = new BigDecimal(importe);
        bd = bd.setScale(doubleLength, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
