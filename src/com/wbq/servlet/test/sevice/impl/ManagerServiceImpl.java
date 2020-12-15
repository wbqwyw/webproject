package com.wbq.servlet.test.sevice.impl;

import com.wbq.servlet.test.dao.ManagerDao;
import com.wbq.servlet.test.dao.impl.ManagerDaoImpl;
import com.wbq.servlet.test.entity.Manager;
import com.wbq.servlet.test.sevice.ManagerService;

/**
 * @ClassName ManagerService
 * @Description managerService  µœ÷¿‡
 * @Author wbq
 * @Date 2020/12/13 22:05
 * @Version 1.0
 */
public class ManagerServiceImpl implements ManagerService {

    private ManagerDao dao = new ManagerDaoImpl();

    @Override
    public Manager login(int usercode, String username) {
        Manager manager = dao.queryManager(usercode);
        if (manager != null) {
            if (manager.getUsername().equals(username)) {
                return manager;
            }
        }
        return null;
    }
}
