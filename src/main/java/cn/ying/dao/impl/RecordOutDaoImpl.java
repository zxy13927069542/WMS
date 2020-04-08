package cn.ying.dao.impl;

import cn.ying.dao.IRecordOutDao;
import cn.ying.domain.RecordOut;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 出库记录持久层实现类
 */
@Repository
public class RecordOutDaoImpl implements IRecordOutDao {
    @Autowired
    QueryRunner runner;
    public void insert(RecordOut recordOut) {
        try {
            runner.update("insert into record_out(goodsid,amount,time) values(?,?,?)",recordOut.getGoodsId(),recordOut.getAmount(),recordOut.getTime());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer recordId) {
        try {
            runner.update("delete from record_out where id=?", recordId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<RecordOut> getAll() {
        try {
            return runner.query("select * from record_out", new BeanListHandler<RecordOut>(RecordOut.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public RecordOut getById(Integer recordId) {
        try {
            return runner.query("select * from record_out where id=?",new BeanHandler<RecordOut>(RecordOut.class),recordId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
