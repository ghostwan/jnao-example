package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALFindPersonHead extends ALModule {

    public ALFindPersonHead(Session session) {
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
     * 113 startSearch         Void ()
     * Starts the module's process, the events are then raised.
     */
    public void startSearch() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startSearch");
        else
            service.call("startSearch").get();
    }

    /**
     * 114 stopSearch          Void ()
     * Stops the module's process, the events are not raised anymore.
     */
    public void stopSearch() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopSearch");
        else
            service.call("stopSearch").get();
    }

    /**
     * 115 isSearching         Bool ()
     * Tells if the module is running or not.
     * return: True if the module is running, False if not.
     */
    public Boolean isSearching() throws CallError, InterruptedException {
        return (Boolean) service.call("isSearching").get();
    }

    /**
     * 116 setTrackingDistance Void (Float)
     * Sets the distance (in meters) for the tracking
     * distance: New value (in meters)
     */
    public void setTrackingDistance(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setTrackingDistance", param1);
        else
            service.call("setTrackingDistance", param1).get();
    }

    /**
     * 117 getTrackingDistance Float ()
     * Gets the distance (in meters) for the tracking
     * return: Current tracking distance (in meters)
     */
    public Float getTrackingDistance() throws CallError, InterruptedException {
        return (Float) service.call("getTrackingDistance").get();
    }

    /**
     * 118 setVerticalOffset   Void (Float)
     * Sets the value of vertical offset (in meters) for the blob tracker
     * value: New vertical offset (in meters), added if positive, substracted if negative
     */
    public void setVerticalOffset(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setVerticalOffset", param1);
        else
            service.call("setVerticalOffset", param1).get();
    }

    /**
     * 119 getVerticalOffset   Float ()
     * Sets the value of vertical offset (in meters) for the blob tracker
     * return: Current vertical offset of the blob tracker
     * * Signals:
     */
    public Float getVerticalOffset() throws CallError, InterruptedException {
        return (Float) service.call("getVerticalOffset").get();
    }


}
    