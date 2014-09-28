package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALSpeechRecognition extends ALModule {

    public ALSpeechRecognition(Session session) {
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
     * 126 setVisualExpression     Void (Bool)
     * Enables or disables the leds animations showing the state of the recognition engine during the recognition process.
     * setOrNot: Enable (true) or disable it (false).
     */
    public void setVisualExpression(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setVisualExpression", param1);
        else
            service.call("setVisualExpression", param1).get();
    }

    /**
     * 127 setVisualExpressionMode Void (Int32)
     * Sets the LED animation mode
     * mode: animation mode: 0: deactivated, 1: eyes, 2: ears, 3: full
     */
    public void setVisualExpressionMode(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setVisualExpressionMode", param1);
        else
            service.call("setVisualExpressionMode", param1).get();
    }

    /**
     * 128 setAudioExpression      Void (Bool)
     * Enables or disables the playing of sounds indicating the state of the recognition engine. If this option is enabled, a sound is played at the beginning of the recognition process (after a call to the subscribe method), and a sound is played when the user call the unsubscribe method
     * setOrNot: Enable (true) or disable it (false).
     */
    public void setAudioExpression(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setAudioExpression", param1);
        else
            service.call("setAudioExpression", param1).get();
    }

    /**
     * 129 getAudioExpression      Bool ()
     * To check if audio expression is enabled or disabled.
     */
    public Boolean getAudioExpression() throws CallError, InterruptedException {
        return (Boolean) service.call("getAudioExpression").get();
    }

    /**
     * 130 setLanguage             Void (String)
     * Sets the language used by the speech recognition engine. The list of the available languages can be collected through the getAvailableLanguages method. If you want to set a language as the default language (loading automatically at module launch), please refer to the web page of the robot.
     * languageName: Name of the language in English.
     */
    public void setLanguage(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setLanguage", param1);
        else
            service.call("setLanguage", param1).get();
    }

    /**
     * 132 getLanguage             String ()
     * Returns the current language used by the speech recognition system.
     * return: Current language used by the speech recognition engine.
     */
    public String getLanguage() throws CallError, InterruptedException {
        return (String) service.call("getLanguage").get();
    }

    /**
     * 133 getAvailableLanguages   List<String> ()
     * Returns the list of the languages installed on the system.
     * return: Array of strings that contains the list of the installed languages.
     */
    public List<String> getAvailableLanguages() throws CallError, InterruptedException {
        return (List<String>) service.call("getAvailableLanguages").get();
    }

    /**
     * 134 setParameter            Void (String,Float)
     * Sets a parameter of the speech recognition engine. Note that when the ASR engine language is set to Chinese, no parameter can be set.
     * The parameters that can be set and the corresponding values are:
     * "Sensitivity" - Values : range is [0.0; 1.0].
     * "Timeout" - Values :  default values 3000 ms. Timeout for the remote recognition
     * "MinimumTrailingSilence" : Values : 0 (no) or 1 (yes) - Applies a High-Pass filter on the input signal - default value is 0.
     * paramName: Name of the parameter.
     * paramValue: Value of the parameter.
     */
    public void setParameter(String param1, Float param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setParameter", param1, param2);
        else
            service.call("setParameter", param1, param2).get();
    }

    /**
     * 135 setParameter            Void (String,Bool)
     * Sets a parameter of the speech recognition engine. Note that when the ASR engine language is set to Chinese, no parameter can be set.
     * The parameters that can be set and the corresponding values are:
     * "Sensitivity" - Values : range is [0.0; 1.0].
     * "Timeout" - Values :  default values 3000 ms. Timeout for the remote recognition
     * "MinimumTrailingSilence" : Values : 0 (no) or 1 (yes) - Applies a High-Pass filter on the input signal - default value is 0.
     * paramName: Name of the parameter.
     * paramValue: Value of the parameter.
     */
    public void setParameter(String param1, Boolean param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setParameter", param1, param2);
        else
            service.call("setParameter", param1, param2).get();
    }

    /**
     * 136 getParameter            Float (String)
     * Gets a parameter of the speech recognition engine. Note that when the ASR engine language is set to Chinese, no parameter can be retrieved
     * paramName: Name of the parameter.
     * return: Value of the parameter.
     */
    public Float getParameter(String param1) throws CallError, InterruptedException {
        return (Float) service.call("getParameter", param1).get();
    }

    /**
     * 137 setWordListAsVocabulary Void (List<String>)
     * Sets the list of words (vocabulary) that should be recognized by the speech recognition engine.
     * vocabulary: List of words that should be recognized
     */
    public void setWordListAsVocabulary(List<String> param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setWordListAsVocabulary", param1);
        else
            service.call("setWordListAsVocabulary", param1).get();
    }

    /**
     * 138 setVocabulary           Void (List<String>,Bool)
     * Sets the list of words (vocabulary) that should be recognized by the speech recognition engine.
     * vocabulary: List of words that should be recognized
     * enabledWordSpotting: If disabled, the engine expects to hear one of the specified words, nothing more, nothing less. If enabled, the specified words can be pronounced in the middle of a whole speech stream, the engine will try to spot them.
     */
    public void setVocabulary(List<String> param1, Boolean param2) throws CallError, InterruptedException {
            service.call("setVocabulary", param1, param2);
    }

    /**
     * 139 pause                   Void (Bool)
     * Stops and restarts the speech recognition engine according to the input parameter This can be used to add contexts, activate or deactivate rules of a contex, add a words to a slot.
     * pause: Boolean to enable or disable pause of the speech recognition engine.
     */
    public void pause(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("pause", param1);
        else
            service.call("pause", param1).get();
    }

    /**
     * 140 compile                 Void (String,String,String)
     */
    public void compile(String param1, String param2, String param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("compile", param1, param2, param3);
        else
            service.call("compile", param1, param2, param3).get();
    }

    /**
     * 141 addContext              Void (String,String)
     * Add a context from a LCF file.
     * pathToLCFFile: Path to a LCF file. This LCF file contains the set of rules that should be recognized by the speech recognition engine.
     * contextName: Name of the context of your choice.
     */
    public void addContext(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("addContext", param1, param2);
        else
            service.call("addContext", param1, param2).get();
    }

    /**
     * 142 removeContext           Void (String)
     * Remove one context from the speech recognition engine.
     * contextName: Name of the context to remove from the speech recognition engine.
     */
    public void removeContext(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeContext", param1);
        else
            service.call("removeContext", param1).get();
    }

    /**
     * 143 removeAllContext        Void ()
     * Remove all contexts from the speech recognition engine.
     */
    public void removeAllContext() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeAllContext");
        else
            service.call("removeAllContext").get();
    }

    /**
     * 144 pushContexts            Void ()
     * Disable current contexts of the speech recognition engine and save them in a  stack.
     */
    public void pushContexts() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("pushContexts");
        else
            service.call("pushContexts").get();
    }

    /**
     * 145 popContexts             Void ()
     * Disable current contexts and restore saved contexts of the speech recognition engine.
     */
    public void popContexts() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("popContexts");
        else
            service.call("popContexts").get();
    }

    /**
     * 146 saveContextSet          Bool (String)
     * Save current context set of the speech recognition engine
     * saveName: Name under which to save
     */
    public Boolean saveContextSet(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("saveContextSet", param1).get();
    }

    /**
     * 147 loadContextSet          Void (String)
     * Load a saved context set of the speech recognition engine
     * saveName: Name under which the context set is saved
     */
    public void loadContextSet(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("loadContextSet", param1);
        else
            service.call("loadContextSet", param1).get();
    }

    /**
     * 148 eraseContextSet         Void (String)
     * Erase a saved context set of the speech recognition engine
     * saveName: Name under which the context set is saved
     */
    public void eraseContextSet(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("eraseContextSet", param1);
        else
            service.call("eraseContextSet", param1).get();
    }

    /**
     * 149 activateRule            Void (String,String)
     * Activate a rule contained in the specified context.
     * contextName: Name of the context to modify.
     * ruleName: Name of the rule to activate.
     */
    public void activateRule(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("activateRule", param1, param2);
        else
            service.call("activateRule", param1, param2).get();
    }

    /**
     * 150 deactivateRule          Void (String,String)
     * Deactivate a rule contained in the specified context.
     * contextName: Name of the context to modify.
     * ruleName: Name of the rule to deactivate.
     */
    public void deactivateRule(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("deactivateRule", param1, param2);
        else
            service.call("deactivateRule", param1, param2).get();
    }

    /**
     * 151 activateAllRules        Void (String)
     * Activate all rules contained in the specified context.
     * contextName: Name of the context to modify.
     */
    public void activateAllRules(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("activateAllRules", param1);
        else
            service.call("activateAllRules", param1).get();
    }

    /**
     * 152 deactivateAllRules      Void (String)
     * Deactivate all rules contained in the specified context.
     * contextName: Name of the context to modify.
     */
    public void deactivateAllRules(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("deactivateAllRules", param1);
        else
            service.call("deactivateAllRules", param1).get();
    }

    /**
     * 153 setContextParam         Void (String,String,Int32)
     * Set the given parameter for the specified context.
     * contextName: Name of the context
     * paramName: Name of the parameter to change
     * value: New parameter value
     */
    public void setContextParam(String param1, String param2, Integer param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setContextParam", param1, param2, param3);
        else
            service.call("setContextParam", param1, param2, param3).get();
    }

    /**
     * 154 getContextParam         Int32 (String,String)
     * Get the given parameter for the specified context.
     * contextName: Name of the context
     * paramName: Name of the parameter to get
     * return: Value of the fetched parameter
     */
    public Integer getContextParam(String param1, String param2) throws CallError, InterruptedException {
        return (Integer) service.call("getContextParam", param1, param2).get();
    }

    /**
     * 155 addWordListToSlot       Void (String,String,List<String>)
     * Add a list of words in a slot. A slot is a part of a context which can be modified. You can add a list of words that should be recognized by the speech recognition engine
     * contextName: Name of the context to modify.
     * slotName: Name of the slot to modify.
     * wordList: List of words to insert in the slot.
     */
    public void addWordListToSlot(String param1, String param2, List<String> param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("addWordListToSlot", param1, param2, param3);
        else
            service.call("addWordListToSlot", param1, param2, param3).get();
    }

    /**
     * 156 removeWordListFromSlot  Void (String,String)
     * Remove all words from a slot.
     * contextName: Name of the context to modify.
     * slotName: Name of the slot to modify.
     */
    public void removeWordListFromSlot(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("removeWordListFromSlot", param1, param2);
        else
            service.call("removeWordListFromSlot", param1, param2).get();
    }

    /**
     * 157 getRules                List<String> (String,String)
     * Get all rules contained for a specific context.
     * contextName: Name of the context to analyze.
     * typeName: Type of the required rules.
     */
    public List<String> getRules(String param1, String param2) throws CallError, InterruptedException {
        return (List<String>) service.call("getRules", param1, param2).get();
    }

    /**
     * 162 loadVocabulary          Void (String)
     * Loads the vocabulary to recognized contained in a .lxd file. This method is not available with the ASR engine language set to Chinese. For more informations see the red documentation
     * vocabularyFile: Name of the lxd file containing the vocabulary
     * * Signals:
     */
    public void loadVocabulary(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("loadVocabulary", param1);
        else
            service.call("loadVocabulary", param1).get();
    }


}
    