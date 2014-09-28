package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALTracker extends ALModule {

    public ALTracker(Session session) {
        super(session);
    }

    /**
     * 100 exit                        Void ()
     * Exits and unregisters the module.
     * 102 pCall                       Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version                     String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                        Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList               List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp               Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp               Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                        Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning                   Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                        Void (Int32)
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
     * 111 getBrokerName               String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage                    String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 getTargetPosition           List<Float> (Int32)
     * Returns the [x, y, z] position of the target in FRAME_TORSO. This is done assuming an average target size, so it might not be very accurate.
     * pFrame: target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * return: Vector of 3 floats corresponding to the target position 3D.
     */
    public List<Float> getTargetPosition(Integer param1) throws CallError, InterruptedException {
        return (List<Float>) service.call("getTargetPosition", param1).get();
    }

    /**
     * 114 getRobotPosition            List<Float> ()
     * Only work with LandMarks target name. Returns the [x, y, z, wx, wy, wz] position of the robot in coordinate system setted with setMap API. This is done assuming an average target size, so it might not be very accurate.
     * return: Vector of 6 floats corresponding to the robot position 6D.
     */
    public List<Float> getRobotPosition() throws CallError, InterruptedException {
        return (List<Float>) service.call("getRobotPosition").get();
    }

    /**
     * 115 isActive                    Bool ()
     * Return true if Tracker is running.
     * return: True if Tracker is running.
     */
    public Boolean isActive() throws CallError, InterruptedException {
        return (Boolean) service.call("isActive").get();
    }

    /**
     * 116 isNewTargetDetected         Bool ()
     * Return true if a new target was detected.
     * return: True if a new target was detected since the last getTargetPosition().
     */
    public Boolean isNewTargetDetected() throws CallError, InterruptedException {
        return (Boolean) service.call("isNewTargetDetected").get();
    }

    /**
     * 117 setRelativePosition         Void (Value)
     * Set the robot position relative to target in Move mode.
     * target: Set the final goal of the tracking. Could be [distance, thresholdX, thresholdY] or with LandMarks target name [coordX, coordY, coordWz, thresholdX, thresholdY, thresholdWz].
     */
    public void setRelativePosition(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setRelativePosition", param1);
        else
            service.call("setRelativePosition", param1).get();
    }

    /**
     * 118 getRelativePosition         Value ()
     * Get the robot position relative to target in Move mode.
     * return: The final goal of the tracking. Could be [distance, thresholdX, thresholdY] or with LandMarks target name [coordX, coordY, coordWz, thresholdX, thresholdY, thresholdWz].
     */
    public com.aldebaran.qimessaging.Object getRelativePosition() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getRelativePosition").get();
    }

    /**
     * 119 setTargetCoordinates        Void (Value)
     * Only work with LandMarks target name. Set objects coordinates. Could be [[first object coordinate], [second object coordinate]] [[x1, y1, z1], [x2, y2, z2]]
     * pCoord: objects coordinates.
     */
    public void setTargetCoordinates(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setTargetCoordinates", param1);
        else
            service.call("setTargetCoordinates", param1).get();
    }

    /**
     * 120 getTargetCoordinates        Value ()
     * Only work with LandMarks target name. Get objects coordinates. Could be [[first object coordinate], [second object coordinate]] [[x1, y1, z1], [x2, y2, z2]]
     * return: objects coordinates.
     */
    public com.aldebaran.qimessaging.Object getTargetCoordinates() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getTargetCoordinates").get();
    }

    /**
     * 121 setMode                     Void (String)
     * Set the tracker in the predefined mode.Could be "Head", "WholeBody" or "Move".
     * pMode: a predefined mode.
     */
    public void setMode(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setMode", param1);
        else
            service.call("setMode", param1).get();
    }

    /**
     * 122 getMode                     String ()
     * Get the tracker current mode.
     * return: The current tracker mode.
     */
    public String getMode() throws CallError, InterruptedException {
        return (String) service.call("getMode").get();
    }

    /**
     * 123 getAvailableModes           List<String> ()
     * Get the list of predefined mode.
     * return: List of predefined mode.
     */
    public List<String> getAvailableModes() throws CallError, InterruptedException {
        return (List<String>) service.call("getAvailableModes").get();
    }

    /**
     * 124 toggleSearch                Void (Bool)
     * Enables/disables the target search process. Target search process occurs only when the target is lost.
     * pSearch: If true and if the target is lost, the robot moves the head in order to find the target. If false and if the target is lost the robot does not move.
     */
    public void toggleSearch(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("toggleSearch", param1);
        else
            service.call("toggleSearch", param1).get();
    }

    /**
     * 125 isSearchEnabled             Bool ()
     * Return true if the target search process is enabled.
     * return: If true the target search process is enabled.
     */
    public Boolean isSearchEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("isSearchEnabled").get();
    }

    /**
     * 126 stopTracker                 Void ()
     * Stop the tracker.
     */
    public void stopTracker() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopTracker");
        else
            service.call("stopTracker").get();
    }

    /**
     * 127 isTargetLost                Bool ()
     * Return true if the target was lost.
     * return: True if the target was lost.
     */
    public Boolean isTargetLost() throws CallError, InterruptedException {
        return (Boolean) service.call("isTargetLost").get();
    }

    /**
     * 128 track                       Void (String)
     * Set the predefided target to track and start the tracking process if not started.
     * pTarget: a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
     */
    public void track(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("track", param1);
        else
            service.call("track", param1).get();
    }

    /**
     * 129 trackEvent                  Void (String)
     * Track event and start the tracking process if not started.
     * pEventName: a event name to track.
     */
    public void trackEvent(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("trackEvent", param1);
        else
            service.call("trackEvent", param1).get();
    }

    /**
     * 130 registerTarget              Void (String,Value)
     * Register a predefined target. Subscribe to corresponding extractor if Tracker is running..
     * pTarget: a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
     * pParams: a target parameters. (RedBall : set diameter of ball.
     */
    public void registerTarget(String param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("registerTarget", param1, param2);
        else
            service.call("registerTarget", param1, param2).get();
    }

    /**
     * 131 setExtractorPeriod          Void (String,Int32)
     * Set a period for the corresponding target name extractor.
     * pTarget: a predefined target name.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
     * pPeriod: a period in milliseconds
     */
    public void setExtractorPeriod(String param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setExtractorPeriod", param1, param2);
        else
            service.call("setExtractorPeriod", param1, param2).get();
    }

    /**
     * 132 getExtractorPeriod          Int32 (String)
     * Get the period of corresponding target name extractor.
     * pTarget: a predefined target name.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
     * return: a period in milliseconds
     */
    public Integer getExtractorPeriod(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getExtractorPeriod", param1).get();
    }

    /**
     * 133 unregisterTarget            Void (String)
     * Unregister target name and stop corresponding extractor.
     * pTarget: a predefined target to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
     */
    public void unregisterTarget(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unregisterTarget", param1);
        else
            service.call("unregisterTarget", param1).get();
    }

    /**
     * 134 unregisterTargets           Void (List<String>)
     * Unregister a list of target names and stop corresponding extractor.
     * pTarget: a predefined target list to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
     */
    public void unregisterTargets(List<String> param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unregisterTargets", param1);
        else
            service.call("unregisterTargets", param1).get();
    }

    /**
     * 135 unregisterAllTargets        Void ()
     * Unregister all targets except active target and stop corresponding extractor.
     */
    public void unregisterAllTargets() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unregisterAllTargets");
        else
            service.call("unregisterAllTargets").get();
    }

    /**
     * 136 getActiveTarget             String ()
     * Return active target name.
     * return: Tracked target name.
     */
    public String getActiveTarget() throws CallError, InterruptedException {
        return (String) service.call("getActiveTarget").get();
    }

    /**
     * 137 getSupportedTargets         List<String> ()
     * Return a list of supported targets names.
     * return: Supported targets names.
     */
    public List<String> getSupportedTargets() throws CallError, InterruptedException {
        return (List<String>) service.call("getSupportedTargets").get();
    }

    /**
     * 138 getRegisteredTargets        List<String> ()
     * Return a list of registered targets names.
     * return: Registered targets names.
     */
    public List<String> getRegisteredTargets() throws CallError, InterruptedException {
        return (List<String>) service.call("getRegisteredTargets").get();
    }

    /**
     * 139 lookAt                      Void (List<Float>,Int32,Float,Bool)
     * Look at the target position with head.
     * pPosition: position 3D [x, y, z] x position must be striclty positif.
     * pFrame: target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * pFractionMaxSpeed: The fraction of maximum speed to use. Must be between 0 and 1.
     * pUseWholeBody: If true, use whole body constraints.
     */
    public void lookAt(List<Float> param1, Integer param2, Float param3, Boolean param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("lookAt", param1, param2, param3, param4);
        else
            service.call("lookAt", param1, param2, param3, param4).get();
    }

    /**
     * 140 pointAt                     Void (String,List<Float>,Int32,Float)
     * Point at the target position with arms.
     * pEffector: effector name. Could be "Arms", "LArm", "RArm".
     * pPosition: position 3D [x, y, z] to point in FRAME_TORSO. x position must be striclty positif.
     * pFrame: target frame {FRAME_TORSO = 0, FRAME_WORLD = 1, FRAME_ROBOT = 2}.
     * pFractionMaxSpeed: The fraction of maximum speed to use. Must be between 0 and 1.
     */
    public void pointAt(String param1, List<Float> param2, Integer param3, Float param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("pointAt", param1, param2, param3, param4);
        else
            service.call("pointAt", param1, param2, param3, param4).get();
    }

    /**
     * 141 getMoveConfig               Value ()
     * Get the config for move modes.
     * return: ALMotion GaitConfig
     */
    public com.aldebaran.qimessaging.Object getMoveConfig() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMoveConfig").get();
    }

    /**
     * 142 setMoveConfig               Void (Value)
     * set a config for move modes.
     * config: ALMotion GaitConfig
     */
    public void setMoveConfig(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setMoveConfig", param1);
        else
            service.call("setMoveConfig", param1).get();
    }

    /**
     * 143 getTimeOut                  Int32 ()
     * get the timeout parameter for target lost.
     * return: time in milliseconds.
     */
    public Integer getTimeOut() throws CallError, InterruptedException {
        return (Integer) service.call("getTimeOut").get();
    }

    /**
     * 144 setTimeOut                  Void (Int32)
     * set the timeout parameter for target lost.
     * pTimeMs: time in milliseconds.
     */
    public void setTimeOut(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setTimeOut", param1);
        else
            service.call("setTimeOut", param1).get();
    }

    /**
     * 145 getMaximumDistanceDetection Float ()
     * get the maximum distance for target detection in meter.
     * return: The maximum distance for target detection in meter.
     */
    public Float getMaximumDistanceDetection() throws CallError, InterruptedException {
        return (Float) service.call("getMaximumDistanceDetection").get();
    }

    /**
     * 146 setMaximumDistanceDetection Void (Float)
     * set the maximum target detection distance in meter.
     * pMaxDistance: The maximum distance for target detection in meter.
     */
    public void setMaximumDistanceDetection(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setMaximumDistanceDetection", param1);
        else
            service.call("setMaximumDistanceDetection", param1).get();
    }

    /**
     * 147 getEffector                 String ()
     * Get active effector.
     * return: Active effector name. Could be: "Arms", "LArm", "RArm" or "None".
     */
    public String getEffector() throws CallError, InterruptedException {
        return (String) service.call("getEffector").get();
    }

    /**
     * 148 setEffector                 Void (String)
     * Set an end-effector to move for tracking.
     * pEffector: Name of effector. Could be: "Arms", "LArm", "RArm" or "None".
     */
    public void setEffector(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setEffector", param1);
        else
            service.call("setEffector", param1).get();
    }

    /**
     * 149 lookAt                      Void (List<Float>,Float,Bool)
     * DEPRECATED. Use lookAt with frame instead. Look at the target position with head.
     * pPosition: position 3D [x, y, z] to look in FRAME_TORSO. x position must be striclty positif.
     * pFractionMaxSpeed: The fraction of maximum speed to use. Must be between 0 and 1.
     * pUseWholeBody: If true, use whole body constraints.
     */
    public void lookAt(List<Float> param1, Float param2, Boolean param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("lookAt", param1, param2, param3);
        else
            service.call("lookAt", param1, param2, param3).get();
    }

    /**
     * 150 pointAt                     Void (String,List<Float>,Float)
     * DEPRECATED. Use pointAt with frame instead. Point at the target position with arms.
     * pEffector: effector name. Could be "Arms", "LArm", "RArm".
     * pPosition: position 3D [x, y, z] to point in FRAME_TORSO. x position must be striclty positif.
     * pFractionMaxSpeed: The fraction of maximum speed to use. Must be between 0 and 1.
     */
    public void pointAt(String param1, List<Float> param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("pointAt", param1, param2, param3);
        else
            service.call("pointAt", param1, param2, param3).get();
    }

    /**
     * 151 getTargetPosition           List<Float> ()
     * DEPRECATED. Use pointAt with frame instead. Returns the [x, y, z] position of the target in FRAME_TORSO. This is done assuming an average target size, so it might not be very accurate.
     * return: Vector of 3 floats corresponding to the target position 3D.
     */
    public List<Float> getTargetPosition() throws CallError, InterruptedException {
        return (List<Float>) service.call("getTargetPosition").get();
    }

    /**
     * 152 getTargetNames              List<String> ()
     * DEPRECATED. Use getSupportedTargets() instead. Return a list of targets names.
     * return: Valid targets names.
     */
    public List<String> getTargetNames() throws CallError, InterruptedException {
        return (List<String>) service.call("getTargetNames").get();
    }

    /**
     * 153 getManagedTargets           List<String> ()
     * DEPRECATED. Use getRegisteredTargets() instead. Return a list of managed targets names.
     * return: Managed targets names.
     */
    public List<String> getManagedTargets() throws CallError, InterruptedException {
        return (List<String>) service.call("getManagedTargets").get();
    }

    /**
     * 154 addTarget                   Void (String,Value)
     * DEPRECATED. Use registerTarget() instead. Add a predefined target. Subscribe to corresponding extractor if Tracker is running..
     * pTarget: a predefined target to track.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
     * pParams: a target parameters. (RedBall : set diameter of ball.
     */
    public void addTarget(String param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("addTarget", param1, param2);
        else
            service.call("addTarget", param1, param2).get();
    }

    /**
     * 155 removeTarget                Void (String)
     * DEPRECATED. Use unregisterTarget() instead. Remove target name and stop corresponding extractor.
     * pTarget: a predefined target to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
     */
    public void removeTarget(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeTarget", param1);
        else
            service.call("removeTarget", param1).get();
    }

    /**
     * 156 removeTargets               Void (List<String>)
     * DEPRECATED. Use unregisterTargets() instead. Remove a list of target names and stop corresponding extractor.
     * pTarget: a predefined target list to remove.Could be "RedBall", "Face", "LandMark", "LandMarks", "People" or "Sound".
     */
    public void removeTargets(List<String> param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeTargets", param1);
        else
            service.call("removeTargets", param1).get();
    }

    /**
     * 157 removeAllTargets            Void ()
     * DEPRECATED. Use unregisterAllTargets() instead. Remove all managed targets except active target and stop corresponding extractor.
     */
    public void removeAllTargets() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeAllTargets");
        else
            service.call("removeAllTargets").get();
    }

    /**
     * 158 addEffector                 Void (String)
     * DEPRECATED. Use setEffector instead. Add an end-effector to move for tracking.
     * pEffector: Name of effector. Could be: "Arms", "LArm" or "RArm".
     */
    public void addEffector(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("addEffector", param1);
        else
            service.call("addEffector", param1).get();
    }

    /**
     * 159 removeEffector              Void (String)
     * DEPRECATED. Use setEffector("None") instead. Remove an end-effector from tracking.
     * pEffector: Name of effector. Could be: "Arms", "LArm" or "RArm".
     * * Signals:
     */
    public void removeEffector(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeEffector", param1);
        else
            service.call("removeEffector", param1).get();
    }


}
    