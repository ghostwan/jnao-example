package fr.ghostwan.waoremote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import com.aldebaran.qimessaging.EmbeddedTools;
import com.camera.simplemjpeg.MjpegActivity;
import fr.ghostwan.waoremote.qihelper.Cache;
import fr.ghostwan.waoremote.qihelper.ProxyHelper;
import fr.ghostwan.waoremote.qihelper.QiSessionCallback;
import fr.ghostwan.waoremote.qihelper.QiSessionManager;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceListener;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity implements QiSessionCallback {
    /**
     * Called when the activity is first created.
     */
    private static final String LOG_TAG = "MainActivity";
    private static final String PORT = "3000";

    private QiSessionManager qiSessionManager;
    private TextView consoleView;
    private ImageButton connectionButton;
    private EditText ipInput;
    private ExpandableListView behaviorList;
    private ArrayList<QiCommand> qiDialog;
    private ExpandableListAdapter behaviorAdapter;
    private String currentBehavior = null;
    private Button stopButton;
    private Button lButton;
    private LinearLayout layoutButton;
    private EditText dialogInput;

    List<String> listDataHeader;
    HashMap<String, List<QiCommand>> listDataChild;
    private QiCommand lifeSolitary;
    private QiCommand lifeOff;

    private boolean isDebug = false;
    private int currentVolume;

    private WifiManager.MulticastLock lock;
    private JmDNS jmdns;
    private ServiceListener listener;

    private String type = "_naoqi._tcp.local.";

    private ArrayList<QiAddress> qiAddressList;
    private ArrayAdapter<QiAddress> qiAddressAdapter;
    private QiAddress address;
    private Spinner spinner;
    private LinearLayout spinnerLayout;
    private String ipAddressConnected ="";
    private Context context;


    private void startServiceRoutine() {

        Thread routine = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();

                log("Loading...");

                EmbeddedTools ebt = new EmbeddedTools();
                File cacheDir = getApplicationContext().getCacheDir();
                log("Extracting libraries in " + cacheDir.getAbsolutePath());
                ebt.overrideTempDirectory(cacheDir);
                ebt.loadEmbeddedLibraries();
                Cache.clearApplicationData(getApplication());

                try {
                    jmdns = JmDNS.create();
                    jmdns.addServiceListener(type, listener = new ServiceListener() {
                        public void serviceResolved(ServiceEvent event) {
                            addEvent(event);
                        }
                        public void serviceRemoved(ServiceEvent event) {
                           removeEvent(event);
                        }
                        public void serviceAdded(ServiceEvent event) {
                            addEvent(event);
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        routine.start();
    }

    public void addEvent(ServiceEvent event) {
        jmdns.requestServiceInfo(event.getType(), event.getName(), 1);
        String name = event.getName();
        InetAddress[] addressList;
        try {
            addressList = InetAddress.getAllByName(name);
            String ip = addressList[0].getHostAddress();
            QiAddress qiAddress = new QiAddress(name, ip);
            Log.i(LOG_TAG, "name : "+name+ " ip : "+ip);
            if(!qiAddressList.contains(qiAddress))
                qiAddressList.add(qiAddress);
        } catch (UnknownHostException e) {
        }
    }

    public void removeEvent(ServiceEvent event) {
        jmdns.requestServiceInfo(event.getType(), event.getName(), 1);
        String name = event.getName();
        InetAddress[] addressList;
        try {
            addressList = InetAddress.getAllByName(name);
            String ip = addressList[0].getHostAddress();
            QiAddress qiAddress = new QiAddress(name, ip);
            if(qiAddressList.contains(qiAddress))
                qiAddressList.remove(qiAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        context = this;
        qiAddressList = new ArrayList<QiAddress>();

        consoleView = (TextView) findViewById(R.id.message_text);
        connectionButton = (ImageButton) findViewById(R.id.connect_button);
        ipInput = (EditText) findViewById(R.id.robotip_edit);
        behaviorList = (ExpandableListView) findViewById(R.id.behavior_list);
        stopButton = (Button) findViewById(R.id.stop_button);
        lButton = (Button) findViewById(R.id.life_button);
        layoutButton = (LinearLayout) findViewById(R.id.button_layout);
        dialogInput = (EditText) findViewById(R.id.dialog_input);

        spinnerLayout = (LinearLayout) findViewById(R.id.spinner_layout);
        spinner = (Spinner) findViewById(R.id.robot_spinner);
        qiAddressAdapter = new ArrayAdapter<QiAddress>(this, android.R.layout.simple_spinner_item);
        qiAddressAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(qiAddressAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                address = qiAddressAdapter.getItem(position);
                connectionButton.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                connectionButton.setVisibility(View.INVISIBLE);
            }
        });
        qiDialog = new ArrayList<QiCommand>();

        lifeSolitary = new QiCommand("L on", "ALAutonomousLife", "setState", "solitary");
        lifeOff = new QiCommand("L off", "ALAutonomousLife", "setState", "disabled");

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<QiCommand>>();

        //fillBehaviorList();
        behaviorAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        behaviorList.setAdapter(behaviorAdapter);

        initConnectButtonAction(true);
        initLifeButtonAction(0);

        ((Button) findViewById(R.id.rest_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCommand(new QiCommand("", "ALMotion", "rest"));
            }
        });
        ((ImageButton) findViewById(R.id.play_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = dialogInput.getText().toString();
                launchCommand(QiCommand.newQiDialog("", text));
            }
        });
        ((ImageButton) findViewById(R.id.add_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = dialogInput.getText().toString();
                qiDialog.add(QiCommand.newQiDialog(text, text));
                behaviorAdapter.notifyDataSetChanged();
            }
        });
        ((ImageButton) findViewById(R.id.type_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(spinnerLayout.getVisibility() == View.VISIBLE) {
                    ((ImageButton)view).setImageResource(R.drawable.list);
                    spinnerLayout.setVisibility(View.GONE);
                    ipInput.setVisibility(View.VISIBLE);
                }
                else {
                    ((ImageButton)view).setImageResource(R.drawable.ip);
                    spinnerLayout.setVisibility(View.VISIBLE);
                    ipInput.setVisibility(View.GONE);
                }
            }
        });
        ((ImageButton) findViewById(R.id.refresh_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qiAddressAdapter.clear();

                qiAddressAdapter.addAll(qiAddressList);
                qiAddressAdapter.sort(new Comparator<QiAddress>() {
                    @Override
                    public int compare(QiAddress lhs, QiAddress rhs) {
                        return lhs.toString().compareToIgnoreCase(rhs.toString());
                    }
                });
                qiAddressAdapter.notifyDataSetChanged();
            }
        });
        ((Button) findViewById(R.id.video_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MjpegActivity.class);
                intent.putExtra(MjpegActivity.EXTRA_HOSTNAME, ipAddressConnected);
                intent.putExtra(MjpegActivity.EXTRA_PORT, PORT);
                startActivity(intent);
            }
        });


        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentBehavior != null) {
                    launchCommand(new QiCommand("", "ALBehaviorManager", "stopBehavior", currentBehavior));
                    launchCommand(new QiCommand("", "ALMotion", "rest"));
                }
                stopButton.setVisibility(View.INVISIBLE);
            }
        });

        behaviorList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                QiCommand cmd = (QiCommand) behaviorAdapter.getChild(groupPosition, childPosition);
                launchCommand(cmd);
                if(cmd.getType() == QiCommand.TYPE_BEHAVIOR)
                    currentBehavior = (String) cmd.getArguments()[0];
                stopButton.setVisibility(View.VISIBLE);
                return false;
            }
        });

        try {
            setUp();
        } catch (IOException e) {
            e.printStackTrace();
        }
        qiSessionManager = new QiSessionManager(this);
        startServiceRoutine();
    }




    private void setUp() throws IOException {
        android.net.wifi.WifiManager wifi =  (android.net.wifi.WifiManager) getSystemService(android.content.Context.WIFI_SERVICE);
        lock = wifi.createMulticastLock("HeeereDnssdLock");
        lock.setReferenceCounted(true);
        lock.acquire();
    }

    @Override
    protected void onDestroy() {

        try {
            jmdns.removeServiceListener(type, listener);
            jmdns.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lock != null)
            lock.release();
    }


    private void launchCommand(QiCommand command) {

        if (qiSessionManager.isSessionActive()) {
            try {
                log(command.getProxy()+"."+command.getCommand()+"("+command.getArgumentString()+")");
                command.launch();
            } catch (ProxyHelper.ProxyException e) {
                log(e.getMessage());
            }
        } else {
            log("No robot connected !");
        }
    }


    public void initLifeButtonAction(int lifeStatus) {
        if (lifeStatus == 0) {
            lButton.setText(lifeSolitary.getName());
            lButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    launchCommand(lifeSolitary);
                    initLifeButtonAction(1);
                }
            });
        } else {
            lButton.setText(lifeOff.getName());
            lButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    launchCommand(lifeOff);
                    initLifeButtonAction(0);
                }
            });
        }
    }

    public void initConnectButtonAction(boolean connect) {
        if (connect) {
            connectionButton.setImageResource(R.drawable.connecting);
            connectionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if(spinnerLayout.getVisibility() == View.VISIBLE) {
                        ipAddressConnected =  address.getIp();
                        qiSessionManager.init("tcp://" + ipAddressConnected + ":9559");
                        ipInput.setText(ipAddressConnected);
                    }
                    else {
                        ipAddressConnected = ipInput.getText().toString();

                        if(!ipAddressConnected.contains(".")) {
                            ipInput.setText("Wait...");
                            Thread routine = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    InetAddress[] addressList = new InetAddress[0];
                                    try {
                                        addressList = InetAddress.getAllByName(ipAddressConnected);
                                        ipAddressConnected = addressList[0].getHostAddress();
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                ipInput.setText(ipAddressConnected);
                                                qiSessionManager.init("tcp://" + ipAddressConnected + ":9559");
                                            }
                                        });

                                    } catch (UnknownHostException e) {
                                    }
                                }
                            });
                            routine.start();
                        }
                        else {
                            qiSessionManager.init("tcp://" + ipAddressConnected + ":9559");
                        }

                    }


                }
            });

        } else {
            connectionButton.setImageResource(R.drawable.disconnecting);
            connectionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    qiSessionManager.dispose();
                }
            });
        }
    }



    @Override
    public void onConnectionStateChanged(int connectionState) {
        if (connectionState == QiSessionManager.REGISTERED) {
            try {
                currentVolume = (Integer)ProxyHelper.get("ALAudioDevice", "getOutputVolume");
            } catch (ProxyHelper.ProxyException e) {
                e.printStackTrace();
            }
            getList();
            behaviorAdapter.notifyDataSetChanged();
            layoutButton.setVisibility(View.VISIBLE);
            initConnectButtonAction(false);

        } else if (connectionState == QiSessionManager.DISCONNECTED) {
            listDataChild.clear();
            listDataHeader.clear();
            qiDialog.clear();
            behaviorAdapter.notifyDataSetChanged();
            behaviorList.setVisibility(View.INVISIBLE);
            layoutButton.setVisibility(View.INVISIBLE);
            initConnectButtonAction(true);
        }
    }


    @Override
    public void log(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (consoleView != null)
                    consoleView.setText(message);
            }
        });
    }


    private void getList() {

        List<QiCommand> posture = new ArrayList<QiCommand>();
        List<QiCommand> animation = new ArrayList<QiCommand>();
        List<QiCommand> application = new ArrayList<QiCommand>();

        qiDialog.add(QiCommand.newQiDialog("Hi", "Hi how are you ? my name is Nao !!"));
        qiDialog.add(QiCommand.newQiDialog("I am fine!", "I am fine! "));
        qiDialog.add(QiCommand.newQiDialog("I am a little tired!", "I am a little tired! I am the star of Geecon"));
        qiDialog.add(QiCommand.newQiDialog("Bien aal", "Quoi de neuf, mathieu ? "));

        posture.add(QiCommand.newQiPosture("Stand", 0.5));
        posture.add(QiCommand.newQiPosture("Crouch", 0.5));
        posture.add(QiCommand.newQiPosture("Sit", 0.5));

        if (isDebug) {
            application.add(QiCommand.newQiBehavior("Thriller", "User/thriller-dance"));
            application.add(QiCommand.newQiBehavior("Thai Chi", "User/taichi-dance"));
            application.add(QiCommand.newQiBehavior("Les 3 mousquetaires", "User/3-musketeers-story-se"));
            application.add(QiCommand.newQiBehavior("Starwars", "User/starwars-story-se"));
            application.add(QiCommand.newQiBehavior("Vangelis", "User/vangelis-dance"));
            application.add(QiCommand.newQiBehavior("Dialog", "User/run_dialog"));
            animation.add(QiCommand.newQiBehavior("Welcom", "User/dialog_welcome"));
            animation.add(QiCommand.newQiBehavior("Bye Bye", "User/dialog_anims/animations/ByeByeCute"));

        } else {

            ArrayList<String> list = null;
            try {
                list = (ArrayList<String>) ProxyHelper.get("ALBehaviorManager", "getInstalledBehaviors");
                for (String s : list) {
                    String[] splitString = s.split("/");
                    if (s.contains("animations"))
                        animation.add(QiCommand.newQiBehavior(splitString[splitString.length - 1], s));
                    else
                        application.add(QiCommand.newQiBehavior(splitString[splitString.length - 1], s));
                }
            } catch (ProxyHelper.ProxyException e) {
                e.printStackTrace();
            }
        }
        listDataHeader.add("Posture");
        listDataHeader.add("Application");
        listDataHeader.add("Animation");
        listDataHeader.add("Dialog");

        listDataChild.put(listDataHeader.get(0), posture); // Header, Child data
        listDataChild.put(listDataHeader.get(1), application); // Header, Child data
        listDataChild.put(listDataHeader.get(2), animation);
        listDataChild.put(listDataHeader.get(3), qiDialog);
        behaviorAdapter.notifyDataSetChanged();
        behaviorList.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(qiSessionManager.isSessionActive()) {
            if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
                if ( (currentVolume - 5) >= 0 ) {
                    try {
                        currentVolume -= 5;
                        ProxyHelper.call("ALAudioDevice", "setOutputVolume", currentVolume);
                        ProxyHelper.call("ALTextToSpeech", "say", "" + currentVolume);
                    } catch (ProxyHelper.ProxyException e) {
                        e.printStackTrace();
                    }
                }
                return  true;
            }
            else if(keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
                if ( (currentVolume + 5) <= 100 ) {
                    try {
                        currentVolume += 5;
                        ProxyHelper.call("ALAudioDevice", "setOutputVolume", currentVolume);
                        ProxyHelper.call("ALTextToSpeech", "say", ""+currentVolume);
                    } catch (ProxyHelper.ProxyException e) {
                        e.printStackTrace();
                    }
                }
                return  true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
