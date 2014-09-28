package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALNavigation extends ALModule {

    public ALNavigation(Session session) {
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
     * 113 navigateTo          Bool (Float,Float)
     * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
     * x: The position along x axis [m].
     * y: The position along y axis [m].
     */
    public Boolean navigateTo(Float param1, Float param2) throws CallError, InterruptedException {
        return (Boolean) service.call("navigateTo", param1, param2).get();
    }

    /**
     * 114 navigateTo          Bool (Float,Float,Value)
     * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
     * x: The position along x axis [m].
     * y: The position along y axis [m].
     * config: Configuration ALValue. For example, [["SpeedFactor", 0.5]] sets speedFactor to 0.5
     */
    public Boolean navigateTo(Float param1, Float param2, com.aldebaran.qimessaging.Object param3) throws CallError, InterruptedException {
        return (Boolean) service.call("navigateTo", param1, param2, param3).get();
    }

    /**
     * 115 navigateTo          Bool (Float,Float,Float)
     * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
     * x: The position along x axis [m].
     * y: The position along y axis [m].
     * theta: Orientation of the robot (rad).
     */
    public Boolean navigateTo(Float param1, Float param2, Float param3) throws CallError, InterruptedException {
        return (Boolean) service.call("navigateTo", param1, param2, param3).get();
    }

    /**
     * 116 navigateTo          Bool (Float,Float,Float,Value)
     * Makes the robot navigate to a relative metrical target pose2D expressed in FRAME_ROBOT. The robot computes a path to avoid obstacles.
     * x: The position along x axis [m].
     * y: The position along y axis [m].
     * theta: Orientation of the robot (rad).
     * config: Configuration ALValue. For example, [["SpeedFactor", 0.5]] sets speedFactor to 0.5
     */
    public Boolean navigateTo(Float param1, Float param2, Float param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        return (Boolean) service.call("navigateTo", param1, param2, param3, param4).get();
    }

    /**
     * 117 moveTo              Void (Float,Float,Float)
     * Makes the robot move at the given position.This is a blocking call.
     * x: The position along x axis [m].
     * y: The position along y axis [m].
     * theta: The angle around z axis [rad].
     */
    public void moveTo(Float param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("moveTo", param1, param2, param3);
        else
            service.call("moveTo", param1, param2, param3).get();
    }

    /**
     * 118 moveTo              Void (Float,Float,Float,Value)
     * Makes the robot move at the given position.This is a blocking call.
     * x: The position along x axis [m].
     * y: The position along y axis [m].
     * theta: The angle around z axis [rad].
     * moveConfig: An ALValue with custom move configuration.
     */
    public void moveTo(Float param1, Float param2, Float param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("moveTo", param1, param2, param3, param4);
        else
            service.call("moveTo", param1, param2, param3, param4).get();
    }

    /**
     * 119 move                Void (Float,Float,Float)
     * Makes the robot move at the given speed in S.I. units. This is a blocking call.
     * x: The speed along x axis [m.s-1].
     * y: The speed along y axis [m.s-1].
     * theta: The anglular speed around z axis [rad.s-1].
     */
    public void move(Float param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("move", param1, param2, param3);
        else
            service.call("move", param1, param2, param3).get();
    }

    /**
     * 120 move                Void (Float,Float,Float,Value)
     * Makes the robot move at the given speed in S.I. units. This is a blocking call.
     * x: The speed along x axis [m.s-1].
     * y: The speed along y axis [m.s-1].
     * theta: The anglular speed around z axis [rad.s-1].
     * moveConfig: An ALValue with custom move configuration.
     */
    public void move(Float param1, Float param2, Float param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("move", param1, param2, param3, param4);
        else
            service.call("move", param1, param2, param3, param4).get();
    }

    /**
     * 121 moveToward          Void (Float,Float,Float)
     * Makes the robot move at the given speed in normalized speed fraction. This is a blocking call.
     * x: The speed along x axis [0.0-1.0].
     * y: The speed along y axis [0.0-1.0].
     * theta: The anglular speed around z axis [0.0-1.0].
     */
    public void moveToward(Float param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("moveToward", param1, param2, param3);
        else
            service.call("moveToward", param1, param2, param3).get();
    }

    /**
     * 122 moveToward          Void (Float,Float,Float,Value)
     * Makes the robot move at the given speed in normalized speed fraction. This is a blocking call.
     * x: The speed along x axis [0.0-1.0].
     * y: The speed along y axis [0.0-1.0].
     * theta: The anglular speed around z axis [0.0-1.0].
     * moveConfig: An ALValue with custom move configuration.
     */
    public void moveToward(Float param1, Float param2, Float param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("moveToward", param1, param2, param3, param4);
        else
            service.call("moveToward", param1, param2, param3, param4).get();
    }

    /**
     * 124 setSecurityDistance Void (Float)
     * Distance in meters fromwhich the robot should stop if there is an obstacle.
     */
    public void setSecurityDistance(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setSecurityDistance", param1);
        else
            service.call("setSecurityDistance", param1).get();
    }

    /**
     * 125 getSecurityDistance Float ()
     * Distance in meters fromwhich the robot should stop if there is an obstacle.
     */
    public Float getSecurityDistance() throws CallError, InterruptedException {
        return (Float) service.call("getSecurityDistance").get();
    }

    /**
     * 126 stopNavigateTo      Void ()
     * Stops the navigateTo.
     */
    public void stopNavigateTo() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopNavigateTo");
        else
            service.call("stopNavigateTo").get();
    }

    /**
     * 157 moveAlong           Bool (Value)
     * .
     * trajectory: An ALValue describing a trajectory.
     */
    public Boolean moveAlong(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        return (Boolean) service.call("moveAlong", param1).get();
    }

    /**
     * 180 onTouchChanged      Void (String,Value,String)
     * .
     * * Signals:
     */
    public void onTouchChanged(String param1, com.aldebaran.qimessaging.Object param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("onTouchChanged", param1, param2, param3);
        else
            service.call("onTouchChanged", param1, param2, param3).get();
    }


}
    