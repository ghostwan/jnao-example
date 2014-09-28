package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;
import java.util.Map;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALMemory extends ALModule {

    public ALMemory(Session session) {
        super(session);
    }

    /**
     * 100 exit                      Void ()
     * Exits and unregisters the module.
     * 102 pCall                     Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version                   String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                      Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList             List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp             Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp             Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                      Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning                 Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                      Void (Int32)
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
     * 111 getBrokerName             String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage                  String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 declareEvent              Void (String)
     * Declares an event to allow future subscriptions to the event
     * eventName: The name of the event
     */
    public void declareEvent(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("declareEvent", param1);
        else
            service.call("declareEvent", param1).get();
    }

    /**
     * 114 declareEvent              Void (String,String)
     * Declares an event to allow future subscriptions to the event
     * eventName: The name of the event
     * extractorName: The name of the extractor capable of creating the event
     */
    public void declareEvent(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("declareEvent", param1, param2);
        else
            service.call("declareEvent", param1, param2).get();
    }

    /**
     * 115 getData                   Value (String)
     * Gets the value of a key-value pair stored in memory
     * key: Name of the value.
     * return: The data as an ALValue. This can often be cast transparently into the original type.
     */
    public Object getData(String param1) throws CallError, InterruptedException {
        return service.call("getData", param1).get();
    }

    /**
     * 116 getData                   Value (String,Int32)
     * DEPRECATED - Gets the value of a key-value pair stored in memory. Please use the version of this method with no second parameter.
     * key: Name of the value.
     * deprecatedParameter: DEPRECATED - This parameter has no effect, but is left for compatibility reason.
     * return: The data as an ALValue
     */
    public com.aldebaran.qimessaging.Object getData(String param1, Integer param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getData", param1, param2).get();
    }

    /**
     * 117 subscriber                Object (String)
     * Get an object wrapping a signal bound to the given ALMemory event. Throw if the event does not exist or if it is invalid.
     * eventName: Name of the ALMemory event
     * return: An AnyObject with a signal named "signal"
     */
    public com.aldebaran.qimessaging.Object subscriber(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("subscriber", param1).get();
    }

    /**
     * 118 getTimestamp              Value (String)
     * Get data value and timestamp
     * key: Name of the variable
     * return: A list of all the data key names that contain the given string.
     */
    public com.aldebaran.qimessaging.Object getTimestamp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getTimestamp", param1).get();
    }

    /**
     * 119 getEventHistory           Value (String)
     * Get data value and timestamp
     * key: Name of the variable
     * return: A list of all the data key names that contain the given string.
     */
    public com.aldebaran.qimessaging.Object getEventHistory(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getEventHistory", param1).get();
    }

    /**
     * 120 getDataList               List<String> (String)
     * Gets a list of all key names that contain a given string
     * filter: A string used as the search term
     * return: A list of all the data key names that contain the given string.
     */
    public List<String> getDataList(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getDataList", param1).get();
    }

    /**
     * 121 getDataListName           List<String> ()
     * Gets the key names for all the key-value pairs in memory
     * return: A list containing the keys in memory
     */
    public List<String> getDataListName() throws CallError, InterruptedException {
        return (List<String>) service.call("getDataListName").get();
    }

    /**
     * 122 getDataOnChange           Value (String,Int32)
     * DEPRECATED - Blocks the caller until the value of a key changes
     * key: Name of the data.
     * deprecatedParameter: DEPRECATED - this parameter has no effect
     * return: an array containing all the retrieved data
     */
    public com.aldebaran.qimessaging.Object getDataOnChange(String param1, Integer param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getDataOnChange", param1, param2).get();
    }

    /**
     * 123 getDataPtr                Unknown (String)
     * Gets a pointer to 32 a bit data item. Beware, the pointer will only be valid during the lifetime of the ALMemory object. Use with care, at initialization, not every loop.
     * key: Name of the data.
     * return: A pointer converted to int
     */
    public com.aldebaran.qimessaging.Object getDataPtr(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getDataPtr", param1).get();
    }

    /**
     * 124 getEventList              List<String> ()
     * Gets a list containing the names of all the declared events
     * return: A list containing the names of all events
     */
    public List<String> getEventList() throws CallError, InterruptedException {
        return (List<String>) service.call("getEventList").get();
    }

    /**
     * 125 getExtractorEvent         List<String> (String)
     * Gets the list of all events generated by a given extractor
     * extractorName: The name of the extractor
     * return: A list containing the names of the events associated with the given extractor
     */
    public List<String> getExtractorEvent(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getExtractorEvent", param1).get();
    }

    /**
     * 126 getListData               Value (Value)
     * Gets the values associated with the given list of keys. This is more efficient than calling getData many times, especially over the network.
     * keyList: An array containing the key names.
     * return: An array containing all the values corresponding to the given keys.
     */
    public com.aldebaran.qimessaging.Object getListData(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getListData", param1).get();
    }

    /**
     * 127 getMicroEventList         List<String> ()
     * Gets a list containing the names of all the declared micro events
     * return: A list containing the names of all the microEvents
     */
    public List<String> getMicroEventList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMicroEventList").get();
    }

    /**
     * 128 getSubscribers            List<String> (String)
     * Gets a list containing the names of subscribers to an event.
     * name: Name of the event or micro-event
     * return: List of subscriber names
     */
    public List<String> getSubscribers(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getSubscribers", param1).get();
    }

    /**
     * 129 getType                   String (String)
     * Gets the storage class of the stored data. This is not the underlying POD type.
     * key: Name of the variable
     * return: String type: Data, Event, MicroEvent
     */
    public String getType(String param1) throws CallError, InterruptedException {
        return (String) service.call("getType", param1).get();
    }

    /**
     * 130 insertData                Void (String,Int32)
     * Inserts a key-value pair into memory, where value is an int
     * key: Name of the value to be inserted.
     * value: The int to be inserted
     */
    public void insertData(String param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("insertData", param1, param2);
        else
            service.call("insertData", param1, param2).get();
    }

    /**
     * 131 insertData                Void (String,Float)
     * Inserts a key-value pair into memory, where value is a float
     * key: Name of the value to be inserted.
     * value: The float to be inserted
     */
    public void insertData(String param1, Float param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("insertData", param1, param2);
        else
            service.call("insertData", param1, param2).get();
    }

    /**
     * 132 insertData                Void (String,String)
     * Inserts a key-value pair into memory, where value is a string
     * key: Name of the value to be inserted.
     * value: The string to be inserted
     */
    public void insertData(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("insertData", param1, param2);
        else
            service.call("insertData", param1, param2).get();
    }

    /**
     * 133 insertData                Void (String,Value)
     * Inserts a key-value pair into memory, where value is an ALValue
     * key: Name of the value to be inserted.
     * data: The ALValue to be inserted. This could contain a basic type, or a more complex array. See the ALValue documentation for more information.
     */
    public void insertData(String param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("insertData", param1, param2);
        else
            service.call("insertData", param1, param2).get();
    }

    /**
     * 134 insertListData            Void (Value)
     * Inserts a list of key-value pairs into memory.
     * list: An ALValue list of the form [[Key, Value],...]. Each item will be inserted.
     */
    public void insertListData(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("insertListData", param1);
        else
            service.call("insertListData", param1).get();
    }

    /**
     * 135 raiseEvent                Void (String,Value)
     * Publishes the given data to all subscribers.
     * name: Name of the event to raise.
     * value: The data associated with the event. This could contain a basic type, or a more complex array. See the ALValue documentation for more information.
     */
    public void raiseEvent(String param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        service.post("raiseEvent", param1, param2);
    }

    /**
     * 136 raiseMicroEvent           Void (String,Value)
     * Publishes the given data to all subscribers.
     * name: Name of the event to raise.
     * value: The data associated with the event. This could contain a basic type, or a more complex array. See the ALValue documentation for more information.
     */
    public void raiseMicroEvent(String param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("raiseMicroEvent", param1, param2);
        else
            service.call("raiseMicroEvent", param1, param2).get();
    }

    /**
     * 137 removeData                Void (String)
     * Removes a key-value pair from memory
     * key: Name of the data to be removed.
     */
    public void removeData(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeData", param1);
        else
            service.call("removeData", param1).get();
    }

    /**
     * 138 removeEvent               Void (String)
     * Removes a event from memory and unsubscribes any exiting subscribers.
     * name: Name of the event to remove.
     */
    public void removeEvent(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeEvent", param1);
        else
            service.call("removeEvent", param1).get();
    }

    /**
     * 139 removeMicroEvent          Void (String)
     * Removes a micro event from memory and unsubscribes any exiting subscribers.
     * name: Name of the event to remove.
     */
    public void removeMicroEvent(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeMicroEvent", param1);
        else
            service.call("removeMicroEvent", param1).get();
    }

    /**
     * 140 subscribeToEvent          Void (String,String,String)
     * Subscribes to an event and automaticaly launches the module that declared itself as the generator of the event if required.
     * name: The name of the event to subscribe to
     * callbackModule: Name of the module to call with notifications
     * callbackMethod: Name of the module's method to call when a data is changed
     */
    public void subscribeToEvent(String param1, String param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("subscribeToEvent", param1, param2, param3);
        else
            service.call("subscribeToEvent", param1, param2, param3).get();
    }

    public void subscribeToEvent(String event, String signature, Object callback) throws Exception {
        subscriber(event).connect("signal", signature, callback);
    }

    /**
     * 141 subscribeToEvent          Void (String,String,String,String)
     * DEPRECATED Subscribes to event and automaticaly launches the module capable of generating the event if it is not already running. Please use the version without the callbackMessage parameter.
     * name: The name of the event to subscribe to
     * callbackModule: Name of the module to call with notifications
     * callbackMessage: DEPRECATED Message included in the notification.
     * callbacMethod: Name of the module's method to call when a data is changed
     */
    public void subscribeToEvent(String param1, String param2, String param3, String param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("subscribeToEvent", param1, param2, param3, param4);
        else
            service.call("subscribeToEvent", param1, param2, param3, param4).get();
    }

    /**
     * 142 subscribeToMicroEvent     Void (String,String,String,String)
     * Subscribes to a microEvent. Subscribed modules are notified on theircallback method whenever the data is updated, even if the new value is the same as the old value.
     * name: Name of the data.
     * callbackModule: Name of the module to call with notifications
     * callbackMessage: Message included in the notification. This can be used to disambiguate multiple subscriptions.
     * callbackMethod: Name of the module's method to call when a data is changed
     */
    public void subscribeToMicroEvent(String param1, String param2, String param3, String param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("subscribeToMicroEvent", param1, param2, param3, param4);
        else
            service.call("subscribeToMicroEvent", param1, param2, param3, param4).get();
    }

    /**
     * 143 unregisterModuleReference Void (String)
     * Informs ALMemory that a module doesn't exist anymore.
     * moduleName: Name of the departing module.
     */
    public void unregisterModuleReference(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unregisterModuleReference", param1);
        else
            service.call("unregisterModuleReference", param1).get();
    }

    /**
     * 145 unsubscribeToEvent        Void (String,String)
     * Unsubscribes a module from the given event. No further notifications will be received.
     * name: The name of the event
     * callbackModule: The name of the module that was given when subscribing.
     */
    public void unsubscribeToEvent(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unsubscribeToEvent", param1, param2);
        else
            service.call("unsubscribeToEvent", param1, param2).get();
    }

    /**
     * 146 unsubscribeToMicroEvent   Void (String,String)
     * Unsubscribes from the given event. No further notifications will be received.
     * name: Name of the event.
     * callbackModule: The name of the module that was given when subscribing.
     */
    public void unsubscribeToMicroEvent(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unsubscribeToMicroEvent", param1, param2);
        else
            service.call("unsubscribeToMicroEvent", param1, param2).get();
    }

    /**
     * 150 setDescription            Void (String,String)
     * Describe a key
     * name: Name of the key.
     * description: The description of the event (text format).
     */
    public void setDescription(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setDescription", param1, param2);
        else
            service.call("setDescription", param1, param2).get();
    }

    /**
     * 151 getDescriptionList        Value (List<String>)
     * Descriptions of all given keys
     * keylist: List of keys. (empty to get all descriptions)
     * return: an array of tuple (name, type, description) describing all keys.
     */
    public com.aldebaran.qimessaging.Object getDescriptionList(List<String> param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getDescriptionList", param1).get();
    }

    /**
     * 152 addMapping                Void (String,String,String)
     * Add a mapping between signal and event
     * service: Name of the service
     * signal: Name of the signal
     * event: Name of the event
     */
    public void addMapping(String param1, String param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("addMapping", param1, param2, param3);
        else
            service.call("addMapping", param1, param2, param3).get();
    }

    /**
     * 153 addMapping                Void (String,Map<String,String>)
     * Add a mapping between signal and event
     * service: Name of the service
     * signalEvent: A map of signal corresponding to event
     * * Signals:
     */
    public void addMapping(String param1, Map<String, String> param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("addMapping", param1, param2);
        else
            service.call("addMapping", param1, param2).get();
    }


}
    