/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mike.utils.jnumericfield.component;

import java.awt.Image;
import java.beans.BeanDescriptor;
import java.beans.SimpleBeanInfo;


/**
 *
 * @author mike
 */
public class JNumericFieldBeanInfo extends SimpleBeanInfo {

    protected Image iconColor16;
    protected Image iconColor32;
    protected Image iconMono16;
    protected Image iconMono32;

    /**
     * Constructs a new BeanInfo.
     */
    public JNumericFieldBeanInfo(String bean) {
        try {
            iconColor16 = loadImage("/mike/utils/jnumericfield/resources/JNumericFieldColor16.gif");
            iconColor32 = loadImage("/mike/utils/jnumericfield/resources/JNumericFieldColor32.gif");
            iconMono16 = loadImage("/mike/utils/jnumericfield/resources/JNumericFieldMono16.gif");
            iconMono32 = loadImage("/mike/utils/jnumericfield/resources/JNumericFieldMono32.gif");
        } catch (RuntimeException e) {
            System.out.println("GenericBeanInfo.GenericBeanInfo(): " + e);
        }
    }
    
    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor bd = new BeanDescriptor(JNumericField.class, null);
        bd.setDisplayName("Numeric Field");
        bd.setName("A lightweight component that allow the editing of a simple line of a length determined.");
        return bd;
    }

    @Override
    public Image getIcon(int iconKind) {
        switch (iconKind) {
            case ICON_COLOR_16x16:
                return iconColor16;
            case ICON_COLOR_32x32:
                return iconColor32;
            case ICON_MONO_16x16:
                return iconMono16;
            case ICON_MONO_32x32:
                return iconMono32;
        }
        return null;
    }

}
