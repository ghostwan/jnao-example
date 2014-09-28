package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALDialog extends ALModule {

    public ALDialog(Session session) {
        super(session);
    }

    /**
     * 100 exit                           Void ()
     * Exits and unregisters the module.
     * 102 pCall                          Value Value
     * NAOqi1 pCall method.
     */
    public void exit() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("exit");
        else
            service.call("exit").get();
    }

    /**
     * 103 version                        String ()
     * Returns the version of the module.
     * return: A string containing the version of the module.
     */
    public String version() throws CallError, InterruptedException {
        return (String) service.call("version").get();
    }

    /**
     * 104 ping                           Bool ()
     * Just a ping. Always returns true
     * return: returns true
     */
    public Boolean ping() throws CallError, InterruptedException {
        return (Boolean) service.call("ping").get();
    }

    /**
     * 105 getMethodList                  List<String> ()
     * Retrieves the module's method list.
     * return: An array of method names.
     */
    public List<String> getMethodList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMethodList").get();
    }

    /**
     * 106 getMethodHelp                  Value (String)
     * Retrieves a method's description.
     * methodName: The name of the method.
     * return: A structure containing the method's description.
     */
    public com.aldebaran.qimessaging.Object getMethodHelp(String param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getMethodHelp", param1).get();
    }

    /**
     * 107 getModuleHelp                  Value ()
     * Retrieves the module's description.
     * return: A structure describing the module.
     */
    public com.aldebaran.qimessaging.Object getModuleHelp() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getModuleHelp").get();
    }

    /**
     * 108 wait                           Bool (Int32,Int32)
     * Wait for the end of a long running method that was called using 'post'
     * id: The ID of the method that was returned when calling the method using 'post'
     * timeoutPeriod: The timeout period in ms. To wait indefinately, use a timeoutPeriod of zero.
     * return: True if the timeout period terminated. False if the method returned.
     */
    public Boolean wait(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("wait", param1, param2).get();
    }

    /**
     * 109 isRunning                      Bool (Int32)
     * Returns true if the method is currently running.
     * id: The ID of the method that was returned when calling the method using 'post'
     * return: True if the method is currently running
     */
    public Boolean isRunning(Integer param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isRunning", param1).get();
    }

    /**
     * 110 stop                           Void (Int32)
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
     * 111 getBrokerName                  String ()
     * Gets the name of the parent broker.
     * return: The name of the parent broker.
     */
    public String getBrokerName() throws CallError, InterruptedException {
        return (String) service.call("getBrokerName").get();
    }

    /**
     * 112 getUsage                       String (String)
     * Gets the method usage string. This summarises how to use the method.
     * name: The name of the method.
     * return: A string that summarises the usage of the method.
     */
    public String getUsage(String param1) throws CallError, InterruptedException {
        return (String) service.call("getUsage", param1).get();
    }

    /**
     * 113 subscribe                      Void (String,Int32,Float)
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
     * 114 subscribe                      Void (String)
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
     * 115 unsubscribe                    Void (String)
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
     * 116 updatePeriod                   Void (String,Int32)
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
     * 117 updatePrecision                Void (String,Float)
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
     * 118 getCurrentPeriod               Int32 ()
     * Gets the current period.
     * return: Refresh period (in milliseconds).
     */
    public Integer getCurrentPeriod() throws CallError, InterruptedException {
        return (Integer) service.call("getCurrentPeriod").get();
    }

    /**
     * 119 getCurrentPrecision            Float ()
     * Gets the current precision.
     * return: Precision of the extractor.
     */
    public Float getCurrentPrecision() throws CallError, InterruptedException {
        return (Float) service.call("getCurrentPrecision").get();
    }

    /**
     * 120 getMyPeriod                    Int32 (String)
     * Gets the period for a specific subscription.
     * name: Name of the module which has subscribed.
     * return: Refresh period (in milliseconds).
     */
    public Integer getMyPeriod(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getMyPeriod", param1).get();
    }

    /**
     * 121 getMyPrecision                 Float (String)
     * Gets the precision for a specific subscription.
     * name: name of the module which has subscribed
     * return: precision of the extractor
     */
    public Float getMyPrecision(String param1) throws CallError, InterruptedException {
        return (Float) service.call("getMyPrecision", param1).get();
    }

    /**
     * 122 getSubscribersInfo             Value ()
     * Gets the parameters given by the module.
     * return: Array of names and parameters of all subscribers.
     */
    public com.aldebaran.qimessaging.Object getSubscribersInfo() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("getSubscribersInfo").get();
    }

    /**
     * 123 getOutputNames                 List<String> ()
     * Get the list of values updated in ALMemory.
     * return: Array of values updated by this extractor in ALMemory
     */
    public List<String> getOutputNames() throws CallError, InterruptedException {
        return (List<String>) service.call("getOutputNames").get();
    }

    /**
     * 124 getEventList                   List<String> ()
     * Get the list of events updated in ALMemory.
     * return: Array of events updated by this extractor in ALMemory
     */
    public List<String> getEventList() throws CallError, InterruptedException {
        return (List<String>) service.call("getEventList").get();
    }

    /**
     * 125 getMemoryKeyList               List<String> ()
     * Get the list of events updated in ALMemory.
     * return: Array of events updated by this extractor in ALMemory
     */
    public List<String> getMemoryKeyList() throws CallError, InterruptedException {
        return (List<String>) service.call("getMemoryKeyList").get();
    }

    /**
     * 126 wordRecognized                 Void (String,Value,String)
     * Callback when speech recognition recognized a word
     */
    public void wordRecognized(String param1, com.aldebaran.qimessaging.Object param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("wordRecognized", param1, param2, param3);
        else
            service.call("wordRecognized", param1, param2, param3).get();
    }

    /**
     * 127 addBlockingEvent               Void (String)
     * Callback when speech recognition recognized a word
     */
    public void addBlockingEvent(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("addBlockingEvent", param1);
        else
            service.call("addBlockingEvent", param1).get();
    }

    /**
     * 128 wordsRecognizedCallback        Void (Value,Int32)
     * Get loaded dialog list
     */
    public void wordsRecognizedCallback(com.aldebaran.qimessaging.Object param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("wordsRecognizedCallback", param1, param2);
        else
            service.call("wordsRecognizedCallback", param1, param2).get();
    }

    /**
     * 129 endOfUtteranceCallback         Bool ()
     * End of utterance callback
     */
    public Boolean endOfUtteranceCallback() throws CallError, InterruptedException {
        return (Boolean) service.call("endOfUtteranceCallback").get();
    }

    /**
     * 130 eventReceived                  Void (String,Value,String)
     * Callback when dialog received a event
     */
    public void eventReceived(String param1, com.aldebaran.qimessaging.Object param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("eventReceived", param1, param2, param3);
        else
            service.call("eventReceived", param1, param2, param3).get();
    }

    /**
     * 131 statusChanged                  Void (String,Value,String)
     * Callback when ASR status changes
     */
    public void statusChanged(String param1, com.aldebaran.qimessaging.Object param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("statusChanged", param1, param2, param3);
        else
            service.call("statusChanged", param1, param2, param3).get();
    }

    /**
     * 132 gotoTag                        Void (String,String)
     * Callback when ASR status changes
     */
    public void gotoTag(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("gotoTag", param1, param2);
        else
            service.call("gotoTag", param1, param2).get();
    }

    /**
     * 133 noPick                         Void (String)
     * noPick
     */
    public void noPick(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("noPick", param1);
        else
            service.call("noPick", param1).get();
    }

    /**
     * 134 connectionChanged              Void (String,Value,String)
     * Callback when remote connection changes
     */
    public void connectionChanged(String param1, com.aldebaran.qimessaging.Object param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("connectionChanged", param1, param2, param3);
        else
            service.call("connectionChanged", param1, param2, param3).get();
    }

    /**
     * 135 compileAll                     Void ()
     * compile all for ASR
     */
    public void compileAll() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("compileAll");
        else
            service.call("compileAll").get();
    }

    /**
     * 136 loadTopic                      String (String)
     * Load a topic
     */
    public String loadTopic(String param1) throws CallError, InterruptedException {
        return (String) service.call("loadTopic", param1).get();
    }

    /**
     * 137 deactivateTopic                Void (String)
     * Activate a topic
     */
    public void deactivateTopic(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("deactivateTopic", param1);
        else
            service.call("deactivateTopic", param1).get();
    }

    /**
     * 138 activateTopic                  Void (String)
     * Activate a topic
     */
    public void activateTopic(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("activateTopic", param1);
        else
            service.call("activateTopic", param1).get();
    }

    /**
     * 139 unloadTopic                    Void (String)
     * unload a dialog
     */
    public void unloadTopic(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unloadTopic", param1);
        else
            service.call("unloadTopic", param1).get();
    }

    /**
     * 140 forceOutput                    Void ()
     * Get a proposal
     */
    public void forceOutput() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("forceOutput");
        else
            service.call("forceOutput").get();
    }

    /**
     * 141 forceInput                     Void (String)
     * Give a sentence to the dialog and get the answer
     */
    public void forceInput(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("forceInput", param1);
        else
            service.call("forceInput", param1).get();
    }

    /**
     * 142 tell                           Void (String)
     * Give a sentence to the dialog and get the answer
     */
    public void tell(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("tell", param1);
        else
            service.call("tell", param1).get();
    }

    /**
     * 143 setASRConfidenceThreshold      Void (Float)
     * Set the minimum confidence required to recognize words
     */
    public void setASRConfidenceThreshold(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setASRConfidenceThreshold", param1);
        else
            service.call("setASRConfidenceThreshold", param1).get();
    }

    /**
     * 144 getASRConfidenceThreshold      Float ()
     * Get the minimum confidence required to recognize words
     */
    public Float getASRConfidenceThreshold() throws CallError, InterruptedException {
        return (Float) service.call("getASRConfidenceThreshold").get();
    }

    /**
     * 148 openSession                    Void (Int32)
     * Open a session
     */
    public void openSession(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("openSession", param1);
        else
            service.call("openSession", param1).get();
    }

    /**
     * 149 closeSession                   Void ()
     * Close the session
     */
    public void closeSession() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("closeSession");
        else
            service.call("closeSession").get();
    }

    /**
     * 151 setDelay                       Void (String,Int32)
     * change event's delay
     */
    public void setDelay(String param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setDelay", param1, param2);
        else
            service.call("setDelay", param1, param2).get();
    }

    /**
     * 152 setNumberOfScopes              Void (Int32)
     * Set how many scopes remains open
     */
    public void setNumberOfScopes(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setNumberOfScopes", param1);
        else
            service.call("setNumberOfScopes", param1).get();
    }

    /**
     * 153 setConcept                     Void (String,String,List<String>)
     * Set the content of a dynamic concept
     * conceptName: Name of the concept
     * language: Language of the concept
     * content: content of the concept
     */
    public void setConcept(String param1, String param2, List<String> param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setConcept", param1, param2, param3);
        else
            service.call("setConcept", param1, param2, param3).get();
    }

    /**
     * 154 setConcept                     Void (String,String,List<String>,Bool)
     * Set the content of a dynamic concept
     * conceptName: Name of the concept
     * language: Language of the concept
     * content: content of the concept
     * store: determine if the concept will be save in the database
     */
    public void setConcept(String param1, String param2, List<String> param3, Boolean param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setConcept", param1, param2, param3, param4);
        else
            service.call("setConcept", param1, param2, param3, param4).get();
    }

    /**
     * 155 setConceptKeepInCache          Void (String,String,List<String>)
     * set the content of a dynamic concept
     */
    public void setConceptKeepInCache(String param1, String param2, List<String> param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setConceptKeepInCache", param1, param2, param3);
        else
            service.call("setConceptKeepInCache", param1, param2, param3).get();
    }

    /**
     * 156 setPushMode                    Void (Int32)
     * Set push mode
     */
    public void setPushMode(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setPushMode", param1);
        else
            service.call("setPushMode", param1).get();
    }

    /**
     * 157 startPush                      Void ()
     * Start push mode
     */
    public void startPush() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startPush");
        else
            service.call("startPush").get();
    }

    /**
     * 158 stopPush                       Void ()
     * Stop push mode
     */
    public void stopPush() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopPush");
        else
            service.call("stopPush").get();
    }

    /**
     * 159 setAnimatedSpeechConfiguration Void (Value)
     * Set the configuration of animated speech for the current dialog.
     */
    public void setAnimatedSpeechConfiguration(com.aldebaran.qimessaging.Object param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setAnimatedSpeechConfiguration", param1);
        else
            service.call("setAnimatedSpeechConfiguration", param1).get();
    }

    /**
     * 160 applicationBlackList           Void (List<String>)
     * Black list a list of application
     */
    public void applicationBlackList(List<String> param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("applicationBlackList", param1);
        else
            service.call("applicationBlackList", param1).get();
    }

    /**
     * 161 isContentNeedsUpdate           Bool ()
     * True if new content was installed
     */
    public Boolean isContentNeedsUpdate() throws CallError, InterruptedException {
        return (Boolean) service.call("isContentNeedsUpdate").get();
    }

    /**
     * 176 setVariablePath                Void (String,String,String)
     * setVariablePath
     */
    public void setVariablePath(String param1, String param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setVariablePath", param1, param2, param3);
        else
            service.call("setVariablePath", param1, param2, param3).get();
    }

    /**
     * 177 setLanguage                    Void (String)
     * setLanguage
     */
    public void setLanguage(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setLanguage", param1);
        else
            service.call("setLanguage", param1).get();
    }

    /**
     * 178 startUpdate                    Void (String,Value,String)
     * startUpdate
     */
    public void startUpdate(String param1, com.aldebaran.qimessaging.Object param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startUpdate", param1, param2, param3);
        else
            service.call("startUpdate", param1, param2, param3).get();
    }

    /**
     * 179 startApp                       Void (String,Value,String)
     * startUpdate
     */
    public void startApp(String param1, com.aldebaran.qimessaging.Object param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startApp", param1, param2, param3);
        else
            service.call("startApp", param1, param2, param3).get();
    }

    /**
     * 180 packageInstalled               Void (String,Value,String)
     * packageInstalled
     */
    public void packageInstalled(String param1, com.aldebaran.qimessaging.Object param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("packageInstalled", param1, param2, param3);
        else
            service.call("packageInstalled", param1, param2, param3).get();
    }

    /**
     * 181 setFocus                       Void (String)
     * Give focus to a dialog
     */
    public void setFocus(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setFocus", param1);
        else
            service.call("setFocus", param1).get();
    }

    /**
     * 182 getFocus                       String ()
     * Give focus to a dialog
     */
    public String getFocus() throws CallError, InterruptedException {
        return (String) service.call("getFocus").get();
    }

    /**
     * 183 gotoTopic                      Void (String)
     * Set the focus to a topic and make a proposal
     */
    public void gotoTopic(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("gotoTopic", param1);
        else
            service.call("gotoTopic", param1).get();
    }

    /**
     * 189 getLoadedTopics                List<String> (String)
     * Load precompiled file
     */
    public List<String> getLoadedTopics(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getLoadedTopics", param1).get();
    }

    /**
     * 190 getActivatedTopics             List<String> ()
     * Get activated topics
     */
    public List<String> getActivatedTopics() throws CallError, InterruptedException {
        return (List<String>) service.call("getActivatedTopics").get();
    }

    /**
     * 194 activateTag                    Void (String,String)
     * activate a tag
     */
    public void activateTag(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("activateTag", param1, param2);
        else
            service.call("activateTag", param1, param2).get();
    }

    /**
     * 195 deactivateTag                  Void (String,String)
     * deactivate a tag
     */
    public void deactivateTag(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("deactivateTag", param1, param2);
        else
            service.call("deactivateTag", param1, param2).get();
    }

    /**
     * 197 resetAll                       Void ()
     * fallback
     */
    public void resetAll() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("resetAll");
        else
            service.call("resetAll").get();
    }

    /**
     * 198 insertUserData                 Void (String,String,Int32)
     * insert user data into dialog database
     */
    public void insertUserData(String param1, String param2, Integer param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("insertUserData", param1, param2, param3);
        else
            service.call("insertUserData", param1, param2, param3).get();
    }

    /**
     * 199 getUserData                    String (String,Int32)
     * get user data from dialog database
     */
    public String getUserData(String param1, Integer param2) throws CallError, InterruptedException {
        return (String) service.call("getUserData", param1, param2).get();
    }

    /**
     * 200 getUserDataList                List<String> (Int32)
     * get user data list from dialog database
     */
    public List<String> getUserDataList(Integer param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getUserDataList", param1).get();
    }

    /**
     * 201 getUserList                    List<Int32> ()
     * get user list from dialog database
     */
    public List<Integer> getUserList() throws CallError, InterruptedException {
        return (List<Integer>) service.call("getUserList").get();
    }

    /**
     * 202 removeUserData                 Void (Int32)
     * remove a user from the database
     */
    public void removeUserData(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeUserData", param1);
        else
            service.call("removeUserData", param1).get();
    }

    /**
     * 203 clearConcepts                  Void ()
     * clear concepts in DB
     */
    public void clearConcepts() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("clearConcepts");
        else
            service.call("clearConcepts").get();
    }

    /**
     * 204 enableSendingLogToCloud        Void (Bool)
     * let the robot send log the cloud
     */
    public void enableSendingLogToCloud(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("enableSendingLogToCloud", param1);
        else
            service.call("enableSendingLogToCloud", param1).get();
    }

    /**
     * 205 isSendingLogToCloud            Bool ()
     * check if the robot is sending the log to the cloud
     */
    public Boolean isSendingLogToCloud() throws CallError, InterruptedException {
        return (Boolean) service.call("isSendingLogToCloud").get();
    }

    /**
     * 206 enableLogAudio                 Void (Bool)
     * enable sending log audio (recorded conversation) to the cloud
     */
    public void enableLogAudio(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("enableLogAudio", param1);
        else
            service.call("enableLogAudio", param1).get();
    }

    /**
     * 221 generateSentences              Void (String,String,String)
     * Generate sentences
     * * Signals:
     */
    public void generateSentences(String param1, String param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("generateSentences", param1, param2, param3);
        else
            service.call("generateSentences", param1, param2, param3).get();
    }


}
    