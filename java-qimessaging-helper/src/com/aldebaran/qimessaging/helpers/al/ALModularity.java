package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALModularity extends ALModule {

    public ALModularity(Session session) {
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
     * 113 getModularity             Unknown ()
     */
    public com.aldebaran.qimessaging.Object getModularity() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModularity").get();
    }

    /**
     * 114 loadProgram               Bool (String)
     * program: The code that will be used by Modularity to generate a part of the graph.
     */
    public Boolean loadProgram(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("loadProgram", param1).get();
    }

    /**
     * 115 loadProgramFromFile       Bool (String)
     */
    public Boolean loadProgramFromFile(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("loadProgramFromFile", param1).get();
    }

    /**
     * 116 getData                   Value (String)
     * sink: The name of the sink from where data must be extracted.
     */
    public com.aldebaran.qimessaging.Object getData(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getData", param1).get();
    }

    /**
     * 117 getLastData               Value (String)
     * sink: The name of the sink from where data must be extracted.
     */
    public com.aldebaran.qimessaging.Object getLastData(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getLastData", param1).get();
    }

    /**
     * 118 getImageLocal             Unknown (String)
     * sink: The name of the sink from where data must be extracted.
     */
    public com.aldebaran.qimessaging.Object getImageLocal(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getImageLocal", param1).get();
    }

    /**
     * 119 getImageRemote            Value (String)
     * sink: The name of the sink from where data must be extracted.
     */
    public com.aldebaran.qimessaging.Object getImageRemote(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getImageRemote", param1).get();
    }

    /**
     * 120 getFilters                Value ()
     */
    public com.aldebaran.qimessaging.Object getFilters() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getFilters").get();
    }

    /**
     * 121 getFilterDescription      String (String)
     * name: The name of the filter.
     */
    public String getFilterDescription(String param1) throws CallError, InterruptedException {
        return (String) service.call("getFilterDescription", param1).get();
    }

    /**
     * 122 getFilterInputs           Value (String)
     * name: The name of the filter.
     */
    public com.aldebaran.qimessaging.Object getFilterInputs(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getFilterInputs", param1).get();
    }

    /**
     * 123 getFilterOutputs          Value (String)
     * name: The name of the filter.
     */
    public com.aldebaran.qimessaging.Object getFilterOutputs(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getFilterOutputs", param1).get();
    }

    /**
     * 124 deleteFilter              Bool (String)
     * name: The name of the filter.
     */
    public Boolean deleteFilter(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("deleteFilter", param1).get();
    }

    /**
     * 125 getSources                List<String> ()
     */
    public List<String> getSources() throws CallError, InterruptedException {
        return (List<String>) service.call("getSources").get();
    }

    /**
     * 126 isSourceBinded            Bool (String)
     * name: The name of the source.
     */
    public Boolean isSourceBinded(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isSourceBinded", param1).get();
    }

    /**
     * 127 getSourceFrequency        Float (String)
     * name: The name of the source.
     */
    public Float getSourceFrequency(String param1) throws CallError, InterruptedException {
        return (Float) service.call("getSourceFrequency", param1).get();
    }

    /**
     * 128 deleteSource              Bool (String)
     * name: The name of the source.
     */
    public Boolean deleteSource(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("deleteSource", param1).get();
    }

    /**
     * 129 getRobotHeightOffset      Float ()
     */
    public Float getRobotHeightOffset() throws CallError, InterruptedException {
        return (Float) service.call("getRobotHeightOffset").get();
    }

    /**
     * 130 setRobotHeightOffset      Bool (Float)
     * heightOffset: Height Offset of the robot from the ground.
     */
    public Boolean setRobotHeightOffset(Float param1) throws CallError, InterruptedException {
        return (Boolean) service.call("setRobotHeightOffset", param1).get();
    }

    /**
     * 131 getProcesses              List<String> ()
     */
    public List<String> getProcesses() throws CallError, InterruptedException {
        return (List<String>) service.call("getProcesses").get();
    }

    /**
     * 132 isProcesses               Bool (String)
     * name: The name of the process.
     */
    public Boolean isProcesses(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isProcesses", param1).get();
    }

    /**
     * 133 getProcessDescription     String (String)
     * name: The name of the process.
     */
    public String getProcessDescription(String param1) throws CallError, InterruptedException {
        return (String) service.call("getProcessDescription", param1).get();
    }

    /**
     * 134 getProcessSources         List<String> (String)
     * name: The name of the process.
     */
    public List<String> getProcessSources(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getProcessSources", param1).get();
    }

    /**
     * 135 getProcessSinks           List<String> (String)
     * name: The name of the process.
     */
    public List<String> getProcessSinks(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getProcessSinks", param1).get();
    }

    /**
     * 136 getProcessAggregatedSinks List<String> (String)
     * name: The name of the process.
     */
    public List<String> getProcessAggregatedSinks(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getProcessAggregatedSinks", param1).get();
    }

    /**
     * 137 getProcessPriority        Int32 (String)
     * name: The name of the process.
     */
    public Integer getProcessPriority(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getProcessPriority", param1).get();
    }

    /**
     * 138 getProcessFrequency       Float (String)
     * name: The name of the process.
     */
    public Float getProcessFrequency(String param1) throws CallError, InterruptedException {
        return (Float) service.call("getProcessFrequency", param1).get();
    }

    /**
     * 139 setProcessPriority        Bool (String,UInt32)
     * name: The name of the process.
     * priority: The new priority of the process.
     */
    public Boolean setProcessPriority(String param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("setProcessPriority", param1, param2).get();
    }

    /**
     * 140 setProcessFrequency       Bool (String,Float)
     * name: The name of the process.
     * priority: The new frequency of the process.
     */
    public Boolean setProcessFrequency(String param1, Float param2) throws CallError, InterruptedException {
        return (Boolean) service.call("setProcessFrequency", param1, param2).get();
    }

    /**
     * 141 resetProcess              Bool (String)
     * name: The name of the process to reset.
     */
    public Boolean resetProcess(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("resetProcess", param1).get();
    }

    /**
     * 142 isProcessEnable           Bool (String)
     * name: The name of the process.
     */
    public Boolean isProcessEnable(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isProcessEnable", param1).get();
    }

    /**
     * 143 isProcessZombie           Bool (String)
     * name: The name of the process.
     */
    public Boolean isProcessZombie(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isProcessZombie", param1).get();
    }

    /**
     * 144 enableProcess             Bool (String)
     * name: The name of the process.
     */
    public Boolean enableProcess(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("enableProcess", param1).get();
    }

    /**
     * 145 disableProcess            Bool (String)
     * name: The name of the process.
     */
    public Boolean disableProcess(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("disableProcess", param1).get();
    }

    /**
     * 146 deleteProcess             Bool (String)
     * name: The name of the process.
     */
    public Boolean deleteProcess(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("deleteProcess", param1).get();
    }

    /**
     * 147 getScheduledJobs          List<String> ()
     */
    public List<String> getScheduledJobs() throws CallError, InterruptedException {
        return (List<String>) service.call("getScheduledJobs").get();
    }

    /**
     * 148 startScheduler            Bool ()
     */
    public Boolean startScheduler() throws CallError, InterruptedException {
        return (Boolean) service.call("startScheduler").get();
    }

    /**
     * 149 stopScheduler             Bool ()
     */
    public Boolean stopScheduler() throws CallError, InterruptedException {
        return (Boolean) service.call("stopScheduler").get();
    }

    /**
     * 150 getInstrumentationResult  String ()
     */
    public String getInstrumentationResult() throws CallError, InterruptedException {
        return (String) service.call("getInstrumentationResult").get();
    }

    /**
     * 151 getDotGraph               Value (String,Int32)
     * filter: The name of the filter to dump.
     * level: Maximum depth (-1 for unlimited depth)
     * * Signals:
     */
    public com.aldebaran.qimessaging.Object getDotGraph(String param1, Integer param2) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getDotGraph", param1, param2).get();
    }


}
    