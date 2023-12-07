package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author Jinfeng
 * @Date 12/21/2021 12:50 AM
 * @Description
 */
public class JdbcUtils
{
    //创建唯一连接池对象
    private static DataSource pool = null;
    private static ThreadLocal<Connection> threadLocalConn = new ThreadLocal<>();

    //加载并给连接池赋值
    static
    {
        try
        {
            //InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //relative path doesn't work due to unknown reason therefore using absolute path
            InputStream resourceAsStream = new FileInputStream("E:\\Software Development\\Workspace\\Java\\CCNY\\miniTwitter\\miniTwitter\\src\\main\\java\\jdbc.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);

            pool = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @return java.sql.Connection
     * @Author Jinfeng
     * @Date 12/21/2021 1:05 AM
     * @Description get database connection from the source pool, fail to get connection if return null
     */
    public static Connection getConnection()
    {
        Connection connection = threadLocalConn.get();

        if (connection == null)
        {
            try
            {
                connection = pool.getConnection();
                threadLocalConn.set(connection);
                connection.setAutoCommit(false);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        return connection;
    }

    /**
     * 使用了新方法 commitAndClose()： 使用了Threadlocal来确保实现事务
     *
     * @return void
     * @Author Jinfeng
     * @Date 12/21/2021 1:07 AM
     * @Description close Connection
     * @param: conn
     */
    public static void closeResources(Connection conn)
    {
        try
        {
            if (conn != null)
                conn.close();
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }

    /**
     * @return void
     * @Author Jinfeng
     * @Date 12/21/2021 1:10 AM
     * @Description close Connection and PreparedStatement
     * @param: conn
     * @param: ps
     */
    public static void closeResources(Connection conn, PreparedStatement ps)
    {
        try
        {
            if (conn != null)
                conn.close();
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }

        try
        {
            if (ps != null)
                ps.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * @return void
     * @Author Jinfeng
     * @Date 12/21/2021 1:11 AM
     * @Description close Connection, PreparedStatement and ResultSet
     * @param: conn
     * @param: ps
     * @param: rs
     */
    public static void closeResources(Connection conn, PreparedStatement ps, ResultSet rs)
    {
        try
        {
            if (conn != null)
                conn.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        try
        {
            if (ps != null)
                ps.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        try
        {
            if (rs != null)
                ps.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 事务实现：提交数据 并关闭数据库连接
     *
     * @Author Jinfeng
     * @Date 2/2/2022 6:47 PM
     * @return void
     */
    public static void commitAndClose()
    {
        Connection connection = threadLocalConn.get();

        if (connection != null)
        {
            try
            {
                connection.commit();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            } finally
            {
                try
                {
                    connection.close();
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }

        //一定要执行remove 否则会出错（因为Tomcat底层使用了线程池技术）
        threadLocalConn.remove();
    }

    public static void rollbackAndClose(){
        Connection connection = threadLocalConn.get();

        if (connection != null)
        {
            try
            {
                connection.rollback();
            } catch (SQLException throwables)
            {
                throwables.printStackTrace();
            } finally
            {
                try
                {
                    connection.close();
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }

        //一定要执行remove 否则会出错（因为Tomcat底层使用了线程池技术）
        threadLocalConn.remove();
    }

}
