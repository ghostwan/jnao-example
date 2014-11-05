package com.aldebaran.demo.example;

import com.aldebaran.demo.RobotIP;
import com.aldebaran.demo.StartInterface;
import com.aldebaran.demo.picture.Picture;
import com.aldebaran.demo.picture.SendEmail;
import com.aldebaran.demo.picture.ShowPicture;
import com.aldebaran.demo.picture.Util;
import com.aldebaran.qimessaging.Application;
import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.al.*;
import twitter4j.DirectMessage;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.media.ImageUpload;
import twitter4j.media.ImageUploadFactory;
import twitter4j.media.MediaProvider;

import java.io.File;
import java.nio.ByteBuffer;
import java.util.List;

/**
 * Created by epinault on 12/05/2014.
 */
public class ExPictureTwitter implements StartInterface {

    private Application application;
    private ALMemory alMemory;
    private String moduleName;

    private ALVideoDevice video;
    private ALMotion motion;
    private ALTextToSpeech tts;
    private ALAudioPlayer audio;

    int topCamera = 0;
    int resolution = 2; // 640 x 480
    int colorspace = 11; // RGB
    int frameRate = 10; // FPS

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
            alMemory.subscribeToEvent("MiddleTactilTouched" , "onEnd::(f)", this);
            alMemory.subscribeToEvent("FrontTactilTouched" , "onTouchFront::(f)", this);

            motion = new ALMotion(session);
            tts = new ALTextToSpeech(session);
            video = new ALVideoDevice(session);
            audio = new ALAudioPlayer(session);


            application.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onEnd(Float touch) throws InterruptedException, CallError {
        if (touch == 1.0) {
            tts.say("Application is stopping");
            motion.rest();
            application.stop();
        }
    }
    public void onTouchFront(Float touch) throws Exception {
        if (touch == 1.0) {
            motion.wakeUp();
            tts.say("I'm going to take a photo. One. Two. Three. Smile!");
            byte[] rawData = takePicture();
            Picture picture = Util.toPicture(rawData);
            try {
                showPicture(picture);
            } catch (Exception e) {
                // pass
            }
            motion.rest();
//            askAndSendEmail(picture);
            askAndSendPictureByTwitter(picture, "Picture from Nao");
            askAndSendEmail(picture);
            new File(picture.getFilename()).delete();
            tts.say("Everything done!");
        }
    }

    public void showPicture(Picture picture) {
        new ShowPicture(picture);
    }

    public void askAndSendEmail(Picture picture) throws  Exception {
        tts.say("Sending you the picture by mail");
        new SendEmail().sendPicture(picture.getFilename());
    }
    public void askAndSendPictureByTwitter(Picture picture, String text) throws  Exception {
        tts.say("Sending you the picture by twitter");
        try {
            Configuration conf = new ConfigurationBuilder().setMediaProviderAPIKey(RobotIP.TWITPIK_KEY).build();
            ImageUpload upload = new ImageUploadFactory(conf).getInstance(MediaProvider.TWITTER);
            String url;
            url = upload.upload(new File(picture.getFilename()), text);
            String messageString = "Nice pic live from our session at Java One : "+url;

            tts.say("Successfully uploaded image to Twitpic !");

            Twitter sender = TwitterFactory.getSingleton();
            DirectMessage message = sender.sendDirectMessage(RobotIP.TWITTER_LOGIN, messageString);

            tts.say("look on my profile : "+RobotIP.TWITTER_NAME+" ! You're in !");
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to upload the image: " + te.getMessage());
            tts.say("Failed to upload the image !");
        }
    }

    public byte[] takePicture() throws Exception {
        moduleName = video.subscribeCamera("demoAndroid", topCamera, resolution, colorspace, frameRate);
        System.out.format("subscribed with id: %s", moduleName);

//        audio.playFile("/home/nao/camera.mp3");
        List<Object> image = (List<Object>) video.getImageRemote(moduleName);
        ByteBuffer buffer = (ByteBuffer)image.get(6);
        byte[] rawData = buffer.array();
        video.unsubscribe(moduleName);
        return rawData;
    }
}
