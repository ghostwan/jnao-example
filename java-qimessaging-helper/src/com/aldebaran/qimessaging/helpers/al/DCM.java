package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class DCM extends ALModule {

    public DCM(Session session) {
        super(session);
    }

    /**
     * 100 exit          Void ()
     * Exits and unregisters the module.
     * 102 pCall         Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version       String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping          Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait          Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning     Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop          Void (Int32)
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
     * 111 getBrokerName String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage      String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 set           Void (Value)
     * Call this function to send a timed-command list to an actuator
     * commands: AL::ALValue with all data
     */
    public void set(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("set", param1);
        else
            service.call("set", param1).get();
    }

    /**
     * 114 setAlias      Void (String,Int32,List<Float>)
     * Call this function to send timed-command list to an alias (list of actuators)
     * commands: AL::ALValue with all data
     */
    public void setAlias(String param1, Integer param2, List<Float> param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setAlias", param1, param2, param3);
        else
            service.call("setAlias", param1, param2, param3).get();
    }

    /**
     * 115 setAlias      Void (Value)
     * Call this function to send timed-command list to an alias (list of actuators) with "ClearAll" merge startegy
     * name: alias name
     * time: time for the timed command
     * commands: std::vector<float> with all commands
     */
    public void setAlias(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setAlias", param1);
        else
            service.call("setAlias", param1).get();
    }

    /**
     * 116 getTime       Int32 (Int32)
     * Return the DCM time
     * offset: optional time in ms (signed) to add/remove
     * return: An integer (could be signed) with the DCM time
     */
    public Integer getTime(Integer param1) throws CallError, InterruptedException {
        return (Integer) service.call("getTime", param1).get();
    }

    /**
     * 117 createAlias   Value (Value)
     * Create or change an alias (list of actuators)
     * alias: Alias name and description
     * return: Same as pParams, but with the name removed if the actuator is not found
     */
    public com.aldebaran.qimessaging.Object createAlias(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("createAlias", param1).get();
    }

    /**
     * 118 getPrefix     Value ()
     * Return the STM base name
     * return: the STM base name for all device/sensors (1st string in the array) and all devices (2nd string in the array)
     */
    public com.aldebaran.qimessaging.Object getPrefix() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getPrefix").get();
    }

    /**
     * 119 special       Void (String)
     * Special DCM commands
     * result: one string and could be Reset, Version, Chain, Diagnostic, Config
     */
    public void special(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("special", param1);
        else
            service.call("special", param1).get();
    }

    /**
     * 120 calibration   Void (Value)
     * Calibration of a joint
     * calibrationInput: A complex ALValue. See red documentation
     */
    public void calibration(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("calibration", param1);
        else
            service.call("calibration", param1).get();
    }

    /**
     * 121 preferences   Int32 (String,String,String,Value)
     * Save updated value from DCM in XML pref file
     * action: string : 'Save' 'Load' 'Add'
     * target: string : 'Chest' 'Head' 'Main' 'All'
     * keyName: The name of the key if action = 'Add'.
     * keyValue: The ALVAlue of the key to add
     * return: Nothing
     * * Signals:
     */
    public Integer preferences(String param1, String param2, String param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        return (Integer) service.call("preferences", param1, param2, param3, param4).get();
    }


}
    