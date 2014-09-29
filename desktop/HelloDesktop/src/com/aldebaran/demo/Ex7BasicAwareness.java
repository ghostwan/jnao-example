package com.aldebaran.demo;

import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.ALBasicAwareness;
import com.aldebaran.qimessaging.helpers.al.ALMemory;

/**
 * Created by epinault on 25/09/2014.
 */
public class Ex7BasicAwareness implements StartInterface {

	private ALMemory alMemory;
	private Application application;
	private ALBasicAwareness awareness;

	@Override
	public void start(String robotIp, String ip) {
		application = new Application();
		Session session = new Session();
		Future<Void> future = null;
		try {
			future = session.connect("tcp://"+ip+":9559");

			synchronized (future) {
				future.wait(1000);
			}

			alMemory = new ALMemory(session);
			awareness = new ALBasicAwareness(session);
			awareness.setEngagementMode("SemiEngaged");
			awareness.setTrackingMode("Head");
			awareness.setStimulusDetectionEnabled("Sound", true);
			awareness.setStimulusDetectionEnabled("Movement", true);
			awareness.setStimulusDetectionEnabled("People", true);
			awareness.setStimulusDetectionEnabled("Touch", true);

			alMemory.subscribeToEvent("RearTactilTouched" , "onBackTouch::(f)", this);
			alMemory.subscribeToEvent("FrontTactilTouched" , "onFrontTouch::(f)", this);
			alMemory.subscribeToEvent("UserSession/FocusedUser" , "onFocusedUser::(f)", this);
			application.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onFrontTouch(Float touch) throws InterruptedException, CallError {
		if(touch == 1.0) {
			System.out.println("touch");
			awareness.startAwareness();
		}
	}
	public void onBackTouch(Float touch) throws InterruptedException, CallError {
		if(touch == 1.0) {
			System.out.println("touch");
			awareness.stopAwareness();
		}
	}
}
