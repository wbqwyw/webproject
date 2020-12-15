package com.wbq.servlet.test.dao;

import com.wbq.servlet.test.entity.Manager;
import com.wbq.servlet.test.entity.Page;

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
     * @param page
     * @return
     */
    public List<Manager> queryAllManager(Page page);

    /**
     * 查询数据行数
     *
     * @return
     */
    public long selectRowCount();

}
