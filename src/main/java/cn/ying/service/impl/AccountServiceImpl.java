package cn.ying.service.impl;

import cn.ying.dao.IUserDao;
import cn.ying.domain.User;
import cn.ying.exception.DuplicateAccountException;
import cn.ying.exception.NullUserException;
import cn.ying.exception.WrongNameException;
import cn.ying.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务层实现类
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IUserDao userDao;
    public void update(User user) throws NullUserException, WrongNameException{
        if (user.getName().equals("") || user.getPassword().equals("")){
            throw new NullUserException("账号或密码为空");
        }
        else {
            User user1 = userDao.getById(user.getName());
            if (user1 == null){
                throw new WrongNameException("找不到指定账号，请检查账号名是否错误");
            }
            else {
                userDao.update(user);
            }
        }
    }

    public void delete(String userName) throws NullUserException, WrongNameException {
        if (userName.equals("")){
            throw new NullUserException("账户名为空");
        }
        else {
            User target = userDao.getById(userName);
            if (target == null){
                throw new WrongNameException("找不到指定账号，请检查账号名是否错误");
            }
            else {
                userDao.delete(userName);
            }
        }
    }

    public void insert(User user) throws NullUserException, DuplicateAccountException {
        if (user.getName().equals("") || user.getPassword().equals("")){
            throw new NullUserException("账号或密码为空");
        }
        else {
            User target = userDao.getById(user.getName());
            if (target != null){
                throw new DuplicateAccountException("账号重复，请重新输入");
            }
            else {
                userDao.insert(user);
            }
        }
    }
}
