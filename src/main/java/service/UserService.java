package service;

import pojo.user;

/**
 * @Author Jinfeng
 * @Date 12/24/2021 12:38 AM
 * @Description
 */
public interface UserService
{
    //注册用户
    public int registUser(user user);

    //用户登录
    public user login(user user);

    //检测用户是否存在
    public boolean existsUnsername(String username);
}
