package fr.ghostwan.audricklauncher;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.EmbeddedTools;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.ALMemory;
import com.aldebaran.qimessaging.helpers.al.ALMotion;
import com.aldebaran.qimessaging.helpers.al.ALRobotPosture;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;

import java.io.File;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MyActivity extends Activity {

    private static final String TAG = "MyActivity";
    private EditText behaviorName;
    private EditText robotIp;
    private LinearLayout layout;
    private ArrayList<SessionBehavior> sessions;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        behaviorName = (EditText) findViewById(R.id.behavior_name_edit);
        robotIp = (EditText) findViewById(R.id.robot_ip_edit);
        layout = (LinearLayout) findViewById(R.id.button_layout);

        sessions = new ArrayList<SessionBehavior>();

        EmbeddedTools ebt = new EmbeddedTools();
        File cacheDir = getApplicationContext().getCacheDir();
        ebt.overrideTempDirectory(cacheDir);
        ebt.loadEmbeddedLibraries();
    }

    public void connect(View view) {
        if (behaviorName.getText() != null && robotIp.getText() != null) {
            final String behavior = behaviorName.getText().toString();
            final String ip = robotIp.getText().toString();
            final Button button = new Button(MyActivity.this);
            button.setVisibility(View.INVISIBLE);
            button.setText(ip + " : " + behavior);
            final SessionBehavior sessionBehavior = new SessionBehavior(behavior, ip, new CallBackInterface() {
                @Override
                public void onConnected() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            button.setVisibility(View.VISIBLE);
                        }
                    });

                }
            });
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sessionBehavior.launch();
                }
            });
            sessions.add(sessionBehavior);
            layout.addView(button);
        }
    }


    public void disconnectAll(View view) {
        for (SessionBehavior session : sessions) {
            session.disconnect();
        }
        sessions.clear();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                layout.removeAllViews();
            }
        });
    }

    public void stopAll(View view) {
        for (SessionBehavior session : sessions) {
            session.stop();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            if (sessions.size() >= 1) {
                sessions.get(0).launch();
                return true;
            }
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            if (sessions.size() >= 2) {
                sessions.get(1).launch();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
