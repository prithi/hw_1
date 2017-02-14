package com.prithi.hw_1;

import com.prithi.hw_1.domain.EmployeePOJO;
import com.prithi.hw_1.service.EmployeeDetailService;
import com.prithi.hw_1.service.IOService;

import java.sql.SQLException;

/**
 * Created by Prithi on 09-Feb-17.
 */
public class Main {

    public static void main (String [] args) throws SQLException, ClassNotFoundException {

        IOService ioService = new IOService();
        ioService.printWelcomeMessage();
        int userAction = 0;
        userAction = ioService.getUserAction();
        int view = 1;
        int save = 2;

        if (userAction == view){
            EmployeeDetailService employeeDetailService = new EmployeeDetailService();
            employeeDetailService.viewAll();
        }else if (userAction == save){
            EmployeePOJO employeeInformation = ioService.getNewEmployeeInformation();
            EmployeeDetailService employeeDetailService = new EmployeeDetailService();
            employeeDetailService.save(employeeInformation);
        }


    }
}
