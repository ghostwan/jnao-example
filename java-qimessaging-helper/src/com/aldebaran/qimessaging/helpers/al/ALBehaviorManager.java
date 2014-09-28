package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALBehaviorManager extends ALModule {

    public ALBehaviorManager(Session session) {
        super(session);
    }

    /**
     * 100 exit                   Void ()
     * Exits and unregisters the module.
     * 102 pCall                  Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version                String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                   Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList          List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp          Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp          Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                   Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning              Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                   Void (Int32)
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
     * 111 getBrokerName          String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage               String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 installBehavior        Bool (String)
     * Install a behavior.
     * Check the given local path for a valid behavior or package.
     * On success, behavior added or updated signal is emitted.
     * DEPRECATED in favor of PackageManager.install.
     * localPath: the relative destination path.
     * return: true on success, false on failure.
     */
    public Boolean installBehavior(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("installBehavior", param1).get();
    }

    /**
     * 114 installBehavior        Bool (String,String,Bool)
     * Install a behavior.
     * Check and take the behavior found at the given absolute path andimport it to the given local path, relative to behaviors path.
     * On success, behavior added signal is emitted before returning.DEPRECATED in favor of PackageManager.install.
     * absolutePath: a behavior on the local file system to install.
     * localPath: the relative destination path.
     * overwrite: whether to replace existing behavior if present.
     * return: true on success, false on failure.
     */
    public Boolean installBehavior(String param1, String param2, Boolean param3) throws CallError, InterruptedException {
        return (Boolean) service.call("installBehavior", param1, param2, param3).get();
    }

    /**
     * 115 preloadBehavior        Bool (String)
     * Load a behavior
     * behavior: Behavior name
     * return: Returns true if it was successfully loaded.
     */
    public Boolean preloadBehavior(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("preloadBehavior", param1).get();
    }

    /**
     * 116 startBehavior          Void (String)
     * Starts a behavior, returns when started.
     * behavior: Behavior name
     */
    public void startBehavior(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startBehavior", param1);
        else
            service.call("startBehavior", param1).get();
    }

    /**
     * 117 runBehavior            Void (String)
     * Runs a behavior, returns when finished
     * behavior: Behavior name
     */
    public void runBehavior(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("runBehavior", param1);
        else
            service.call("runBehavior", param1).get();
    }

    /**
     * 118 stopBehavior           Void (String)
     * Stop a behavior
     * behavior: Behavior name
     */
    public void stopBehavior(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopBehavior", param1);
        else
            service.call("stopBehavior", param1).get();
    }

    /**
     * 119 stopAllBehaviors       Void ()
     * Stop all behaviors
     */
    public void stopAllBehaviors() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopAllBehaviors");
        else
            service.call("stopAllBehaviors").get();
    }

    /**
     * 120 removeBehavior         Bool (String)
     * Remove a behavior from the filesystem. DEPRECATED in favor of PackageManager.remove.
     * behavior: Behavior name
     */
    public Boolean removeBehavior(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("removeBehavior", param1).get();
    }

    /**
     * 121 isBehaviorInstalled    Bool (String)
     * Tell if supplied name corresponds to a behavior that has been installed
     * name: The behavior directory name
     * return: Returns true if it is a valid behavior
     */
    public Boolean isBehaviorInstalled(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isBehaviorInstalled", param1).get();
    }

    /**
     * 122 isBehaviorPresent      Bool (String)
     * Tell if the supplied namecorresponds to an existing behavior.
     * prefixedBehavior: Prefixed behavior or just behavior's name (latter usage deprecated, in this case the behavior is searched for amongst user's behaviors, then in system behaviors) DEPRECATED in favor of ALBehaviorManager.isBehaviorInstalled.
     * return: Returns true if it is an existing behavior
     */
    public Boolean isBehaviorPresent(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isBehaviorPresent", param1).get();
    }

    /**
     * 123 getBehaviorNames       List<String> ()
     * Get behaviors
     * return: Returns the list of behaviors prefixed by their type (User/ or System/). DEPRECATED in favor of ALBehaviorManager.getInstalledBehaviors.
     */
    public List<String> getBehaviorNames() throws CallError, InterruptedException {
        return (List<String>) service.call("getBehaviorNames").get();
    }

    /**
     * 124 getUserBehaviorNames   List<String> ()
     * Get user's behaviors
     * return: Returns the list of user's behaviors prefixed by User/. DEPRECATED in favor of ALBehaviorManager.getInstalledBehaviors.
     */
    public List<String> getUserBehaviorNames() throws CallError, InterruptedException {
        return (List<String>) service.call("getUserBehaviorNames").get();
    }

    /**
     * 125 getSystemBehaviorNames List<String> ()
     * Get system behaviors
     * return: Returns the list of system behaviors prefixed by System/. DEPRECATED in favor of ALBehaviorManager.getInstalledBehaviors.
     */
    public List<String> getSystemBehaviorNames() throws CallError, InterruptedException {
        return (List<String>) service.call("getSystemBehaviorNames").get();
    }

    /**
     * 126 getInstalledBehaviors  List<String> ()
     * Get installed behaviors directories names
     * return: Returns the behaviors list
     */
    public List<String> getInstalledBehaviors() throws CallError, InterruptedException {
        return (List<String>) service.call("getInstalledBehaviors").get();
    }

    /**
     * 127 getBehaviorsByTag      List<String> (String)
     * Get installed behaviors directories names and filter it by tag.
     * tag: A tag to filter the list with.
     * return: Returns the behaviors list
     */
    public List<String> getBehaviorsByTag(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getBehaviorsByTag", param1).get();
    }

    /**
     * 128 isBehaviorRunning      Bool (String)
     * Tell if supplied name corresponds to a running behavior
     * behavior: Behavior name
     * return: Returns true if it is a running behavior
     */
    public Boolean isBehaviorRunning(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isBehaviorRunning", param1).get();
    }

    /**
     * 129 isBehaviorLoaded       Bool (String)
     * Tell if supplied name corresponds to a loaded behavior
     * behavior: Behavior name
     * return: Returns true if it is a loaded behavior
     */
    public Boolean isBehaviorLoaded(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isBehaviorLoaded", param1).get();
    }

    /**
     * 130 getRunningBehaviors    List<String> ()
     * Get running behaviors
     * return: Return running behaviors
     */
    public List<String> getRunningBehaviors() throws CallError, InterruptedException {
        return (List<String>) service.call("getRunningBehaviors").get();
    }

    /**
     * 131 getLoadedBehaviors     List<String> ()
     * Get loaded behaviors
     * return: Return loaded behaviors
     */
    public List<String> getLoadedBehaviors() throws CallError, InterruptedException {
        return (List<String>) service.call("getLoadedBehaviors").get();
    }

    /**
     * 132 getTagList             List<String> ()
     * Get tags found on installed behaviors.
     * return: The list of tags found.
     */
    public List<String> getTagList() throws CallError, InterruptedException {
        return (List<String>) service.call("getTagList").get();
    }

    /**
     * 133 getBehaviorTags        List<String> (String)
     * Get tags found on the given behavior.
     * behavior: The local path towards a behavior or a directory.
     * return: The list of tags found.
     */
    public List<String> getBehaviorTags(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getBehaviorTags", param1).get();
    }

    /**
     * 134 getBehaviorNature      String (String)
     * Get the nature of the given behavior.
     * behavior: The local path towards a behavior or a directory.
     * return: The nature of the behavior.
     */
    public String getBehaviorNature(String param1) throws CallError, InterruptedException {
        return (String) service.call("getBehaviorNature", param1).get();
    }

    /**
     * 135 addDefaultBehavior     Void (String)
     * Set the given behavior as default
     * behavior: Behavior name
     */
    public void addDefaultBehavior(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("addDefaultBehavior", param1);
        else
            service.call("addDefaultBehavior", param1).get();
    }

    /**
     * 136 removeDefaultBehavior  Void (String)
     * Remove the given behavior from the default behaviors
     * behavior: Behavior name
     */
    public void removeDefaultBehavior(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeDefaultBehavior", param1);
        else
            service.call("removeDefaultBehavior", param1).get();
    }

    /**
     * 137 getDefaultBehaviors    List<String> ()
     * Get default behaviors
     * return: Return default behaviors
     */
    public List<String> getDefaultBehaviors() throws CallError, InterruptedException {
        return (List<String>) service.call("getDefaultBehaviors").get();
    }

    /**
     * 138 playDefaultProject     Void ()
     * Play default behaviors
     */
    public void playDefaultProject() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playDefaultProject");
        else
            service.call("playDefaultProject").get();
    }

    /**
     * 141 resolveBehaviorName    String (String)
     * Find out the actual <package>/<behavior> path behind a behavior name.
     * name: name of a behavior
     * return: The actual <package>/<behavior> path if found, else an empty string. Throws an ALERROR if two behavior names conflicted.
     * * Signals:
     */
    public String resolveBehaviorName(String param1) throws CallError, InterruptedException {
        return (String) service.call("resolveBehaviorName", param1).get();
    }

    /**
     * 142 behaviorsAdded   (List<String>)
     * 143 behaviorsRemoved (List<String>)
     */
    public void behaviorsAdded(List<String> param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("behaviorsAdded", param1);
        else
            service.call("behaviorsAdded", param1).get();
    }

    /**
     * 144 behaviorLoaded   (String)
     */
    public void behaviorLoaded(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("behaviorLoaded", param1);
        else
            service.call("behaviorLoaded", param1).get();
    }

    /**
     * 145 behaviorStarted  (String)
     */
    public void behaviorStarted(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("behaviorStarted", param1);
        else
            service.call("behaviorStarted", param1).get();
    }

    /**
     * 146 behaviorStopped  (String)
     */
    public void behaviorStopped(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("behaviorStopped", param1);
        else
            service.call("behaviorStopped", param1).get();
    }

    /**
     * 147 behaviorFailed   (String,String,String)
     */
    public void behaviorFailed(String param1, String param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("behaviorFailed", param1, param2, param3);
        else
            service.call("behaviorFailed", param1, param2, param3).get();
    }


}
    