package com.aldebaran.demo;

import com.aldebaran.qimessaging.*;
import com.aldebaran.qimessaging.Object;
import com.aldebaran.qimessaging.helpers.al.ALMemory;
import com.aldebaran.qimessaging.helpers.al.ALMotion;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by epinault on 11/05/2014.
 */
public class DancyMoves implements StartInterface {


    public static ArrayList<Float> LARM_STRETCHED;
    public static ArrayList<Float> LARM_UP;
    public static ArrayList<Float> LARM_FRONT;
    public static ArrayList<Float> LARM_HIP;

    private ALMemory alMemory;
    private ALTextToSpeech tts;
    private Object memory;
    private ALMotion motion;
    private Application application;
    private boolean running = false;

    @Override
    public void start(String ip, String port) {
        Float[] stretched = {0.2111847996711731f, 1.3107420206069946f, -1.284562587738037f, -0.03490659222006798f, -1.8238688707351685f, 0.5400000214576721f};
        Float[] up = {-1.4800336360931396f, 0.08084873855113983f, 0.44161051511764526f, -0.03490658476948738f, -1.787217378616333f, 0.5400000214576721f};
        Float[] front = {2.802596928649634e-45f, -0.174532949924469f, 2.00189208984375f, -0.03490659222006798f, -1.787217378616333f, 0.5400000214576721f};
        Float[] hip = {1.1889886856079102f, 0.7981850504875183f, 0.3110186457633972f, -1.230137586593628f, -1.787217378616333f, 0.0f};
        LARM_STRETCHED = new ArrayList<Float>(Arrays.asList(stretched));
        LARM_UP = new ArrayList<Float>(Arrays.asList(up));
        LARM_FRONT = new ArrayList<Float>(Arrays.asList(front));
        LARM_HIP = new ArrayList<Float>(Arrays.asList(hip));
        application = new Application();
        Session session = new Session();
        Future<Void> future = null;
        try {
	        future = session.connect("tcp://"+ip+":"+port);

            synchronized (future) {
                future.wait(1000);
            }

            alMemory = new ALMemory(session);
            tts = new ALTextToSpeech(session);
            motion = new ALMotion(session);

            alMemory.subscribeToEvent("FrontTactilTouched" , "onTouchFront::(f)", this);
            alMemory.subscribeToEvent("RearTactilTouched" , "onEnd::(f)", this);
            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private float measureDistance(String joint, ArrayList<Float> desired) {
        float distanceSum = 0.0f;
        try {
            ArrayList<Float> angles = (ArrayList<Float>) motion.getAngles(joint, true);
            if ((desired.size() <= 0) || (desired.size() != angles.size())) {
                return 0f; // Could print a warning too, or even assert
            }
            for (int i = 0; i < angles.size(); i++) {
                distanceSum += Math.abs(desired.get(i) - angles.get(i));
            }
            return distanceSum / desired.size();
        } catch (CallError callError) {
            callError.printStackTrace();
            return 0f;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return 0f;
        }
    }

    public void onTouchFront(Float touch) throws InterruptedException, CallError {
        if(touch == 1.0) {
            tts.say("Let's go!");
            motion.wakeUp();
            boolean running = true;
            float speed = 0.5f;
            ArrayList<ArrayList<Float>> moves = new ArrayList<ArrayList<Float>>();
            moves.add(LARM_HIP);
            moves.add(LARM_STRETCHED);
            moves.add(LARM_HIP);
            moves.add(LARM_STRETCHED);
            ArrayList<Float> dest = moves.remove(0);
            while (running) {
                motion.setAngles("LArm", dest, speed);
                Thread.sleep(50);
                float dist = measureDistance("LArm", dest);
                if (dist < 0.1) {
                    if (moves.size() > 0) {
                        dest = moves.remove(0);
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }
    public void onEnd(Float touch) throws InterruptedException, CallError {
        if(touch == 1.0) {
            tts.say("Done");
            motion.rest();
            application.stop();
        }
    }
}
