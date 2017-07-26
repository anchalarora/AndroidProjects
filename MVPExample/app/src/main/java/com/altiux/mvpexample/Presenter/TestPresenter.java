package com.altiux.mvpexample.Presenter;

import com.altiux.mvpexample.Model.Employee;
import com.altiux.mvpexample.interfaces.IDataAcceptors;
import com.altiux.mvpexample.interfaces.IEventHandler;

/**
 * Created by Sivananda.CK on 4/10/2017.
 */

public class TestPresenter implements IEventHandler {

    IDataAcceptors iDataAcceptors;
    Employee emp;

    public  TestPresenter(IDataAcceptors iDataAcceptors) {
        this.iDataAcceptors = iDataAcceptors;

    }

    @Override
    public void processEvent() {
        // Invoke the Model and fetch data from Model
        emp = new Employee();
        iDataAcceptors.acceptDataFromPresenter(emp);
    }
}
