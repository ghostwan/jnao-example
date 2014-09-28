package com.aldebaran.demo;


import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.ALMemory;
import com.aldebaran.qimessaging.helpers.al.ALMotion;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;

/**
 * Created by epinault on 21/05/2014.
 */
public class Ex6TouchEvent implements StartInterface {

    private ALMemory alMemory;
    private Application application;

    @Override
    public void start(String ip) {
        application = new Application();
        Session session = new Session();
        Future<Void> future = null;
        try {
            future = session.connect("tcp://"+ip+":9559");

            synchronized (future) {
                future.wait(1000);
            }

            alMemory = new ALMemory(session);

            alMemory.subscribeToEvent("ALTabletService/onTouchDown" , "onTouchDown::(s)", this);
            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTouchDown(String value) {
        System.out.println("Value "+value);
    }
}
