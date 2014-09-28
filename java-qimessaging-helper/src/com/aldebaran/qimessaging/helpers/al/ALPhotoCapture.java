package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALPhotoCapture extends ALModule {

    public ALPhotoCapture(Session session) {
        super(session);
    }

    /**
     * 100 exit                Void ()
     * Exits and unregisters the module.
     * 102 pCall               Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version             String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList       List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp       Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp       Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning           Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                Void (Int32)
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
     * 111 getBrokerName       String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage            String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 setHalfPressEnabled Void (Bool)
     * Enables or disables the half-press mode.
     * enable: True to enable, false to disable.
     */
    public void setHalfPressEnabled(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setHalfPressEnabled", param1);
        else
            service.call("setHalfPressEnabled", param1).get();
    }

    /**
     * 114 halfPress           Bool ()
     * Manually (un)subscribes to ALVideoDevice.
     * return: True if eveything went well, False otherwise.
     */
    public Boolean halfPress() throws CallError, InterruptedException {
        return (Boolean) service.call("halfPress").get();
    }

    /**
     * 115 takePicture         Value (String,String)
     * Takes one picture.
     * folderPath: Folder where the picture is saved.
     * fileName: Filename used to save the picture.
     * return: Full file name of the picture saved on the disk: [filename]
     */
    public com.aldebaran.qimessaging.Object takePicture(String param1, String param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("takePicture", param1, param2).get();
    }

    /**
     * 116 takePicture         Value (String,String,Bool)
     * Takes one picture.
     * folderPath: Folder where the picture is saved.
     * fileName: Filename used to save the picture.
     * overwrite: If false and the filename already exists, an error is thrown.
     * return: Full file name of the picture saved on the disk: [filename]
     */
    public com.aldebaran.qimessaging.Object takePicture(String param1, String param2, Boolean param3) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("takePicture", param1, param2, param3).get();
    }

    /**
     * 117 takePictures        Value (Int32,String,String)
     * Takes several pictures as quickly as possible
     * numberOfPictures: Number of pictures to take
     * folderPath: Folder where the pictures are saved.
     * fileName: Filename used to save the pictures.
     * return: List of all saved files: [[filename1, filename2...]]
     */
    public com.aldebaran.qimessaging.Object takePictures(Integer param1, String param2, String param3) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("takePictures", param1, param2, param3).get();
    }

    /**
     * 118 takePictures        Value (Int32,String,String,Bool)
     * Takes several pictures as quickly as possible
     * numberOfPictures: Number of pictures to take
     * folderPath: Folder where the pictures are saved.
     * fileName: Filename used to save the pictures.
     * overwrite: If false and the filename already exists, an error is thrown.
     * return: List of all saved files: [[filename1, filename2...]]
     */
    public com.aldebaran.qimessaging.Object takePictures(Integer param1, String param2, String param3, Boolean param4) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("takePictures", param1, param2, param3, param4).get();
    }

    /**
     * 119 setCameraID         Void (Int32)
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
     * 120 setResolution       Void (Int32)
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
     * 121 setColorSpace       Void (Int32)
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
     * 122 setCaptureInterval  Void (Int32)
     * Sets delay between two captures.
     * captureInterval: New delay (in ms) between two pictures.
     */
    public void setCaptureInterval(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setCaptureInterval", param1);
        else
            service.call("setCaptureInterval", param1).get();
    }

    /**
     * 123 setPictureFormat    Void (String)
     * Sets picture extension.
     * pictureFormat: New extension used to save pictures.
     */
    public void setPictureFormat(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setPictureFormat", param1);
        else
            service.call("setPictureFormat", param1).get();
    }

    /**
     * 124 getCameraID         Int32 ()
     * Returns current camera ID.
     * return: Current camera ID.
     */
    public Integer getCameraID() throws CallError, InterruptedException {
        return (Integer) service.call("getCameraID").get();
    }

    /**
     * 125 getResolution       Int32 ()
     * Returns current resolution.
     * return: Current frame resolution.
     */
    public Integer getResolution() throws CallError, InterruptedException {
        return (Integer) service.call("getResolution").get();
    }

    /**
     * 126 getColorSpace       Int32 ()
     * Returns current color space.
     * return: Current color space.
     */
    public Integer getColorSpace() throws CallError, InterruptedException {
        return (Integer) service.call("getColorSpace").get();
    }

    /**
     * 127 getCaptureInterval  Int32 ()
     * Returns current delay between captures.
     * return: Current delay (in ms) between two pictures.
     */
    public Integer getCaptureInterval() throws CallError, InterruptedException {
        return (Integer) service.call("getCaptureInterval").get();
    }

    /**
     * 128 getPictureFormat    String ()
     * Returns current picture format.
     * return: Current picture format.
     */
    public String getPictureFormat() throws CallError, InterruptedException {
        return (String) service.call("getPictureFormat").get();
    }

    /**
     * 129 isHalfPressEnabled  Bool ()
     * Returns True if the "half press" mode is on.
     * return: True or False.
     */
    public Boolean isHalfPressEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("isHalfPressEnabled").get();
    }

    /**
     * 130 isHalfPressed       Bool ()
     * Returns True if the "half press" mode is on.
     * return: True or False.
     * * Signals:
     */
    public Boolean isHalfPressed() throws CallError, InterruptedException {
        return (Boolean) service.call("isHalfPressed").get();
    }


}
    