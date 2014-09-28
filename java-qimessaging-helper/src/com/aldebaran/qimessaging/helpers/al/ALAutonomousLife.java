package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;
import java.util.Map;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALAutonomousLife extends ALModule {

    public ALAutonomousLife(Session session) {
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
     * 124 setState                       Void (String)
     * Programatically control the state of Autonomous Life
     * state: The possible states of AutonomousLife are: interactive, solitary, safeguard, disabled
     */
    public void setState(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setState", param1);
        else
            service.call("setState", param1).get();
    }

    /**
     * 125 getState                       String ()
     * Returns the current state of AutonomousLife
     * return: Can be: solitary, interactive, safeguard, disabled
     */
    public String getState() throws CallError, InterruptedException {
        return (String) service.call("getState").get();
    }

    /**
     * 126 focusedActivity                String ()
     * Returns the currently focused activity
     * return: The name of the focused activity
     */
    public String focusedActivity() throws CallError, InterruptedException {
        return (String) service.call("focusedActivity").get();
    }

    /**
     * 127 switchFocus                    Void (String)
     * Set an activity as running with user focus
     * activity_name: The package_name/activity_name to run
     */
    public void switchFocus(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("switchFocus", param1);
        else
            service.call("switchFocus", param1).get();
    }

    /**
     * 128 switchFocus                    Void (String,Int32)
     * Set an activity as running with user focus
     * activity_name: The package_name/activity_name to run
     * flags: Flags for focus changing. STOP_CURRENT or STOP_AND_STACK_CURRENT
     */
    public void switchFocus(String param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("switchFocus", param1, param2);
        else
            service.call("switchFocus", param1, param2).get();
    }

    /**
     * 129 stopFocus                      Void ()
     * Stops the focused activity. If another activity is stacked it will be started.
     */
    public void stopFocus() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopFocus");
        else
            service.call("stopFocus").get();
    }

    /**
     * 130 stopAll                        Void ()
     * Stops the focused activity and clears stack of activities
     */
    public void stopAll() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopAll");
        else
            service.call("stopAll").get();
    }

    /**
     * 131 getActivityNature              String (String)
     * Returns the nature of an activity
     * activity_name: The package_name/activity_name to check
     * return: Possible values are: solitary, interactive
     */
    public String getActivityNature(String param1) throws CallError, InterruptedException {
        return (String) service.call("getActivityNature", param1).get();
    }

    /**
     * 132 preloadActivities              Void ()
     * Preload activities to optimize launching
     */
    public void preloadActivities() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("preloadActivities");
        else
            service.call("preloadActivities").get();
    }

    /**
     * 133 getActivityStatistics          Map<String,Map<String,Int32>> ()
     * Get launch count, last completion time, etc for activities.
     * return: A map of activity names, with a cooresponding map of  "prevStartTime", "prevCompletionTime", "startCount", "totalDuration". Times are 0 for unlaunched Activities
     */
    public Map<String, Map<String, Integer>> getActivityStatistics() throws CallError, InterruptedException {
        return (Map<String, Map<String, Integer>>) service.call("getActivityStatistics").get();
    }

    /**
     * 134 getAutonomousActivityStatistics Map<String,Map<String,Int32>> ()
     * Get launch count, last completion time, etc for activities with autonomous launch trigger conditions.
     * return: A map of activity names, with a cooresponding map of  "prevStartTime", "prevCompletionTime", "startCount", "totalDuration". Times are 0 for unlaunched Activities
     */
    public Map<String, Map<String, Integer>> getAutonomousActivityStatistics() throws CallError, InterruptedException {
        return (Map<String, Map<String, Integer>>) service.call("getAutonomousActivityStatistics").get();
    }

    /**
     * 135 getFocusHistory                List<(String,Int32)> ()
     * Get a list of the order that activities that have been focused, and their time focused.
     * return: A list of pairs, each pair is ActivityName/PreviousFocusedTime
     */
    public Map<String, Integer> getFocusHistory() throws CallError, InterruptedException {
        return (Map<String, Integer>) service.call("getFocusHistory").get();
    }

    /**
     * 136 getStateHistory                List<(String,Int32)> ()
     * Get a list of the order that states that have been entered, and their time entered.
     * return: A list of pairs, each pair is StateName/PreviousEnteredTime
     */
    public Map<String, Integer> getStateHistory() throws CallError, InterruptedException {
        return (Map<String, Integer>) service.call("getStateHistory").get();
    }

    /**
     * 137 getFocusHistory                List<(String,Int32)> (Int32)
     * Get a list of the order that activities that have been focused, and their time focused.
     * depth: How many items of history to report, starting from most recent.
     * return: A list of pairs, each pair is ActivityName/PreviousFocusedTime
     */
    public Map<String, Integer> getFocusHistory(Integer param1) throws CallError, InterruptedException {
        return (Map<String, Integer>) service.call("getFocusHistory", param1).get();
    }

    /**
     * 138 getStateHistory                List<(String,Int32)> (Int32)
     * Get a list of the order that states that have been entered, and their time entered.
     * depth: How many items of history to report, starting from most recent.
     * return: A list of pairs, each pair is StateName/PreviousEnteredTime
     */
    public Map<String, Integer> getStateHistory(Integer param1) throws CallError, InterruptedException {
        return (Map<String, Integer>) service.call("getStateHistory", param1).get();
    }

    /**
     * 139 getLifeTime                    Int32 ()
     * Get the time in seconds as life sees it.  Based on gettimeofday()
     * return: The int time in seconds as Autonomous Life sees it
     */
    public Integer getLifeTime() throws CallError, InterruptedException {
        return (Integer) service.call("getLifeTime").get();
    }

    /**
     * 140 startMonitoringLaunchpadConditions Void ()
     * Start monitoring ALMemory and reporting conditional triggers with AutonomousLaunchpad.
     */
    public void startMonitoringLaunchpadConditions() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startMonitoringLaunchpadConditions");
        else
            service.call("startMonitoringLaunchpadConditions").get();
    }

    /**
     * 141 stopMonitoringLaunchpadConditions Void ()
     * Stop monitoring ALMemory and reporting conditional triggers with AutonomousLaunchpad.
     */
    public void stopMonitoringLaunchpadConditions() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopMonitoringLaunchpadConditions");
        else
            service.call("stopMonitoringLaunchpadConditions").get();
    }

    /**
     * 142 isMonitoringLaunchpadConditions Bool ()
     * Gets running status of AutonomousLaunchpad
     * return: True if AutonomousLaunchpad is monitoring ALMemory and reporting conditional triggers.
     */
    public Boolean isMonitoringLaunchpadConditions() throws CallError, InterruptedException {
        return (Boolean) service.call("isMonitoringLaunchpadConditions").get();
    }

    /**
     * 143 setLaunchpadPluginEnabled      Void (String,Bool)
     * Temporarily enables/disables AutonomousLaunchpad Plugins
     * plugin_name: The name of the plugin to enable/disable
     * enabled: Whether or not to enable this plugin
     */
    public void setLaunchpadPluginEnabled(String param1, Boolean param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setLaunchpadPluginEnabled", param1, param2);
        else
            service.call("setLaunchpadPluginEnabled", param1, param2).get();
    }

    /**
     * 144 getEnabledLaunchpadPlugins     List<String> ()
     * Get a list of enabled AutonomousLaunchpad Plugins.  Enabled plugins will run when AutonomousLaunchpad is started
     * return: A list of strings of enabled plugins.
     */
    public List<String> getEnabledLaunchpadPlugins() throws CallError, InterruptedException {
        return (List<String>) service.call("getEnabledLaunchpadPlugins").get();
    }

    /**
     * 145 getLaunchpadPluginsForGroup    List<String> (String)
     * Get a list of AutonomousLaunchpad Plugins that belong to specified group
     * group: The group to search for the plugins
     * return: A list of strings of the plugins belonging to the group.
     */
    public List<String> getLaunchpadPluginsForGroup(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getLaunchpadPluginsForGroup", param1).get();
    }

    /**
     * 146 setRobotOffsetFromFloor        Void (Float)
     * Set the vertical offset (in meters) of the base of the robot with respect to the floor
     * offset: The new vertical offset (in meters)
     */
    public void setRobotOffsetFromFloor(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setRobotOffsetFromFloor", param1);
        else
            service.call("setRobotOffsetFromFloor", param1).get();
    }

    /**
     * 147 getRobotOffsetFromFloor        Float ()
     * Get the vertical offset (in meters) of the base of the robot with respect to the floor
     * return: Current vertical offset (in meters)
     */
    public Float getRobotOffsetFromFloor() throws CallError, InterruptedException {
        return (Float) service.call("getRobotOffsetFromFloor").get();
    }

    /**
     * 152 setSafeguardEnabled            Void (String,Bool)
     * Set if a given safeguard will be handled by Autonomous Life or not.
     * name: Name of the safeguard to consider: RobotPushed, RobotFell,CriticalDiagnosis, CriticalTemperature
     * enabled: True if life handles the safeguard.
     */
    public void setSafeguardEnabled(String param1, Boolean param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setSafeguardEnabled", param1, param2);
        else
            service.call("setSafeguardEnabled", param1, param2).get();
    }

    /**
     * 153 isSafeguardEnabled             Bool (String)
     * Get if a given safeguard will be handled by Autonomous Life or not.
     * name: Name of the safeguard to consider: RobotPushed, RobotFell,CriticalDiagnosis, CriticalTemperature
     * return: True if life handles the safeguard.
     * * Signals:
     */
    public Boolean isSafeguardEnabled(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isSafeguardEnabled", param1).get();
    }


}
    