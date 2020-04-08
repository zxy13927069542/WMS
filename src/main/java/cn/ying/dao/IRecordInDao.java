package cn.ying.dao;

import cn.ying.domain.RecordIn;

import java.util.List;

/**
 * 入库记录持久层接口
 */
public interface IRecordInDao {
    /**
     * 新增一条入库记录
     * @param recordIn
     */
    public void insert(RecordIn recordIn);

    /**
     * 根据入库记录id删除记录
     * @param recordId
     */
    public void delete(Integer recordId);

    /**
     * 获取所有入库记录
     * @return
     */
    public List<RecordIn> getAll();

    /**
     * 根据入库记录id获取入库记录
     * @param recordId
     * @return
     */
    public RecordIn getById(Integer recordId);

}
