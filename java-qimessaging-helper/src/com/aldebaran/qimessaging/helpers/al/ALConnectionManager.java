package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALConnectionManager extends ALModule {

    public ALConnectionManager(Session session) {
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
     * 113 setServiceInput         Void (Value)
     * provide input for pending connection
     * reply: The required input requested by the connection manager to finalize the pending connection
     */
    public void setServiceInput(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setServiceInput", param1);
        else
            service.call("setServiceInput", param1).get();
    }

    /**
     * 114 services                Value ()
     * Return the list of all network services with their properties
     * return: An array of NetworkInfo
     */
    public com.aldebaran.qimessaging.Object services() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("services").get();
    }

    /**
     * 115 service                 Value (String)
     * Return the service properties
     * serviceId: Service identifier
     * return: Return the service properties
     */
    public com.aldebaran.qimessaging.Object service(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("service", param1).get();
    }

    /**
     * 116 setServiceConfiguration Void (Value)
     * Set the service configuration
     * service: The service to configure
     */
    public void setServiceConfiguration(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setServiceConfiguration", param1);
        else
            service.call("setServiceConfiguration", param1).get();
    }

    /**
     * 117 state                   String ()
     * Return the current global state of the connection manager
     * return: A string containing the current state
     */
    public String state() throws CallError, InterruptedException {
        return (String) service.call("state").get();
    }

    /**
     * 118 forget                  Void (String)
     * Forget stored information about the service
     * serviceId: Service identifier
     */
    public void forget(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("forget", param1);
        else
            service.call("forget", param1).get();
    }

    /**
     * 119 connect                 Void (String)
     * Request a connection to the service. If some input is needed for the connection to succeed, an event will be raised
     * serviceId: Service identifier
     */
    public void connect(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("connect", param1);
        else
            service.call("connect", param1).get();
    }

    /**
     * 120 disconnect              Void (String)
     * Disconnect a service
     * serviceId: Service identifier
     */
    public void disconnect(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("disconnect", param1);
        else
            service.call("disconnect", param1).get();
    }

    /**
     * 121 technologies            Value ()
     * return the list of all available technologies
     * return: An AL::Value containing an array of string
     */
    public com.aldebaran.qimessaging.Object technologies() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("technologies").get();
    }

    /**
     * 122 scan                    Void ()
     * scan all available services on registered technologies
     */
    public void scan() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("scan");
        else
            service.call("scan").get();
    }

    /**
     * 123 scan                    Void (String)
     * scan for available services on a given technology
     * technology: The type of technology to scan
     */
    public void scan(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("scan", param1);
        else
            service.call("scan", param1).get();
    }

    /**
     * 124 enableTethering         Void (String)
     * Create a Network Access Point on a given technology and share internet connection if any
     * technology: Technology on which enabling tethering
     */
    public void enableTethering(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("enableTethering", param1);
        else
            service.call("enableTethering", param1).get();
    }

    /**
     * 125 enableTethering         Void (String,String,String)
     * Create a Network Access Point on a given technology and share internet connection if any
     * technology: The technology on which enabling tethering
     * name: The name of the network to create
     * Passphrase: The WPA2 passphrase to connect to the created network
     */
    public void enableTethering(String param1, String param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("enableTethering", param1, param2, param3);
        else
            service.call("enableTethering", param1, param2, param3).get();
    }

    /**
     * 126 disableTethering        Void (String)
     * Destroy the Access Point created on a given technology
     * technology: The technology to disable tethering
     */
    public void disableTethering(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("disableTethering", param1);
        else
            service.call("disableTethering", param1).get();
    }

    /**
     * 127 getTetheringEnable      Bool (String)
     * technology: The technology
     * return: Return whether tethering mode is enabled for the given technology.
     */
    public Boolean getTetheringEnable(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("getTetheringEnable", param1).get();
    }

    /**
     * 128 tetheringName           String (String)
     * technology: The technology
     * return: The name of the network used by the tethering mode
     */
    public String tetheringName(String param1) throws CallError, InterruptedException {
        return (String) service.call("tetheringName", param1).get();
    }

    /**
     * 129 tetheringPassphrase     String (String)
     * technology: The technology
     * return: The passphrase of the network used by the tethering mode
     */
    public String tetheringPassphrase(String param1) throws CallError, InterruptedException {
        return (String) service.call("tetheringPassphrase", param1).get();
    }

    /**
     * 130 countries               List<String> ()
     * Returns the complete list of known countries.
     * return: A vector of std::string country code as  ISO 3166-1
     */
    public List<String> countries() throws CallError, InterruptedException {
        return (List<String>) service.call("countries").get();
    }

    /**
     * 131 setCountry              Void (String)
     * Set a country code for wireless regulatory
     * country: An alpha2 country code as defined in ISO 3166-1
     */
    public void setCountry(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setCountry", param1);
        else
            service.call("setCountry", param1).get();
    }

    /**
     * 132 country                 String ()
     * The country code in use for wireless regulatory
     * return: An alpha2 country code as defined in ISO 3166-1
     */
    public String country() throws CallError, InterruptedException {
        return (String) service.call("country").get();
    }

    /**
     * 133 interfaces              Value ()
     * Returns a list of pair interface name / mac address
     * return: A list of pair interface name / mac address
     * * Signals:
     */
    public com.aldebaran.qimessaging.Object interfaces() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("interfaces").get();
    }


}
    