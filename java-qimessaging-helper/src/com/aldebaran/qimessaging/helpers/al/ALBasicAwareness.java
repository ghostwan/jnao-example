package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALBasicAwareness extends ALModule {

    public ALBasicAwareness(Session session) {
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
     * 124 startAwareness              Void ()
     * Start Basic Awareness.
     */
    public void startAwareness() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startAwareness");
        else
            service.call("startAwareness").get();
    }

    /**
     * 125 stopAwareness               Void ()
     * Stop Basic Awareness.
     */
    public void stopAwareness() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopAwareness");
        else
            service.call("stopAwareness").get();
    }

    /**
     * 126 isAwarenessRunning          Bool ()
     * Get the status (started or not) of the module.
     * return: Boolean value, true if running else false
     */
    public Boolean isAwarenessRunning() throws CallError, InterruptedException {
        return (Boolean) service.call("isAwarenessRunning").get();
    }

    /**
     * 127 setStimulusDetectionEnabled Void (String,Bool)
     * Enable/Disable Stimulus Detection.
     * stimulusName: Name of the stimulus to enable/disable
     * isStimulusDetectionEnabled: Boolean value: true to enable, false to disable.
     */
    public void setStimulusDetectionEnabled(String param1, Boolean param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setStimulusDetectionEnabled", param1, param2);
        else
            service.call("setStimulusDetectionEnabled", param1, param2).get();
    }

    /**
     * 128 isStimulusDetectionEnabled  Bool (String)
     * Get status enabled/disabled for Stimulus Detection.
     * stimulusName: Name of the stimulus to check
     * return: Boolean value for status enabled/disabled
     */
    public Boolean isStimulusDetectionEnabled(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isStimulusDetectionEnabled", param1).get();
    }

    /**
     * 129 setParameter                Void (String,Value)
     * Set the specified parameter
     * paramName: "ServoingSpeed" : Speed of servoing head moves, as fraction of max speed
     * "LookStimulusSpeed" : Speed of head moves when looking at a stimulus, as fraction of max speed
     * "LookBackSpeed" : Speed of head moves when looking back to previous position, as fraction of max speed
     * "NobodyFoundTimeOut" : timeout to send HumanLost event when no blob is found, in seconds
     * "MinTimeTracking" : Minimum Time for the robot to be focused on someone, without listening to other stimuli, in seconds
     * "TimeSleepBeforeStimuli" : Slept time before waiting for stimuli
     * "TimeSleepBeforeResumeMS" : Slept time before automatically resuming BasicAwareness when an automatic pause has been made, in milliseconds
     * "AmplitudeYawTracking" : max absolute value for head yaw in tracking, in degrees
     * "PeoplePerceptionPeriod" : Period for people perception, in milliseconds
     * "SlowPeoplePerceptionPeriod" : Period for people perception in FullyEngaged mode, in milliseconds
     * "HeadThreshold" : Yaw threshold for tracking, in degrees
     * "BodyRotationThreshold" : Angular threshold for BodyRotation tracking mode, in degrees
     * "BodyRotationThresholdNao" : Angular threshold for BodyRotation tracking mode on Nao, in degrees
     * "MoveDistanceX" : X Distance for the Move tracking mode, in meters
     * "MoveDistanceY" : Y Distance for the Move tracking mode, in meters
     * "MoveAngleTheta" : Angle for the Move tracking mode, in degrees
     * "MoveThresholdX" : Threshold for the Move tracking mode, in meters
     * "MoveThresholdY" : Threshold for the Move tracking mode, in meters
     * "MoveThresholdTheta" : Theta Threshold for the Move tracking mode, in degrees
     * "MaxDistanceFullyEngaged" : Maximum distance for someone to be tracked for FullyEngaged mode, in meters
     * "MaxDistanceNotFullyEngaged" : Maximum distance for someone to be tracked for modes different from FullyEngaged, in meters
     * "MaxHumanSearchTime" : Maximum time to find a human after observing stimulous, in seconds
     * "DeltaPitchComfortZone" : Pitch width of the comfort zone, in degree
     * "CenterPitchComfortZone" : Pitch center of the confort zone, in degree
     * "SoundHeight" : Default Height for sound detection, in meters
     * "MoveSpeed" : Speed of the robot moves
     * "MC_Interactive_MinTime" : Minimum time between 2 contextual moves (when the robot is tracking somebody)
     * "MC_Interactive_MaxOffsetTime" : Maximum time that we can add to MC_Interactive_MinTime (when the robot is tracking somebody)
     * "MC_Interactive_DistanceXY" : Maximum offset distance in X and Y that the robot can apply when he tracks somebody
     * "MC_Interactive_MinTheta" : Minimum theta that the robot can apply when he tracks somebody
     * "MC_Interactive_MaxTheta" : Maximum theta that the robot can apply when he tracks somebody
     * "MC_Interactive_DistanceHumanRobot" : Distance between the human and the robot
     * "MC_Interactive_MaxDistanceHumanRobot" : Maximum distance human robot to allow the robot to move (in MoveContextually mode)
     * "MC_Solitary_MinTime" : Minimum time between 2 contextual moves (when the robot DOESN'T track somebody)
     * "MC_Solitary_MaxOffsetTime" : Maximum time that we can add to MC_Solitary_MinTime (when the robot DOESN'T track somebody)
     * "MC_Solitary_DistanceXY" : Maximum offset distance in X and Y that the robot can apply when he DOESN'T' track somebody
     * "MC_Solitary_Theta" : Maximum theta that the robot can apply when he tracks somebody
     * <p/>
     * newVal: "ServoingSpeed" : Float in range [0.01;1]
     * "LookStimulusSpeed" : Float in range [0.01;1]
     * "LookBackSpeed" : Float in range [0.01;1]
     * "NobodyFoundTimeOut" : Float > 0
     * "MinTimeTracking" : Float in range [0;20]
     * "TimeSleepBeforeStimuli" : Float > 0
     * "TimeSleepBeforeResumeMS" : Int > 0
     * "AmplitudeYawTracking" : Float in range [10;120]
     * "PeoplePerceptionPeriod" : Int > 1
     * "SlowPeoplePerceptionPeriod" : Int > 1
     * "HeadThreshold" : Float in range [0;180]
     * "BodyRotationThreshold" : Float in range [-180;180]
     * "BodyRotationThresholdNao" : Float in range [-180;180]
     * "MoveDistanceX" : Float in range [-5;5]
     * "MoveDistanceY" : Float in range [-5;5]
     * "MoveAngleTheta" : Float in range [-180;180]
     * "MoveThresholdX" : Float in range [0;5]
     * "MoveThresholdY" : Float in range [0;5]
     * "MoveThresholdTheta" : Float in range [-180;180]
     * "MaxDistanceFullyEngaged" : Float in range [0.5;5]
     * "MaxDistanceNotFullyEngaged" : Float in range [0.5;5]
     * "MaxHumanSearchTime" : Float in range [0.1;10]
     * "DeltaPitchComfortZone" : Float in range [0;90]
     * "CenterPitchComfortZone" : Float in range [-90;90]
     * "SoundHeight" : Float in range [0;2]
     * "MoveSpeed" : Float in range [0.1;0.55]
     * "MC_Interactive_MinTime" : Int in range [0;100]
     * "MC_Interactive_MaxOffsetTime" : Int in range [0;100]
     * "MC_Interactive_DistanceXY" : Float in range [0;1]
     * "MC_Interactive_MinTheta" : Float in range [-30;0]
     * "MC_Interactive_MaxTheta" : Float in range [0;30]
     * "MC_Interactive_DistanceHumanRobot" : Float in range [0.1;2]
     * "MC_Interactive_MaxDistanceHumanRobot" : Float in range [0.1;3]
     * "MC_Solitary_MinTime" : Int in range [0;100]
     * "MC_Solitary_MaxOffsetTime" : Int in range [0;100]
     * "MC_Solitary_DistanceXY" : Float in range [0;1]
     * "MC_Solitary_Theta" : Float in range [0;180]
     */
    public void setParameter(String param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setParameter", param1, param2);
        else
            service.call("setParameter", param1, param2).get();
    }

    /**
     * 130 resetAllParameters          Void ()
     * Reset all parameters
     */
    public void resetAllParameters() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("resetAllParameters");
        else
            service.call("resetAllParameters").get();
    }

    /**
     * 131 getParameter                Value (String)
     * Get the specified parameter.
     * paramName: "ServoingSpeed" : Speed of servoing head moves, as fraction of max speed
     * "LookStimulusSpeed" : Speed of head moves when looking at a stimulus, as fraction of max speed
     * "LookBackSpeed" : Speed of head moves when looking back to previous position, as fraction of max speed
     * "NobodyFoundTimeOut" : timeout to send HumanLost event when no blob is found, in seconds
     * "MinTimeTracking" : Minimum Time for the robot to be focused on someone, without listening to other stimuli, in seconds
     * "TimeSleepBeforeStimuli" : Slept time before waiting for stimuli
     * "TimeSleepBeforeResumeMS" : Slept time before automatically resuming BasicAwareness when an automatic pause has been made, in milliseconds
     * "AmplitudeYawTracking" : max absolute value for head yaw in tracking, in degrees
     * "PeoplePerceptionPeriod" : Period for people perception, in milliseconds
     * "SlowPeoplePerceptionPeriod" : Period for people perception in FullyEngaged mode, in milliseconds
     * "HeadThreshold" : Yaw threshold for tracking, in degrees
     * "BodyRotationThreshold" : Angular threshold for BodyRotation tracking mode, in degrees
     * "BodyRotationThresholdNao" : Angular threshold for BodyRotation tracking mode on Nao, in degrees
     * "MoveDistanceX" : X Distance for the Move tracking mode, in meters
     * "MoveDistanceY" : Y Distance for the Move tracking mode, in meters
     * "MoveAngleTheta" : Angle for the Move tracking mode, in degrees
     * "MoveThresholdX" : Threshold for the Move tracking mode, in meters
     * "MoveThresholdY" : Threshold for the Move tracking mode, in meters
     * "MoveThresholdTheta" : Theta Threshold for the Move tracking mode, in degrees
     * "MaxDistanceFullyEngaged" : Maximum distance for someone to be tracked for FullyEngaged mode, in meters
     * "MaxDistanceNotFullyEngaged" : Maximum distance for someone to be tracked for modes different from FullyEngaged, in meters
     * "MaxHumanSearchTime" : Maximum time to find a human after observing stimulous, in seconds
     * "DeltaPitchComfortZone" : Pitch width of the comfort zone, in degree
     * "CenterPitchComfortZone" : Pitch center of the confort zone, in degree
     * "SoundHeight" : Default Height for sound detection, in meters
     * "MoveSpeed" : Speed of the robot moves
     * "MC_Interactive_MinTime" : Minimum time between 2 contextual moves (when the robot is tracking somebody)
     * "MC_Interactive_MaxOffsetTime" : Maximum time that we can add to MC_Interactive_MinTime (when the robot is tracking somebody)
     * "MC_Interactive_DistanceXY" : Maximum offset distance in X and Y that the robot can apply when he tracks somebody
     * "MC_Interactive_MinTheta" : Minimum theta that the robot can apply when he tracks somebody
     * "MC_Interactive_MaxTheta" : Maximum theta that the robot can apply when he tracks somebody
     * "MC_Interactive_DistanceHumanRobot" : Distance between the human and the robot
     * "MC_Interactive_MaxDistanceHumanRobot" : Maximum distance human robot to allow the robot to move (in MoveContextually mode)
     * "MC_Solitary_MinTime" : Minimum time between 2 contextual moves (when the robot DOESN'T track somebody)
     * "MC_Solitary_MaxOffsetTime" : Maximum time that we can add to MC_Solitary_MinTime (when the robot DOESN'T track somebody)
     * "MC_Solitary_DistanceXY" : Maximum offset distance in X and Y that the robot can apply when he DOESN'T' track somebody
     * "MC_Solitary_Theta" : Maximum theta that the robot can apply when he tracks somebody
     * <p/>
     * return: ALValue format for required parameter
     */
    public com.aldebaran.qimessaging.Object getParameter(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getParameter", param1).get();
    }

    /**
     * 132 setEngagementMode           Void (String)
     * Set engagement mode.
     * modeName: Name of the mode
     */
    public void setEngagementMode(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setEngagementMode", param1);
        else
            service.call("setEngagementMode", param1).get();
    }

    /**
     * 133 getEngagementMode           String ()
     * Set engagement mode.
     * return: Name of current engagement mode as a string
     */
    public String getEngagementMode() throws CallError, InterruptedException {
        return (String) service.call("getEngagementMode").get();
    }

    /**
     * 134 setTrackingMode             Void (String)
     * Set tracking mode.
     * modeName: Name of the mode
     */
    public void setTrackingMode(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setTrackingMode", param1);
        else
            service.call("setTrackingMode", param1).get();
    }

    /**
     * 135 getTrackingMode             String ()
     * Set tracking mode.
     * return: Name of current tracking mode as a string
     */
    public String getTrackingMode() throws CallError, InterruptedException {
        return (String) service.call("getTrackingMode").get();
    }

    /**
     * 136 engagePerson                Void (Int32)
     * Force Engage Person.
     * engagePerson: ID of the person as found in PeoplePerception.
     * * Signals:
     */
    public void engagePerson(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("engagePerson", param1);
        else
            service.call("engagePerson", param1).get();
    }


}
    