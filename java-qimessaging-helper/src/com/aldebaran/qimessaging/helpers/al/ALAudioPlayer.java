package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALAudioPlayer extends ALModule {

    public ALAudioPlayer(Session session) {
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
     * 113 playFile                  Void (String)
     * Plays a wav or mp3 file
     * fileName: Path of the sound file
     */
    public void playFile(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playFile", param1);
        else
            service.call("playFile", param1).get();
    }

    /**
     * 114 playFile                  Void (String,Float,Float)
     * Plays a wav or mp3 file, with specific volume and audio balance
     * fileName: Path of the sound file
     * volume: volume of the sound file (must be between 0.0 and 1.0)
     * pan: audio balance of the sound file (-1.0 : left / 1.0 : right / 0.0 : centered)
     */
    public void playFile(String param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playFile", param1, param2, param3);
        else
            service.call("playFile", param1, param2, param3).get();
    }

    /**
     * 116 playSoundSetFile          Void (String)
     * Plays a file contained in one of the sound sets loaded
     * fileName: Name of the file without extension
     */
    public void playSoundSetFile(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playSoundSetFile", param1);
        else
            service.call("playSoundSetFile", param1).get();
    }

    /**
     * 119 playSoundSetFile          Void (String,String)
     * Plays a file contained in a given sound set
     * soundSetName: Name of the soundset
     * fileName: Name of the file without extension
     */
    public void playSoundSetFile(String param1, String param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playSoundSetFile", param1, param2);
        else
            service.call("playSoundSetFile", param1, param2).get();
    }

    /**
     * 121 playSoundSetFile          Void (String,String,Float,Float,Float,Bool)
     * Plays a file contained in a given sound set
     * soundSetName: Name of the soundset
     * fileName: Name of the file without extension
     * position: Position in second where the playing has to begin
     * volume: volume of the sound file (must be between 0.0 and 1.0)
     * pan: audio balance of the sound file (-1.0 : left / 1.0 : right)
     * loop: specify if the file must be played in loop
     */
    public void playSoundSetFile(String param1, String param2, Float param3, Float param4, Float param5, Boolean param6) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playSoundSetFile", param1, param2, param3, param4, param5, param6);
        else
            service.call("playSoundSetFile", param1, param2, param3, param4, param5, param6).get();
    }

    /**
     * 123 playSoundSetFile          Void (String,Float,Float,Float,Bool)
     * Plays a file contained in a given sound set
     * fileName: Name of the file without extension
     * position: Position in second where the playing has to begin
     * volume: volume of the sound file (must be between 0.0 and 1.0)
     * pan: audio balance of the sound file (-1.0 : left / 1.0 : right)
     * loop: specify if the file must be played in loop
     */
    public void playSoundSetFile(String param1, Float param2, Float param3, Float param4, Boolean param5) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playSoundSetFile", param1, param2, param3, param4, param5);
        else
            service.call("playSoundSetFile", param1, param2, param3, param4, param5).get();
    }

    /**
     * 125 loadSoundSet              Void (String)
     * Load a sound set
     * setName: name of the set
     */
    public void loadSoundSet(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("loadSoundSet", param1);
        else
            service.call("loadSoundSet", param1).get();
    }

    /**
     * 127 unloadSoundSet            Void (String)
     * Unload a sound set
     * setName: name of the set
     */
    public void unloadSoundSet(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unloadSoundSet", param1);
        else
            service.call("unloadSoundSet", param1).get();
    }

    /**
     * 131 getSoundSetFileNames      List<String> (String)
     * Return the list of files contained in a sound set
     * setName: name of the set
     */
    public List<String> getSoundSetFileNames(String param1) throws CallError, InterruptedException {
        return (List<String>) service.call("getSoundSetFileNames", param1).get();
    }

    /**
     * 134 getLoadedSoundSetsList    List<String> ()
     */
    public List<String> getLoadedSoundSetsList() throws CallError, InterruptedException {
        return (List<String>) service.call("getLoadedSoundSetsList").get();
    }

    /**
     * 136 getInstalledSoundSetsList List<String> ()
     */
    public List<String> getInstalledSoundSetsList() throws CallError, InterruptedException {
        return (List<String>) service.call("getInstalledSoundSetsList").get();
    }

    /**
     * 138 isSoundSetInstalled       Bool (String)
     * setName: name of the set
     */
    public Boolean isSoundSetInstalled(String param1) throws CallError, InterruptedException {
        return (Boolean) service.call("isSoundSetInstalled", param1).get();
    }

    /**
     * 140 isSoundSetFileInstalled   Bool (String,String)
     * setName: name of the set
     * soundName: name of the sound
     */
    public Boolean isSoundSetFileInstalled(String param1, String param2) throws CallError, InterruptedException {
        return (Boolean) service.call("isSoundSetFileInstalled", param1, param2).get();
    }

    /**
     * 143 playFileInLoop            Void (String)
     * Plays a wav or mp3 file in loop
     * fileName: Path of the sound file
     */
    public void playFileInLoop(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playFileInLoop", param1);
        else
            service.call("playFileInLoop", param1).get();
    }

    /**
     * 144 playFileInLoop            Void (String,Float,Float)
     * Plays a wav or mp3 file in loop, with specific volume and audio balance
     * fileName: Path of the sound file
     * volume: volume of the sound file (must be between 0.0 and 1.0)
     * pan: audio balance of the sound file (-1.0 : left / 1.0 : right)
     */
    public void playFileInLoop(String param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playFileInLoop", param1, param2, param3);
        else
            service.call("playFileInLoop", param1, param2, param3).get();
    }

    /**
     * 145 playFileFromPosition      Void (String,Float)
     * Plays a wav or mp3 file from a given position in the file.
     * fileName: Name of the sound file
     * position: Position in second where the playing has to begin
     */
    public void playFileFromPosition(String param1, Float param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playFileFromPosition", param1, param2);
        else
            service.call("playFileFromPosition", param1, param2).get();
    }

    /**
     * 146 playFileFromPosition      Void (String,Float,Float,Float)
     * Plays a wav or mp3 file from a given position in the file, with specific volume and audio balance
     * fileName: Name of the sound file
     * position: Position in second where the playing has to begin
     * volume: volume of the sound file (must be between 0.0 and 1.0)
     * pan: audio balance of the sound file (-1.0 : left / 1.0 : right)
     */
    public void playFileFromPosition(String param1, Float param2, Float param3, Float param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playFileFromPosition", param1, param2, param3, param4);
        else
            service.call("playFileFromPosition", param1, param2, param3, param4).get();
    }

    /**
     * 147 goTo                      Void (Int32,Float)
     * Goes to a given position in a file which is playing.
     * playId: Id of the process which is playing the file
     * position: Position in the file (in second)
     */
    public void goTo(Integer param1, Float param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("goTo", param1, param2);
        else
            service.call("goTo", param1, param2).get();
    }

    /**
     * 148 stopAll                   Void ()
     * Stops all the files that are currently playing.
     */
    public void stopAll() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopAll");
        else
            service.call("stopAll").get();
    }

    /**
     * 149 pause                     Void (Int32)
     * Pause a play back
     * id: Id of the process that is playing the file you want to put in pause
     */
    public void pause(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("pause", param1);
        else
            service.call("pause", param1).get();
    }

    /**
     * 150 setVolume                 Void (Int32,Float)
     * Sets the volume of the player
     * id: Id of the process that is playing the file you want to put louder or less loud
     * volume: Volume - range 0.0 to 1.0
     */
    public void setVolume(Integer param1, Float param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setVolume", param1, param2);
        else
            service.call("setVolume", param1, param2).get();
    }

    /**
     * 151 setMasterVolume           Void (Float)
     * Sets the master volume of the player
     * volume: Volume - range 0.0 to 1.0
     */
    public void setMasterVolume(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setMasterVolume", param1);
        else
            service.call("setMasterVolume", param1).get();
    }

    /**
     * 152 getVolume                 Float (Int32)
     * Returns the volume of the player
     * playId: Id of the process which is playing the file
     * return: Volume of the player - range 0.0 to 1.0.
     */
    public Float getVolume(Integer param1) throws CallError, InterruptedException {
        return (Float) service.call("getVolume", param1).get();
    }

    /**
     * 153 getMasterVolume           Float ()
     * Returns the master volume of the player
     * return: Volume of the master - range 0.0 to 1.0.
     */
    public Float getMasterVolume() throws CallError, InterruptedException {
        return (Float) service.call("getMasterVolume").get();
    }

    /**
     * 154 setPanorama               Void (Float)
     * sets the audio panorama : -1 for left speaker / 1 for right speaker
     * return: Volume of the player - range 0.0 to 1.0.
     */
    public void setPanorama(Float param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setPanorama", param1);
        else
            service.call("setPanorama", param1).get();
    }

    /**
     * 155 loadFile                  Int32 (String)
     * Loads a file for ulterior playback
     * fileName: Path of the sound file (either mp3 or wav)
     * return: Id of the file which has been loaded. This file can then be played with the play function
     */
    public Integer loadFile(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("loadFile", param1).get();
    }

    /**
     * 156 unloadFile                Void (Int32)
     * unloads a file previously loaded with the loadFile function
     * id: Id returned by the loadFile function
     */
    public void unloadFile(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unloadFile", param1);
        else
            service.call("unloadFile", param1).get();
    }

    /**
     * 157 unloadAllFiles            Void ()
     * unloads all the files already loaded.
     */
    public void unloadAllFiles() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unloadAllFiles");
        else
            service.call("unloadAllFiles").get();
    }

    /**
     * 158 getLoadedFilesNames       List<String> ()
     * returns an array containing the names of the currently loaded files
     * return: Array containing the names of the files which has been loaded
     */
    public List<String> getLoadedFilesNames() throws CallError, InterruptedException {
        return (List<String>) service.call("getLoadedFilesNames").get();
    }

    /**
     * 159 getLoadedFilesIds         List<String> ()
     * returns an array containing the Ids of the currently loaded files
     * return: Array containing the Ids of the files which has been loaded
     */
    public List<String> getLoadedFilesIds() throws CallError, InterruptedException {
        return (List<String>) service.call("getLoadedFilesIds").get();
    }

    /**
     * 160 play                      Void (Int32)
     * Starts the playback of a file preloaded with the loadFile function.
     * id: Id returned by the loadFile function
     */
    public void play(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("play", param1);
        else
            service.call("play", param1).get();
    }

    /**
     * 161 play                      Void (Int32,Float,Float)
     * Starts the playback of a file preloaded with the loadFile function, with specific volume and audio balance
     * id: Id returned by the loadFile function
     * volume: volume of the sound file (must be between 0.0 and 1.0)
     * pan: audio balance of the sound file (-1.0 : left / 1.0 : right)
     */
    public void play(Integer param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("play", param1, param2, param3);
        else
            service.call("play", param1, param2, param3).get();
    }

    /**
     * 162 playInLoop                Void (Int32)
     * Starts the playback in loop of a file preloaded with the loadFile function
     * id: Id returned by the loadFile function
     */
    public void playInLoop(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playInLoop", param1);
        else
            service.call("playInLoop", param1).get();
    }

    /**
     * 163 playInLoop                Void (Int32,Float,Float)
     * Plays a wav or mp3 file in loop, with specific volume and audio balance
     * id: Id returned by the loadFile function
     * volume: volume of the sound file (must be between 0.0 and 1.0)
     * pan: audio balance of the sound file (-1.0 : left / 1.0 : right)
     */
    public void playInLoop(Integer param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playInLoop", param1, param2, param3);
        else
            service.call("playInLoop", param1, param2, param3).get();
    }

    /**
     * 164 playWebStream             Void (String,Float,Float)
     * Starts the playback of a wab audio stream
     * streamName: Path of the web audio stream
     */
    public void playWebStream(String param1, Float param2, Float param3) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playWebStream", param1, param2, param3);
        else
            service.call("playWebStream", param1, param2, param3).get();
    }

    /**
     * 165 getFileLength             Float (Int32)
     * Returns the length of the file played
     * playId: Id of the process which is playing the file
     * return: Length of the file in seconds
     */
    public Float getFileLength(Integer param1) throws CallError, InterruptedException {
        return (Float) service.call("getFileLength", param1).get();
    }

    /**
     * 166 getCurrentPosition        Float (Int32)
     * Returns the position in the file which is currently played
     * playId: Id of the process which is playing the file
     * return: Position in the file in seconds
     */
    public Float getCurrentPosition(Integer param1) throws CallError, InterruptedException {
        return (Float) service.call("getCurrentPosition", param1).get();
    }

    /**
     * 167 playSine                  Void (Int32,Int32,Int32,Float)
     * Play a sine wave which specified caracteristics.
     * frequence: Frequence in Hertz
     * gain: Volume Gain between 0 and 100
     * pan: Stereo Pan set to either {-1,0,+1}
     * duration: Duration of the sine wave in seconds
     * * Signals:
     */
    public void playSine(Integer param1, Integer param2, Integer param3, Float param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playSine", param1, param2, param3, param4);
        else
            service.call("playSine", param1, param2, param3, param4).get();
    }


}
    