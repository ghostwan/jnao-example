package com.aldebaran.demo;


import com.aldebaran.demo.example.*;

public class Main {

    private static final String ROBOT_IP = RobotIP.ip;
    private static final String ROBOT_PORT = RobotIP.port;

    private static int step = 4;

    public static void main(String[] args) {


        switch (step) {
            case 1: new ExHelloWorld().start(ROBOT_IP, ROBOT_PORT);break;
            case 2: new ExReactToTouch().start(ROBOT_IP, ROBOT_PORT);break;
            case 3: new ExReactToVoice().start(ROBOT_IP, ROBOT_PORT);break;
            case 4: new ExBasicAwareness().start(ROBOT_IP, ROBOT_PORT);break;
            case 5: new ExSmileDetector().start(ROBOT_IP, ROBOT_PORT);break;
            case 6: new ExPictureTwitter().start(ROBOT_IP, ROBOT_PORT);break;
            case 7: new ExReactToSound().start(ROBOT_IP, ROBOT_PORT);break;
        }


    }
}
