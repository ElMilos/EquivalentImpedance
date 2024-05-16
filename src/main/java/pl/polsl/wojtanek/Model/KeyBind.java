package pl.polsl.wojtanek.Model;

import javax.swing.*;
import java.awt.event.*;

/**
 * The class containing the control's key assignment method
 *
 * @author m
 */
public class KeyBind {

    /**
     * Sets key bindings for various components in the user interface.
     *
     * @param frequencyField JTextField for frequency input
     * @param valueField1 JTextField for value input 1
     * @param valueField2 JTextField for value input 2

     * @param jTable1 JTable component
     */
    public static void setKeyBindings( JTextField frequencyField, JTextField valueField1, JTextField valueField2,JTable jTable1) {

        // Key bindings for text fields to set focus using keyboard shortcuts
        frequencyField.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.CTRL_DOWN_MASK), "frequencyPressed");
        frequencyField.getActionMap().put("frequencyPressed", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                frequencyField.requestFocusInWindow();
            }
        });

        // Key bindings for text fields to set focus using keyboard shortcuts
        valueField1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_2, KeyEvent.CTRL_DOWN_MASK), "valuePressed");
        valueField1.getActionMap().put("valuePressed", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                valueField1.requestFocusInWindow();
            }
        });

        // Key bindings for text fields to set focus using keyboard shortcuts
        valueField2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_3, KeyEvent.CTRL_DOWN_MASK), "valuePressed");
        valueField2.getActionMap().put("valuePressed", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                valueField2.requestFocusInWindow();
            }
        });

        // Key binding for the JTable component to set focus using a keyboard shortcut
        jTable1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK), "frequencyPressed");
        jTable1.getActionMap().put("frequencyPressed", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                jTable1.requestFocusInWindow();
            }
        });

    }
}
