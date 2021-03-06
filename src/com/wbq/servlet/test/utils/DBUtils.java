package com.wbq.servlet.test.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @ClassName DBUtils
 * @Description 连接数据库工具类
 * @Author wbq
 * @Date 2020/12/13 21:06
 * @Version 1.0
 */
public class DBUtils {
    public static final Properties PROPERTIES = new Properties();
    public static final ThreadLocal<Connection> THREAD_LOCAL = new ThreadLocal<>();
    private static DataSource ds;

    static {
        try {
            InputStream resourceAsStream = DBUtils.class.getResourceAsStream("/db.properties");
            PROPERTIES.load(resourceAsStream);
            ds = DruidDataSourceFactory.createDataSource(PROPERTIES);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection con = THREAD_LOCAL.get();
        try {
            if (con == null) {
                con = ds.getConnection();
                THREAD_LOCAL.set(con);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static void begin() {
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void commit() {
        Connection con = getConnection();
        try {
            con.commit();
            closeAll(con, null, null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(con, null, null);
        }
    }

    public static void rollback() {
        Connection con = getConnection();
        try {
            con.rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll(con, null, null);
        }
    }


    public static void closeAll(Connection con, Statement st, ResultSet rs) {
        try {
            if (con != null) {
                con.close();
                THREAD_LOCAL.remove();
            }
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
