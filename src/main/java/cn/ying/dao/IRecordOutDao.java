package cn.ying.dao;

import cn.ying.domain.RecordOut;

import java.util.List;

/**
 * 出库记录持久层接口
 */
public interface IRecordOutDao {
    /**
     * 新增一条出库记录
     * @param recordOut
     */
    public void insert(RecordOut recordOut);

    /**
     * 根据出库记录id删除记录
     * @param recordId
     */
    public void delete(Integer recordId);

    /**
     * 获取所有出库记录
     * @return
     */
    public List<RecordOut> getAll();

    /**
     * 根据出库记录id获取出库记录
     * @param recordId
     * @return
     */
    public RecordOut getById(Integer recordId);
}
