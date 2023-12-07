package test;

import DAO.impl.UserDAOImp;
import org.junit.Test;
import pojo.user;
import utils.JdbcUtils;


/**
 * @Author Jinfeng
 * @Date 12/22/2021 11:58 PM
 * @Description
 */
public class UserDAOTest
{
    UserDAOImp imp = new UserDAOImp();

    @Test
    public void lookForUsername()
    {
        if (imp.lookForUsername("a10546") == null)
            System.out.println("用户名不存在");
        else
            System.out.println("用户名已存在");
    }

    @Test
    public void signInVerification()
    {
        if (imp.signInVerification("a10546", "woai1ni") == null)
            System.out.println("帐号或密码错误");
        else
            System.out.println("登陆成功");
    }

    @Test
    public void saveUser()
    {
        try {
            if(imp.saveUser(new user("admin1465", "Admin1465.", "admin",0)) == 1) {
                System.out.println("帐号注册成功");
                JdbcUtils.commitAndClose();
            }
            else {
                System.out.println("帐号注册失败");
                JdbcUtils.rollbackAndClose();
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }
}