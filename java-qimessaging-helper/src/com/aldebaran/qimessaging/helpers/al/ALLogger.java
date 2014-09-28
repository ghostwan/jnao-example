package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALLogger extends ALModule {

    public ALLogger(Session session) {
        super(session);
    }

    /**
     * 100 exit           Void ()
     * Exits and unregisters the module.
     * 102 pCall          Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version        String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping           Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList  List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp  Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp  Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait           Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning      Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop           Void (Int32)
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
     * 111 getBrokerName  String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage       String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 fatal          Void (String,String)
     * DEPRECATED. Use qiLogFatal instead.
     * Log a fatal error.
     * moduleName: Name of the module.
     * message: Log Message.
     */
    public void fatal(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("fatal", param1, param2);
        else
            service.call("fatal", param1, param2).get();
    }

    /**
     * 114 error          Void (String,String)
     * DEPRECATED. Use qiLogError instead.
     * Log an error.
     * moduleName: Name of the module.
     * message: Log Message.
     */
    public void error(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("error", param1, param2);
        else
            service.call("error", param1, param2).get();
    }

    /**
     * 115 warn           Void (String,String)
     * DEPRECATED: use qiLogWarning instead. Log a warning.
     * moduleName: Name of the module.
     * message: Log Message.
     */
    public void warn(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("warn", param1, param2);
        else
            service.call("warn", param1, param2).get();
    }

    /**
     * 116 info           Void (String,String)
     * DEPRECATED. Use qiLogInfo instead.
     * Log a info message.
     * moduleName: Name of the module.
     * message: Log Message.
     */
    public void info(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("info", param1, param2);
        else
            service.call("info", param1, param2).get();
    }

    /**
     * 117 debug          Void (String,String)
     * DEPRECATED. Use qiLogDebug instead.
     * Log a debug message.
     * moduleName: Name of the module.
     * message: Log Message.
     */
    public void debug(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("debug", param1, param2);
        else
            service.call("debug", param1, param2).get();
    }

    /**
     * 118 setVerbosity   Void (String)
     * Removed: not implemented anymore.
     */
    public void setVerbosity(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setVerbosity", param1);
        else
            service.call("setVerbosity", param1).get();
    }

    /**
     * 119 verbosity      Int32 ()
     * Removed: not implemented anymore.
     */
    public Integer verbosity() throws CallError, InterruptedException {
        return (Integer) service.call("verbosity").get();
    }

    /**
     * 120 logInFile      Void (String)
     * Removed: not implemented anymore.
     */
    public void logInFile(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("logInFile", param1);
        else
            service.call("logInFile", param1).get();
    }

    /**
     * 121 logInForwarder Void (String)
     * Removed: not implemented anymore.
     */
    public void logInForwarder(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("logInForwarder", param1);
        else
            service.call("logInForwarder", param1).get();
    }

    /**
     * 122 removeHandler  Void (String)
     * Removed: not implemented anymore.
     * * Signals:
     */
    public void removeHandler(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeHandler", param1);
        else
            service.call("removeHandler", param1).get();
    }


}
    