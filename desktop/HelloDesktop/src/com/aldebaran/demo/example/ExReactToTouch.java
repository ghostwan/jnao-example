package com.aldebaran.demo.example;

import com.aldebaran.demo.StartInterface;
import com.aldebaran.qimessaging.*;
import com.aldebaran.qimessaging.Object;
import com.aldebaran.qimessaging.helpers.al.ALMemory;
import com.aldebaran.qimessaging.helpers.al.ALMotion;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;

/**
 * Created by epinault on 11/05/2014.
 */
public class ExReactToTouch implements StartInterface {


    private ALMemory alMemory;
    private ALTextToSpeech tts;
    private Object memory;
    private ALMotion motion;
    private Application application;

    @Override
    public void start(String ip, String port) {
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
            alMemory.subscribeToEvent("MiddleTactilTouched" , "onTouchSynch::(f)", this);
            alMemory.subscribeToEvent("RearTactilTouched" , "onTouchAsynch::(f)", this);
            alMemory.subscribeToEvent("LeftBumperPressed" , "onEnd::(f)", this);

	        tts.say("I am ready");
            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTouchFront(Float touch) throws InterruptedException, CallError {
        if(touch == 1.0) {
            tts.say("Hi");
            motion.wakeUp();
        }
        else {
            tts.say("Thank's you!");
        }
    }
    public void onEnd(Float touch) throws InterruptedException, CallError {
        if(touch == 1.0) {
            tts.say("Application is stopping");
            motion.rest();
            application.stop();
        }
    }

    public void onTouchAsynch(Float touch) throws InterruptedException, CallError {
        if(touch == 1.0) {
            tts.setAsynchronous(true);
            tts.say("Now I'm gonna rest because I'm really tired");
            motion.rest();
        }
    }
    public void onTouchSynch(Float touch) throws InterruptedException, CallError {
        if(touch == 1.0) {
            tts.say("Now I'm gonna rest because I'm really tired");
            motion.rest();
        }
    }
}
