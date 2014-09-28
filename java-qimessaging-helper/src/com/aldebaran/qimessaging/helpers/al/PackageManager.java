package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class PackageManager extends ALModule {

    public PackageManager(Session session) {
        super(session);
    }

    /**
     * 100 install             Bool (String)
     */
    public Boolean install(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("install", param1).get();
    }

    /**
     * 101 installCheckMd5     Bool (String,String)
     */
    public Boolean installCheckMd5(String param1, String param2) throws CallError, InterruptedException {
        return (Boolean) service.call("installCheckMd5", param1, param2).get();
    }

    /**
     * 104 setServiceDirectory Void (String)
     */
    public void setServiceDirectory(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setServiceDirectory", param1);
        else
            service.call("setServiceDirectory", param1).get();
    }

    /**
     * 105 hasPackage          Bool (String)
     */
    public Boolean hasPackage(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("hasPackage", param1).get();
    }

    /**
     * 106 packages            List<PackageInfo> ()
     */
    public List<Object> packages() throws CallError, InterruptedException {
        return (List<Object>) service.call("packages").get();
    }

    /**
     * 107 package             PackageInfo (String)
     */
    public com.aldebaran.qimessaging.Object qiPackage(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("qiPackage", param1).get();
    }

    /**
     * 108 packageIcon         String (String)
     */
    public String packageIcon(String param1) throws CallError, InterruptedException {
        return (String) service.call("packageIcon", param1).get();
    }

    /**
     * 109 removePkg           Void (String)
     */
    public void removePkg(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removePkg", param1);
        else
            service.call("removePkg", param1).get();
    }

    /**
     * 115 getPackages         Value ()
     */
    public com.aldebaran.qimessaging.Object getPackages() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getPackages").get();
    }

    /**
     * 116 getPackage          Value (String)
     */
    public com.aldebaran.qimessaging.Object getPackage(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getPackage", param1).get();
    }

    /**
     * 117 getPackageIcon      Value (String)
     */
    public com.aldebaran.qimessaging.Object getPackageIcon(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getPackageIcon", param1).get();
    }

    /**
     * 118 install             Int32 (String,String)
     */
    public Integer install(String param1, String param2) throws CallError, InterruptedException {
        return (Integer) service.call("install", param1, param2).get();
    }

    /**
     * 119 install             Int32 (String,String,String)
     */
    public Integer install(String param1, String param2, String param3) throws CallError, InterruptedException {
        return (Integer) service.call("install", param1, param2, param3).get();
    }

    /**
     * 120 remove              Int32 (String)
     * * Signals:
     * 113 onPackageInstalled (PackageInfo)
     */
    public Integer remove(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("remove", param1).get();
    }

    /**
     * 114 onPackageRemoved   (PackageInfo)
     */
    public void onPackageRemoved(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("onPackageRemoved", param1);
        else
            service.call("onPackageRemoved", param1).get();
    }

    /**
     * 123 packageInstalled   (PackageInfo)
     */
    public void packageInstalled(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("packageInstalled", param1);
        else
            service.call("packageInstalled", param1).get();
    }

    /**
     * 124 packageRemoved     (PackageInfo)
     */
    public void packageRemoved(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("packageRemoved", param1);
        else
            service.call("packageRemoved", param1).get();
    }


}
    