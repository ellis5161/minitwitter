package DAO.impl;

import DAO.BaseDAO;
import DAO.userDAO;
import pojo.user;

/**
 * @Author Jinfeng
 * @Date
 * @Description
 */
public class UserDAOImp extends BaseDAO implements userDAO
{
    public UserDAOImp(){}
    /**
     *
     * @param username
     * @return
     * @Description return null means not exits
     */
    @Override
    public user lookForUsername(String username)
    {
        String sql = "select * from users where username = ?";
        return query(user.class, sql, username);
    }

    @Override
    public user signInVerification(String username, String password)
    {
        String sql = "select * from users where username = ? and password = ?";
        return query(user.class, sql, username, password);
    }

    @Override
    public int saveUser(user user)
    {
        String sql = "insert into users(username, password, nickname, authority) values(?,?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getNickname(),user.getAuthority());
    }
}
