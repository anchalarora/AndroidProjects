package com.altiux.mvpexample.Model;

/**
 * Created by Sivananda.CK on 4/10/2017.
 */

public class Employee {
    private String empName , empNo;

    public Employee() {
        this.empName = "Siva";
        this.empNo = "118";
    }

   public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = "118";
    }

    public String getEmpName() {

        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = "Siva";
    }
}
