package cn.ying.dao;

import cn.ying.domain.User;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {
    /**
     * 插入一个新用户
     * @param user
     */
    public void insert(User user);

    /**
     * 根据账户名删除账户
     * @param name
     */
    public void delete(String name);

    /**
     * 返回所有账户信息
     * @return
     */
    public List<User> getAll();

    /**
     * 根据账户名获取账户
     * @param name
     * @return
     */
    public User getById(String name);

    /**
     * 更新账户信息
     * @param user
     */
    public void update(User user);
}
