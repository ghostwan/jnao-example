package com.aldebaran.demo.example;

import com.aldebaran.demo.StartInterface;
import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.*;

import java.util.ArrayList;

/**
 * Created by epinault on 25/09/2014.
 */
//Only on real robot
public class ExSmileDetector implements StartInterface {

	private ALMemory alMemory;
	private Application application;
	private ALBasicAwareness awareness;
	private boolean isRunning;
	private ALFaceCharacteristics faceCharac;
	private ALTextToSpeech tts;
	private ALMotion motion;

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
			awareness = new ALBasicAwareness(session);
			tts = new ALTextToSpeech(session);
			motion = new ALMotion(session);
			faceCharac = new ALFaceCharacteristics(session);

			tts.say("hello");
			motion.wakeUp();
			awareness.setEngagementMode("SemiEngaged");
			awareness.setTrackingMode("Head");
			awareness.setStimulusDetectionEnabled("Sound", true);
			awareness.setStimulusDetectionEnabled("Movement", true);
			awareness.setStimulusDetectionEnabled("People", true);
			awareness.setStimulusDetectionEnabled("Touch", true);

			alMemory.subscribeToEvent("RearTactilTouched" , "onBackTouch::(f)", this);
			alMemory.subscribeToEvent("FrontTactilTouched" , "onFrontTouch::(f)", this);
			alMemory.subscribeToEvent("ALBasicAwareness/HumanTracked", "onHumanTracked::(i)", this);

			application.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void onHumanTracked(Integer humanID) throws InterruptedException, CallError {
		if (humanID >= 0 && !isRunning) {
			isRunning = true;

			float threshNeutralEmotion = 0.45f;
			float threshHappyEmotion = 0.35f;
			float threshSurprisedEmotion = 0.45f;
			float threshAngryEmotion = 0.7f;
			float threshSadEmotion = 0.55f;
			float threshScaredEmotion = 0.3f;

			// #activate the output of the box
			float[] tabProperties = new float[5];
			int counter = 0;

			while (isRunning) {
				System.out.println("Loop");
				if (counter < 3) {
					ArrayList<Integer> ids = (ArrayList<Integer>) alMemory.getData("PeoplePerception/PeopleList");
					if (ids.size() > 0) {
						faceCharac.analyzeFaceCharacteristics(ids.get(0));
						Thread.sleep(400);
						try {
							ArrayList<Float> properties = (ArrayList<Float>) alMemory.getData("PeoplePerception/Person/" + ids.get(0) + "/ExpressionProperties");
							tabProperties[0] += properties.get(0);
							tabProperties[1] += properties.get(1);
							tabProperties[2] += properties.get(2);
							tabProperties[3] += properties.get(3);
							tabProperties[4] += properties.get(4);
							counter += 1;
						} catch (Exception e) {

						}
					} else {
						isRunning = false;
						tts.say("I am all alone now");
					}
				} else {
					tabProperties[0] /= 3;
					tabProperties[1] /= 3;
					tabProperties[2] /= 3;
					tabProperties[3] /= 3;
					tabProperties[4] /= 3;

					if (tabProperties[1] > threshHappyEmotion) {
						tts.say("You are smiling ");
					} else if (tabProperties[2] > threshSurprisedEmotion) {
						tts.say("You are surprised ");
					} else if (tabProperties[3] > threshAngryEmotion) {
						tts.say("You are angry ");
					} else if (tabProperties[4] > threshSadEmotion) {
						tts.say("You are sad ");
					}
					counter = 0;
				}
			}
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
