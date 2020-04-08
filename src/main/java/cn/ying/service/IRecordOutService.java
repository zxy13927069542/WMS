package cn.ying.service;

import cn.ying.domain.RecordOut;
import cn.ying.exception.NullCustomerException;
import cn.ying.exception.NullStockException;
import cn.ying.exception.ShortGoodsException;

/**
 * 出库业务层接口
 */
public interface IRecordOutService {
    /**
     * 出库
     * @param out
     */
    public void recordOut(RecordOut out) throws NullStockException, NullCustomerException, ShortGoodsException;
}
