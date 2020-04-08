package cn.ying.dao.impl;

import cn.ying.dao.IUserDao;
import cn.ying.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户持久层实现类
 */
@Repository
public class UserDaoImpl implements IUserDao {
    @Autowired
    QueryRunner runner;
    public void insert(User user) {
        try {
            runner.update("insert into user_account(name,password) values(?,?)", user.getName(),user.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String name) {
        try {
            runner.update("delete from user_account where name=?",name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<User> getAll() {
        try {
            return runner.query("select * from user_account", new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getById(String name) {
        try {
            return runner.query("select * from user_account where name=?", new BeanHandler<User>(User.class),name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(User user) {
        try {
            runner.update("update user_account set password=? where name=?", user.getPassword(),user.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
