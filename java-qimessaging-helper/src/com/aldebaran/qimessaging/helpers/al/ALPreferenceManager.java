package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALPreferenceManager extends ALModule {

    public ALPreferenceManager(Session session) {
        super(session);
    }

    /**
     * 100 exit               Void ()
     * Exits and unregisters the module.
     * 102 pCall              Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version            String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping               Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList      List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp      Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp      Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait               Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning          Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop               Void (Int32)
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
     * 111 getBrokerName      String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage           String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 getValue           Value (String,String)
     * Get specified preference
     * domain: Preference domain
     * setting: Preference setting
     * return: corresponding preferences value
     */
    public com.aldebaran.qimessaging.Object getValue(String param1, String param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getValue", param1, param2).get();
    }

    /**
     * 114 setValue           Void (String,String,Value)
     * Set specified preference
     * domain: Preference domain
     * setting: Preference setting
     * value: Preference value
     */
    public void setValue(String param1, String param2, com.aldebaran.qimessaging.Object param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setValue", param1, param2, param3);
        else
            service.call("setValue", param1, param2, param3).get();
    }

    /**
     * 115 getValueList       List<List<Value>> (String)
     * Get preferences names and values for a given domain
     * domain: Preference domain
     * return: a list of preferences names and values associated to the domain
     */
    public List<List<Object>> getValueList(String param1) throws CallError, InterruptedException {
        return (List<List<Object>>) service.call("getValueList", param1).get();
    }

    /**
     * 116 getDomainList      List<String> ()
     * Get available preferences domain
     * return: a list containing all the available domain names
     */
    public List<String> getDomainList() throws CallError, InterruptedException {
        return (List<String>) service.call("getDomainList").get();
    }

    /**
     * 117 removeValue        Void (String,String)
     * Remove specified preference
     * domain: Preference domain
     * setting: Preference setting
     */
    public void removeValue(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeValue", param1, param2);
        else
            service.call("removeValue", param1, param2).get();
    }

    /**
     * 118 removeDomainValues Void (String)
     * Remove an entire preference domain
     * domain: Preference domain
     */
    public void removeDomainValues(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeDomainValues", param1);
        else
            service.call("removeDomainValues", param1).get();
    }

    /**
     * 119 importPrefFile     Void (String,String,String,Bool)
     * Import a preferences XML file
     * domain: Preference domain: all preferences values found in XML file will be imported in that domain.
     * applicationName: Application name: will be used to search for preference file on disk (in location of type <configurationdirectory>/applicationName/filename).
     * filename: Preference XML filename
     * override: Set this to true if you want to override preferences that already exist with preferences in imported XML file
     */
    public void importPrefFile(String param1, String param2, String param3, Boolean param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("importPrefFile", param1, param2, param3, param4);
        else
            service.call("importPrefFile", param1, param2, param3, param4).get();
    }

    /**
     * 120 update             Void ()
     * Synchronizes local preferences with preferences stored on a server.
     * * Signals:
     */
    public void update() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("update");
        else
            service.call("update").get();
    }


}
    