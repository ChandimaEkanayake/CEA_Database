/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahesh.db;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Akila Darshana
 */
public class MessagingCore {

    public static synchronized void showErrorMessage(Object Message, String Title) {
        JOptionPane.showMessageDialog(null, Message, Title, JOptionPane.ERROR_MESSAGE);

    }

    public static synchronized void showInformationMessage(Object Message, String Title) {
        JOptionPane.showMessageDialog(null, Message, Title, JOptionPane.INFORMATION_MESSAGE);

    }

    public static synchronized int showYesNoOption(Object Message, String Title) {
        return JOptionPane.showConfirmDialog(null, Message, Title, JOptionPane.YES_NO_OPTION);

    }

    public static synchronized int showInputWindow(Object Message, String Title) {
        return JOptionPane.showConfirmDialog(null, Message, Title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, new ImageIcon());

    }

}
