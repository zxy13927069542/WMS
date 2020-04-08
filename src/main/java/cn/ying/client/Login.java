/*
 * Created by JFormDesigner on Fri Mar 20 13:24:59 CST 2020
 */

package cn.ying.client;

import cn.ying.exception.DuplicateAccountException;
import cn.ying.exception.NullUserException;
import cn.ying.exception.WrongNameException;
import cn.ying.exception.WrongPasswordException;
import cn.ying.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ResourceBundle;

/**
 * @author Brainrain
 */
@Controller
public class Login extends JFrame {

    @Autowired
    ILoginService loginService;

    @Autowired
    MainFrame mainFrame;

    int choice = 0;
    public Login() {
        //initComponents();
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (choice == 0){
            //文本提示框
            JOptionPane.showMessageDialog(null, "请选择功能！！");
        }
        //登录功能
        else if (choice == 1){
            //提取文本框里的用户名和密码
            String name_text = textField2.getText();
            String pwd_text = textField3.getText();
            try {
                if (loginService.login(name_text,pwd_text)){
                    //文本提示框
                    JOptionPane.showMessageDialog(null, "登陆成功");
                    //界面转换
                    //将原来页面设置为不可见
                    this.setVisible(false);
                    mainFrame.initComponents();
                }
            } catch (NullUserException e1) {
                //文本提示框
                JOptionPane.showMessageDialog(null, "账号或密码为空");

            } catch (WrongNameException e2) {
                //文本提示框
                JOptionPane.showMessageDialog(null, "账户名错误");
            } catch (WrongPasswordException e3) {
                //文本提示框
                JOptionPane.showMessageDialog(null, "密码错误");
            }

        }
        //注册功能
        else {
            //提取文本框里的用户名和密码
            String name_text = textField2.getText();
            String pwd_text = textField3.getText();
            try {
                loginService.enroll(name_text, pwd_text);
                //文本提示框
                JOptionPane.showMessageDialog(null, "注册成功，请登录");
            } catch (DuplicateAccountException ex) {
                //文本提示框
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }

    }

    private void ItemStateChanged(ItemEvent e) {
        // TODO add your code here
        if (e.getSource() == radioButton1) choice = 1;  //登录功能
        if (e.getSource() == radioButton2) choice = 2;  //注册功能
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        dialogPane = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button2 = new JButton();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(null);

            //---- label2 ----
            label2.setText(bundle.getString("label2.text_2"));
            dialogPane.add(label2);
            label2.setBounds(new Rectangle(new Point(80, 70), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText(bundle.getString("label3.text"));
            dialogPane.add(label3);
            label3.setBounds(new Rectangle(new Point(80, 120), label3.getPreferredSize()));
            dialogPane.add(textField2);
            textField2.setBounds(130, 60, 155, textField2.getPreferredSize().height);
            dialogPane.add(textField3);
            textField3.setBounds(130, 115, 155, textField3.getPreferredSize().height);

            //---- button2 ----
            button2.setText(bundle.getString("button2.text_2"));
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button2ActionPerformed(e);
                }
            });
            dialogPane.add(button2);
            button2.setBounds(new Rectangle(new Point(170, 185), button2.getPreferredSize()));

            //---- radioButton1 ----
            radioButton1.setText(bundle.getString("radioButton1.text"));
            radioButton1.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    ItemStateChanged(e);
                }
            });
            dialogPane.add(radioButton1);
            radioButton1.setBounds(new Rectangle(new Point(150, 155), radioButton1.getPreferredSize()));

            //---- radioButton2 ----
            radioButton2.setText(bundle.getString("radioButton2.text"));
            radioButton2.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    ItemStateChanged(e);
                }
            });
            dialogPane.add(radioButton2);
            radioButton2.setBounds(new Rectangle(new Point(220, 155), radioButton2.getPreferredSize()));

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < dialogPane.getComponentCount(); i++) {
                    Rectangle bounds = dialogPane.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = dialogPane.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                dialogPane.setMinimumSize(preferredSize);
                dialogPane.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(dialogPane);
        dialogPane.setBounds(0, 0, 398, 268);

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

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button2;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
