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
     * @return
     */
    public Manager login(int usercode, String username);

}
