package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALWorldRepresentation extends ALModule {

    public ALWorldRepresentation(Session session) {
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
     * 113 addAttributeToCategory      Int32 (String,String,Value)
     * Add an attribute to a category.
     */
    public Integer addAttributeToCategory(String param1, String param2, com.aldebaran.qimessaging.Object param3) throws CallError, InterruptedException {
        return (Integer) service.call("addAttributeToCategory", param1, param2, param3).get();
    }

    /**
     * 114 clearObject                 Int32 (String)
     * Clear an object.
     */
    public Integer clearObject(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("clearObject", param1).get();
    }

    /**
     * 115 clearOldPositions           Int32 (String,Int32)
     * Clear recording of old positions.
     */
    public Integer clearOldPositions(String param1, Integer param2) throws CallError, InterruptedException {
        return (Integer) service.call("clearOldPositions", param1, param2).get();
    }

    /**
     * 116 createObjectCategory        Int32 (String,Bool)
     * Create a new object category
     */
    public Integer createObjectCategory(String param1, Boolean param2) throws CallError, InterruptedException {
        return (Integer) service.call("createObjectCategory", param1, param2).get();
    }

    /**
     * 117 removeObjectCategory        Int32 (String)
     * Remove an object category
     */
    public Integer removeObjectCategory(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("removeObjectCategory", param1).get();
    }

    /**
     * 118 deleteObjectAttribute       Int32 (String,String,String)
     * Delete an object attribute
     */
    public Integer deleteObjectAttribute(String param1, String param2, String param3) throws CallError, InterruptedException {
        return (Integer) service.call("deleteObjectAttribute", param1, param2, param3).get();
    }

    /**
     * 119 findObject                  Bool (String)
     * Check that an object is present.
     */
    public Boolean findObject(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("findObject", param1).get();
    }

    /**
     * 120 load                        Int32 ()
     */
    public Integer load() throws CallError, InterruptedException {
        return (Integer) service.call("load").get();
    }

    /**
     * 121 getAttributesFromCategory   Value (String)
     * Get all attributes from a category if it exists.
     */
    public com.aldebaran.qimessaging.Object getAttributesFromCategory(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getAttributesFromCategory", param1).get();
    }

    /**
     * 122 getChildrenNames            List<String> (String)
     * Get the direct children of an object.
     */
    public List<String> getChildrenNames(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getChildrenNames", param1).get();
    }

    /**
     * 123 getObjectNames              List<String> ()
     * Get the name of the objects.
     */
    public List<String> getObjectNames() throws CallError, InterruptedException {
        return (List<String>) service.call("getObjectNames").get();
    }

    /**
     * 124 getObjectAttributes         Value (String)
     */
    public com.aldebaran.qimessaging.Object getObjectAttributes(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getObjectAttributes", param1).get();
    }

    /**
     * 125 getObjectAttributeValues    Value (String,String,Int32)
     */
    public com.aldebaran.qimessaging.Object getObjectAttributeValues(String param1, String param2, Integer param3) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getObjectAttributeValues", param1, param2, param3).get();
    }

    /**
     * 126 getObjectLatestAttributes   Value (String,Int32)
     */
    public com.aldebaran.qimessaging.Object getObjectLatestAttributes(String param1, Integer param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getObjectLatestAttributes", param1, param2).get();
    }

    /**
     * 127 getObjectParentName         String (String)
     */
    public String getObjectParentName(String param1) throws CallError, InterruptedException {
        return (String) service.call("getObjectParentName", param1).get();
    }

    /**
     * 128 getObjectsInCategory        List<String> (String)
     * Get the name of the objects stored in the database.
     */
    public List<String> getObjectsInCategory(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getObjectsInCategory", param1).get();
    }

    /**
     * 129 getObjectCategory           String (String)
     * Get the name of the database where the object is stored.
     */
    public String getObjectCategory(String param1) throws CallError, InterruptedException {
        return (String) service.call("getObjectCategory", param1).get();
    }

    /**
     * 130 getPosition                 Value (String,String)
     * Get the position of an object with quaternion / translation.
     */
    public com.aldebaran.qimessaging.Object getPosition(String param1, String param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getPosition", param1, param2).get();
    }

    /**
     * 131 getPosition6D               List<Float> (String,String)
     * Get the position from one object to another.
     */
    public List<Float> getPosition6D(String param1, String param2) throws CallError, InterruptedException {
        return (List<Float>) service.call("getPosition6D", param1, param2).get();
    }

    /**
     * 132 getPosition6DAtTime         List<Float> (String,String,Int32,Int32)
     * Get the interpolated position of an object
     */
    public List<Float> getPosition6DAtTime(String param1, String param2, Integer param3, Integer param4) throws CallError, InterruptedException {
        return (List<Float>) service.call("getPosition6DAtTime", param1, param2, param3, param4).get();
    }

    /**
     * 133 getRootName                 String ()
     */
    public String getRootName() throws CallError, InterruptedException {
        return (String) service.call("getRootName").get();
    }

    /**
     * 134 save                        Int32 ()
     */
    public Integer save() throws CallError, InterruptedException {
        return (Integer) service.call("save").get();
    }

    /**
     * 135 select                      Value (String,String,String,String)
     * Select information from a database.
     */
    public com.aldebaran.qimessaging.Object select(String param1, String param2, String param3, String param4) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("select", param1, param2, param3, param4).get();
    }

    /**
     * 136 selectWithOrder             Value (String,String,String,String,String)
     * Select ordered information from a database.
     */
    public com.aldebaran.qimessaging.Object selectWithOrder(String param1, String param2, String param3, String param4, String param5) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("selectWithOrder", param1, param2, param3, param4, param5).get();
    }

    /**
     * 137 storeObject                 Int32 (String,String,List<Float>,String,Value)
     */
    public Integer storeObject(String param1, String param2, List<Float> param3, String param4, com.aldebaran.qimessaging.Object param5) throws CallError, InterruptedException {
        return (Integer) service.call("storeObject", param1, param2, param3, param4, param5).get();
    }

    /**
     * 138 storeObjectWithReference    Int32 (String,String,String,List<Float>,String,Value)
     */
    public Integer storeObjectWithReference(String param1, String param2, String param3, List<Float> param4, String param5, com.aldebaran.qimessaging.Object param6) throws CallError, InterruptedException {
        return (Integer) service.call("storeObjectWithReference", param1, param2, param3, param4, param5, param6).get();
    }

    /**
     * 139 storeObjectAttribute        Int32 (String,String,Value)
     */
    public Integer storeObjectAttribute(String param1, String param2, com.aldebaran.qimessaging.Object param3) throws CallError, InterruptedException {
        return (Integer) service.call("storeObjectAttribute", param1, param2, param3).get();
    }

    /**
     * 140 updatePosition              Int32 (String,List<Float>,Bool)
     * Update the position of an object.
     */
    public Integer updatePosition(String param1, List<Float> param2, Boolean param3) throws CallError, InterruptedException {
        return (Integer) service.call("updatePosition", param1, param2, param3).get();
    }

    /**
     * 141 updatePositionWithReference Int32 (String,String,List<Float>,Bool)
     * Update the position of an object relative to another.
     */
    public Integer updatePositionWithReference(String param1, String param2, List<Float> param3, Boolean param4) throws CallError, InterruptedException {
        return (Integer) service.call("updatePositionWithReference", param1, param2, param3, param4).get();
    }

    /**
     * 142 updateAttribute             Int32 (String,String,String,Value)
     * * Signals:
     */
    public Integer updateAttribute(String param1, String param2, String param3, com.aldebaran.qimessaging.Object param4) throws CallError, InterruptedException {
        return (Integer) service.call("updateAttribute", param1, param2, param3, param4).get();
    }


}
    