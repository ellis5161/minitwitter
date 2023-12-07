package service.impl;

import DAO.impl.UserDAOImp;
import pojo.user;
import service.UserService;

/**
 * @Author Jinfeng
 * @Date 12/24/2021 12:44 AM
 * @Description
 */
public class UserServiceImpl implements UserService
{
    private UserDAOImp userDAOImp = new UserDAOImp();

    /**
     * @Author Jinfeng
     * @Date 12/26/2021 12:22 AM
     * @Description 将用户信息写入数据库
     * @param: user
     * @return int 返回1表示注册成功，-2则表示因为账户已存在注册失败， -1则另有原因
     */
    @Override
    public int registUser(user user)
    {
        if(existsUnsername(user.getUsername()))
            return -2;
        else
            return userDAOImp.saveUser(user);
    }

    /**
     * @Author Jinfeng
     * @Date 12/24/2021 12:54 AM
     * @Description 用户登录功能 检测输入用户名及密码 是否匹配
     * @param: user
     * @return pojo.User 如果返回的user为null则说明验证失败，user不为null则成功
     */
    @Override
    public user login(user user)
    {
        return userDAOImp.signInVerification(user.getUsername(), user.getPassword());
    }

    /**
     * @Author Jinfeng
     * @Date 12/24/2021 12:52 AM
     * @Description 用于检测用户名是否存在
     * @param: username
     * @return boolean  返回false则说明用户名不存在，反之则表示用户名已存在
     */
    @Override
    public boolean existsUnsername(String username)
    {
        if(userDAOImp.lookForUsername(username) == null)
            return false;
        else
            return true;
    }
}
