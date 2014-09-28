package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALInfrared extends ALModule {

    public ALInfrared(Session session) {
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
     * 113 initReception         Void (Int32)
     * Init IR reception (connect as a client to the LIRC daemon).
     * RepeatThreshold: Give the keep-pressing threshold after which the repetition of a key is taken into consideration.
     */
    public void initReception(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("initReception", param1);
        else
            service.call("initReception", param1).get();
    }

    /**
     * 114 sendRemoteKey         Void (String,String)
     * Simulate a remote control (Nao as a remote control).
     * Remote: IR remote control name.
     * Key: IR remote control key name.
     */
    public void sendRemoteKey(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("sendRemoteKey", param1, param2);
        else
            service.call("sendRemoteKey", param1, param2).get();
    }

    /**
     * 115 sendRemoteKeyWithTime Void (String,String,Int32)
     * Simulate a remote control (Nao as a remote control).
     * Remote: IR remote control name.
     * Key: IR remote control key name.
     * pTimeMs: The time in ms when the remote key must be send. 0 deals like sendRemoteKey
     */
    public void sendRemoteKeyWithTime(String param1, String param2, Integer param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("sendRemoteKeyWithTime", param1, param2, param3);
        else
            service.call("sendRemoteKeyWithTime", param1, param2, param3).get();
    }

    /**
     * 116 sendIpAddress         Void (String)
     * Send an IP by IR.
     * IP: IP adress to send through IR.
     */
    public void sendIpAddress(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("sendIpAddress", param1);
        else
            service.call("sendIpAddress", param1).get();
    }

    /**
     * 117 send8                 Void (Int32)
     * Send 1 octet by IR.
     * Octet: octet to send through IR.
     */
    public void send8(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("send8", param1);
        else
            service.call("send8", param1).get();
    }

    /**
     * 118 send32                Void (String)
     * Send 4 octets by IR.
     * Data_IR: 4 octets to send through IR.
     */
    public void send32(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("send32", param1);
        else
            service.call("send32", param1).get();
    }

    /**
     * 119 send32                Void (Int32,Int32,Int32,Int32)
     * Send 4 octets by IR.
     * Octet1: Octet 1 to send through IR.
     * Octet2: Octet 2 to send through IR.
     * Octet3: Octet 3 to send through IR.
     * Octet4: Octet 4 to send through IR.
     */
    public void send32(Integer param1, Integer param2, Integer param3, Integer param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("send32", param1, param2, param3, param4);
        else
            service.call("send32", param1, param2, param3, param4).get();
    }

    /**
     * 120 confRemoteRecordSave  Void ()
     * Rewrite the LIRC daemon configuration file (lircd.conf) with everyremotes configuration concatenated, and reload it in LIRC daemons
     * * Signals:
     */
    public void confRemoteRecordSave() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("confRemoteRecordSave");
        else
            service.call("confRemoteRecordSave").get();
    }


}
    