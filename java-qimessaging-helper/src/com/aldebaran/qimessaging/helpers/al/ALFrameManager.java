package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALFrameManager extends ALModule {

    public ALFrameManager(Session session) {
        super(session);
    }

    /**
     * 100 exit                       Void ()
     * Exits and unregisters the module.
     * 102 pCall                      Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version                    String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                       Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList              List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp              Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp              Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                       Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning                  Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                       Void (Int32)
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
     * 111 getBrokerName              String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage                   String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 newBehaviorFromFile        String (String,String)
     * Creates a new behavior, from a box found in an xml file stored in the robot.
     * xmlFilePath: Path to Xml file, ex : "/home/youhou/mybehavior.xar".
     * behName:
     * return: return a unique identifier for the created box, that can be used by playBehavior
     */
    public String newBehaviorFromFile(String param1, String param2) throws CallError, InterruptedException {
        return (String) service.call("newBehaviorFromFile", param1, param2).get();
    }

    /**
     * 114 newBehavior                String (String,String)
     * Creates a new behavior, from a box found in an xml file. Note that you have to give the xml file contents, so this method is not very user friendly. You have to open the file, and send the string that matches the file contents if you are working from a file. You probably want to use newBehaviorFromFile instead. DEPRECATED since 1.14
     * path: The path to reach the box to instantiate in the project ("" if root).
     * xmlFile: The choregraphe project (in plain text for the moment).
     * return: return a unique identifier for the created box.
     */
    public String newBehavior(String param1, String param2) throws CallError, InterruptedException {
        return (String) service.call("newBehavior", param1, param2).get();
    }

    /**
     * 115 newBehaviorFromChoregraphe String ()
     * Creates a new behavior, from the current Choregraphe behavior 0(uploaded to /tmp/currentChoregrapheBehavior/behavior.xar). DEPRECATED since 1.14
     * return: return a unique identifier for the created behavior
     */
    public String newBehaviorFromChoregraphe() throws CallError, InterruptedException {
        return (String) service.call("newBehaviorFromChoregraphe").get();
    }

    /**
     * 116 completeBehavior           Void (String)
     * It will play a behavior and block until the behavior is finished. Note that it can block forever if the behavior output is never called.
     * id: The id of the box.
     */
    public void completeBehavior(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("completeBehavior", param1);
        else
            service.call("completeBehavior", param1).get();
    }

    /**
     * 117 deleteBehavior             Void (String)
     * Deletes a behavior (meaning a box). Stop the whole behavior contained in this box first.
     * id: The id of the box to delete.
     */
    public void deleteBehavior(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("deleteBehavior", param1);
        else
            service.call("deleteBehavior", param1).get();
    }

    /**
     * 118 playBehavior               Void (String)
     * Starts a behavior
     * id: The id of the box.
     */
    public void playBehavior(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playBehavior", param1);
        else
            service.call("playBehavior", param1).get();
    }

    /**
     * 119 exitBehavior               Void (String)
     * Exit the reading of a timeline contained in a given box
     * id: The id of the box.
     */
    public void exitBehavior(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exitBehavior", param1);
        else
            service.call("exitBehavior", param1).get();
    }

    /**
     * 120 isBehaviorRunning          Bool (String)
     * Tells whether the behavior is running
     * id: The id of the behavior to check
     * return: True if the behavior is running, false otherwise
     */
    public Boolean isBehaviorRunning(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isBehaviorRunning", param1).get();
    }

    /**
     * 121 cleanBehaviors             Void ()
     * Stop playing any behavior in FrameManager, and delete all of them.
     */
    public void cleanBehaviors() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("cleanBehaviors");
        else
            service.call("cleanBehaviors").get();
    }

    /**
     * 122 getBehaviorPath            String (String)
     * Returns a playing behavior absolute path.
     * id: The id of the behavior.
     * return: Returns the absolute path of given behavior.
     */
    public String getBehaviorPath(String param1) throws CallError, InterruptedException {
        return (String) service.call("getBehaviorPath", param1).get();
    }

    /**
     * 123 createTimeline             String (String)
     * Creates a timeline.
     * timelineContent: The timeline content (in XML format).
     * return: return a unique identifier for the created box that contains the timeline. You must call deleteBehavior on it at some point. DEPRECATED since 1.14
     */
    public String createTimeline(String param1) throws CallError, InterruptedException {
        return (String) service.call("createTimeline", param1).get();
    }

    /**
     * 124 playTimeline               Void (String)
     * Starts playing a timeline contained in a given box. If the box is a flow diagram, it will look for the first onStart input of type Bang, and stimulate it ! DEPRECATED since 1.14
     * id: The id of the box.
     */
    public void playTimeline(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playTimeline", param1);
        else
            service.call("playTimeline", param1).get();
    }

    /**
     * 125 stopTimeline               Void (String)
     * Stops playing a timeline contained in a given box, at the current frame. DEPRECATED since 1.14
     * id: The id of the box.
     */
    public void stopTimeline(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopTimeline", param1);
        else
            service.call("stopTimeline", param1).get();
    }

    /**
     * 126 setTimelineFps             Void (String,Int32)
     * Sets the FPS of a given timeline. DEPRECATED since 1.14
     * id: The id of the timeline.
     * fps: The FPS to set.
     */
    public void setTimelineFps(String param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setTimelineFps", param1, param2);
        else
            service.call("setTimelineFps", param1, param2).get();
    }

    /**
     * 127 getTimelineFps             Int32 (String)
     * Gets the FPS of a given timeline. DEPRECATED since 1.14
     * id: The id of the timeline.
     * return: Returns the timeline's FPS.
     */
    public Integer getTimelineFps(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getTimelineFps", param1).get();
    }

    /**
     * 128 getMotionLength            Float (String)
     * Returns in seconds, the duration of a given movement stored in a box. Returns 0 if the behavior has no motion layers.  DEPRECATED since 1.14
     * id: The id of the box.
     * return: Returns the time in seconds.
     */
    public Float getMotionLength(String param1) throws CallError, InterruptedException {
        return (Float) service.call("getMotionLength", param1).get();
    }

    /**
     * 129 behaviors                  List<String> ()
     * List all behaviors currently handled by the frame manager.
     * return: a set listing all behavior ids
     */
    public List<String> behaviors() throws CallError, InterruptedException {
        return (List<String>) service.call("behaviors").get();
    }

    /**
     * 130 gotoAndStop                Void (String,String)
     * Goes to a certain frame and pause. DEPRECATED since 1.14
     * id: The id of the box containing the box.
     * frame: The behavior frame name we want the timeline to go to. If will jump to the starting index of the name given.
     */
    public void gotoAndStop(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("gotoAndStop", param1, param2);
        else
            service.call("gotoAndStop", param1, param2).get();
    }

    /**
     * 131 gotoAndStop                Void (String,Int32)
     * Goes to a certain frame and pause. DEPRECATED since 1.14
     * id: The id of the box containing the box.
     * frame: The frame we want the timeline to go to.
     */
    public void gotoAndStop(String param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("gotoAndStop", param1, param2);
        else
            service.call("gotoAndStop", param1, param2).get();
    }

    /**
     * 132 gotoAndPlay                Void (String,String)
     * Goes to a certain frame and continue playing. DEPRECATED since 1.14
     * id: The id of the box containing the box.
     * frame: The behavior frame name we want the timeline to go to. If will jump to the starting index of the name given.
     */
    public void gotoAndPlay(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("gotoAndPlay", param1, param2);
        else
            service.call("gotoAndPlay", param1, param2).get();
    }

    /**
     * 133 gotoAndPlay                Void (String,Int32)
     * Goes to a certain frame and continue playing. DEPRECATED since 1.14
     * id: The id of the box containing the box.
     * frame: The frame we want the timeline to go to.
     * * Signals:
     */
    public void gotoAndPlay(String param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("gotoAndPlay", param1, param2);
        else
            service.call("gotoAndPlay", param1, param2).get();
    }

    /**
     * 141 behaviorCreated   (String)
     */
    public void behaviorCreated(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("behaviorCreated", param1);
        else
            service.call("behaviorCreated", param1).get();
    }

    /**
     * 142 behaviorPlayed    (String)
     */
    public void behaviorPlayed(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("behaviorPlayed", param1);
        else
            service.call("behaviorPlayed", param1).get();
    }

    /**
     * 143 behaviorStopped   (String)
     * 144 behaviorDestroyed (String)
     */
    public void behaviorStopped(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("behaviorStopped", param1);
        else
            service.call("behaviorStopped", param1).get();
    }

    /**
     * 145 behaviorFailed    (String,String,String)
     */
    public void behaviorFailed(String param1, String param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("behaviorFailed", param1, param2, param3);
        else
            service.call("behaviorFailed", param1, param2, param3).get();
    }


}
    