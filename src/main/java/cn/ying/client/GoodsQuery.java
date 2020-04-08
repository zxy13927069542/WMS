/*
 * Created by JFormDesigner on Sat Mar 21 21:44:36 CST 2020
 */

package cn.ying.client;

import cn.ying.domain.Goods;
import cn.ying.service.IGoodsService;
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
public class GoodsQuery extends JFrame {
    @Autowired
    IGoodsService goodsService;
    public GoodsQuery() {
        //initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        List<Goods> goods = goodsService.queryAll();
        for (Goods good:goods){
            model.addRow(new Object[]{good.getId(),good.getName(),good.getType(),good.getSize(),good.getOrigin(),good.getPrice()});
        }

    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("form");
        dialogPane = new JPanel();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(null);

            //---- button1 ----
            button1.setText(bundle.getString("button1.text_4"));
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button1ActionPerformed(e);
                }
            });
            dialogPane.add(button1);
            button1.setBounds(new Rectangle(new Point(295, 250), button1.getPreferredSize()));

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(table1);
            }
            dialogPane.add(scrollPane1);
            scrollPane1.setBounds(10, 5, 705, 190);

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
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        model = new DefaultTableModel(new Object[][] {},new String[]{"商品ID","商品名称","商品类型","商品大小","商品产地","商品价格"});
        table1.setModel(model);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private DefaultTableModel model;// 用于存储表格数据
}
