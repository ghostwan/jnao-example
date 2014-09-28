package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALMotionRecorder extends ALModule {

    public ALMotionRecorder(Session session) {
        super(session);
    }

    /**
     * 100 exit                      Void ()
     * Exits and unregisters the module.
     * 102 pCall                     Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version                   String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                      Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList             List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp             Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp             Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                      Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning                 Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                      Void (Int32)
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
     * 111 getBrokerName             String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage                  String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 startInteractiveRecording Void (List<String>,Int32,Bool,Int32)
     * Start recording the motion in an interactive mode
     * jointsToRecord: Names of joints that must be recorded
     * nbPoses: Default number of poses to record
     * extensionAllowed: Set to true to ignore nbPoses and keep recording new poses as long as record is not manually stopped
     * mode: Indicates which interactive mode must be used. 1 : Use right bumper to enslave and left bumper to store the pose  (deprecated); 2 : Use chest button to store the pose
     */
    public void startInteractiveRecording(List<String> param1, Integer param2, Boolean param3, Integer param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startInteractiveRecording", param1, param2, param3, param4);
        else
            service.call("startInteractiveRecording", param1, param2, param3, param4).get();
    }

    /**
     * 114 startPeriodicRecording    Void (List<String>,Int32,Bool,Float,List<String>,Value)
     * Start recording the motion in a periodic mode
     * jointsToRecord: Names of joints that must be recorded
     * nbPoses: Default number of poses to record
     * extensionAllowed: set to true to ignore nbPoses and keep recording new poses as long as record is not manually stopped
     * timeStep: Time in seconds to wait between two poses
     * jointsToReplay: Names of joints that must be replayed
     * replayData: An ALValue holding data for replayed joints. It holds two ALValues. The first one is an ALValue where each line corresponds to a joint, and column elements are times of control points The second one is also an ALValue where each line corresponds to a joint, but column elements are arrays containing [float angle, Handle1, Handle2] elements, where Handle is [int InterpolationType, float dAngle, float dTime] describing the handle offsets relative to the angle and time of the point. The first bezier param describes the handle that controls the curve preceding the point, the second describes the curve following the point.
     */
    public void startPeriodicRecording(List<String> param1, Integer param2, Boolean param3, Float param4, List<String> param5, com.aldebaran.qimessaging.Object param6) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startPeriodicRecording", param1, param2, param3, param4, param5, param6);
        else
            service.call("startPeriodicRecording", param1, param2, param3, param4, param5, param6).get();
    }

    /**
     * 115 stopAndGetRecording       Value ()
     * Stop recording the motion and return data
     * return: Returns the recorded data as an ALValue: [[JointName1,[pos1, pos2, ...]], [JointName2,[pos1, pos2, ...]], ...]
     */
    public com.aldebaran.qimessaging.Object stopAndGetRecording() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("stopAndGetRecording").get();
    }

    /**
     * 116 dataChanged               Void (String,Value,String)
     * Called by ALMemory when subcription data is updated. INTERNAL
     * dataName: Name of the subscribed data.
     * data: Value of the the subscribed data
     * message: The message give when subscribing.
     * * Signals:
     */
    public void dataChanged(String param1, com.aldebaran.qimessaging.Object param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("dataChanged", param1, param2, param3);
        else
            service.call("dataChanged", param1, param2, param3).get();
    }


}
    