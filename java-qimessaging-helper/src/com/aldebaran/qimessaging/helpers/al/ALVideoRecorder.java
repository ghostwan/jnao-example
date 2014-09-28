package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALVideoRecorder extends ALModule {

    public ALVideoRecorder(Session session) {
        super(session);
    }

    /**
     * 100 exit           Void ()
     * Exits and unregisters the module.
     * 102 pCall          Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version        String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping           Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList  List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp  Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp  Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait           Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning      Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop           Void (Int32)
     * returns true if the method is currently running
     * id: the ID of the method to wait for
     */
    public void stop(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stop", param1);
        else
            service.call("stop", param1).get();
    }

    /**
     * 111 getBrokerName  String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage       String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 startRecording Void (String,String)
     * Starts recording a video. Please note that only one record at a time can be made.
     * folderPath: Folder where the video is saved.
     * fileName: Filename used to save the video.
     */
    public void startRecording(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startRecording", param1, param2);
        else
            service.call("startRecording", param1, param2).get();
    }

    /**
     * 114 startRecording Void (String,String,Bool)
     * Starts recording a video. Please note that only one record at a time can be made.
     * folderPath: Folder where the video is saved.
     * fileName: Filename used to save the video.
     * overwrite: If false and the filename already exists, an exception is thrown.
     */
    public void startRecording(String param1, String param2, Boolean param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startRecording", param1, param2, param3);
        else
            service.call("startRecording", param1, param2, param3).get();
    }

    /**
     * 115 stopRecording  Value ()
     * Stops a video record that was launched with startRecording(). The function returns the number of frames that were recorded, as well as the video absolute file name.
     * return: Array of two elements [numRecordedFrames, recordAbsolutePath]
     */
    public com.aldebaran.qimessaging.Object stopRecording() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("stopRecording").get();
    }

    /**
     * 116 isRecording    Bool ()
     * Are we currently recording a video
     * return: True/False
     */
    public Boolean isRecording() throws CallError, InterruptedException {
        return (Boolean) service.call("isRecording").get();
    }

    /**
     * 118 setCameraID    Void (Int32)
     * Sets camera ID.
     * cameraID: ID of the camera to use.
     */
    public void setCameraID(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setCameraID", param1);
        else
            service.call("setCameraID", param1).get();
    }

    /**
     * 119 setResolution  Void (Int32)
     * Sets resolution.
     * resolution: New frame resolution.
     */
    public void setResolution(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setResolution", param1);
        else
            service.call("setResolution", param1).get();
    }

    /**
     * 120 setColorSpace  Void (Int32)
     * Sets color space.
     * colorSpace: New color space.
     */
    public void setColorSpace(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setColorSpace", param1);
        else
            service.call("setColorSpace", param1).get();
    }

    /**
     * 121 setFrameRate   Void (Float)
     * Sets frame rate.
     * frameRate: New frame rate.
     */
    public void setFrameRate(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setFrameRate", param1);
        else
            service.call("setFrameRate", param1).get();
    }

    /**
     * 122 setVideoFormat Void (String)
     * Sets video format.
     * videoFormat: New video format.
     */
    public void setVideoFormat(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setVideoFormat", param1);
        else
            service.call("setVideoFormat", param1).get();
    }

    /**
     * 123 getCameraID    Int32 ()
     * Returns current camera ID.
     * return: Current camera ID.
     */
    public Integer getCameraID() throws CallError, InterruptedException {
        return (Integer) service.call("getCameraID").get();
    }

    /**
     * 124 getResolution  Int32 ()
     * Returns current resolution.
     * return: Current resolution.
     */
    public Integer getResolution() throws CallError, InterruptedException {
        return (Integer) service.call("getResolution").get();
    }

    /**
     * 125 getColorSpace  Int32 ()
     * Returns current color space.
     * return: Current color space.
     */
    public Integer getColorSpace() throws CallError, InterruptedException {
        return (Integer) service.call("getColorSpace").get();
    }

    /**
     * 126 getFrameRate   Int32 ()
     * Returns current frame rate.
     * return: Current frame rate.
     */
    public Integer getFrameRate() throws CallError, InterruptedException {
        return (Integer) service.call("getFrameRate").get();
    }

    /**
     * 127 getVideoFormat String ()
     * Returns current video format.
     * return: Current video format.
     * * Signals:
     */
    public String getVideoFormat() throws CallError, InterruptedException {
        return (String) service.call("getVideoFormat").get();
    }


}
    