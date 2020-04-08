package cn.ying.service;

import cn.ying.domain.User;
import cn.ying.exception.DuplicateAccountException;
import cn.ying.exception.NullUserException;
import cn.ying.exception.WrongNameException;

/**
 * 用户业务层接口
 */
public interface IAccountService {
    /**
     * 更新账户
     * @param user
     */
    public void update(User user) throws NullUserException, WrongNameException;

    /**
     * 删除账户
     * @param userName
     */
    public void delete(String userName) throws NullUserException, WrongNameException;

    /**
     * 插入一个账户
     * @param user
     */
    public void insert(User user) throws NullUserException, DuplicateAccountException;
}
