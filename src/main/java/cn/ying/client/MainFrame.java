/*
 * Created by JFormDesigner on Fri Jan 31 16:34:06 CST 2020
 */

package cn.ying.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

/**
 * @author Brainrain
 */
@Controller
public class MainFrame extends JFrame {

    @Autowired
    UpdateAccount updateAccount;
    public MainFrame() {
        //initComponents();
    }




    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        updateAccount.initComponents();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        button2 = new JButton();
        button1 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button2 ----
        button2.setText(bundle.getString("button2.text_3"));
        contentPane.add(button2);
        button2.setBounds(240, 60, 120, 90);

        //---- button1 ----
        button1.setText(bundle.getString("button1.text_3"));
        contentPane.add(button1);
        button1.setBounds(45, 35, 110, 75);

        //---- button3 ----
        button3.setText(bundle.getString("button3.text_2"));
        contentPane.add(button3);
        button3.setBounds(30, 155, 133, 60);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button2;
    private JButton button1;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
