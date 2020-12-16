package com.wbq.servlet.test.sevice;

import com.wbq.servlet.test.entity.Manager;

/**
 * @author wbq
 */
public interface ManagerService {

    /**
     * ¹ÜÀíÔ±µÇÂ¼
     *
     * @param usercode
     * @return
     */
    public Manager login(int usercode, String username);

}
