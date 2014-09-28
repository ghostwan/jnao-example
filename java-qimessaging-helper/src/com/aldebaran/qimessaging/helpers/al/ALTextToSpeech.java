package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALTextToSpeech extends ALModule {

    public ALTextToSpeech(Session session) {
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
     * 113 say                     Void (String)
     * Performs the text-to-speech operations : it takes a std::string as input and outputs a sound in both speakers. String encoding must be UTF8.
     * stringToSay: Text to say, encoded in UTF-8.
     */
    public void say(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("say", param1);
        else
            service.call("say", param1).get();
    }

    /**
     * 114 say                     Void (String,String)
     * Performs the text-to-speech operations in a specific language: it takes a std::string as input and outputs a sound in both speakers. String encoding must be UTF8. Once the text is said, the language is set back to its initial value.
     * stringToSay: Text to say, encoded in UTF-8.
     * language: Language used to say the text.
     */
    public void say(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("say", param1, param2);
        else
            service.call("say", param1, param2).get();
    }

    /**
     * 115 sayToFile               Void (String,String)
     * Performs the text-to-speech operations: it takes a std::string as input and outputs the corresponding audio signal in the specified file.
     * pStringToSay: Text to say, encoded in UTF-8.
     * pFileName: RAW file where to store the generated signal. The signal is encoded with a sample rate of 22050Hz, format S16_LE, 2 channels.
     * return: Id of the task. Can be used to interrupt it.
     */
    public void sayToFile(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("sayToFile", param1, param2);
        else
            service.call("sayToFile", param1, param2).get();
    }

    /**
     * 116 sayToFileAndPlay        Void (String)
     * This method performs the text-to-speech operations: it takes a std::string, outputs the synthesis resulting audio signal in a file, and then plays the audio file. The file is deleted afterwards. It is useful when you want to perform a short synthesis, when few CPU is available. Do not use it if you want a low-latency synthesis or to synthesize a long std::string.
     * pStringToSay: Text to say, encoded in UTF-8.
     * return: Id of the task. Can be used to interrupt it.
     */
    public void sayToFileAndPlay(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("sayToFileAndPlay", param1);
        else
            service.call("sayToFileAndPlay", param1).get();
    }

    /**
     * 117 stopAll                 Void ()
     * This method stops the current and all the pending tasks immediately.
     */
    public void stopAll() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopAll");
        else
            service.call("stopAll").get();
    }

    /**
     * 118 setLanguage             Void (String)
     * Changes the language used by the Text-to-Speech engine. It automatically changes the voice used since each of them is related to a unique language. If you want that change to take effect automatically after reboot of your robot, refer to the robot web page (setting page).
     * pLanguage: Language name. Must belong to the languages available in TTS (can be obtained with the getAvailableLanguages method).  It should be an identifier std::string.
     */
    public void setLanguage(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setLanguage", param1);
        else
            service.call("setLanguage", param1).get();
    }

    /**
     * 119 getLanguage             String ()
     * Returns the language currently used by the text-to-speech engine.
     * return: Language of the current voice.
     */
    public String getLanguage() throws CallError, InterruptedException {
        return (String) service.call("getLanguage").get();
    }

    /**
     * 120 getLanguageEncoding     String (String)
     * Returns the encoding that should be used with the specified language.
     * pLanguage: Language name (as a std::string). Must belong to the languages available in TTS.
     * return: Encoding of the specified language.
     */
    public String getLanguageEncoding(String param1) throws CallError, InterruptedException {
        return (String) service.call("getLanguageEncoding", param1).get();
    }

    /**
     * 121 getAvailableLanguages   List<String> ()
     * Outputs the languages installed on the system.
     * return: Array of std::string that contains the languages installed on the system.
     */
    public List<String> getAvailableLanguages() throws CallError, InterruptedException {
        return (List<String>) service.call("getAvailableLanguages").get();
    }

    /**
     * 122 getSupportedLanguages   List<String> ()
     * Outputs all the languages supported (may be installed or not).
     * return: Array of std::string that contains all the supported languages (may be installed or not).
     */
    public List<String> getSupportedLanguages() throws CallError, InterruptedException {
        return (List<String>) service.call("getSupportedLanguages").get();
    }

    /**
     * 123 setParameter            Void (String,Float)
     * Changes the parameters of the voice. The available parameters are:
     * pitchShift: applies a pitch shifting to the voice. The value indicates the ratio between the new fundamental frequencies and the old ones (examples: 2.0: an octave above, 1.5: a quint above). Correct range is (1.0 -- 4), or 0 to disable effect.
     * doubleVoice: adds a second voice to the first one. The value indicates the ratio between the second voice fundamental frequency and the first one. Correct range is (1.0 -- 4), or 0 to disable effect
     * doubleVoiceLevel: the corresponding value is the level of the double voice (1.0: equal to the main voice one). Correct range is (0 -- 4).
     * doubleVoiceTimeShift: the corresponding value is the delay between the double voice and the main one. Correct range is (0 -- 0.5)
     * If the effect value is not available, the effect parameter remains unchanged.
     * pEffectName: Name of the parameter.
     * pEffectValue: Value of the parameter.
     * return: (int) >= 0 if successful, negative error code if failed Vincent : pas sûr que cette fonction balance un truc en sortie
     */
    public void setParameter(String param1, Float param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setParameter", param1, param2);
        else
            service.call("setParameter", param1, param2).get();
    }

    /**
     * 124 getParameter            Float (String)
     * Returns the value of one of the voice parameters. The available parameters are: "pitchShift", "doubleVoice","doubleVoiceLevel" and "doubleVoiceTimeShift"
     * pParameterName: Name of the parameter.
     * return: Value of the specified parameter
     */
    public Float getParameter(String param1) throws CallError, InterruptedException {
        return (Float) service.call("getParameter", param1).get();
    }

    /**
     * 125 setVoice                Void (String)
     * Changes the voice used by the text-to-speech engine. The voice identifier must belong to the installed voices, that can be listed using the 'getAvailableVoices' method. If the voice is not available, it remains unchanged. No exception is thrown in this case. For the time being, only two voices are available by default : Kenny22Enhanced (English voice) and Julie22Enhanced (French voice)
     * pVoiceID: The voice (as a std::string).
     */
    public void setVoice(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setVoice", param1);
        else
            service.call("setVoice", param1).get();
    }

    /**
     * 126 getVoice                String ()
     * Returns the voice currently used by the text-to-speech engine.
     * return: Name of the current voice
     */
    public String getVoice() throws CallError, InterruptedException {
        return (String) service.call("getVoice").get();
    }

    /**
     * 127 getAvailableVoices      List<String> ()
     * Outputs the available voices. The returned list contains the voice IDs.
     * return:  Array of std::string containing the voices installed on the system.
     */
    public List<String> getAvailableVoices() throws CallError, InterruptedException {
        return (List<String>) service.call("getAvailableVoices").get();
    }

    /**
     * 128 setVolume               Void (Float)
     * Sets the volume of text-to-speech output.
     * volume: Volume (between 0.0 and 1.0).
     */
    public void setVolume(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setVolume", param1);
        else
            service.call("setVolume", param1).get();
    }

    /**
     * 129 getVolume               Float ()
     * Fetches the current volume the text to speech.
     * return: Volume (integer between 0 and 100).
     */
    public Float getVolume() throws CallError, InterruptedException {
        return (Float) service.call("getVolume").get();
    }

    /**
     * 130 locale                  String ()
     * Get the locale associate to the current language.
     * return: A string with xx_XX format (region_country)
     */
    public String locale() throws CallError, InterruptedException {
        return (String) service.call("locale").get();
    }

    /**
     * 131 loadVoicePreference     Void (String)
     * Loads a set of voice parameters defined in a xml file contained in the preferences folder.The name of the xml file must begin with ALTextToSpeech_Voice_
     * pPreferenceName: Name of the voice preference.
     */
    public void loadVoicePreference(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("loadVoicePreference", param1);
        else
            service.call("loadVoicePreference", param1).get();
    }

    /**
     * 133 setLanguageDefaultVoice Void (String,String)
     * Sets a voice as the default voice for the corresponding language
     * Language: The language among those available on your robot as a String
     * Voice: The voice among those available on your robot as a String
     */
    public void setLanguageDefaultVoice(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setLanguageDefaultVoice", param1, param2);
        else
            service.call("setLanguageDefaultVoice", param1, param2).get();
    }

    /**
     * 134 enableNotifications     Void ()
     * Enables the notifications puted in ALMemory during the synthesis (TextStarted, TextDone, CurrentBookMark, CurrentWord, ...)
     */
    public void enableNotifications() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("enableNotifications");
        else
            service.call("enableNotifications").get();
    }

    /**
     * 135 disableNotifications    Void ()
     * Disables the notifications puted in ALMemory during the synthesis (TextStarted, TextDone, CurrentBookMark, CurrentWord, ...)
     * * Signals:
     * 143 synchroTTS (timeval)
     */
    public void disableNotifications() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("disableNotifications");
        else
            service.call("disableNotifications").get();
    }


}
    