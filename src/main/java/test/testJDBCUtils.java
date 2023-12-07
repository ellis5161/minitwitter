package test;

import org.junit.Test;
import utils.JdbcUtils;

import java.sql.Connection;

/**
 * @Author Jinfeng
 * @Date 12/21/2021 1:12 AM
 * @Description
 */
public class testJDBCUtils
{
    @Test
    public void testGetConneciton(){
        Connection conn = null;
        Connection conn1 = null;
        for (int i = 0; i < 100; i++)
        {
            conn = JdbcUtils.getConnection();
            conn1 = JdbcUtils.getConnection();
            System.out.println(i + ": "+conn);
            System.out.println(i + ": "+conn1);
            JdbcUtils.closeResources(conn);
            JdbcUtils.closeResources(conn1);
        }
    }
}
