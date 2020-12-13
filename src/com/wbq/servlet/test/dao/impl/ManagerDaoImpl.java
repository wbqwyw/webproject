package com.wbq.servlet.test.dao.impl;

import com.wbq.servlet.test.dao.ManagerDao;
import com.wbq.servlet.test.entity.Manager;
import com.wbq.servlet.test.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
    private QueryRunner queryRunner = new QueryRunner(DBUtils.getDataSource());

    @Override
    public Manager queryManager(int usercode) {
        Manager query = null;
        try {
            query = queryRunner.query("select * from manager where usercode = ?", new BeanHandler<Manager>(Manager.class), usercode);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query;
    }

    @Override
    public List<Manager> queryAllManager() {

        List<Manager> managerList = null;
        try {
            managerList = queryRunner.query("select * from manager ;", new BeanListHandler<Manager>(Manager.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return managerList;
    }


}
