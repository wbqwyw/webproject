package com.wbq.servlet.test.sevice;

import com.wbq.servlet.test.entity.Manager;

/**
 * @author wbq
 */
public interface ManagerService {

    /**
     * 管理员登录
     *
     * @param usercode
     * @param username
     * @return
     */
    public Manager login(int usercode, String username);

    /**
     * 查询管理员
     *
     * @param usercode
     * @return
     */
    public Manager queryManager(int usercode);

    /**
     * 删除管理员
     *
     * @param usercode
     * @return
     */
    public int deleteManager(int usercode);

    /**
     * 修改管理员
     *
     * @param manager
     * @return
     */
    public int updateManager(Manager manager);

}
