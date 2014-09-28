package com.aldebaran.demo;


public class Main {

    private static final String ROBOT_NAME = RobotIP.ip;
    private static int step = 5;

    public static void main(String[] args) {


        switch (step) {
            case 1: new Ex1HelloWorld().start(ROBOT_NAME);break;
            case 2: new Ex2ReactToTouch().start(ROBOT_NAME);break;
            case 3: new Ex3ReactToSound().start(ROBOT_NAME);break;
            case 4: new Ex4ReactToVoice().start(ROBOT_NAME);break;
            case 5: new Ex5PictureTwitter().start(ROBOT_NAME);break;
            case 6: new Ex6TouchEvent().start(ROBOT_NAME);break;
            case 7: new Ex7BasicAwareness().start(ROBOT_NAME);break;
        }


    }
}
