package anchal.com.commuactivitytoservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;

import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Anchal.arora on 24-01-2017.
 */
public class OwnService extends Service {
    public static final String TAG ="OwnService";
    public static Handler ServiceHandler = null;
    public static boolean threadisAlive;
    public static MyHandlerThread myThread;

    public static boolean serviceStatus= false;


    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "Wow ! My OwnService Created", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate");
    }

    /*@Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Toast.makeText(this, "Yayyyyy!!!!!...My OwnService Started", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart");
    }
*/
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        myThread = new MyHandlerThread();
        myThread.start();

        try
        {
            Thread.sleep(0);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        serviceStatus = true;
        Toast.makeText(this, "Oh Yeah! My OwnService Started", Toast.LENGTH_LONG).show();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Oh No!!! My OwnService Stopped..:(", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy");
        serviceStatus = false;

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    class MyHandlerThread extends Thread
    {
        public void run() {
         Looper.prepare();
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
           threadisAlive =  Thread.currentThread().isAlive();

            Looper.loop();
        }
    }
}
