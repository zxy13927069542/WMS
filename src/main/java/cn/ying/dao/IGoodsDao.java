package cn.ying.dao;

import cn.ying.domain.Goods;

import java.util.List;

/**
 * 货物持久层接口
 */
public interface IGoodsDao {
    /**
     * 增加一个货物
     * @param goods
     */
    public void insert(Goods goods);

    /**
     * 根据货物id删除货物
     * @param goodsId
     */
    public void delete(Integer goodsId);

    /**
     * 返货所有货物信息
     * @return
     */
    public List<Goods> getAll();

    /**
     * 根据货物id获取货物信息
     * @param goodsId
     * @return
     */
    public Goods getById(Integer goodsId);

    /**
     * 更新货物信息
     * @param goods
     */
    public void update(Goods goods);
}
