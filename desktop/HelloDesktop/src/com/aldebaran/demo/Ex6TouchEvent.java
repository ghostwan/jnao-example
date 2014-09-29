package com.aldebaran.demo;


import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.ALMemory;

/**
 * Created by epinault on 21/05/2014.
 */
public class Ex6TouchEvent implements StartInterface {

    private ALMemory alMemory;
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
