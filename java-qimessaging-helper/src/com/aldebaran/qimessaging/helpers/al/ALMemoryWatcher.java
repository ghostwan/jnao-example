package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALMemoryWatcher extends ALModule {

    public ALMemoryWatcher(Session session) {
        super(session);
    }

    /**
     * 100 exit               Void ()
     * Exits and unregisters the module.
     * 102 pCall              Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version            String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping               Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList      List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp      Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp      Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait               Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning          Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop               Void (Int32)
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
     * 111 getBrokerName      String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage           String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 listeners          List<String> ()
     * get the list of listened ALMemory keys
     * return: a list of ALMemory keys
     */
    public List<String> listeners() throws CallError, InterruptedException {
        return (List<String>) service.call("listeners").get();
    }

    /**
     * 114 addListener        Void (String,Int32)
     * add an ALMemory key to the list of keys to listen to
     * name: the complete name of the ALMemory key
     * interval: interval of time the system should wait before retrieving this key value again
     */
    public void addListener(String param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("addListener", param1, param2);
        else
            service.call("addListener", param1, param2).get();
    }

    /**
     * 115 addListener        Void (String)
     * add an ALMemory key to the list of keys to listen to
     * name: the complete name of the ALMemory key
     */
    public void addListener(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("addListener", param1);
        else
            service.call("addListener", param1).get();
    }

    /**
     * 116 addListeners       Void (List<String>,Int32)
     * add a list of ALMemory keys to the list of keys to listen
     * listNames: the vector of complete names of ALMemory keys
     * interval: interval of time the system should wait before retrieving this key value again
     */
    public void addListeners(List<String> param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("addListeners", param1, param2);
        else
            service.call("addListeners", param1, param2).get();
    }

    /**
     * 117 addListeners       Void (List<String>)
     * add a list of ALMemory keys to the list of keys to listen
     * listNames: the vector of complete names of ALMemory keys
     */
    public void addListeners(List<String> param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("addListeners", param1);
        else
            service.call("addListeners", param1).get();
    }

    /**
     * 118 removeAllListeners Void ()
     * remove all keys listened to
     */
    public void removeAllListeners() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeAllListeners");
        else
            service.call("removeAllListeners").get();
    }

    /**
     * 119 removeListener     Void (String)
     * remove a key from the list to listen to
     * name: the name of the key to stop to listen
     */
    public void removeListener(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeListener", param1);
        else
            service.call("removeListener", param1).get();
    }

    /**
     * 120 removeListeners    Void (List<String>)
     * remove a list of key from the list to listen
     * listNames: the vector of names of key to stop to listen
     */
    public void removeListeners(List<String> param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeListeners", param1);
        else
            service.call("removeListeners", param1).get();
    }

    /**
     * 121 getData            Value ()
     * return an ALValue containing all buffered data                                       since the last call of getData().
     * return: The complete array of all buffered data
     */
    public com.aldebaran.qimessaging.Object getData() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getData").get();
    }

    /**
     * 122 clearBuffer        Void ()
     * remove all buffered data.                                           The list of keys listened to keeps unchanged.
     */
    public void clearBuffer() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("clearBuffer");
        else
            service.call("clearBuffer").get();
    }

    /**
     * 123 isWatching         Bool ()
     * tells whether keys are watched and data being gathered.
     * return: true if keys are being watched.
     */
    public Boolean isWatching() throws CallError, InterruptedException {
        return (Boolean) service.call("isWatching").get();
    }

    /**
     * 124 startWatching      Void (Int32)
     * start listening to selected keys from ALMemory
     * period: the time between two listen of ALMemory keys, in milliseconds.
     */
    public void startWatching(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startWatching", param1);
        else
            service.call("startWatching", param1).get();
    }

    /**
     * 125 stopWatching       Void ()
     * stop listening selected keys from ALMemory.                                    List of listened keys and associated buffers keep unchanged.
     */
    public void stopWatching() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopWatching");
        else
            service.call("stopWatching").get();
    }

    /**
     * 127 setPeriodMs        Void (Int32)
     * edit "period" value between two buffering.
     * period: the new period (in ms) to apply.
     * * Signals:
     */
    public void setPeriodMs(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setPeriodMs", param1);
        else
            service.call("setPeriodMs", param1).get();
    }


}
    