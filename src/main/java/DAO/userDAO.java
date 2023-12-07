package DAO;

import pojo.user;

/**
 * @Author Jinfeng
 * @Date 12/22/2021 11:39 PM
 * @Description
 */
public interface userDAO
{
    /**
     * @Author Jinfeng
     * @Date 12/22/2021 11:46 PM
     * @Description 查询用户名 返回null则说明：用户名不存在
     * @param: username
     * @return pojo.User
     */
    public user lookForUsername(String username);

    /**
     * @Author Jinfeng
     * @Date 12/22/2021 11:47 PM
     * @Description 验证用户名与密码, 返回null则说明：帐号或密码错误
     * @param: username
     * @param: password
     * @return pojo.User
     */
    public user signInVerification(String username, String password);

    /**
     * @Author Jinfeng
     * @Date 12/22/2021 11:47 PM
     * @Description 保存用户名与密码 返回-1则说明：保存失败
     * @param: user
     * @return int
     */
    public int saveUser(user user);

}
