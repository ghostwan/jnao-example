package fr.ghostwan.audricklauncher;

import android.os.Looper;
import android.util.Log;
import android.widget.Toast;
import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALInterface;
import com.aldebaran.qimessaging.helpers.al.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by epinault on 26/05/2014.
 */
public class SessionBehavior implements ALInterface {

    private static final String TAG = "SessionBehavior";
    private final CallBackInterface callBackInterface;
    private Session session;
    private String behaviorName;
    private String ip;
    private ALBehaviorManager alBehaviorManager;
    private boolean isConnected = false;
    private ALMotion motion;

    public SessionBehavior(String behaviorName, String ip, CallBackInterface callBackInterface) {
        this.ip = ip;
        this.behaviorName = behaviorName;
        this.callBackInterface = callBackInterface;
        connect();
    }

    public void connect() {
        Thread routine = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();

                if (ip != null && !ip.equals("")) {
                    try {
                        Log.i(TAG, "Ip address : " + ip);
                        session = new Session();
                        session.connect("tcp://" + ip + ":9559").sync(500, TimeUnit.MILLISECONDS);
                        alBehaviorManager = new ALBehaviorManager(session);
                        motion = new ALMotion(session);
                        ALBehaviorManager.alInterface = SessionBehavior.this;
                        isConnected = true;
                        callBackInterface.onConnected();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        routine.start();
    }

    public void launch() {
        if(isConnected) {
            Thread routine = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        alBehaviorManager.runBehavior(behaviorName);
                    } catch (CallError callError) {
                        callError.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            routine.start();
        }

    }

    public void disconnect() {
        stop();
        session.close();
    }

    @Override
    public void onALModuleReady() {

    }

    @Override
    public void onALModuleException(Exception e) {
        Log.e(TAG, "error ",e);
    }

    public void stop() {
        try {
            alBehaviorManager.stopBehavior(behaviorName);
            motion.rest();
        } catch (CallError callError) {
            callError.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
