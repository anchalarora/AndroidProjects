package com.altiux.mvpexample.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.altiux.mvpexample.Model.Employee;
import com.altiux.mvpexample.Presenter.TestPresenter;
import com.altiux.mvpexample.R;
import com.altiux.mvpexample.interfaces.IDataAcceptors;
import com.altiux.mvpexample.interfaces.IEventHandler;

public class MainActivity extends AppCompatActivity implements IDataAcceptors {

    TextView tvEmpName, tvEmpNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvEmpName = (TextView) findViewById(R.id.textView);
        tvEmpNo   = (TextView) findViewById(R.id.textView2);
    }

    public void buttonClick(View v) {
        IEventHandler presenter = new TestPresenter(this);
        presenter.processEvent();
    }

    @Override
    public void acceptDataFromPresenter(Employee e) {
        tvEmpName.setText(e.getEmpName());
        tvEmpNo.setText(e.getEmpNo());

    }


}
