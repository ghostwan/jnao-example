package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALLauncher extends ALModule {

    public ALLauncher(Session session) {
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
     * 113 launchLocal         List<String> (String)
     * Loads dynamicaly a module
     * moduleName: the name of the module to launch or the name of the python script to evaluate
     * return: list of modules loaded
     */
    public List<String> launchLocal(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("launchLocal", param1).get();
    }

    /**
     * 114 launchExecutable    Bool (String)
     * runs an executable and connect it to current broker (executable)
     * moduleName: the name of the module to launch or the name of the script file to execute
     * return: true if ok
     */
    public Boolean launchExecutable(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("launchExecutable", param1).get();
    }

    /**
     * 117 launchScript        Bool (String)
     * runs a script connected the current broker
     * moduleName: the name of the script to launch (python)
     * return: true if ok
     */
    public Boolean launchScript(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("launchScript", param1).get();
    }

    /**
     * 118 launchPythonModule  Bool (String)
     * Import a python module
     * moduleName: the name of the module to launch
     * return: true if ok
     */
    public Boolean launchPythonModule(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("launchPythonModule", param1).get();
    }

    /**
     * 119 isModulePresent     Bool (String)
     * Tests the existence of an active module in the global system (in same executable or in another executable of the distributed system)
     * strPartOfModuleName: a part of the name of the module to test existence
     * return: the returned value is true if this module is present
     */
    public Boolean isModulePresent(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isModulePresent", param1).get();
    }

    /**
     * 120 getGlobalModuleList List<String> ()
     * get the list of modules loaded on the robot and connected on the robot
     * return: array of present modules
     * * Signals:
     */
    public List<String> getGlobalModuleList() throws CallError, InterruptedException {
        return (List<String>) service.call("getGlobalModuleList").get();
    }


}
    