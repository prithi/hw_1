package com.prithi.hw_1.service;

import com.prithi.hw_1.dao.EmployeeDao;
import com.prithi.hw_1.domain.EmployeePOJO;

import java.sql.SQLException;

/**
 * Created by Prithi on 09-Feb-17.
 */
public class EmployeeDetailService {

    public void save(EmployeePOJO employeePOJO){
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.save(employeePOJO);
    }

    public void viewAll() throws SQLException, ClassNotFoundException {
        EmployeeDao employeeDao =new EmployeeDao();
        employeeDao.viewAll();
    }
}
