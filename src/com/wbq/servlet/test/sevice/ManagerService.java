package com.wbq.servlet.test.sevice;

import com.wbq.servlet.test.entity.Manager;

/**
 * @author wbq
 */
public interface ManagerService {

    /**
     * ����Ա��¼
     *
     * @param usercode
     * @param username
     * @return
     */
    public Manager login(int usercode, String username);

    /**
     * ��ѯ����Ա
     *
     * @param usercode
     * @return
     */
    public Manager queryManager(int usercode);

    /**
     * ɾ������Ա
     *
     * @param usercode
     * @return
     */
    public int deleteManager(int usercode);

    /**
     * �޸Ĺ���Ա
     *
     * @param manager
     * @return
     */
    public int updateManager(Manager manager);

}
