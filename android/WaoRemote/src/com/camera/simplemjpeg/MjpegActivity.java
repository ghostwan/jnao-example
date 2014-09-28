package com.camera.simplemjpeg;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.jcraft.jsch.*;
import fr.ghostwan.waoremote.R;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

public class MjpegActivity extends Activity {
	private static final boolean DEBUG=false;
    private static final String TAG = "MJPEG";
    public static final String EXTRA_HOSTNAME = "EXTRA_HOSTNAME";
    public static final String EXTRA_PORT = "EXTRA_PORT";

    private MjpegView mv = null;
    private String hostname;
    private String portnum;
    private Session session;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        setContentView(R.layout.video);
        mv = (MjpegView) findViewById(R.id.mv);
        
        // receive parameters from PreferenceActivity
        Intent intent = getIntent();
        hostname = intent.getStringExtra(EXTRA_HOSTNAME);
        portnum =  intent.getStringExtra(EXTRA_PORT);

        new DoRead().execute( hostname, portnum);

    }

    /** Called when the user clicks the send button */
    public void sshConnect(String host) throws Exception {

        Properties props = new Properties();
        props.put("StrictHostKeyChecking", "no");

        String user ="nao";
        String pwd = "nao";
        int port = 22;

        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        config.put("compression.s2c", "zlib,none");
        config.put("compression.c2s", "zlib,none");

        JSch jsch=new JSch();
        session =jsch.getSession(user, host, port);
        session.setConfig(config);
        session.setPassword(pwd);
        session.connect();

        startGStreamer(session);
    }

    public void startGStreamer(Session session) throws Exception {
        Channel channel = session.openChannel("exec");
        ((ChannelExec) channel).setCommand("gst-launch-0.10 -v v4l2src device=/dev/video0 ! video/x-raw-yuv,width=640,height=480,framerate=30/1 ! ffmpegcolorspace ! jpegenc ! multipartmux! tcpserversink port=3000");
        channel.setInputStream(null);
        ((ChannelExec) channel).setErrStream(System.err);
        channel.connect();

    }

    public void stopGStreamer(Session session) throws Exception {
        Channel channel = session.openChannel("exec");
        ((ChannelExec) channel).setCommand("killall gst-launch-0.10");
        channel.setInputStream(null);
        ((ChannelExec) channel).setErrStream(System.err);
        channel.connect();

    }

    public void onResume() {
    	if(DEBUG) Log.d(TAG,"onResume()");
        super.onResume();
        if(mv!=null){
        	mv.resumePlayback();
        }

    }

    public void onStart() {
    	if(DEBUG) Log.d(TAG,"onStart()");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stopGStreamer(session);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        super.onStart();
    }
    public void onPause() {
    	if(DEBUG) Log.d(TAG,"onPause()");
        super.onPause();
        if(mv!=null){
        	mv.stopPlayback();
        }
    }
    public void onStop() {
    	if(DEBUG) Log.d(TAG,"onStop()");
        super.onStop();
    }

    public void onDestroy() {
    	if(DEBUG) Log.d(TAG,"onDestroy()");
    	
    	if(mv!=null){
    		mv.freeCameraMemory();
    	}
    	
        super.onDestroy();
    }
    
    public class DoRead extends AsyncTask<String, Void, MjpegInputStream> {
    	protected MjpegInputStream doInBackground( String... params){
    		Socket socket = null;
    		try {
                sshConnect(hostname);
                Thread.sleep(4000);
                socket = new Socket( params[0], Integer.valueOf( params[1]));
	    		return (new MjpegInputStream(socket.getInputStream()));
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
                e.printStackTrace();
            }
            return null;
    	}
    	
        protected void onPostExecute(MjpegInputStream result) {
            mv.setSource(result);
            if(result!=null) result.setSkip(1);
            mv.setDisplayMode(MjpegView.SIZE_BEST_FIT);
            mv.showFps(true);
        }
    }
}