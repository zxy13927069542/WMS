package cn.ying.dao.impl;

import cn.ying.dao.IGoodsDao;
import cn.ying.domain.Goods;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 货物持久层实现类
 */
@Repository
public class GoodsDaoImpl implements IGoodsDao {
    @Autowired
    QueryRunner runner;
    public void insert(Goods goods) {
        try {
            runner.update("insert into goods(name,type,size,origin,price) values(?,?,?,?,?)",goods.getName(),goods.getType(),goods.getSize(),goods.getOrigin(),goods.getPrice());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(Integer goodsId) {
        try {
            runner.update("delete from goods where id=?",goodsId);
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }

    }

    public List<Goods> getAll() {
        try {
            return runner.query("select * from goods", new BeanListHandler<Goods>(Goods.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Goods getById(Integer goodsId) {
        try {
            return runner.query("select * from goods where id=?", new BeanHandler<Goods>(Goods.class),goodsId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Goods goods) {
        try {
            runner.update("update goods set name=?,type=?,size=?,origin=?,price=? where id=?",goods.getName(),goods.getType(),goods.getSize(),goods.getOrigin(),goods.getPrice(),goods.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
