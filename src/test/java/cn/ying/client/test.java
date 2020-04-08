package cn.ying.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationcontext.xml")
public class test {
    @Autowired
    Login login;
    @Autowired
    MainFrame main;
    @Autowired
    GoodsQuery goodsQuery;


    @Autowired
    UpdateAccount updateAccount;

    //登陆界面测试
    @Test
    public void loginTest(){
        login.initComponents();
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //主界面测试
    @Test
    public void mainFrameTest(){
        main.initComponents();
        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



    //账户界面测试
    @Test
    public void updateAccountTest(){
        updateAccount.initComponents();
        try {
            Thread.sleep(1000000000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //商品界面测试
    @Test
    public void goodsQueryTest(){
        goodsQuery.initComponents();

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
