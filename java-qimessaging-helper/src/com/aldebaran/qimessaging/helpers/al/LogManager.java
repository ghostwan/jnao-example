package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

/**
 * Created by erwan on 01/05/2014.
 */
public class LogManager extends ALModule {

    public LogManager(Session session) {
        super(session);
    }

    /**
     * 100 log            Void (LogMessage)
     */
    public void log(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("log", param1);
        else
            service.call("log", param1).get();
    }

    /**
     * 101 getListener    Object ()
     */
    public com.aldebaran.qimessaging.Object getListener() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getListener").get();
    }

    /**
     * 102 addProvider    Int32 (Object)
     */
    public Integer addProvider(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        return (Integer) service.call("addProvider", param1).get();
    }

    /**
     * 103 removeProvider Void (Int32)
     * * Signals:
     */
    public void removeProvider(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeProvider", param1);
        else
            service.call("removeProvider", param1).get();
    }


}
    