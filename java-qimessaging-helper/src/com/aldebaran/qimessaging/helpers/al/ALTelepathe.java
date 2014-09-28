package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALTelepathe extends ALModule {

    public ALTelepathe(Session session) {
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
     * 113 subscribe               Void (String,Int32,Float)
     * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
     * name: Name of the module which subscribes.
     * period: Refresh period (in milliseconds) if relevant.
     * precision: Precision of the extractor if relevant.
     */
    public void subscribe(String param1, Integer param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("subscribe", param1, param2, param3);
        else
            service.call("subscribe", param1, param2, param3).get();
    }

    /**
     * 114 subscribe               Void (String)
     * Subscribes to the extractor. This causes the extractor to start writing information to memory using the keys described by getOutputNames(). These can be accessed in memory using ALMemory.getData("keyName"). In many cases you can avoid calling subscribe on the extractor by just calling ALMemory.subscribeToEvent() supplying a callback method. This will automatically subscribe to the extractor for you.
     * name: Name of the module which subscribes.
     */
    public void subscribe(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("subscribe", param1);
        else
            service.call("subscribe", param1).get();
    }

    /**
     * 115 unsubscribe             Void (String)
     * Unsubscribes from the extractor.
     * name: Name of the module which had subscribed.
     */
    public void unsubscribe(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unsubscribe", param1);
        else
            service.call("unsubscribe", param1).get();
    }

    /**
     * 116 updatePeriod            Void (String,Int32)
     * Updates the period if relevant.
     * name: Name of the module which has subscribed.
     * period: Refresh period (in milliseconds).
     */
    public void updatePeriod(String param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("updatePeriod", param1, param2);
        else
            service.call("updatePeriod", param1, param2).get();
    }

    /**
     * 117 updatePrecision         Void (String,Float)
     * Updates the precision if relevant.
     * name: Name of the module which has subscribed.
     * precision: Precision of the extractor.
     */
    public void updatePrecision(String param1, Float param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("updatePrecision", param1, param2);
        else
            service.call("updatePrecision", param1, param2).get();
    }

    /**
     * 118 getCurrentPeriod        Int32 ()
     * Gets the current period.
     * return: Refresh period (in milliseconds).
     */
    public Integer getCurrentPeriod() throws CallError, InterruptedException {
        return (Integer) service.call("getCurrentPeriod").get();
    }

    /**
     * 119 getCurrentPrecision     Float ()
     * Gets the current precision.
     * return: Precision of the extractor.
     */
    public Float getCurrentPrecision() throws CallError, InterruptedException {
        return (Float) service.call("getCurrentPrecision").get();
    }

    /**
     * 120 getMyPeriod             Int32 (String)
     * Gets the period for a specific subscription.
     * name: Name of the module which has subscribed.
     * return: Refresh period (in milliseconds).
     */
    public Integer getMyPeriod(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getMyPeriod", param1).get();
    }

    /**
     * 121 getMyPrecision          Float (String)
     * Gets the precision for a specific subscription.
     * name: name of the module which has subscribed
     * return: precision of the extractor
     */
    public Float getMyPrecision(String param1) throws CallError, InterruptedException {
        return (Float) service.call("getMyPrecision", param1).get();
    }

    /**
     * 122 getSubscribersInfo      Value ()
     * Gets the parameters given by the module.
     * return: Array of names and parameters of all subscribers.
     */
    public com.aldebaran.qimessaging.Object getSubscribersInfo() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getSubscribersInfo").get();
    }

    /**
     * 123 getOutputNames          List<String> ()
     * Get the list of values updated in ALMemory.
     * return: Array of values updated by this extractor in ALMemory
     */
    public List<String> getOutputNames() throws CallError, InterruptedException {
        return (List<String>) service.call("getOutputNames").get();
    }

    /**
     * 124 getEventList            List<String> ()
     * Get the list of events updated in ALMemory.
     * return: Array of events updated by this extractor in ALMemory
     */
    public List<String> getEventList() throws CallError, InterruptedException {
        return (List<String>) service.call("getEventList").get();
    }

    /**
     * 125 getMemoryKeyList        List<String> ()
     * Get the list of events updated in ALMemory.
     * return: Array of events updated by this extractor in ALMemory
     */
    public List<String> getMemoryKeyList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMemoryKeyList").get();
    }

    /**
     * 126 setDebugMode            Void (Bool)
     * enable/disable the printing of some debug information
     * bSetOrUnset: enable the functionnality when true.
     */
    public void setDebugMode(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setDebugMode", param1);
        else
            service.call("setDebugMode", param1).get();
    }

    /**
     * 127 processRemote           Void (Int32,Int32,Value,Value)
     * enable/disable the printing of some debug information
     * nbOfChannels: Provides the number of channels of the buffer.
     * nbOfSamplesByChannel: Provides the number of samples by channel.
     * timestamp: Provides the timestamp of the buffer.
     * buffer: Provides the audio buffer as an ALValue.
     */
    public void processRemote(Integer param1, Integer param2, com.aldebaran.qimessaging.Object param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("processRemote", param1, param2, param3, param4);
        else
            service.call("processRemote", param1, param2, param3, param4).get();
    }

    /**
     * 128 processSoundRemote      Void (Int32,Int32,Value)
     * enable/disable the printing of some debug information
     * nbOfChannels: Provides the number of channels of the buffer.
     * nbOfSamplesByChannel: Provides the number of samples by channel.
     * buffer: Provides the audio buffer as an ALValue.
     */
    public void processSoundRemote(Integer param1, Integer param2, com.aldebaran.qimessaging.Object param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("processSoundRemote", param1, param2, param3);
        else
            service.call("processSoundRemote", param1, param2, param3).get();
    }

    /**
     * 129 associatedUser          String ()
     * Tells who is associated to the robot, if anyone.
     * This simply accesses to the ALMemory key ALTelepathe/User
     * return: the name of the user, empty if none
     */
    public String associatedUser() throws CallError, InterruptedException {
        return (String) service.call("associatedUser").get();
    }

    /**
     * 130 associateUser           Void (String,String)
     * Associates the robot to the given Aldebaran Robotics user.
     * The associated user is recalled in ALMemory as ALTelepathe/User
     * login: A valid Aldebaran Robotics user name.
     * password: The matching password with the user name.
     */
    public void associateUser(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("associateUser", param1, param2);
        else
            service.call("associateUser", param1, param2).get();
    }

    /**
     * 131 dissociateUser          Void ()
     * Clears the login and password for accessing Aldebaran Robotics's network.Login can be tracked in the ALMemory key ALTelepathe/User
     */
    public void dissociateUser() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("dissociateUser");
        else
            service.call("dissociateUser").get();
    }

    /**
     * 132 connectNetwork          Void ()
     * Connects the robot to the messaging network.
     * Returns once connected. Throws runtime error otherwise.
     */
    public void connectNetwork() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("connectNetwork");
        else
            service.call("connectNetwork").get();
    }

    /**
     * 133 disconnectNetwork       Void ()
     * Disconnects the robot from the messaging network.
     * Returns once disconnected. Does not throw.
     */
    public void disconnectNetwork() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("disconnectNetwork");
        else
            service.call("disconnectNetwork").get();
    }

    /**
     * 134 isConnected             Bool ()
     * Gets the current connection status.
     * Value is the same as in the ALMemory key ALTelepathe/Connected
     * return: Whether ALTelepathe is online or not.
     */
    public Boolean isConnected() throws CallError, InterruptedException {
        return (Boolean) service.call("isConnected").get();
    }

    /**
     * 135 enableAutoconnection    Void (Bool)
     * Enables autoconnection to the network, using the saved user login information if present.
     * enabled: Whether to connect automatically at startup.
     */
    public void enableAutoconnection(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("enableAutoconnection", param1);
        else
            service.call("enableAutoconnection", param1).get();
    }

    /**
     * 136 isAutoconnectionEnabled Bool ()
     * Says whether autoconnection is enabled or not.
     * return: Whether autoconnection is enabled
     */
    public Boolean isAutoconnectionEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("isAutoconnectionEnabled").get();
    }

    /**
     * 138 sendMessage             Void (String,String)
     * Sends a text message to the chosen destination.
     * destination: The id of the destination contact.
     * message: The message to send to the contact.
     */
    public void sendMessage(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("sendMessage", param1, param2);
        else
            service.call("sendMessage", param1, param2).get();
    }

    /**
     * 139 enableRPC               Void (Bool)
     * Enable / disable RPC handling for received messages.
     * enabled: Whether to enable RPC
     */
    public void enableRPC(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("enableRPC", param1);
        else
            service.call("enableRPC", param1).get();
    }

    /**
     * 140 isRPCEnabled            Bool ()
     * Says whether RPC is enabled or not.
     * return: Whether RPC is enabled
     */
    public Boolean isRPCEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("isRPCEnabled").get();
    }

    /**
     * 141 sendRPC                 Value (String,String,String,Value)
     * Performs an Internet Remote Procedure Call.
     * Returns once call has been received.Throws runtime error otherwise.
     * destination: Target contact id
     * module: The target module
     * method: The method to call
     * args: The method arguments
     * return: RPC return value
     */
    public com.aldebaran.qimessaging.Object sendRPC(String param1, String param2, String param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("sendRPC", param1, param2, param3, param4).get();
    }

    /**
     * 142 sendRPC                 Value (String,String,String,Value,Int32)
     * Performs an Internet Remote Procedure Call.
     * Returns once call has been received.Throws runtime error otherwise.
     * destination: Target contact id
     * module: The target module
     * method: The method to call
     * args: The method arguments
     * timeout: The timeout after which the call should be aborted
     * return: RPC return value
     */
    public com.aldebaran.qimessaging.Object sendRPC(String param1, String param2, String param3, com.aldebaran.qimessaging.Object param4, Integer param5) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("sendRPC", param1, param2, param3, param4, param5).get();
    }

    /**
     * 144 startCall               Void (String,Bool,Bool)
     * Starts a media call.Returns once the call is accepted remotely.Throws runtime error if the call can't be established.Timeouts after 30 seconds if call not accepted remotely.
     * contact: The contact id to call.
     * audio: Whether audio is enabled for the call.
     * video: Whether video is enabled for the call.
     */
    public void startCall(String param1, Boolean param2, Boolean param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startCall", param1, param2, param3);
        else
            service.call("startCall", param1, param2, param3).get();
    }

    /**
     * 145 stopCall                Void ()
     * Stops the current media call.
     */
    public void stopCall() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopCall");
        else
            service.call("stopCall").get();
    }

    /**
     * 146 isCalling               Bool ()
     * Says whether a media call is currently established.
     * return: Whether ALTelepathe is calling or not.
     * * Signals:
     */
    public Boolean isCalling() throws CallError, InterruptedException {
        return (Boolean) service.call("isCalling").get();
    }


}
    