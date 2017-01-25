package anchal.com.commuactivitytoservice;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static Handler UIHandler = null;
    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*if(null != OwnService.ServiceHandler)
        {
            Message msg = new Message();
            msg.what = 101;
            msg.obj = "hello My dear Service !!!How are you?? Can I please use you??";
            OwnService.ServiceHandler.sendMessage(msg);
        }*/

        UIHandler = new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                switch(msg.what)
                {
                    case 101 :
                        Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_LONG).show();
                        tv = (TextView) findViewById(R.id.text_view_header);
                        tv.setText(msg.obj.toString());
                        break;

                    default:
                        break;
                }
            }
        };
        Toast.makeText(MainActivity.this, "oncreate called"+UIHandler, Toast.LENGTH_LONG).show();
    }

    public void onStartService(View v)
    {
        startService(new Intent(this, OwnService.class));
    }

    public void onStopService(View v)
    {
        stopService(new Intent(this, OwnService.class));
    }

    public void onSendMessage(View v)
    {
        if(null != OwnService.ServiceHandler)
        {
            Message msg = new Message();
            msg.what = 101;
            msg.obj = "hello My dear Service !!!How are you?? Can I please use you??";
            OwnService.ServiceHandler.sendMessage(msg);
        }
    }

    @Override
    protected void onPause() {
        Toast.makeText(MainActivity.this,""+OwnService.myThread.isAlive(),Toast.LENGTH_LONG).show();
        super.onPause();
    }
}
