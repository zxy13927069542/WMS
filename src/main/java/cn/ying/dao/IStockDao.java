package cn.ying.dao;

import cn.ying.domain.Stock;

import java.util.List;

/**
 * 库存表持久层接口
 */
public interface IStockDao {
    /**
     * 插入一条库存记录
     * @param stock
     */
    public void insert(Stock stock);

    /**
     * 根据仓库id及货物id删除库存记录
     * @param
     */
    public void delete(Integer goodsId);

    /**
     * 获取所有库存信息
     * @return
     */
    public List<Stock> getAll();

    /**
     * 根据库存记录id获取库存记录
     * @param
     * @return
     */
    public Stock getById(Integer goodsId);

    /**
     * 更新库存信息
     * @param stock
     */
    public void update(Stock stock);
}
