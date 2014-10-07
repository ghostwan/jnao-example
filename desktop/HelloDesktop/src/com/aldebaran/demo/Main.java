package com.aldebaran.demo;


public class Main {

    private static final String ROBOT_IP = RobotIP.ip;
    private static final String ROBOT_PORT = RobotIP.port;

    private static int step = 4;

    public static void main(String[] args) {


        switch (step) {
            case 1: new Ex1HelloWorld().start(ROBOT_IP, ROBOT_PORT);break;
            case 2: new Ex2ReactToTouch().start(ROBOT_IP, ROBOT_PORT);break;
            case 3: new Ex3ReactToVoice().start(ROBOT_IP, ROBOT_PORT);break;
            case 4: new Ex4BasicAwareness().start(ROBOT_IP, ROBOT_PORT);break;
            case 5: new Ex5SmileDetector().start(ROBOT_IP, ROBOT_PORT);break;
            case 6: new Ex6PictureTwitter().start(ROBOT_IP, ROBOT_PORT);break;
        }


    }
}
