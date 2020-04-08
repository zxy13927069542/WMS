package cn.ying.dao.impl;

import cn.ying.dao.IStockDao;
import cn.ying.domain.Stock;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 库存表持久层实现类
 */
@Repository
public class StockDaoImpl implements IStockDao {
    @Autowired
    QueryRunner runner;
    public void insert(Stock stock) {
        try {
            runner.update("insert into stock(goodsid,amount,address) values(?,?,?)",stock.getGoodsId(),stock.getAmount(),stock.getAddress());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer goodsId) {
        try {
            runner.update("delete from stock where goodsid=?",goodsId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public List<Stock> getAll() {
        try {
            return runner.query("select * from stock", new BeanListHandler<Stock>(Stock.class));
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        }
    }

    public Stock getById(Integer goodsId) {
        try {
            return runner.query("select * from stock where goodsid=?", new BeanHandler<Stock>(Stock.class),goodsId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Stock stock) {
        try {
            runner.update("update stock set amount=?,address=? where goodsid=?",stock.getAmount(),stock.getAddress(),stock.getGoodsId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
