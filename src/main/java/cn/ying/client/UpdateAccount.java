/*
 * Created by JFormDesigner on Fri Jan 31 19:31:19 CST 2020
 */

package cn.ying.client;

import cn.ying.dao.IUserDao;
import cn.ying.domain.User;
import cn.ying.exception.DuplicateAccountException;
import cn.ying.exception.NullUserException;
import cn.ying.exception.WrongNameException;
import cn.ying.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Brainrain
 */
@Controller
public class UpdateAccount extends JFrame {
    @Autowired
    IUserDao userDao;

    @Autowired
    IAccountService accountService;
    public UpdateAccount() {
        //initComponents();
    }

    //点击更新按钮
    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String account = textField1.getText();
        String password = textField2.getText();
        User user = new User();
        user.setName(account);
        user.setPassword(password);
        try {
            accountService.update(user);

            JOptionPane.showMessageDialog(null, "更新成功，刷新一下试试吧");

        } catch (NullUserException ex) {
            //文本提示框
            JOptionPane.showMessageDialog(null, "账号或密码为空");
        } catch (WrongNameException ex) {
            //文本提示框
            JOptionPane.showMessageDialog(null, "账户名错误");
        } finally {
            textField1.setText("");
            textField2.setText("");
        }
    }

    //点击刷新按钮
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        //initComponents();
        model = new DefaultTableModel(new Object[][] {},new String[]{"用户名","密码"});
        table1.setModel(model);
        List<User> users = userDao.getAll();
        for (User user:users){
            model.addRow(new Object[]{user.getName(),user.getPassword()});
        }


    }

    //点击删除按钮
    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String account = textField1.getText();
        try {
            accountService.delete(account);
            textField1.setText("");
            textField2.setText("");
            JOptionPane.showMessageDialog(null, "删除成功，刷新一下试试吧");

        } catch (NullUserException ex) {
            //文本提示框
            JOptionPane.showMessageDialog(null, "账号为空");
        } catch (WrongNameException ex) {
            //文本提示框
            JOptionPane.showMessageDialog(null, "账户名错误");
        } finally {
            textField1.setText("");
            textField2.setText("");
        }
    }

    //点击插入按钮
    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String account = textField1.getText();
        String password = textField2.getText();
        User user = new User();
        user.setName(account);
        user.setPassword(password);
        try {
            accountService.insert(user);
            JOptionPane.showMessageDialog(this, "插入成功，刷新一下试试吧");

        } catch (NullUserException ex) {
            //文本提示框
            JOptionPane.showMessageDialog(this, "账号为空");
        } catch (DuplicateAccountException ex) {
            //文本提示框
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            textField1.setText("");
            textField2.setText("");
        }
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                }
                contentPanel.add(scrollPane1);
                scrollPane1.setBounds(0, 0, 375, 135);

                //---- label1 ----
                label1.setText(bundle.getString("label1.text"));
                contentPanel.add(label1);
                label1.setBounds(35, 175, 40, 30);

                //---- label2 ----
                label2.setText(bundle.getString("label2.text"));
                contentPanel.add(label2);
                label2.setBounds(35, 220, 40, 30);
                contentPanel.add(textField1);
                textField1.setBounds(80, 175, 190, textField1.getPreferredSize().height);
                contentPanel.add(textField2);
                textField2.setBounds(80, 220, 190, textField2.getPreferredSize().height);

                //---- button1 ----
                button1.setText(bundle.getString("button1.text_2"));
                button1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button1ActionPerformed(e);
                    }
                });
                contentPanel.add(button1);
                button1.setBounds(340, 155, 100, 45);

                //---- button2 ----
                button2.setText(bundle.getString("button2.text"));
                button2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button2ActionPerformed(e);
                    }
                });
                contentPanel.add(button2);
                button2.setBounds(395, 40, 88, 45);

                //---- button3 ----
                button3.setText(bundle.getString("button3.text"));
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button3ActionPerformed(e);
                    }
                });
                contentPanel.add(button3);
                button3.setBounds(340, 220, 103, 45);

                //---- button4 ----
                button4.setText(bundle.getString("button4.text"));
                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button4ActionPerformed(e);
                    }
                });
                contentPanel.add(button4);
                button4.setBounds(340, 280, 103, 45);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //手动添加代码
        model = new DefaultTableModel(new Object[][] {},new String[]{"用户名","密码"});
        table1.setModel(model);
        List<User> users = userDao.getAll();
        for (User user:users){
            model.addRow(new Object[]{user.getName(),user.getPassword()});
        }
        this.setVisible(true);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private DefaultTableModel model;// 用于存储表格数据
}
