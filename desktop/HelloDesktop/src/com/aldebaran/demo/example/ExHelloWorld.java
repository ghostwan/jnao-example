package com.aldebaran.demo.example;

import com.aldebaran.demo.StartInterface;
import com.aldebaran.qimessaging.*;
import com.aldebaran.qimessaging.helpers.al.ALTextToSpeech;

/**
 * Created by epinault on 11/05/2014.
 */
public class ExHelloWorld implements StartInterface {


    @Override
    public void start(String ip, String port) {
        Session session = new Session();
        Future<Void> future = null;
        try {
            future = session.connect("tcp://"+ip+":"+port);

            synchronized (future) {
                future.wait(1000);
            }

	        ALTextToSpeech tts = new ALTextToSpeech(session);
            tts.say("Hello, Java One!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
