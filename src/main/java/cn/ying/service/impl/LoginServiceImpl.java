package cn.ying.service.impl;

import cn.ying.dao.IUserDao;
import cn.ying.domain.User;
import cn.ying.exception.DuplicateAccountException;
import cn.ying.exception.NullUserException;
import cn.ying.exception.WrongNameException;
import cn.ying.exception.WrongPasswordException;
import cn.ying.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录功能service实现类
 */
@Service
public class LoginServiceImpl implements ILoginService  {
    @Autowired
    IUserDao userDao;
    User user;
    public boolean login(String name, String password) throws NullUserException, WrongNameException, WrongPasswordException {
        if (name.equals("") || password.equals("")){
            throw new NullUserException("账号或密码为空");
        }
        else {
            user = userDao.getById(name);
            if (user == null){
                throw new WrongNameException("找不到指定账号，请检查账号名是否错误");
            }
            else {
                if (!user.getPassword().equals(password)){
                    throw new WrongPasswordException("密码错误");
                }
                return true;
            }
        }
    }

    @Override
    public boolean enroll(String name, String password) throws DuplicateAccountException {
        User target = userDao.getById(name);
        //账号已注册
        if (target != null){
            throw new DuplicateAccountException("账号已注册！");
        }
        target = new User();
        target.setName(name);
        target.setPassword(password);
        userDao.insert(target);
        return true;
    }
}
