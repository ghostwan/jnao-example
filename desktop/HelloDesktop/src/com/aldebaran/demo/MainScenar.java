package com.aldebaran.demo;

/**
 * Created by epinault on 26/09/2014.
 */
public class MainScenar {

	private static String ROBOT_IP = "192.168.81.164";

	public static void main(String[] args) {
		new Scenar1().start(ROBOT_IP);
	}

}
