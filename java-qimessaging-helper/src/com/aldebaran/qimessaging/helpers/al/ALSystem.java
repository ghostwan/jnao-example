package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALSystem extends ALModule {

    public ALSystem(Session session) {
        super(session);
    }

    /**
     * 100 exit                  Void ()
     * Exits and unregisters the module.
     * 102 pCall                 Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version               String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                  Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList         List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp         Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp         Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                  Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning             Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                  Void (Int32)
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
     * 111 getBrokerName         String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage              String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 diskFree              List<PartitionInfo> (Bool)
     * Display free disk space
     * all: Show all mount partions.
     * return: A vector with all partions' infos
     */
    public List<Object> diskFree(Boolean param1) throws CallError, InterruptedException {
        return (List<Object>) service.call("diskFree", param1).get();
    }

    /**
     * 114 robotName             String ()
     * System hostname
     * return: name of the robot
     */
    public String robotName() throws CallError, InterruptedException {
        return (String) service.call("robotName").get();
    }

    /**
     * 115 setRobotName          Bool (String)
     * Set system hostname
     * name: name to use
     * return: whether the operation was successful
     */
    public Boolean setRobotName(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("setRobotName", param1).get();
    }

    /**
     * 116 robotIcon             Value ()
     * Robot icon
     * return: icon of the robot
     */
    public com.aldebaran.qimessaging.Object robotIcon() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("robotIcon").get();
    }

    /**
     * 117 shutdown              Void ()
     * Shutdown robot
     */
    public void shutdown() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("shutdown");
        else
            service.call("shutdown").get();
    }

    /**
     * 118 reboot                Void ()
     * Reboot robot
     */
    public void reboot() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("reboot");
        else
            service.call("reboot").get();
    }

    /**
     * 119 systemVersion         String ()
     * Running system version
     * return: running system version
     */
    public String systemVersion() throws CallError, InterruptedException {
        return (String) service.call("systemVersion").get();
    }

    /**
     * 120 freeMemory            Int32 ()
     * Amount of available memory in heap
     * return: amount of available memory in heap
     */
    public Integer freeMemory() throws CallError, InterruptedException {
        return (Integer) service.call("freeMemory").get();
    }

    /**
     * 121 totalMemory           Int32 ()
     * Amount of total memory in heap
     * return: amount of total memory in heap
     */
    public Integer totalMemory() throws CallError, InterruptedException {
        return (Integer) service.call("totalMemory").get();
    }

    /**
     * 122 timezone              String ()
     * Current timezone
     * return: current timezone
     */
    public String timezone() throws CallError, InterruptedException {
        return (String) service.call("timezone").get();
    }

    /**
     * 123 setTimezone           Bool (String)
     * Set current timezone
     * timezone: timezone to use
     * return: whether the operation was successful
     */
    public Boolean setTimezone(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("setTimezone", param1).get();
    }

    /**
     * 124 previousSystemVersion String ()
     * Previous system version before software update (empty if this is not the 1st boot after a software update)
     * return: Previous system version before software update.
     */
    public String previousSystemVersion() throws CallError, InterruptedException {
        return (String) service.call("previousSystemVersion").get();
    }

    /**
     * 125 changePassword        Void (String,String)
     * Change the user password.
     * old password: The current password of the user.
     * new password: The new user password.
     * * Signals:
     * 130 userDiskSpaceNearlyFull (UInt32)
     */
    public void changePassword(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("changePassword", param1, param2);
        else
            service.call("changePassword", param1, param2).get();
    }

    /**
     * 131 userDiskSpaceFull       (UInt32)
     */
    public void userDiskSpaceFull(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("userDiskSpaceFull", param1);
        else
            service.call("userDiskSpaceFull", param1).get();
    }

    /**
     * 132 userDiskError           (String)
     */
    public void userDiskError(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("userDiskError", param1);
        else
            service.call("userDiskError", param1).get();
    }

    /**
     * 133 systemUpdateSucceeded   (String)
     */
    public void systemUpdateSucceeded(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("systemUpdateSucceeded", param1);
        else
            service.call("systemUpdateSucceeded", param1).get();
    }

    /**
     * 134 systemUpdateFailed      (String)
     */
    public void systemUpdateFailed(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("systemUpdateFailed", param1);
        else
            service.call("systemUpdateFailed", param1).get();
    }


}
    