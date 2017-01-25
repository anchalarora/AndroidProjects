package anchal.com.commuactivitytoservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.os.Handler;
import android.os.Message;


public class MyIntentService extends IntentService {

    public static Handler ServiceHandler = null;

    public static boolean serviceStatus= false;
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ServiceHandler = new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {

                    case 101:
                        if (null != MainActivity.UIHandler) {
                            Message mymsg = new Message();
                            mymsg.what = 101;
                            if (true == serviceStatus)
                                mymsg.obj = "Service is Running perfectly";
                            else
                                mymsg.obj = "Service is not Running as of now";

                            MainActivity.UIHandler.sendMessage(mymsg);
                        }

                        break;

                    default:
                        break;
                }
            }
        };
    }


}
