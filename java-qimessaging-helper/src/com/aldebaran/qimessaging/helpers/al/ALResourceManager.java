package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALResourceManager extends ALModule {

    public ALResourceManager(Session session) {
        super(session);
    }

    /**
     * 100 exit                         Void ()
     * Exits and unregisters the module.
     * 102 pCall                        Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version                      String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                         Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList                List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp                Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp                Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                         Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning                    Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                         Void (Int32)
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
     * 111 getBrokerName                String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage                     String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 waitForResource              Void (String,String,String,Int32)
     * Wait resource
     * resourceName: Resource name
     * ownerName: Module name
     * callbackName: callback name
     * timeoutSeconds: Timeout in seconds
     */
    public void waitForResource(String param1, String param2, String param3, Integer param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("waitForResource", param1, param2, param3, param4);
        else
            service.call("waitForResource", param1, param2, param3, param4).get();
    }

    /**
     * 114 acquireResource              Void (String,String,String,Int32)
     * Wait and acquire a resource
     * resourceName: Resource name
     * moduleName: Module name
     * callbackName: callback name
     * timeoutSeconds: Timeout in seconds
     */
    public void acquireResource(String param1, String param2, String param3, Integer param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("acquireResource", param1, param2, param3, param4);
        else
            service.call("acquireResource", param1, param2, param3, param4).get();
    }

    /**
     * 115 waitForOptionalResourcesTree List<String> (List<String>,String,String,Int32,List<String>)
     * Wait resource
     */
    public List<String> waitForOptionalResourcesTree(List<String> param1, String param2, String param3, Integer param4, List<String> param5) throws CallError, InterruptedException {
        return (List<String>) service.call("waitForOptionalResourcesTree", param1, param2, param3, param4, param5).get();
    }

    /**
     * 116 waitForResourcesTree         Void (List<String>,String,String,Int32)
     * Wait for resource tree. Parent and children are not in conflict. Local function
     * resourceName: Resource name
     * moduleName: Module name
     * callbackName: callback name
     * timeoutSeconds: Timeout in seconds
     */
    public void waitForResourcesTree(List<String> param1, String param2, String param3, Integer param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("waitForResourcesTree", param1, param2, param3, param4);
        else
            service.call("waitForResourcesTree", param1, param2, param3, param4).get();
    }

    /**
     * 117 acquireResourcesTree         Void (List<String>,String,String,Int32)
     * Wait for resource tree. Parent and children are not in conflict. Local function
     * resourceName: Resource name
     * moduleName: Module name
     * callbackName: callback name
     * timeoutSeconds: Timeout in seconds
     */
    public void acquireResourcesTree(List<String> param1, String param2, String param3, Integer param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("acquireResourcesTree", param1, param2, param3, param4);
        else
            service.call("acquireResourcesTree", param1, param2, param3, param4).get();
    }

    /**
     * 118 areResourcesOwnedBy          Bool (List<String>,String)
     * True if all the specified resources are owned by the owner
     * resourceNameList: Resource name
     * ownerName: Owner pointer with hierarchy
     * return: True if all the specify resources are owned by the owner
     */
    public Boolean areResourcesOwnedBy(List<String> param1, String param2) throws CallError, InterruptedException {
        return (Boolean) service.call("areResourcesOwnedBy", param1, param2).get();
    }

    /**
     * 119 releaseResource              Void (String,String)
     * Release resource
     * resourceName: Resource name
     * ownerName: Existing owner name
     */
    public void releaseResource(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("releaseResource", param1, param2);
        else
            service.call("releaseResource", param1, param2).get();
    }

    /**
     * 120 releaseResources             Void (List<String>,String)
     * Release  resources list
     * resourceNames: Resource names
     * ownerName: Owner name
     */
    public void releaseResources(List<String> param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("releaseResources", param1, param2);
        else
            service.call("releaseResources", param1, param2).get();
    }

    /**
     * 121 enableStateResource          Void (String,Bool)
     * Enable or disable a state resource
     * resourceName: The name of the resource that you wish enable of disable. e.g. Standing
     * enabled: True to enable, false to disable
     */
    public void enableStateResource(String param1, Boolean param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("enableStateResource", param1, param2);
        else
            service.call("enableStateResource", param1, param2).get();
    }

    /**
     * 122 checkStateResourceFree       Bool (List<String>)
     * check if all the state resource in the list are free
     * resourceName: Resource name
     */
    public Boolean checkStateResourceFree(List<String> param1) throws CallError, InterruptedException {
        return (Boolean) service.call("checkStateResourceFree", param1).get();
    }

    /**
     * 123 areResourcesFree             Bool (List<String>)
     * True if all resources are free
     * resourceNames: Resource names
     * return: True if all the specify resources are free
     */
    public Boolean areResourcesFree(List<String> param1) throws CallError, InterruptedException {
        return (Boolean) service.call("areResourcesFree", param1).get();
    }

    /**
     * 124 isResourceFree               Bool (String)
     * True if the resource is free
     * resourceNames: Resource name
     * return: True if the specify resources is free
     */
    public Boolean isResourceFree(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isResourceFree", param1).get();
    }

    /**
     * 125 createResource               Void (String,String)
     * Create a resource
     * resourceName: Resource name to create
     * parentResourceName: Parent resource name or empty string for root resource
     */
    public void createResource(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("createResource", param1, param2);
        else
            service.call("createResource", param1, param2).get();
    }

    /**
     * 126 deleteResource               Void (String,Bool)
     * Delete a root resource
     * resourceName: Resource name to delete
     * deleteChildResources: DEPRECATED: Delete child resources if true
     */
    public void deleteResource(String param1, Boolean param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("deleteResource", param1, param2);
        else
            service.call("deleteResource", param1, param2).get();
    }

    /**
     * 127 isInGroup                    Bool (String,String)
     * True if a resource is in another parent resource
     * resourceGroupName: Group name. Ex: Arm
     * resourceName: Resource name
     */
    public Boolean isInGroup(String param1, String param2) throws CallError, InterruptedException {
        return (Boolean) service.call("isInGroup", param1, param2).get();
    }

    /**
     * 128 createResourcesList          Void (List<String>,String)
     * True if a resource is in another parent resource
     * resourceGroupName: Group name. Ex: Arm
     * resourceName: Resource name
     */
    public void createResourcesList(List<String> param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("createResourcesList", param1, param2);
        else
            service.call("createResourcesList", param1, param2).get();
    }

    /**
     * 129 getResources                 Value ()
     * Get tree of resources
     */
    public com.aldebaran.qimessaging.Object getResources() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getResources").get();
    }

    /**
     * 130 ownersGet                    Value ()
     * The tree of the resources owners.
     * * Signals:
     */
    public com.aldebaran.qimessaging.Object ownersGet() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("ownersGet").get();
    }


}
    