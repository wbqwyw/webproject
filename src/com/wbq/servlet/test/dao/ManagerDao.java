package com.wbq.servlet.test.dao;

import com.wbq.servlet.test.entity.Manager;

import java.util.List;

/**
 * @author wbq
 */
public interface ManagerDao {
    /**
     * ��ѯ����Ա
     *
     * @param usercode
     * @return
     */
    public Manager queryManager(int usercode);

    /**
     * ��ѯ���й���Ա
     *
     * @return
     */
    public List<Manager> queryAllManager();

}
