package cn.ying.dao.impl;

import cn.ying.dao.IRecordInDao;
import cn.ying.domain.RecordIn;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 入库记录持久层实现类
 */
@Repository
public class RecordInDaoImpl implements IRecordInDao {
    @Autowired
    QueryRunner runner;
    public void insert(RecordIn recordIn) {
        try {
            runner.update("insert into record_in(goodsid,amount,time) values(?,?,?)", recordIn.getGoodsId(),recordIn.getAmount(),recordIn.getTime());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer recordId) {
        try {
            runner.update("delete from record_in where id=?",recordId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<RecordIn> getAll() {
        try {
            return runner.query("select * from record_in", new BeanListHandler<RecordIn>(RecordIn.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public RecordIn getById(Integer recordId) {
        try {
            return runner.query("select * from record_in where id=?", new BeanHandler<RecordIn>(RecordIn.class),recordId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
