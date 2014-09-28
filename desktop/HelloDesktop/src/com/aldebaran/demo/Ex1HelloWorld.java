package com.aldebaran.demo;

import com.aldebaran.qimessaging.*;

/**
 * Created by epinault on 11/05/2014.
 */
public class Ex1HelloWorld implements StartInterface {


    @Override
    public void start(String ip) {
        Session session = new Session();
        Future<Void> future = null;
        try {
            future = session.connect("tcp://"+ip+":9559");

            synchronized (future) {
                future.wait(1000);
            }

            com.aldebaran.qimessaging.Object tts = session.service("ALTextToSpeech");
            tts.call("say", "Hello, Desktop");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
