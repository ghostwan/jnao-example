package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALLocalization extends ALModule {

    public ALLocalization(Session session) {
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
     * 113 getMessageFromErrorCode      String (Int32)
     */
    public String getMessageFromErrorCode(Integer param1) throws CallError, InterruptedException {
        return (String) service.call("getMessageFromErrorCode", param1).get();
    }

    /**
     * 114 stopAll                      Void ()
     * Stop all robot movements.
     */
    public void stopAll() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopAll");
        else
            service.call("stopAll").get();
    }

    /**
     * 116 learnHome                    Int32 ()
     * Learn the robot home.
     */
    public Integer learnHome() throws CallError, InterruptedException {
        return (Integer) service.call("learnHome").get();
    }

    /**
     * 117 isInCurrentHome              Bool ()
     * Is the robot in its home?
     */
    public Boolean isInCurrentHome() throws CallError, InterruptedException {
        return (Boolean) service.call("isInCurrentHome").get();
    }

    /**
     * 118 getCurrentPanoramaDescriptor Value ()
     * Get some information about the current panorama.
     */
    public com.aldebaran.qimessaging.Object getCurrentPanoramaDescriptor() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getCurrentPanoramaDescriptor").get();
    }

    /**
     * 119 getFrame                     Value (Int32,String)
     * Get a frame buffer.
     */
    public com.aldebaran.qimessaging.Object getFrame(Integer param1, String param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getFrame", param1, param2).get();
    }

    /**
     * 120 clear                        Int32 (String)
     * Delete all panoramas in a directory.
     * pDirectory: Name of the directory
     */
    public Integer clear(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("clear", param1).get();
    }

    /**
     * 121 load                         Int32 (String)
     * Loads panoramas from a directory in the default one.
     * pDirectory: Name of the directory
     */
    public Integer load(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("load", param1).get();
    }

    /**
     * 122 save                         Int32 (String)
     * Save the temporary panoramas in a directory from the default one.
     * pDirectory: Name of the directory
     */
    public Integer save(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("save", param1).get();
    }

    /**
     * 123 isRelocalizationRequired     Bool ()
     */
    public Boolean isRelocalizationRequired() throws CallError, InterruptedException {
        return (Boolean) service.call("isRelocalizationRequired").get();
    }

    /**
     * 124 isDataAvailable              Bool ()
     */
    public Boolean isDataAvailable() throws CallError, InterruptedException {
        return (Boolean) service.call("isDataAvailable").get();
    }

    /**
     * 125 getRobotPosition             List<Float> ()
     * Get the robot position in world navigation.
     */
    public List<Float> getRobotPosition() throws CallError, InterruptedException {
        return (List<Float>) service.call("getRobotPosition").get();
    }

    /**
     * 126 getRobotPosition             List<Float> (Bool)
     * Get the robot position in world navigation.
     */
    public List<Float> getRobotPosition(Boolean param1) throws CallError, InterruptedException {
        return (List<Float>) service.call("getRobotPosition", param1).get();
    }

    /**
     * 127 getRobotOrientation          Value (Bool)
     * Get the robot orientation.
     */
    public com.aldebaran.qimessaging.Object getRobotOrientation(Boolean param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getRobotOrientation", param1).get();
    }

    /**
     * 128 getRobotOrientation          Value ()
     * Get the robot orientation.
     */
    public com.aldebaran.qimessaging.Object getRobotOrientation() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getRobotOrientation").get();
    }

    /**
     * 130 goToHome                     Int32 ()
     * Go to the robot home.
     */
    public Integer goToHome() throws CallError, InterruptedException {
        return (Integer) service.call("goToHome").get();
    }

    /**
     * 131 goToPosition                 Int32 (List<Float>)
     * Go to a given position.
     * * Signals:
     */
    public Integer goToPosition(List<Float> param1) throws CallError, InterruptedException {
        return (Integer) service.call("goToPosition", param1).get();
    }


}
    