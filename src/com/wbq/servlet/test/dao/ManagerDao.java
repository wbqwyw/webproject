package com.wbq.servlet.test.dao;

import com.wbq.servlet.test.entity.Manager;

import java.util.List;

/**
 * @author wbq
 */
public interface ManagerDao {
    /**
     * 查询管理员
     *
     * @param usercode
     * @return
     */
    public Manager queryManager(int usercode);

    /**
     * 查询所有管理员
     *
     * @return
     */
    public List<Manager> queryAllManager();

}
