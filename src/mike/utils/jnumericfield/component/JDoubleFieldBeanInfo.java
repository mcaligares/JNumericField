package mike.utils.jnumericfield.component;

import java.beans.BeanDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * JDoubleFieldBeanInfo.java
 * Created on 18/02/2012, 10:25:55
 * 
 * @author Miguel Augusto Caligares
 * @email mcaligares@gmail.com
 * @version 0.1.4
 */
public class JDoubleFieldBeanInfo extends SimpleBeanInfo {
    private static final String FILE = "/mike/utils/jnumericfield/resources/JNumericFieldIcon%s.gif";
    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor bd = new BeanDescriptor(JIntegerField.class, null);
        bd.setDisplayName("Double Field");
        bd.setShortDescription("A lightweight component that allow the editing of a simple line of a length determined.");
        return bd;
    }
    @Override
    public java.awt.Image getIcon(int iconKind) {
        switch (iconKind) {
            case ICON_MONO_16x16: return loadImage(String.format(FILE, "Mono16"));
            case ICON_MONO_32x32: return loadImage(String.format(FILE, "Mono32"));
            case ICON_COLOR_16x16:  return loadImage(String.format(FILE, "Color16"));
            case ICON_COLOR_32x32: return loadImage(String.format(FILE, "Color32"));
            default: return null;
        }
    }
}
