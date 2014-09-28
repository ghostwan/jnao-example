package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALPeoplePerception extends ALModule {

    public ALPeoplePerception(Session session) {
        super(session);
    }

    /**
     * 100 exit                           Void ()
     * Exits and unregisters the module.
     * 102 pCall                          Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version                        String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                           Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList                  List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp                  Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp                  Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                           Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning                      Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                           Void (Int32)
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
     * 111 getBrokerName                  String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage                       String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 subscribe                      Void (String,Int32,Float)
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
     * 114 subscribe                      Void (String)
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
     * 115 unsubscribe                    Void (String)
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
     * 116 updatePeriod                   Void (String,Int32)
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
     * 117 updatePrecision                Void (String,Float)
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
     * 118 getCurrentPeriod               Int32 ()
     * Gets the current period.
     * return: Refresh period (in milliseconds).
     */
    public Integer getCurrentPeriod() throws CallError, InterruptedException {
        return (Integer) service.call("getCurrentPeriod").get();
    }

    /**
     * 119 getCurrentPrecision            Float ()
     * Gets the current precision.
     * return: Precision of the extractor.
     */
    public Float getCurrentPrecision() throws CallError, InterruptedException {
        return (Float) service.call("getCurrentPrecision").get();
    }

    /**
     * 120 getMyPeriod                    Int32 (String)
     * Gets the period for a specific subscription.
     * name: Name of the module which has subscribed.
     * return: Refresh period (in milliseconds).
     */
    public Integer getMyPeriod(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getMyPeriod", param1).get();
    }

    /**
     * 121 getMyPrecision                 Float (String)
     * Gets the precision for a specific subscription.
     * name: name of the module which has subscribed
     * return: precision of the extractor
     */
    public Float getMyPrecision(String param1) throws CallError, InterruptedException {
        return (Float) service.call("getMyPrecision", param1).get();
    }

    /**
     * 122 getSubscribersInfo             Value ()
     * Gets the parameters given by the module.
     * return: Array of names and parameters of all subscribers.
     */
    public com.aldebaran.qimessaging.Object getSubscribersInfo() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getSubscribersInfo").get();
    }

    /**
     * 123 getOutputNames                 List<String> ()
     * Get the list of values updated in ALMemory.
     * return: Array of values updated by this extractor in ALMemory
     */
    public List<String> getOutputNames() throws CallError, InterruptedException {
        return (List<String>) service.call("getOutputNames").get();
    }

    /**
     * 124 getEventList                   List<String> ()
     * Get the list of events updated in ALMemory.
     * return: Array of events updated by this extractor in ALMemory
     */
    public List<String> getEventList() throws CallError, InterruptedException {
        return (List<String>) service.call("getEventList").get();
    }

    /**
     * 125 getMemoryKeyList               List<String> ()
     * Get the list of events updated in ALMemory.
     * return: Array of events updated by this extractor in ALMemory
     */
    public List<String> getMemoryKeyList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMemoryKeyList").get();
    }

    /**
     * 126 isPaused                       Bool ()
     * Gets extractor pause status
     * return: True if the extractor is paused, False if not
     */
    public Boolean isPaused() throws CallError, InterruptedException {
        return (Boolean) service.call("isPaused").get();
    }

    /**
     * 127 pause                          Void (Bool)
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
     * 128 isProcessing                   Bool ()
     * Gets extractor running status
     * return: True if the extractor is currently processing images, False if not
     */
    public Boolean isProcessing() throws CallError, InterruptedException {
        return (Boolean) service.call("isProcessing").get();
    }

    /**
     * 129 getMaximumDetectionRange       Float ()
     * Gets the current maximum detection and tracking range.
     * return: Maximum range in meters.
     */
    public Float getMaximumDetectionRange() throws CallError, InterruptedException {
        return (Float) service.call("getMaximumDetectionRange").get();
    }

    /**
     * 130 getTimeBeforePersonDisappears  Float ()
     * Gets the time after which a person, supposed not to be in the field of view of the camera disappears if it has not been detected.
     * return: Time in seconds.
     */
    public Float getTimeBeforePersonDisappears() throws CallError, InterruptedException {
        return (Float) service.call("getTimeBeforePersonDisappears").get();
    }

    /**
     * 131 getTimeBeforeVisiblePersonDisappears Float ()
     * Gets the time after which a person, supposed to be in the field of view of the camera disappears if it has not been detected.
     * return: Time in seconds.
     */
    public Float getTimeBeforeVisiblePersonDisappears() throws CallError, InterruptedException {
        return (Float) service.call("getTimeBeforeVisiblePersonDisappears").get();
    }

    /**
     * 132 isFaceDetectionEnabled         Bool ()
     * Gets the current status of face detection.
     * return: True if face detection is enabled, False otherwise.
     */
    public Boolean isFaceDetectionEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("isFaceDetectionEnabled").get();
    }

    /**
     * 133 isFastModeEnabled              Bool ()
     * Gets the current status of fast mode.
     * return: True if fast mode is enabled, False otherwise.
     */
    public Boolean isFastModeEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("isFastModeEnabled").get();
    }

    /**
     * 134 isGraphicalDisplayEnabled      Bool ()
     * Gets the current status of graphical display in Choregraphe.
     * return: True if graphical display is enabled, False otherwise.
     */
    public Boolean isGraphicalDisplayEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("isGraphicalDisplayEnabled").get();
    }

    /**
     * 135 isMovementDetectionEnabled     Bool ()
     * Gets the current status of movement detection in Choregraphe.
     * return: True if movement detection is enabled, False otherwise.
     */
    public Boolean isMovementDetectionEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("isMovementDetectionEnabled").get();
    }

    /**
     * 136 resetPopulation                Void ()
     * Empties the tracked population.
     */
    public void resetPopulation() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("resetPopulation");
        else
            service.call("resetPopulation").get();
    }

    /**
     * 137 setFastModeEnabled             Void (Bool)
     * Turns fast mode on or off.
     * enable: True to turn it on, False to turn it off.
     */
    public void setFastModeEnabled(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setFastModeEnabled", param1);
        else
            service.call("setFastModeEnabled", param1).get();
    }

    /**
     * 138 setGraphicalDisplayEnabled     Void (Bool)
     * Turns graphical display in Choregraphe on or off.
     * enable: True to turn it on, False to turn it off.
     */
    public void setGraphicalDisplayEnabled(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setGraphicalDisplayEnabled", param1);
        else
            service.call("setGraphicalDisplayEnabled", param1).get();
    }

    /**
     * 139 setMaximumDetectionRange       Void (Float)
     * Sets the maximum range for human detection and tracking.
     * range: Maximum range in meters.
     */
    public void setMaximumDetectionRange(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setMaximumDetectionRange", param1);
        else
            service.call("setMaximumDetectionRange", param1).get();
    }

    /**
     * 140 setMovementDetectionEnabled    Void (Bool)
     * Turns movement detection on or off.
     * enable: True to turn it on, False to turn it off.
     */
    public void setMovementDetectionEnabled(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setMovementDetectionEnabled", param1);
        else
            service.call("setMovementDetectionEnabled", param1).get();
    }

    /**
     * 141 setTimeBeforePersonDisappears  Void (Float)
     * Sets the time after which a person, supposed not to be in the field of view of the camera disappears if it has not been detected.
     * seconds: Time in seconds.
     */
    public void setTimeBeforePersonDisappears(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setTimeBeforePersonDisappears", param1);
        else
            service.call("setTimeBeforePersonDisappears", param1).get();
    }

    /**
     * 142 setTimeBeforeVisiblePersonDisappears Void (Float)
     * Sets the time after which a person, supposed to be in the field of view of the camera disappears if it has not been detected.
     * seconds: Time in seconds.
     */
    public void setTimeBeforeVisiblePersonDisappears(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setTimeBeforeVisiblePersonDisappears", param1);
        else
            service.call("setTimeBeforeVisiblePersonDisappears", param1).get();
    }

    /**
     * 158 setFaceDetectionEnabled        Void (Bool)
     * Turns face detection on or off.
     * enable: True to turn it on, False to turn it off.
     * * Signals:
     * 159 maximumDetectionRangeChanged (Float)
     */
    public void setFaceDetectionEnabled(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setFaceDetectionEnabled", param1);
        else
            service.call("setFaceDetectionEnabled", param1).get();
    }

    /**
     * 160 justArrived                  (Int32)
     */
    public void justArrived(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("justArrived", param1);
        else
            service.call("justArrived", param1).get();
    }

    /**
     * 161 justLeft                     (Int32)
     */
    public void justLeft(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("justLeft", param1);
        else
            service.call("justLeft", param1).get();
    }


}
    