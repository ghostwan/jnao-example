package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALAnimatedSpeech extends ALModule {

    public ALAnimatedSpeech(Session session) {
        super(session);
    }

    /**
     * 100 exit                       Void ()
     * Exits and unregisters the module.
     * 102 pCall                      Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version                    String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                       Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList              List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp              Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp              Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                       Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning                  Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                       Void (Int32)
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
     * 111 getBrokerName              String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage                   String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 say                        Void (String)
     * Say the annotated text given in parameter and animate it with animations inserted in the text.
     * text: An annotated text (for example: "Hello. ^start(Hey_1) My name is NAO").
     */
    public void say(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("say", param1);
        else
            service.call("say", param1).get();
    }

    /**
     * 114 say                        Void (String,Value)
     * Say the annotated text given in parameter and animate it with animations inserted in the text.
     * text: An annotated text (for example: "Hello. ^start(Hey_1) My name is NAO").
     * configuration: The animated speech configuration.
     */
    public void say(String param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("say", param1, param2);
        else
            service.call("say", param1, param2).get();
    }

    /**
     * 118 setBodyTalkEnabled         Void (Bool)
     * DEPRECATED since 1.18: use setBodyLanguageMode instead.Enable or disable the automatic body talk on the speech.If it is enabled, anywhere you have not annotate your text with animation,the robot will fill the gap with automatically calculated gestures.If it is disabled, the robot will move only where you annotate it withanimations.
     * enable: The boolean value: true to enable, false to disable.
     */
    public void setBodyTalkEnabled(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setBodyTalkEnabled", param1);
        else
            service.call("setBodyTalkEnabled", param1).get();
    }

    /**
     * 119 setBodyLanguageEnabled     Void (Bool)
     * DEPRECATED since 1.22: use setBodyLanguageMode instead.Enable or disable the automatic body language on the speech.If it is enabled, anywhere you have not annotate your text with animation,the robot will fill the gap with automatically calculated gestures.If it is disabled, the robot will move only where you annotate it withanimations.
     * enable: The boolean value: true to enable, false to disable.
     */
    public void setBodyLanguageEnabled(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setBodyLanguageEnabled", param1);
        else
            service.call("setBodyLanguageEnabled", param1).get();
    }

    /**
     * 120 setBodyLanguageModeFromStr Void (String)
     * Set the current body language mode.
     * 3 modes exist: "disabled", "random" and "contextual"
     * (see BodyLanguageMode enum for more details)
     * stringBodyLanguageMode: The choosen body language mode.
     */
    public void setBodyLanguageModeFromStr(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setBodyLanguageModeFromStr", param1);
        else
            service.call("setBodyLanguageModeFromStr", param1).get();
    }

    /**
     * 121 setBodyLanguageMode        Void (UInt32)
     * Set the current body language mode.
     * 3 modes exist: BODY_LANGUAGE_MODE_DISABLED,BODY_LANGUAGE_MODE_RANDOM and BODY_LANGUAGE_MODE_CONTEXTUAL
     * (see BodyLanguageMode enum for more details)
     * bodyLanguageMode: The choosen body language mode.
     */
    public void setBodyLanguageMode(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setBodyLanguageMode", param1);
        else
            service.call("setBodyLanguageMode", param1).get();
    }

    /**
     * 122 getBodyLanguageModeToStr   String ()
     * Set the current body language mode.
     * 3 modes exist: "disabled", "random" and "contextual"
     * (see BodyLanguageMode enum for more details)
     * return: The current body language mode.
     */
    public String getBodyLanguageModeToStr() throws CallError, InterruptedException {
        return (String) service.call("getBodyLanguageModeToStr").get();
    }

    /**
     * 123 getBodyLanguageMode        UInt32 ()
     * Set the current body language mode.
     * 3 modes exist: BODY_LANGUAGE_MODE_DISABLED,BODY_LANGUAGE_MODE_RANDOM and BODY_LANGUAGE_MODE_CONTEXTUAL
     * (see BodyLanguageMode enum for more details)
     * return: The current body language mode.
     */
    public Integer getBodyLanguageMode() throws CallError, InterruptedException {
        return (Integer) service.call("getBodyLanguageMode").get();
    }

    /**
     * 124 declareAnimationsPackage   Void (String)
     * Add a new package that contains animations.
     * animationsPackage: The new package that contains animations.
     */
    public void declareAnimationsPackage(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("declareAnimationsPackage", param1);
        else
            service.call("declareAnimationsPackage", param1).get();
    }

    /**
     * 129 addTagsToWords             Void (Value)
     * Add some new links between tags and words.
     * tagsToWords: Map of tags to words.
     */
    public void addTagsToWords(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("addTagsToWords", param1);
        else
            service.call("addTagsToWords", param1).get();
    }

    /**
     * 131 isBodyTalkEnabled          Bool ()
     * DEPRECATED since 1.18: use getBodyLanguageMode instead.Indicate if the body talk is enabled or not.
     * return: The boolean value: true means it is enabled, false means it is disabled.
     */
    public Boolean isBodyTalkEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("isBodyTalkEnabled").get();
    }

    /**
     * 132 isBodyLanguageEnabled      Bool ()
     * DEPRECATED since 1.22: use getBodyLanguageMode instead.Indicate if the body language is enabled or not.
     * return: The boolean value: true means it is enabled, false means it is disabled.
     * * Signals:
     */
    public Boolean isBodyLanguageEnabled() throws CallError, InterruptedException {
        return (Boolean) service.call("isBodyLanguageEnabled").get();
    }


}
    