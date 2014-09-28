package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALVideoDevice extends ALModule {

    public ALVideoDevice(Session session) {
        super(session);
    }

    /**
     * 100 exit                           Void ()
     * Exits and unregisters the module.
     * 102 pCall                          Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version                        String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                           Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList                  List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp                  Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp                  Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                           Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning                      Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                           Void (Int32)
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
     * 111 getBrokerName                  String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage                       String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 subscribeCamera                String (String,Int32,Int32,Int32,Int32)
     * name: Name of the subscribing vision module
     * cameraIndex: Camera requested.
     * resolution: Resolution requested.{0=kQQVGA, 1=kQVGA, 2=kVGA, 3=k4VGA}
     * colorSpace: Colorspace requested.{0=kYuv, 9=kYUV422, 10=kYUV, 11=kRGB, 12=kHSY, 13=kBGR}
     * fps: Fps (frames per second) requested.{5, 10, 15, 30}
     * return: Name under which the vision module is known from ALVideoDevice
     */
    public String subscribeCamera(String param1, Integer param2, Integer param3, Integer param4, Integer param5) throws CallError, InterruptedException {
        return (String) service.call("subscribeCamera", param1, param2, param3, param4, param5).get();
    }

    /**
     * 114 subscribeCameras               String (String,Value,Value,Value,Int32)
     * name: Name of the subscribing vision module
     * cameraIndexes: Cameras requested.
     * resolutions: Resolutions requested.{0=kQQVGA, 1=kQVGA, 2=kVGA, 3=k4VGA}
     * colorSpaces: Colorspaces requested.{0=kYuv, 9=kYUV422, 10=kYUV, 11=kRGB, 12=kHSY, 13=kBGR}
     * fps: Fps (frames per second) requested.{5, 10, 15, 30}
     * return: Name under which the vision module is known from ALVideoDevice
     */
    public String subscribeCameras(String param1, com.aldebaran.qimessaging.Object param2, com.aldebaran.qimessaging.Object param3, com.aldebaran.qimessaging.Object param4, Integer param5) throws CallError, InterruptedException {
        return (String) service.call("subscribeCameras", param1, param2, param3, param4, param5).get();
    }

    /**
     * 115 unsubscribe                    Bool (String)
     * nameId: Name under which the vision module is known from ALVideoDevice.
     * return: True if success, false otherwise
     */
    public Boolean unsubscribe(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("unsubscribe", param1).get();
    }

    /**
     * 116 getSubscribers                 Value ()
     */
    public com.aldebaran.qimessaging.Object getSubscribers() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getSubscribers").get();
    }

    /**
     * 117 getCameraIndexes               Value ()
     */
    public com.aldebaran.qimessaging.Object getCameraIndexes() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getCameraIndexes").get();
    }

    /**
     * 118 getActiveCamera                Int32 ()
     * Tells which camera is the default one
     * return:  0: top camera - 1: bottom camera
     */
    public Integer getActiveCamera() throws CallError, InterruptedException {
        return (Integer) service.call("getActiveCamera").get();
    }

    /**
     * 119 setActiveCamera                Bool (Int32)
     * Set the active camera
     * activeCamera:  0: top camera - 1: bottom camera
     */
    public Boolean setActiveCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("setActiveCamera", param1).get();
    }

    /**
     * 120 getCameraModel                 Int32 (Int32)
     * cameraIndex: Camera requested.
     * return:  1(kOV7670): VGA camera - 2(kMT9M114): HD camera
     */
    public Integer getCameraModel(Integer param1) throws CallError, InterruptedException {
        return (Integer) service.call("getCameraModel", param1).get();
    }

    /**
     * 121 getCameraName                  String (Int32)
     * cameraIndex: Camera requested.
     * return: CameraTop - CameraBottom - CameraDepth
     */
    public String getCameraName(Integer param1) throws CallError, InterruptedException {
        return (String) service.call("getCameraName", param1).get();
    }

    /**
     * 122 getFrameRate                   Int32 (Int32)
     * cameraIndex: Camera requested.
     */
    public Integer getFrameRate(Integer param1) throws CallError, InterruptedException {
        return (Integer) service.call("getFrameRate", param1).get();
    }

    /**
     * 123 getResolution                  Int32 (Int32)
     * cameraIndex: Camera requested.
     */
    public Integer getResolution(Integer param1) throws CallError, InterruptedException {
        return (Integer) service.call("getResolution", param1).get();
    }

    /**
     * 124 getColorSpace                  Int32 (Int32)
     * cameraIndex: Camera requested.
     */
    public Integer getColorSpace(Integer param1) throws CallError, InterruptedException {
        return (Integer) service.call("getColorSpace", param1).get();
    }

    /**
     * 125 getHorizontalFOV               Float (Int32)
     * cameraIndex: Camera requested.
     */
    public Float getHorizontalFOV(Integer param1) throws CallError, InterruptedException {
        return (Float) service.call("getHorizontalFOV", param1).get();
    }

    /**
     * 126 getVerticalFOV                 Float (Int32)
     * cameraIndex: Camera requested.
     */
    public Float getVerticalFOV(Integer param1) throws CallError, InterruptedException {
        return (Float) service.call("getVerticalFOV", param1).get();
    }

    /**
     * 127 getParameter                   Int32 (Int32,Int32)
     * cameraIndex: Camera requested.
     * parameterId: Camera parameter requested.
     */
    public Integer getParameter(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Integer) service.call("getParameter", param1, param2).get();
    }

    /**
     * 128 getParameterRange              Value (Int32,Int32)
     * cameraIndex: Camera requested.
     * parameterId: Camera parameter requested.
     */
    public com.aldebaran.qimessaging.Object getParameterRange(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getParameterRange", param1, param2).get();
    }

    /**
     * 129 getParameterInfo               Value (Int32,Int32)
     * cameraIndex: Camera requested.
     * parameterId: Camera parameter requested.
     */
    public com.aldebaran.qimessaging.Object getParameterInfo(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getParameterInfo", param1, param2).get();
    }

    /**
     * 130 setParameter                   Bool (Int32,Int32,Int32)
     * cameraIndex: Camera requested.
     * parameterId: Camera parameter requested.
     * value: value requested.
     */
    public Boolean setParameter(Integer param1, Integer param2, Integer param3) throws CallError, InterruptedException {
        return (Boolean) service.call("setParameter", param1, param2, param3).get();
    }

    /**
     * 131 setParameterToDefault          Bool (Int32,Int32)
     * cameraIndex: Camera requested.
     * parameterId: Camera parameter requested.
     */
    public Boolean setParameterToDefault(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("setParameterToDefault", param1, param2).get();
    }

    /**
     * 132 setAllParametersToDefault      Bool (Int32)
     * cameraIndex: Camera requested.
     */
    public Boolean setAllParametersToDefault(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("setAllParametersToDefault", param1).get();
    }

    /**
     * 133 openCamera                     Bool (Int32)
     */
    public Boolean openCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("openCamera", param1).get();
    }

    /**
     * 134 closeCamera                    Bool (Int32)
     */
    public Boolean closeCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("closeCamera", param1).get();
    }

    /**
     * 135 isCameraOpen                   Bool (Int32)
     */
    public Boolean isCameraOpen(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isCameraOpen", param1).get();
    }

    /**
     * 136 startCamera                    Bool (Int32)
     */
    public Boolean startCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("startCamera", param1).get();
    }

    /**
     * 137 stopCamera                     Bool (Int32)
     */
    public Boolean stopCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("stopCamera", param1).get();
    }

    /**
     * 138 isCameraStarted                Bool (Int32)
     */
    public Boolean isCameraStarted(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isCameraStarted", param1).get();
    }

    /**
     * 139 resetCamera                    Bool (Int32)
     */
    public Boolean resetCamera(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("resetCamera", param1).get();
    }

    /**
     * 140 startFrameGrabber              Bool (Int32)
     * cameraIndex: Camera requested.
     */
    public Boolean startFrameGrabber(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("startFrameGrabber", param1).get();
    }

    /**
     * 141 stopFrameGrabber               Bool (Int32)
     * cameraIndex: Camera requested.
     */
    public Boolean stopFrameGrabber(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("stopFrameGrabber", param1).get();
    }

    /**
     * 142 isFrameGrabberOff              Bool (Int32)
     * cameraIndex: Camera requested.
     */
    public Boolean isFrameGrabberOff(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isFrameGrabberOff", param1).get();
    }

    /**
     * 143 hasDepthCamera                 Bool ()
     */
    public Boolean hasDepthCamera() throws CallError, InterruptedException {
        return (Boolean) service.call("hasDepthCamera").get();
    }

    /**
     * 144 getFrameRate                   Int32 (String)
     * name: Name of the subscribing vision module
     */
    public Integer getFrameRate(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getFrameRate", param1).get();
    }

    /**
     * 145 setFrameRate                   Bool (String,Int32)
     * name: Name of the subscribing vision module
     * frameRate: Frame Rate requested.
     */
    public Boolean setFrameRate(String param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("setFrameRate", param1, param2).get();
    }

    /**
     * 146 getActiveCamera                Int32 (String)
     * name: Name of the subscribing vision module
     */
    public Integer getActiveCamera(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getActiveCamera", param1).get();
    }

    /**
     * 147 setActiveCamera                Bool (String,Int32)
     * name: Name of the subscribing vision module
     * cameraIndex: Camera requested.
     */
    public Boolean setActiveCamera(String param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("setActiveCamera", param1, param2).get();
    }

    /**
     * 148 getResolution                  Int32 (String)
     * name: Name of the subscribing vision module
     */
    public Integer getResolution(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getResolution", param1).get();
    }

    /**
     * 149 setResolution                  Bool (String,Int32)
     * name: Name of the subscribing vision module
     * resolution: Resolution requested.
     */
    public Boolean setResolution(String param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("setResolution", param1, param2).get();
    }

    /**
     * 150 getColorSpace                  Int32 (String)
     * name: Name of the subscribing vision module
     */
    public Integer getColorSpace(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getColorSpace", param1).get();
    }

    /**
     * 151 setColorSpace                  Bool (String,Int32)
     * name: Name of the subscribing vision module
     * colorSpace: Color Space requested.
     */
    public Boolean setColorSpace(String param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("setColorSpace", param1, param2).get();
    }

    /**
     * 152 getCameraParameter             Int32 (String,Int32)
     * name: Name of the subscribing vision module
     * parameterId: Camera parameter requested.
     */
    public Integer getCameraParameter(String param1, Integer param2) throws CallError, InterruptedException {
        return (Integer) service.call("getCameraParameter", param1, param2).get();
    }

    /**
     * 153 getCameraParameterRange        Value (String,Int32)
     * name: Name of the subscribing vision module
     * parameterId: Camera parameter requested.
     */
    public com.aldebaran.qimessaging.Object getCameraParameterRange(String param1, Integer param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getCameraParameterRange", param1, param2).get();
    }

    /**
     * 154 getCameraParameterInfo         Value (String,Int32)
     * name: Name of the subscribing vision module
     * parameterId: Camera parameter requested.
     */
    public com.aldebaran.qimessaging.Object getCameraParameterInfo(String param1, Integer param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getCameraParameterInfo", param1, param2).get();
    }

    /**
     * 155 setCameraParameter             Bool (String,Int32,Int32)
     * name: Name of the subscribing vision module
     * parameterId: Camera parameter requested.
     * value: value requested.
     */
    public Boolean setCameraParameter(String param1, Integer param2, Integer param3) throws CallError, InterruptedException {
        return (Boolean) service.call("setCameraParameter", param1, param2, param3).get();
    }

    /**
     * 156 setCameraParameterToDefault    Bool (String,Int32)
     * name: Name of the subscribing vision module
     * parameterId: Camera parameter requested.
     */
    public Boolean setCameraParameterToDefault(String param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("setCameraParameterToDefault", param1, param2).get();
    }

    /**
     * 157 setAllCameraParametersToDefault Bool (String)
     * name: Name of the subscribing vision module
     */
    public Boolean setAllCameraParametersToDefault(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("setAllCameraParametersToDefault", param1).get();
    }

    /**
     * 158 getDirectRawImageLocal         Unknown (String)
     * Retrieves the latest image from the video source and returns a pointer to the locked ALImage, with data array pointing directly to raw data. There is no format conversion and no copy of the raw buffer.
     * Warning: When image is not necessary anymore, a call to releaseDirectRawImage() is requested.
     * Warning: When using this mode for several vision module, if they need raw data for more than 25ms check that you have strictly less modules in this mode than the amount of kernel buffers!!
     * Warning: Release all kernel buffers before any action requesting a modification in camera running mode (e.g. resolution, switch between cameras).
     * name: Name of the subscribing vision module
     * return: Pointer to the locked image buffer, NULL if error.
     * Warning, image pointer is valid only for C++ dynamic library.
     */
    public com.aldebaran.qimessaging.Object getDirectRawImageLocal(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getDirectRawImageLocal", param1).get();
    }

    /**
     * 159 getDirectRawImageRemote        Value (String)
     * Fills an ALValue with data coming directly from raw buffer (no format conversion).
     * name: Name of the subscribing vision module
     * return: Array containing image informations :
     * [0] : width;
     * [1] : height;
     * [2] : number of layers;
     * [3] : ColorSpace;
     * [4] : time stamp (highest 32 bits);
     * [5] : time stamp (lowest 32 bits);
     * [6] : array of size height * width * nblayers containing image data;
     * [7] : cameraID;
     * [8] : left angle;
     * [9] : top angle;
     * [10] : right angle;
     * [11] : bottom angle;
     */
    public com.aldebaran.qimessaging.Object getDirectRawImageRemote(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getDirectRawImageRemote", param1).get();
    }

    /**
     * 160 releaseDirectRawImage          Bool (String)
     * Release image buffer locked by getDirectRawImageLocal().
     * name: Name of the subscribing vision module
     * return: true if success
     */
    public Boolean releaseDirectRawImage(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("releaseDirectRawImage", param1).get();
    }

    /**
     * 161 getImageLocal                  Unknown (String)
     * Applies transformations to the last image from video source and returns a pointer to a locked ALImage.
     * When image is not necessary anymore, a call to releaseImage() is requested.
     * name: Name of the subscribing vision module
     * return: Pointer of the locked image buffer, NULL if error.Warning, image pointer is valid only for C++ dynamic library.
     */
    public com.aldebaran.qimessaging.Object getImageLocal(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getImageLocal", param1).get();
    }

    /**
     * 162 getImageRemote                 Value (String)
     * Applies transformations to the last image from video source and fills pFrameOut.
     * name: Name of the subscribing vision module
     * return: Array containing image informations :
     * [0] : width;
     * [1] : height;
     * [2] : number of layers;
     * [3] : ColorSpace;
     * [4] : time stamp (highest 32 bits);
     * [5] : time stamp (lowest 32 bits);
     * [6] : array of size height * width * nblayers containing image data;
     * [7] : cameraID;
     * [8] : left angle;
     * [9] : top angle;
     * [10] : right angle;
     * [11] : bottom angle;
     */
    public List<Object> getImageRemote(String param1) throws CallError, InterruptedException {
        return (List<Object>) service.call("getImageRemote", param1).get();
    }

    /**
     * 163 releaseImage                   Bool (String)
     * Release image buffer locked by getImageLocal().
     * If G.V.M. had no locked image buffer, does nothing.
     * name: Name of the subscribing vision module
     * return: true if success
     */
    public Boolean releaseImage(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("releaseImage", param1).get();
    }

    /**
     * 164 getActiveCameras               Value (String)
     * name: Name of the subscribing vision module
     */
    public com.aldebaran.qimessaging.Object getActiveCameras(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getActiveCameras", param1).get();
    }

    /**
     * 165 setActiveCameras               Value (String,Value)
     * name: Name of the subscribing vision module
     * cameraIndexes: Cameras requested.
     */
    public com.aldebaran.qimessaging.Object setActiveCameras(String param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("setActiveCameras", param1, param2).get();
    }

    /**
     * 166 getResolutions                 Value (String)
     * name: Name of the subscribing vision module
     */
    public com.aldebaran.qimessaging.Object getResolutions(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getResolutions", param1).get();
    }

    /**
     * 167 setResolutions                 Value (String,Value)
     * name: Name of the subscribing vision module
     * resolutions: Resolutions requested.
     */
    public com.aldebaran.qimessaging.Object setResolutions(String param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("setResolutions", param1, param2).get();
    }

    /**
     * 168 getColorSpaces                 Value (String)
     * name: Name of the subscribing vision module
     */
    public com.aldebaran.qimessaging.Object getColorSpaces(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getColorSpaces", param1).get();
    }

    /**
     * 169 setColorSpaces                 Value (String,Value)
     * name: Name of the subscribing vision module
     * colorSpaces: Color Spaces requested.
     */
    public com.aldebaran.qimessaging.Object setColorSpaces(String param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("setColorSpaces", param1, param2).get();
    }

    /**
     * 170 getCamerasParameter            Value (String,Int32)
     * name: Name of the subscribing vision module
     * parameterId: Camera parameter requested.
     */
    public com.aldebaran.qimessaging.Object getCamerasParameter(String param1, Integer param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getCamerasParameter", param1, param2).get();
    }

    /**
     * 171 setCamerasParameter            Value (String,Int32,Value)
     * name: Name of the subscribing vision module
     * parameterId: Camera parameter requested.
     * values: values requested.
     */
    public com.aldebaran.qimessaging.Object setCamerasParameter(String param1, Integer param2, com.aldebaran.qimessaging.Object param3) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("setCamerasParameter", param1, param2, param3).get();
    }

    /**
     * 172 setCamerasParameterToDefault   Value (String,Int32)
     * name: Name of the subscribing vision module
     * parameterId: Camera parameter requested.
     */
    public com.aldebaran.qimessaging.Object setCamerasParameterToDefault(String param1, Integer param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("setCamerasParameterToDefault", param1, param2).get();
    }

    /**
     * 173 getDirectRawImagesLocal        Value (String)
     * Retrieves the latest image from the video source and returns a pointer to the locked ALImage, with data array pointing directly to raw data. There is no format conversion and no copy of the raw buffer.
     * Warning: When image is not necessary anymore, a call to releaseDirectRawImage() is requested.
     * Warning: When using this mode for several vision module, if they need raw data for more than 25ms check that you have strictly less modules in this mode than the amount of kernel buffers!!
     * Warning: Release all kernel buffers before any action requesting a modification in camera running mode (e.g. resolution, switch between cameras).
     * name: Name of the subscribing vision module
     * return: Array of pointer to the locked image buffer, NULL if error.
     * Warning, image pointer is valid only for C++ dynamic library.
     */
    public com.aldebaran.qimessaging.Object getDirectRawImagesLocal(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getDirectRawImagesLocal", param1).get();
    }

    /**
     * 174 getDirectRawImagesRemote       Value (String)
     * Fills an ALValue with data coming directly from raw buffer (no format conversion).
     * name: Name of the subscribing vision module
     * return: Array containing image informations :
     * [0] : width;
     * [1] : height;
     * [2] : number of layers;
     * [3] : ColorSpace;
     * [4] : time stamp (highest 32 bits);
     * [5] : time stamp (lowest 32 bits);
     * [6] : array of size height * width * nblayers containing image data;
     * [7] : cameraID;
     * [8] : left angle;
     * [9] : top angle;
     * [10] : right angle;
     * [11] : bottom angle;
     */
    public Object getDirectRawImagesRemote(String param1) throws CallError, InterruptedException {
        return service.call("getDirectRawImagesRemote", param1).get();
    }

    /**
     * 175 releaseDirectRawImages         Value (String)
     * Release image buffer locked by getDirectRawImagesLocal().
     * name: Name of the subscribing vision module
     * return: true if success
     */
    public com.aldebaran.qimessaging.Object releaseDirectRawImages(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("releaseDirectRawImages", param1).get();
    }

    /**
     * 176 getImagesLocal                 Value (String)
     * Applies transformations to the last image from video source and returns a pointer to a locked ALImage.
     * When image is not necessary anymore, a call to releaseImage() is requested.
     * name: Name of the subscribing vision module
     * return: Array of pointer of the locked image buffer, NULL if error.Warning, image pointer is valid only for C++ dynamic library.
     */
    public com.aldebaran.qimessaging.Object getImagesLocal(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getImagesLocal", param1).get();
    }

    /**
     * 177 getImagesRemote                Value (String)
     * Applies transformations to the last image from video source and fills pFrameOut.
     * name: Name of the subscribing vision module
     * return: Array containing image informations :
     * [0] : width;
     * [1] : height;
     * [2] : number of layers;
     * [3] : ColorSpace;
     * [4] : time stamp (highest 32 bits);
     * [5] : time stamp (lowest 32 bits);
     * [6] : array of size height * width * nblayers containing image data;
     * [7] : cameraID;
     * [8] : left angle;
     * [9] : top angle;
     * [10] : right angle;
     * [11] : bottom angle;
     */
    public com.aldebaran.qimessaging.Object getImagesRemote(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getImagesRemote", param1).get();
    }

    /**
     * 178 releaseImages                  Value (String)
     * Release image buffer locked by getImageLocal().
     * If G.V.M. had no locked image buffer, does nothing.
     * name: Name of the subscribing vision module
     * return: true if success
     */
    public com.aldebaran.qimessaging.Object releaseImages(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("releaseImages", param1).get();
    }

    /**
     * 179 recordVideo                    Bool (String,String,Int32,Int32)
     * Background record of an .arv raw format video from the images processed by a vision module
     * Actualy it take picture each time the vision module call getDirectRawImageRemote().
     * id: Name under which the G.V.M. is known from the V.I.M.
     * path: path/name of the video to be recorded
     * totalNumber: number of images to be recorded. 0xFFFFFFFF for "unlimited"
     * period: one image recorded every pPeriod images
     * return: true if success
     */
    public Boolean recordVideo(String param1, String param2, Integer param3, Integer param4) throws CallError, InterruptedException {
        return (Boolean) service.call("recordVideo", param1, param2, param3, param4).get();
    }

    /**
     * 180 stopVideo                      Bool (String)
     * Stop writing the video sequence
     * id: Name under which the G.V.M. is known from ALVideoDevice.
     * return: true if success
     */
    public Boolean stopVideo(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("stopVideo", param1).get();
    }

    /**
     * 181 getAngularPositionFromImagePosition List<Float> (Int32,List<Float>)
     */
    public List<Float> getAngularPositionFromImagePosition(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>) service.call("getAngularPositionFromImagePosition", param1, param2).get();
    }

    /**
     * 182 getImagePositionFromAngularPosition List<Float> (Int32,List<Float>)
     */
    public List<Float> getImagePositionFromAngularPosition(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>) service.call("getImagePositionFromAngularPosition", param1, param2).get();
    }

    /**
     * 183 getAngularSizeFromImageSize    List<Float> (Int32,List<Float>)
     */
    public List<Float> getAngularSizeFromImageSize(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>) service.call("getAngularSizeFromImageSize", param1, param2).get();
    }

    /**
     * 184 getImageSizeFromAngularSize    List<Float> (Int32,List<Float>)
     */
    public List<Float> getImageSizeFromAngularSize(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>) service.call("getImageSizeFromAngularSize", param1, param2).get();
    }

    /**
     * 185 getImageInfoFromAngularInfo    List<Float> (Int32,List<Float>)
     */
    public List<Float> getImageInfoFromAngularInfo(Integer param1, List<Float> param2) throws CallError, InterruptedException {
        return (List<Float>) service.call("getImageInfoFromAngularInfo", param1, param2).get();
    }

    /**
     * 186 getImageInfoFromAngularInfoWithResolution List<Float> (Int32,List<Float>,Int32)
     */
    public List<Float> getImageInfoFromAngularInfoWithResolution(Integer param1, List<Float> param2, Integer param3) throws CallError, InterruptedException {
        return (List<Float>) service.call("getImageInfoFromAngularInfoWithResolution", param1, param2, param3).get();
    }

    /**
     * 187 putImage                       Bool (Int32,Int32,Int32,Value)
     * Allow image buffer pushing
     * cameraIndex: Camera requested.
     * width: int width of image among 1280*960, 640*480, 320*240, 240*160
     * height: int height of image
     * imageBuffer: Image buffer in bitmap form
     * return: true if the put succeeded
     */
    public Boolean putImage(Integer param1, Integer param2, Integer param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        return (Boolean) service.call("putImage", param1, param2, param3, param4).get();
    }

    /**
     * 188 getExpectedImageParameters     Value (Int32)
     * called by the simulator to know expected image parameters
     * cameraIndex: Camera requested.
     * return: ALValue of expected parameters, [int resolution, int framerate]
     */
    public com.aldebaran.qimessaging.Object getExpectedImageParameters(Integer param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getExpectedImageParameters", param1).get();
    }

    /**
     * 190 onClientDisconnected           Void (String,Value,String)
     * Callback when client is disconnected
     * eventName: The echoed event name
     * eventContents: The name of the client that has disconnected
     * message: The message give when subscribing.
     */
    public void onClientDisconnected(String param1, com.aldebaran.qimessaging.Object param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("onClientDisconnected", param1, param2, param3);
        else
            service.call("onClientDisconnected", param1, param2, param3).get();
    }

    /**
     * 191 subscribe                      String (String,Int32,Int32,Int32)
     * Register to ALVideoDevice (formerly Video Input Module/V.I.M.). When a General Video Module(G.V.M.) registers to ALVideoDevice, a buffer of the requested image format is added to the buffers list.
     * Returns the name under which the G.V.M. is registered to ALVideoDevice (useful when two G.V.M. try to register using the same name
     * gvmName: Name of the subscribing G.V.M.
     * resolution: Resolution requested. { 0 = kQQVGA, 1 = kQVGA, 2 = kVGA }
     * colorSpace: Colorspace requested. { 0 = kYuv, 9 = kYUV422, 10 = kYUV, 11 = kRGB, 12 = kHSY, 13 = kBGR }
     * fps: Fps (frames per second) requested. { 5, 10, 15, 30 }
     * return: Name under which the G.V.M. is known from ALVideoDevice, 0 if failed.
     */
    public String subscribe(String param1, Integer param2, Integer param3, Integer param4) throws CallError, InterruptedException {
        return (String) service.call("subscribe", param1, param2, param3, param4).get();
    }

    /**
     * 192 unsubscribeAllInstances        Void (String)
     * Used to unsubscribe all instances for a given G.V.M. (e.g. VisionModule and VisionModule_5) from ALVideoDevice.
     * id: Root name of the G.V.M. (e.g. with the example above this will be VisionModule).
     */
    public void unsubscribeAllInstances(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unsubscribeAllInstances", param1);
        else
            service.call("unsubscribeAllInstances", param1).get();
    }

    /**
     * 193 getVIMResolution               Int32 ()
     */
    public Integer getVIMResolution() throws CallError, InterruptedException {
        return (Integer) service.call("getVIMResolution").get();
    }

    /**
     * 194 getVIMColorSpace               Int32 ()
     */
    public Integer getVIMColorSpace() throws CallError, InterruptedException {
        return (Integer) service.call("getVIMColorSpace").get();
    }

    /**
     * 195 getVIMFrameRate                Int32 ()
     */
    public Integer getVIMFrameRate() throws CallError, InterruptedException {
        return (Integer) service.call("getVIMFrameRate").get();
    }

    /**
     * 196 getGVMResolution               Int32 (String)
     */
    public Integer getGVMResolution(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getGVMResolution", param1).get();
    }

    /**
     * 197 getGVMColorSpace               Int32 (String)
     */
    public Integer getGVMColorSpace(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getGVMColorSpace", param1).get();
    }

    /**
     * 198 getGVMFrameRate                Int32 (String)
     */
    public Integer getGVMFrameRate(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getGVMFrameRate", param1).get();
    }

    /**
     * 199 getCameraModelID               Int32 ()
     */
    public Integer getCameraModelID() throws CallError, InterruptedException {
        return (Integer) service.call("getCameraModelID").get();
    }

    /**
     * 200 setParam                       Void (Int32,Int32)
     * Sets the value of a specific parameter for the video source.
     * pParam: Camera parameter requested.
     * pNewValue: value requested.
     */
    public void setParam(Integer param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setParam", param1, param2);
        else
            service.call("setParam", param1, param2).get();
    }

    /**
     * 201 setParam                       Void (Int32,Int32,Int32)
     * Sets the value of a specific parameter for the video source.
     * pParam: Camera parameter requested.
     * pNewValue: value requested.
     * pCameraIndex: Camera requested.
     */
    public void setParam(Integer param1, Integer param2, Integer param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setParam", param1, param2, param3);
        else
            service.call("setParam", param1, param2, param3).get();
    }

    /**
     * 202 getParam                       Int32 (Int32)
     * pParam: Camera parameter requested.
     */
    public Integer getParam(Integer param1) throws CallError, InterruptedException {
        return (Integer) service.call("getParam", param1).get();
    }

    /**
     * 203 getParam                       Int32 (Int32,Int32)
     * pParam: Camera parameter requested.
     * pCameraIndex: Camera requested.
     */
    public Integer getParam(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Integer) service.call("getParam", param1, param2).get();
    }

    /**
     * 204 setParamDefault                Void (Int32)
     */
    public void setParamDefault(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setParamDefault", param1);
        else
            service.call("setParamDefault", param1).get();
    }

    /**
     * 205 getAngPosFromImgPos            List<Float> (List<Float>)
     */
    public List<Float> getAngPosFromImgPos(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>) service.call("getAngPosFromImgPos", param1).get();
    }

    /**
     * 206 getImgPosFromAngPos            List<Float> (List<Float>)
     */
    public List<Float> getImgPosFromAngPos(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>) service.call("getImgPosFromAngPos", param1).get();
    }

    /**
     * 207 getAngSizeFromImgSize          List<Float> (List<Float>)
     */
    public List<Float> getAngSizeFromImgSize(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>) service.call("getAngSizeFromImgSize", param1).get();
    }

    /**
     * 208 getImgSizeFromAngSize          List<Float> (List<Float>)
     */
    public List<Float> getImgSizeFromAngSize(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>) service.call("getImgSizeFromAngSize", param1).get();
    }

    /**
     * 209 getImgInfoFromAngInfo          List<Float> (List<Float>)
     */
    public List<Float> getImgInfoFromAngInfo(List<Float> param1) throws CallError, InterruptedException {
        return (List<Float>) service.call("getImgInfoFromAngInfo", param1).get();
    }

    /**
     * 210 getImgInfoFromAngInfoWithRes   List<Float> (List<Float>,Int32)
     */
    public List<Float> getImgInfoFromAngInfoWithRes(List<Float> param1, Integer param2) throws CallError, InterruptedException {
        return (List<Float>) service.call("getImgInfoFromAngInfoWithRes", param1, param2).get();
    }

    /**
     * 211 resolutionToSizes              Value (Int32)
     */
    public com.aldebaran.qimessaging.Object resolutionToSizes(Integer param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("resolutionToSizes", param1).get();
    }

    /**
     * 212 sizesToResolution              Int32 (Int32,Int32)
     */
    public Integer sizesToResolution(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Integer) service.call("sizesToResolution", param1, param2).get();
    }

    /**
     * 213 getExpectedImageParameters     Value ()
     * called by the simulator to know expected image parameters
     * return: ALValue of expected parameters, [int resolution, int framerate]
     */
    public com.aldebaran.qimessaging.Object getExpectedImageParameters() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getExpectedImageParameters").get();
    }

    /**
     * 214 setSimCamInputSize             Bool (Int32,Int32)
     * called by the simulator to know expected image parameters
     * width: int width of image among 1280*960, 640*480, 320*240, 240*160
     * height: int height of image among 1280*960, 640*480, 320*240, 240*160
     * return: true if setSize worked
     */
    public Boolean setSimCamInputSize(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("setSimCamInputSize", param1, param2).get();
    }

    /**
     * 215 putImage                       Bool (Value)
     * Allow image buffer pushing
     * imageBuffer: Image buffer in bitmap form
     * return: true if the put succeeded
     */
    public Boolean putImage(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        return (Boolean) service.call("putImage", param1).get();
    }

    /**
     * 216 startFrameGrabber              Bool ()
     * Advanced method that opens and initialize video source device if it was not before.
     * Note that the first module subscribing to ALVideoDevice will launch it automatically.
     * return: true if success
     */
    public Boolean startFrameGrabber() throws CallError, InterruptedException {
        return (Boolean) service.call("startFrameGrabber").get();
    }

    /**
     * 217 stopFrameGrabber               Bool ()
     * Advanced method that close video source device.
     * Note that the last module unsubscribing to ALVideoDevice will launch it automatically.
     * return: true if success
     */
    public Boolean stopFrameGrabber() throws CallError, InterruptedException {
        return (Boolean) service.call("stopFrameGrabber").get();
    }

    /**
     * 218 isFrameGrabberOff              Int32 ()
     * Advanced method that asks if the framegrabber is off.
     * return: true if off
     */
    public Integer isFrameGrabberOff() throws CallError, InterruptedException {
        return (Integer) service.call("isFrameGrabberOff").get();
    }

    /**
     * 219 getHorizontalAperture          Float (Int32)
     * cameraIndex: Camera requested.
     */
    public Float getHorizontalAperture(Integer param1) throws CallError, InterruptedException {
        return (Float) service.call("getHorizontalAperture", param1).get();
    }

    /**
     * 220 getVerticalAperture            Float (Int32)
     * cameraIndex: Camera requested.
     * * Signals:
     */
    public Float getVerticalAperture(Integer param1) throws CallError, InterruptedException {
        return (Float) service.call("getVerticalAperture", param1).get();
    }


}
    