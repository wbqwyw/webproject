package com.wbq.servlet.test.dao.impl;

import com.wbq.servlet.test.dao.ManagerDao;
import com.wbq.servlet.test.entity.Manager;
import com.wbq.servlet.test.entity.Page;
import com.wbq.servlet.test.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName ManagerDaoImpl
 * @Description 管理员dao实现类
 * @Author wbq
 * @Date 2020/12/13 21:56
 * @Version 1.0
 */
public class ManagerDaoImpl implements ManagerDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public Manager queryManager(int usercode) {
        Manager query = null;
        try {
            query = queryRunner.query(DBUtils.getConnection(), "select * from manager where usercode = ?", new BeanHandler<Manager>(Manager.class), usercode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query;
    }

    @Override
    public List<Manager> queryAllManager(Page page) {

        List<Manager> managerList = null;
        try {
            managerList = queryRunner.query(DBUtils.getConnection(), "select * from manager limit ?,?;", new BeanListHandler<Manager>(Manager.class), page.getStartRows(), page.getPageSize());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return managerList;
    }

    @Override
    public long selectRowCount() {
        try {
            return queryRunner.query(DBUtils.getConnection(), "select count(*) from manager ;", new ScalarHandler<>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteManager(int usercode) {
        try {
            DBUtils.begin();
            int result = queryRunner.execute(DBUtils.getConnection(), "delete from manager where usercode =?", usercode);
            DBUtils.commit();
            return result;
        } catch (SQLException throwables) {
            DBUtils.rollback();
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateManager(Manager manager) {
        try {
            DBUtils.begin();
            int result = queryRunner.execute(DBUtils.getConnection(), "update manager set username=? where usercode =?", manager.getUsername(), manager.getUsercode());
            DBUtils.commit();
            return result;
        } catch (SQLException throwables) {
            DBUtils.rollback();
            throwables.printStackTrace();
        }

        return 0;
    }
}
