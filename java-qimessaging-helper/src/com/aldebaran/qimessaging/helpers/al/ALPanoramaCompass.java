package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALPanoramaCompass extends ALModule {

    public ALPanoramaCompass(Session session) {
        super(session);
    }

    /**
     * 100 exit                         Void ()
     * Exits and unregisters the module.
     * 102 pCall                        Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version                      String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                         Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList                List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp                Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp                Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                         Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning                    Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                         Void (Int32)
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
     * 111 getBrokerName                String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage                     String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 setupPanorama                Int32 ()
     * Shoot a panorama at the current position.
     */
    public Integer setupPanorama() throws CallError, InterruptedException {
        return (Integer) service.call("setupPanorama").get();
    }

    /**
     * 114 isDataAvailable              Bool ()
     * Returns true if there is some panorama data
     */
    public Boolean isDataAvailable() throws CallError, InterruptedException {
        return (Boolean) service.call("isDataAvailable").get();
    }

    /**
     * 115 getCurrentPosition           Value ()
     * Return the current orientation of the robot in the current panorama.
     */
    public com.aldebaran.qimessaging.Object getCurrentPosition() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getCurrentPosition").get();
    }

    /**
     * 116 localizeNoHint               List<Float> ()
     * Localize the robot using the scan,without hint.
     */
    public List<Float> localizeNoHint() throws CallError, InterruptedException {
        return (List<Float>) service.call("localizeNoHint").get();
    }

    /**
     * 117 localize                     List<Float> ()
     * Localize the robot using the scan.
     * pMode: Localization mode
     */
    public List<Float> localize() throws CallError, InterruptedException {
        return (List<Float>) service.call("localize").get();
    }

    /**
     * 118 localize                     List<Float> (Bool)
     * Localize the robot using the scan.
     * pMode: Localization mode
     */
    public List<Float> localize(Boolean param1) throws CallError, InterruptedException {
        return (List<Float>) service.call("localize", param1).get();
    }

    /**
     * 119 localize                     List<Float> (Int32)
     * Localize the robot using the scan.
     * pMode: Localization mode
     */
    public List<Float> localize(Integer param1) throws CallError, InterruptedException {
        return (List<Float>) service.call("localize", param1).get();
    }

    /**
     * 120 localize                     List<Float> (Int32,Bool)
     * Localize the robot using the scan.
     * pMode: Localization mode
     */
    public List<Float> localize(Integer param1, Boolean param2) throws CallError, InterruptedException {
        return (List<Float>) service.call("localize", param1, param2).get();
    }

    /**
     * 121 isInPanorama                 Int32 ()
     * Check if the robot is in the current Panorama.
     * return: Error status.
     */
    public Integer isInPanorama() throws CallError, InterruptedException {
        return (Integer) service.call("isInPanorama").get();
    }

    /**
     * 122 isRelocalizationRequired     Bool ()
     * Is a relocalization movement required.
     */
    public Boolean isRelocalizationRequired() throws CallError, InterruptedException {
        return (Boolean) service.call("isRelocalizationRequired").get();
    }

    /**
     * 123 loadPanorama                 Int32 (Int32)
     * Load the panorama corresponding to the input identity from the hard drive. It has to exist.
     * id: Identity of the requested Panorama.
     * return: Error status.
     */
    public Integer loadPanorama(Integer param1) throws CallError, InterruptedException {
        return (Integer) service.call("loadPanorama", param1).get();
    }

    /**
     * 124 getCurrentPanoramaDescriptor Value ()
     * return: Return an ALValue containing Panorama identity and contained Frames identity.
     */
    public com.aldebaran.qimessaging.Object getCurrentPanoramaDescriptor() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getCurrentPanoramaDescriptor").get();
    }

    /**
     * 125 getFrame                     Value (Int32,String)
     * Return the Frame corresponding to the input identity. It have to be in the current Panorama
     * id: Identity of the resquested Frame.
     * return: ALValue containing the Frame image part.
     */
    public com.aldebaran.qimessaging.Object getFrame(Integer param1, String param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getFrame", param1, param2).get();
    }

    /**
     * 126 isInPanorama                 Int32 (Int32)
     * Check if the robot is in the current Panorama.
     * return: Error status.
     */
    public Integer isInPanorama(Integer param1) throws CallError, InterruptedException {
        return (Integer) service.call("isInPanorama", param1).get();
    }

    /**
     * 127 clearAllPanoramas            Int32 ()
     * Delete all panorama files in the current working directory
     */
    public Integer clearAllPanoramas() throws CallError, InterruptedException {
        return (Integer) service.call("clearAllPanoramas").get();
    }

    /**
     * 128 clearAllPanoramas            Int32 (Bool)
     */
    public Integer clearAllPanoramas(Boolean param1) throws CallError, InterruptedException {
        return (Integer) service.call("clearAllPanoramas", param1).get();
    }

    /**
     * 129 clearPanorama                Int32 (Int32)
     * Delete all files related to a given panorama in the current working directory
     * pIdentity: Panorama identity
     * * Signals:
     */
    public Integer clearPanorama(Integer param1) throws CallError, InterruptedException {
        return (Integer) service.call("clearPanorama", param1).get();
    }


}
    