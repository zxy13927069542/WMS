package cn.ying.service;

import cn.ying.domain.RecordIn;
import cn.ying.exception.NullGoodException;
import cn.ying.exception.NullRepositoryException;
import cn.ying.exception.NullSupplierException;

/**
 * 入库业务层接口
 */
public interface IRecordInService {
    /**
     * 入库
     * @param in
     */
    public void recordIn(RecordIn in) throws NullSupplierException, NullRepositoryException, NullGoodException;
}
