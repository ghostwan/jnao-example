package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;
import java.util.Map;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALUserSession extends ALModule {

    public ALUserSession(Session session) {
        super(session);
    }

    /**
     * 100 exit                    Void ()
     * Exits and unregisters the module.
     * 102 pCall                   Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version                 String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                    Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList           List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp           Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp           Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                    Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning               Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                    Void (Int32)
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
     * 111 getBrokerName           String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage                String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 116 doUsersExist            Bool (List<Int32>)
     * Check if users exist in db.
     * user_list: A list of int ID of the users to check.
     * return: A bool, true if all users exist.
     */
    public Boolean doUsersExist(List<Integer> param1) throws CallError, InterruptedException {
        return (Boolean) service.call("doUsersExist", param1).get();
    }

    /**
     * 117 getUserList             List<Int32> ()
     * Get a full list of the users.
     * return: A list of int user IDs.
     */
    public List<Integer> getUserList() throws CallError, InterruptedException {
        return (List<Integer>) service.call("getUserList").get();
    }

    /**
     * 118 getNumUsers             Int32 ()
     * Get the count of users in db.
     * return: An int of how many users exist
     */
    public Integer getNumUsers() throws CallError, InterruptedException {
        return (Integer) service.call("getNumUsers").get();
    }

    /**
     * 119 getFocusedUser          Int32 ()
     * Get which user has the robot's focus.
     * return: The int ID of the focused user. -1 if no focused user.
     */
    public Integer getFocusedUser() throws CallError, InterruptedException {
        return (Integer) service.call("getFocusedUser").get();
    }

    /**
     * 121 getOpenUserSessions     List<Int32> ()
     * Get which users have an open session.
     * return: A list of int IDs of each user with an open session.
     */
    public List<Integer> getOpenUserSessions() throws CallError, InterruptedException {
        return (List<Integer>) service.call("getOpenUserSessions").get();
    }

    /**
     * 122 areUserSessionsOpen     Bool (List<Int32>)
     * Check if users have an open session.
     * user_list: A list of int IDs of each user to check.
     * return: A bool, true if all users have open sessions.
     */
    public Boolean areUserSessionsOpen(List<Integer> param1) throws CallError, InterruptedException {
        return (Boolean) service.call("areUserSessionsOpen", param1).get();
    }

    /**
     * 125 getBindingSources       List<String> ()
     * The list of binding sources  that have been applied to UserSession
     * return: A list of strings, one for each binding source.
     */
    public List<String> getBindingSources() throws CallError, InterruptedException {
        return (List<String>) service.call("getBindingSources").get();
    }

    /**
     * 126 doesBindingSourceExist  Bool (String)
     * Query if a particular has been applied to UserSession
     * binding_name: The string name of the binding source.
     * return: A bool, true if a binding source exists.
     */
    public Boolean doesBindingSourceExist(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("doesBindingSourceExist", param1).get();
    }

    /**
     * 129 getUserBindings         Map<String,String> (Int32)
     * Get the sources a user is bound to.
     * uid: The int ID of the user.
     * return: A map of string binding names and their string values.
     */
    public Map<String, String> getUserBindings(Integer param1) throws CallError, InterruptedException {
        return (Map<String, String>) service.call("getUserBindings", param1).get();
    }

    /**
     * 130 getUserBinding          String (Int32,String)
     * Get the a specific source a user is bound to.
     * uid: The int ID of the user.
     * binding_name: The string name of the binding source.
     * return: The string value of the binding ID for the user.
     */
    public String getUserBinding(Integer param1, String param2) throws CallError, InterruptedException {
        return (String) service.call("getUserBinding", param1, param2).get();
    }

    /**
     * 131 findUsersWithBinding    List<Int32> (String,String)
     * Get the sources a user is bound to.
     * binding_name: The string name of the binding source.
     * binding_value: The string ID of the user at the binding source.
     * return: The int IDs of the users with the passed binding_value.
     */
    public List<Integer> findUsersWithBinding(String param1, String param2) throws CallError, InterruptedException {
        return (List<Integer>) service.call("findUsersWithBinding", param1, param2).get();
    }

    /**
     * 134 doesUserDataSourceExist Bool (String)
     * Check if a data source has been registered.
     * source_name: The string name of the data source.
     * return: A bool, true if the source has been registered
     */
    public Boolean doesUserDataSourceExist(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("doesUserDataSourceExist", param1).get();
    }

    /**
     * 135 getUserDataSources      List<String> ()
     * Check what data sources have been registered.
     * return: A list of strings of each registered data source.
     */
    public List<String> getUserDataSources() throws CallError, InterruptedException {
        return (List<String>) service.call("getUserDataSources").get();
    }

    /**
     * 136 getUserData             Value (Int32,String,String)
     * Get some data about a user.  Will throw if it does not exist
     * uid: The int ID of the user whose data to get.
     * data_name: The key of the data to get.
     * source_name: The string name of the data source.
     * return: ALValue of the data.
     */
    public com.aldebaran.qimessaging.Object getUserData(Integer param1, String param2, String param3) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getUserData", param1, param2, param3).get();
    }

    /**
     * 137 getUserData             Map<String,Value> (Int32,String)
     * Get some data about a user.  Will throw if it does not exist
     * uid: The int ID of the user whose data to get.
     * data_name: The key of the data to get.
     * return: A map keyed by source_name of ALValues of the data.
     */
    public Map<String, Object> getUserData(Integer param1, String param2) throws CallError, InterruptedException {
        return (Map<String, Object>) service.call("getUserData", param1, param2).get();
    }

    /**
     * 138 setUserData             Void (Int32,String,String,Value)
     * Set some data about a user.  Will throw if user does not exist
     * uid: The int ID of the user whose data to set.
     * data_name: The key of the data to set.
     * source_name: The string name of the data source.
     * data: ALValue of the data.
     * * Signals:
     */
    public void setUserData(Integer param1, String param2, String param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setUserData", param1, param2, param3, param4);
        else
            service.call("setUserData", param1, param2, param3, param4).get();
    }


}
    