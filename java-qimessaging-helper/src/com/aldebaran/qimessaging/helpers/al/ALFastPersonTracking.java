package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALFastPersonTracking extends ALModule {

    public ALFastPersonTracking(Session session) {
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
     * 113 subscribe           Void (String,Int32,Float)
     * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
     * name: Name of the module which subscribes.
     * period: Refresh period (in milliseconds) if relevant.
     * precision: Precision of the extractor if relevant.
     */
    public void subscribe(String param1, Integer param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("subscribe", param1, param2, param3);
        else
            service.call("subscribe", param1, param2, param3).get();
    }

    /**
     * 114 subscribe           Void (String)
     * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
     * name: Name of the module which subscribes.
     */
    public void subscribe(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("subscribe", param1);
        else
            service.call("subscribe", param1).get();
    }

    /**
     * 115 unsubscribe         Void (String)
     * Unsubscribes from the extractor.
     * name: Name of the module which had subscribed.
     */
    public void unsubscribe(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unsubscribe", param1);
        else
            service.call("unsubscribe", param1).get();
    }

    /**
     * 116 updatePeriod        Void (String,Int32)
     * Updates the period if relevant.
     * name: Name of the module which has subscribed.
     * period: Refresh period (in milliseconds).
     */
    public void updatePeriod(String param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("updatePeriod", param1, param2);
        else
            service.call("updatePeriod", param1, param2).get();
    }

    /**
     * 117 updatePrecision     Void (String,Float)
     * Updates the precision if relevant.
     * name: Name of the module which has subscribed.
     * precision: Precision of the extractor.
     */
    public void updatePrecision(String param1, Float param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("updatePrecision", param1, param2);
        else
            service.call("updatePrecision", param1, param2).get();
    }

    /**
     * 118 getCurrentPeriod    Int32 ()
     * Gets the current period.
     * return: Refresh period (in milliseconds).
     */
    public Integer getCurrentPeriod() throws CallError, InterruptedException {
        return (Integer) service.call("getCurrentPeriod").get();
    }

    /**
     * 119 getCurrentPrecision Float ()
     * Gets the current precision.
     * return: Precision of the extractor.
     */
    public Float getCurrentPrecision() throws CallError, InterruptedException {
        return (Float) service.call("getCurrentPrecision").get();
    }

    /**
     * 120 getMyPeriod         Int32 (String)
     * Gets the period for a specific subscription.
     * name: Name of the module which has subscribed.
     * return: Refresh period (in milliseconds).
     */
    public Integer getMyPeriod(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getMyPeriod", param1).get();
    }

    /**
     * 121 getMyPrecision      Float (String)
     * Gets the precision for a specific subscription.
     * name: name of the module which has subscribed
     * return: precision of the extractor
     */
    public Float getMyPrecision(String param1) throws CallError, InterruptedException {
        return (Float) service.call("getMyPrecision", param1).get();
    }

    /**
     * 122 getSubscribersInfo  Value ()
     * Gets the parameters given by the module.
     * return: Array of names and parameters of all subscribers.
     */
    public com.aldebaran.qimessaging.Object getSubscribersInfo() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getSubscribersInfo").get();
    }

    /**
     * 123 getOutputNames      List<String> ()
     * Get the list of values updated in ALMemory.
     * return: Array of values updated by this extractor in ALMemory
     */
    public List<String> getOutputNames() throws CallError, InterruptedException {
        return (List<String>) service.call("getOutputNames").get();
    }

    /**
     * 124 getEventList        List<String> ()
     * Get the list of events updated in ALMemory.
     * return: Array of events updated by this extractor in ALMemory
     */
    public List<String> getEventList() throws CallError, InterruptedException {
        return (List<String>) service.call("getEventList").get();
    }

    /**
     * 125 getMemoryKeyList    List<String> ()
     * Get the list of events updated in ALMemory.
     * return: Array of events updated by this extractor in ALMemory
     */
    public List<String> getMemoryKeyList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMemoryKeyList").get();
    }

    /**
     * 126 isPaused            Bool ()
     * Gets extractor pause status
     * return: True if the extractor is paused, False if not
     */
    public Boolean isPaused() throws CallError, InterruptedException {
        return (Boolean) service.call("isPaused").get();
    }

    /**
     * 127 pause               Void (Bool)
     * Changes the pause status of the extractor
     * status: New pause satus
     */
    public void pause(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("pause", param1);
        else
            service.call("pause", param1).get();
    }

    /**
     * 128 isProcessing        Bool ()
     * Gets extractor running status
     * return: True if the extractor is currently processing images, False if not
     */
    public Boolean isProcessing() throws CallError, InterruptedException {
        return (Boolean) service.call("isProcessing").get();
    }

    /**
     * 129 setTrackingDistance Void (Float)
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
     * 130 getTrackingDistance Float ()
     * Gets the distance (in meters) for the tracking
     * return: Current tracking distance (in meters)
     */
    public Float getTrackingDistance() throws CallError, InterruptedException {
        return (Float) service.call("getTrackingDistance").get();
    }

    /**
     * 131 setVerticalOffset   Void (Float)
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
     * 132 getVerticalOffset   Float ()
     * Sets the value of vertical offset (in meters) for the blob tracker
     * return: Current vertical offset of the blob tracker
     * * Signals:
     */
    public Float getVerticalOffset() throws CallError, InterruptedException {
        return (Float) service.call("getVerticalOffset").get();
    }


}
    