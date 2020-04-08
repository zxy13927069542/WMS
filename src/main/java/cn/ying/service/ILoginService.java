package cn.ying.service;

import cn.ying.exception.DuplicateAccountException;
import cn.ying.exception.NullUserException;
import cn.ying.exception.WrongNameException;
import cn.ying.exception.WrongPasswordException;

/**
 * 登录功能service层接口
 */
public interface ILoginService {
    /**
     * 登录功能
     * @param name
     * @param password
     */
    public boolean login(String name,String password) throws NullUserException, WrongNameException, WrongPasswordException;


    public boolean enroll(String name,String password) throws DuplicateAccountException;
}
