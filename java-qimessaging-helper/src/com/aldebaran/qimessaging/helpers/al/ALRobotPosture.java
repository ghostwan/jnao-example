package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALRobotPosture extends ALModule {

    public ALRobotPosture(Session session) {
        super(session);
    }

    /**
     * 100 exit                 Void ()
     * Exits and unregisters the module.
     * 102 pCall                Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version              String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                 Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList        List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp        Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp        Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                 Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning            Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                 Void (Int32)
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
     * 111 getBrokerName        String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage             String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 getPostureFamily     String ()
     * Returns the posture family for example Standing, LyingBelly,...
     * return: Returns the posture family, e.g. Standing.
     */
    public String getPostureFamily() throws CallError, InterruptedException {
        return (String) service.call("getPostureFamily").get();
    }

    /**
     * 114 goToPosture          Bool (String,Float)
     * Make the robot go to the choosenposture.
     * postureName: Name of the desired posture. Use getPostureList to get the list of posture name available.
     * maxSpeedFraction: A fraction.
     * return: Returns if the posture was reached or not.
     */
    public Boolean goToPosture(String param1, Float param2) throws CallError, InterruptedException {
        return (Boolean) service.call("goToPosture", param1, param2).get();
    }

    /**
     * 115 applyPosture         Bool (String,Float)
     * Set the angle of the joints of the  robot to the choosen posture.
     * postureName: Name of the desired posture. Use getPostureList to get the list of posture name available.
     * maxSpeedFraction: A fraction.
     * return: Returns if the posture was reached or not.
     */
    public Boolean applyPosture(String param1, Float param2) throws CallError, InterruptedException {
        return (Boolean) service.call("applyPosture", param1, param2).get();
    }

    /**
     * 116 stopMove             Void ()
     * Stop the posture move.
     */
    public void stopMove() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopMove");
        else
            service.call("stopMove").get();
    }

    /**
     * 117 getPostureList       List<String> ()
     * Get the list of posture names available.
     */
    public List<String> getPostureList() throws CallError, InterruptedException {
        return (List<String>) service.call("getPostureList").get();
    }

    /**
     * 118 getPostureFamilyList List<String> ()
     * Get the list of posture family names available.
     */
    public List<String> getPostureFamilyList() throws CallError, InterruptedException {
        return (List<String>) service.call("getPostureFamilyList").get();
    }

    /**
     * 119 setMaxTryNumber      Void (Int32)
     * Set maximum of tries on goToPosture fail.
     * pMaxTryNumber: Number of retry if goToPosture fail.
     */
    public void setMaxTryNumber(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setMaxTryNumber", param1);
        else
            service.call("setMaxTryNumber", param1).get();
    }

    /**
     * 120 getPosture           String ()
     * Determine posture.
     * * Signals:
     */
    public String getPosture() throws CallError, InterruptedException {
        return (String) service.call("getPosture").get();
    }


}
    