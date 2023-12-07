package DAO;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author Jinfeng
 * @Date 12/22/2021 1:59 AM
 * @Description
 */
public abstract class BaseDAO
{
    //创建QueryRunner
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * @return int 返回影响的行数，-1则说明返回失败
     * @Author Jinfeng
     * @Date 12/22/2021 2:25 AM
     * @Description 进行update，delete，insert操作
     * @param: sql
     * @param: args
     */
    public int update(String sql, Object... args)
    {
        Connection conn = JdbcUtils.getConnection();

        try
        {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * @return T 返回null则说明没查询到东西
     * @Author Jinfeng
     * @Date 12/22/2021 2:40 AM
     * @Description 针对单个查询的操作
     * @param: type 泛型的class
     * @param: sql  sql语句
     * @param: args sql语句对应填充参数
     */
    public <T> T query(Class<T> type, String sql, Object... args)
    {
        Connection conn = JdbcUtils.getConnection();

        try
        {
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * @return T 返回null则说明没查询到东西
     * @Author Jinfeng
     * @Date 12/22/2021 2:49 AM
     * @Description 针对多个查询的操作
     * @param: type 泛型的class
     * @param: sql  sql语句
     * @param: args sql语句对应填充参数
     */
    public <T> List<T> queryList(Class<T> type, String sql, Object... args)
    {
        Connection conn = JdbcUtils.getConnection();

        try
        {
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * @return java.lang.Object 返回null则说明无查询物
     * @Author Jinfeng
     * @Date 12/22/2021 2:52 AM
     * @Description 查询特殊值如 count()
     * @param: sql  sql语句
     * @param: args sql语句对应填充参数
     */
    public Object specialQuery(String sql, Object... args)
    {
        Connection conn = JdbcUtils.getConnection();
        try
        {
            return queryRunner.query(conn, sql, new ScalarHandler<>(), args);
        } catch (SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
