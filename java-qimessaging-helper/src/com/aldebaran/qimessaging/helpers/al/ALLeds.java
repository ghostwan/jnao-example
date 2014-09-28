package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALLeds extends ALModule {

    public ALLeds(Session session) {
        super(session);
    }

    /**
     * 100 exit            Void ()
     * Exits and unregisters the module.
     * 102 pCall           Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version         String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping            Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList   List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp   Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp   Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait            Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning       Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop            Void (Int32)
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
     * 111 getBrokerName   String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage        String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 createGroup     Void (String,List<String>)
     * Makes a group name for ease of setting multiple LEDs.
     * groupName: The name of the group.
     * ledNames: A vector of the names of the LEDs in the group.
     */
    public void createGroup(String param1, List<String> param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("createGroup", param1, param2);
        else
            service.call("createGroup", param1, param2).get();
    }

    /**
     * 114 earLedsSetAngle Void (Int32,Float,Bool)
     * An animation to show a direction with the ears.
     * degrees: The angle you want to show in degrees (int). 0 is up, 90 is forwards, 180 is down and 270 is back.
     * duration: The duration in seconds of the animation.
     * leaveOnAtEnd: If true the last led is left on at the end of the animation.
     */
    public void earLedsSetAngle(Integer param1, Float param2, Boolean param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("earLedsSetAngle", param1, param2, param3);
        else
            service.call("earLedsSetAngle", param1, param2, param3).get();
    }

    /**
     * 115 fade            Void (String,Float,Float)
     * Sets the intensity of a LED or Group of LEDs within a given time.
     * name: The name of the LED or Group.
     * intensity: The intensity of the LED or Group (a value between 0 and 1).
     * duration: The duration of the fade in seconds
     */
    public void fade(String param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("fade", param1, param2, param3);
        else
            service.call("fade", param1, param2, param3).get();
    }

    /**
     * 116 fadeListRGB     Void (String,Value,Value)
     * Chain a list of color for a device, as the motion.doMove command.
     * name: The name of the LED or Group.
     * rgbList: List of RGB led value, RGB as seen in hexa-decimal: 0x00RRGGBB.
     * timeList: List of time to go to given intensity.
     */
    public void fadeListRGB(String param1, com.aldebaran.qimessaging.Object param2, com.aldebaran.qimessaging.Object param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("fadeListRGB", param1, param2, param3);
        else
            service.call("fadeListRGB", param1, param2, param3).get();
    }

    /**
     * 117 fadeRGB         Void (String,Int32,Float)
     * Sets the intensity of a led. If the name matches an RGB led, all channels are set to the same value.
     * name: The name of the LED or Group.
     * rgb: The RGB value led, RGB as seen in hexa-decimal: 0x00RRGGBB.
     * duration: Time used to fade in seconds.
     */
    public void fadeRGB(String param1, Integer param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("fadeRGB", param1, param2, param3);
        else
            service.call("fadeRGB", param1, param2, param3).get();
    }

    /**
     * 118 reset           Void (String)
     * Resets the state of the leds to default (for ex, eye LEDs are white and fully on by default).
     * name: The name of the LED or Group (for now, only "AllLeds" are implemented).
     */
    public void reset(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("reset", param1);
        else
            service.call("reset", param1).get();
    }

    /**
     * 120 getIntensity    Value (String)
     * Gets the intensity of a LED or device
     * name: The name of the LED or Group.
     * return: The intensity of the LED or Group.
     */
    public com.aldebaran.qimessaging.Object getIntensity(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getIntensity", param1).get();
    }

    /**
     * 121 listLEDs        List<String> ()
     * Lists the short LED names.
     * return: A vector of LED names.
     */
    public List<String> listLEDs() throws CallError, InterruptedException {
        return (List<String>) service.call("listLEDs").get();
    }

    /**
     * 122 listLED         List<String> (String)
     * Lists the devices aliased by a short LED name.
     * name: The name of the LED to list
     * return: A vector of device names.
     */
    public List<String> listLED(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("listLED", param1).get();
    }

    /**
     * 123 listGroup       List<String> (String)
     * Lists the devices in the group.
     * groupName: The name of the Group.
     * return: A vector of string device names.
     */
    public List<String> listGroup(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("listGroup", param1).get();
    }

    /**
     * 124 listGroups      List<String> ()
     * Lists available group names.
     * return: A vector of group names.
     */
    public List<String> listGroups() throws CallError, InterruptedException {
        return (List<String>) service.call("listGroups").get();
    }

    /**
     * 125 off             Void (String)
     * Switch to a minimum intensity a LED or Group of LEDs.
     * name: The name of the LED or Group.
     */
    public void off(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("off", param1);
        else
            service.call("off", param1).get();
    }

    /**
     * 126 on              Void (String)
     * Switch to a maximum intensity a LED or Group of LEDs.
     * name: The name of the LED or Group.
     */
    public void on(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("on", param1);
        else
            service.call("on", param1).get();
    }

    /**
     * 127 rasta           Void (Float)
     * Launch a green/yellow/red rasta animation on all body.
     * duration: Approximate duration of the animation in seconds.
     */
    public void rasta(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("rasta", param1);
        else
            service.call("rasta", param1).get();
    }

    /**
     * 128 rotateEyes      Void (Int32,Float,Float)
     * Launch a rotation using the leds of the eyes.
     * rgb: the RGB value led, RGB as seen in hexa-decimal: 0x00RRGGBB.
     * timeForRotation: Approximate time to make one turn.
     * totalDuration: Approximate duration of the animation in seconds.
     */
    public void rotateEyes(Integer param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("rotateEyes", param1, param2, param3);
        else
            service.call("rotateEyes", param1, param2, param3).get();
    }

    /**
     * 129 randomEyes      Void (Float)
     * Launch a random animation in eyes
     * duration: Approximate duration of the animation in seconds.
     */
    public void randomEyes(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("randomEyes", param1);
        else
            service.call("randomEyes", param1).get();
    }

    /**
     * 130 setIntensity    Void (String,Float)
     * Sets the intensity of a LED or Group of LEDs.
     * name: The name of the LED or Group.
     * intensity: The intensity of the LED or Group (a value between 0 and 1).
     * * Signals:
     */
    public void setIntensity(String param1, Float param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setIntensity", param1, param2);
        else
            service.call("setIntensity", param1, param2).get();
    }


}
    