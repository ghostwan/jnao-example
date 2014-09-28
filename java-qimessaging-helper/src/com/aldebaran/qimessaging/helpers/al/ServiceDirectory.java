package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ServiceDirectory extends ALModule {

    public ServiceDirectory(Session session) {
        super(session);
    }

    /**
     * 100 service           ServiceInfo (String)
     */
    public com.aldebaran.qimessaging.Object service(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("service", param1).get();
    }

    /**
     * 101 services          List<ServiceInfo> ()
     */
    public List<Object> services() throws CallError, InterruptedException {
        return (List<Object>) service.call("services").get();
    }

    /**
     * 102 registerService   UInt32 (ServiceInfo)
     */
    public Integer registerService(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        return (Integer) service.call("registerService", param1).get();
    }

    /**
     * 103 unregisterService Void (UInt32)
     */
    public void unregisterService(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unregisterService", param1);
        else
            service.call("unregisterService", param1).get();
    }

    /**
     * 104 serviceReady      Void (UInt32)
     */
    public void serviceReady(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("serviceReady", param1);
        else
            service.call("serviceReady", param1).get();
    }

    /**
     * 105 updateServiceInfo Void (ServiceInfo)
     */
    public void updateServiceInfo(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("updateServiceInfo", param1);
        else
            service.call("updateServiceInfo", param1).get();
    }

    /**
     * 108 machineId         String ()
     * * Signals:
     */
    public String machineId() throws CallError, InterruptedException {
        return (String) service.call("machineId").get();
    }

    /**
     * 106 serviceAdded   (UInt32,String)
     * 107 serviceRemoved (UInt32,String)
     */
    public void serviceAdded(Integer param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("serviceAdded", param1, param2);
        else
            service.call("serviceAdded", param1, param2).get();
    }


}
    