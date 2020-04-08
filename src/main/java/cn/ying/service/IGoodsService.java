package cn.ying.service;

import cn.ying.domain.Goods;

import java.util.List;

/**
 * 商品业务层接口
 */
public interface IGoodsService {
    /**
     * 查询所有商品信息
     * @return
     */
    public List<Goods> queryAll();
}
