package com.wbq.servlet.test.dao;

import com.wbq.servlet.test.entity.Manager;
import com.wbq.servlet.test.entity.Page;

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
     * @param page
     * @return
     */
    public List<Manager> queryAllManager(Page page);

    /**
     * ��ѯ��������
     *
     * @return
     */
    public long selectRowCount();

}
