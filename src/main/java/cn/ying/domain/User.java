package cn.ying.domain;

import java.io.Serializable;

/**
 * 用户实体类
 */
public class User implements Serializable {
    //账户名
    private String name;

    //账户密码
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
