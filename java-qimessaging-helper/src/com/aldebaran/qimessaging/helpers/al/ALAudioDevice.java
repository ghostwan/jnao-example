package com.aldebaran.qimessaging.helpers.al;

import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Session;
import com.aldebaran.qimessaging.helpers.ALModule;

import java.util.List;

/**
 * Created by erwan on 01/05/2014.
 */
public class ALAudioDevice extends ALModule {

    public ALAudioDevice(Session session) {
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
     * 113 subscribe                 Void (String)
     * This function allows a module to subscribe to the ALAudioDevice module.For more informations see the audio part of the red documentation
     * pModule: Name of the module
     */
    public void subscribe(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("subscribe", param1);
        else
            service.call("subscribe", param1).get();
    }

    /**
     * 114 unsubscribe               Void (String)
     * This function allows a module to subscribe to the ALAudioDevice module.For more informations see the audio part of the red documentation
     * pModule: Name of the module
     */
    public void unsubscribe(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("unsubscribe", param1);
        else
            service.call("unsubscribe", param1).get();
    }

    /**
     * 115 sendLocalBufferToOutput   Bool (Int32,Int32)
     * This function allows a local module to send sound onto the nao's loudpseakers
     * You must pass to this function a pointer to the stereo buffer to send, and the number of frames per channel. The buffer must contain 16bits stereo interleaved samples, and the number of frames does not exceed 16384
     * nbOfFrames: Number of 16 bits samples per channel to send.
     * pBuffer: Buffer to send
     * return: True if the operation is successfull - False otherwise
     */
    public Boolean sendLocalBufferToOutput(Integer param1, Integer param2) throws CallError, InterruptedException {
        return (Boolean) service.call("sendLocalBufferToOutput", param1, param2).get();
    }

    /**
     * 116 sendRemoteBufferToOutput  Bool (Int32,Value)
     * This function allows a remote module to send sound onto the nao's loudpseakers
     * You must pass to this function the stereo buffer you want to send as an ALValue converted to binary, and the number of frames per channel. The number of frames does not exceed 16384. For more information please see the red documentation
     * nbOfFrames: Number of 16 bits samples per channel to send.
     * pBuffer: Buffer to send
     * return: True if the operation is successfull - False otherwise
     */
    public Boolean sendRemoteBufferToOutput(Integer param1, com.aldebaran.qimessaging.Object param2) throws CallError, InterruptedException {
        return (Boolean) service.call("sendRemoteBufferToOutput", param1, param2).get();
    }

    /**
     * 117 setFileAsInput            Void (String)
     * This method allows to send sound samples contained in a sound file at the input of ALAudioDevice, instead of the nao's microphones sound data. The sound file must be a .wav file containing 16bits / 4 channels / interleaved samples. Once the file has been read, microphones sound data will again taken as input
     * pFileName: Name of the input file.
     */
    public void setFileAsInput(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setFileAsInput", param1);
        else
            service.call("setFileAsInput", param1).get();
    }

    /**
     * 118 setParameter              Void (String,Int32)
     * This method sets the specified internal parameter ('outputSampleRate' or 'inputBufferSize')
     * inputBufferSize can bet set to 8192 or 16384. Warning: when speech recognition is running, a buffer size of 8192 is used. Don't change it during the recognition process.
     * outputSampleRate can bet set to 16000 Hz, 22050 Hz, 44100 Hz or 48000 Hz. Warning: if speech synthesis is running, a sample rate of 16000 Hz or 22050 Hz is used (depending of the language). Don't change it during the synthesis process
     * pParamName: Name of the parameter to set ('outputSampleRate' or 'inputBufferSize').
     * pParamValue: The value to which the specified parameter should be set.
     */
    public void setParameter(String param1, Integer param2) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setParameter", param1, param2);
        else
            service.call("setParameter", param1, param2).get();
    }

    /**
     * 119 getParameter              Int32 (String)
     * This method returns the specified internal parameter ('outputSampleRate' or 'inputBufferSize'). The value -1 is returned if the specified parameter is not valid.
     * pParamName: Name of the parameter to get ('outputSampleRate' or 'inputBufferSize').
     * return: value of the specified parameter
     */
    public Integer getParameter(String param1) throws CallError, InterruptedException {
        return (Integer) service.call("getParameter", param1).get();
    }

    /**
     * 120 startMicrophonesRecording Void (String)
     * This method allows to record the signal collected on the nao's microphones. You can choose to record only the front microphone in a ogg file, or the 4 microphones in a wav file. In this last case the format of the file is 4 channels, 16 bits little endian, 48 KHz
     * pFileName: Name of the file where to record the sound.
     */
    public void startMicrophonesRecording(String param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("startMicrophonesRecording", param1);
        else
            service.call("startMicrophonesRecording", param1).get();
    }

    /**
     * 121 stopMicrophonesRecording  Void ()
     * This method stops the recording of the sound collected by the microphones.
     */
    public void stopMicrophonesRecording() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("stopMicrophonesRecording");
        else
            service.call("stopMicrophonesRecording").get();
    }

    /**
     * 122 setOutputVolume           Void (Int32)
     * Sets the output sound level of the system.
     * volume: Volume [0-100].
     */
    public void setOutputVolume(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setOutputVolume", param1);
        else
            service.call("setOutputVolume", param1).get();
    }

    /**
     * 123 getOutputVolume           Int32 ()
     * Gets the output sound level of the system.
     * return: outputVolume of the system
     */
    public Integer getOutputVolume() throws CallError, InterruptedException {
        return (Integer) service.call("getOutputVolume").get();
    }

    /**
     * 124 openAudioInputs           Void ()
     * Opens the audio device for capture. If you closed the audio inputs with the closeAudioInputs method, you must call this method to be able to access to the sound data of the nao's microphones.
     */
    public void openAudioInputs() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("openAudioInputs");
        else
            service.call("openAudioInputs").get();
    }

    /**
     * 125 openAudioOutputs          Void ()
     * Opens the audio device for playback. If you closed the audio outputs with the closeAudioOutputs method, you must call this method to ear or send sound onto the nao's loudspeakers.
     */
    public void openAudioOutputs() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("openAudioOutputs");
        else
            service.call("openAudioOutputs").get();
    }

    /**
     * 126 closeAudioInputs          Void ()
     * Closes the audio device for capture. You can call this method if you want to have access to the alsa input buffers in another program than naoqi while naoqi is running (with arecord for example)
     */
    public void closeAudioInputs() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("closeAudioInputs");
        else
            service.call("closeAudioInputs").get();
    }

    /**
     * 127 closeAudioOutputs         Void ()
     * Closes the audio device for playback. close the audio device for capture. You can call this method if you want to send sound to alsa in another program than naoqi while naoqi is running (with aplay for example)
     */
    public void closeAudioOutputs() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("closeAudioOutputs");
        else
            service.call("closeAudioOutputs").get();
    }

    /**
     * 128 flushAudioOutputs         Void ()
     * Flush the audio device for playback. close the audio device for capture. You can call this method if you want to send sound to alsa in another program than naoqi while naoqi is running (with aplay for example)
     */
    public void flushAudioOutputs() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("flushAudioOutputs");
        else
            service.call("flushAudioOutputs").get();
    }

    /**
     * 129 isOutputClosed            Bool ()
     * Allows to know if audio ouputs are closed or not
     * return: True if audio outputs are closed / False otherwise
     */
    public Boolean isOutputClosed() throws CallError, InterruptedException {
        return (Boolean) service.call("isOutputClosed").get();
    }

    /**
     * 130 isInputClosed             Bool ()
     * Allows to know if audio inputs are closed or not
     * return: True if audio inputs are closed / False otherwise
     */
    public Boolean isInputClosed() throws CallError, InterruptedException {
        return (Boolean) service.call("isInputClosed").get();
    }

    /**
     * 131 listOutputs               Value ()
     * return the list of available outputs
     * return: A list of AudioDeviceInfo
     */
    public com.aldebaran.qimessaging.Object listOutputs() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("listOutputs").get();
    }

    /**
     * 132 output                    Value (UInt32)
     * return the output matching the index
     * index: The output index
     * return: An AudioDeviceInfo
     */
    public com.aldebaran.qimessaging.Object output(Integer param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("output", param1).get();
    }

    /**
     * 133 defaultOutput             UInt32 ()
     * return the default output
     * return: The default output index
     */
    public Integer defaultOutput() throws CallError, InterruptedException {
        return (Integer) service.call("defaultOutput").get();
    }

    /**
     * 134 setDefaultOutput          Void (UInt32)
     * set the default output
     * index: The output index
     */
    public void setDefaultOutput(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setDefaultOutput", param1);
        else
            service.call("setDefaultOutput", param1).get();
    }

    /**
     * 135 listInputs                Value ()
     * return the list of available inputs
     * return: A list of AudioDeviceInfo
     */
    public com.aldebaran.qimessaging.Object listInputs() throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("listInputs").get();
    }

    /**
     * 136 input                     Value (UInt32)
     * return the input matching the index
     * index: The input index
     * return: An AudioDeviceInfo
     */
    public com.aldebaran.qimessaging.Object input(Integer param1) throws CallError, InterruptedException {
        return (com.aldebaran.qimessaging.Object) service.call("input", param1).get();
    }

    /**
     * 137 defaultInput              UInt32 ()
     * return the default input
     * return: The default input index
     */
    public Integer defaultInput() throws CallError, InterruptedException {
        return (Integer) service.call("defaultInput").get();
    }

    /**
     * 138 setDefaultInput           Void (UInt32)
     * set the default input
     * index: The input index
     */
    public void setDefaultInput(Integer param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setDefaultInput", param1);
        else
            service.call("setDefaultInput", param1).get();
    }

    /**
     * 139 playSine                  Void (Int32,Int32,Int32,Float)
     * Play a sine wave which specified caracteristics.
     * frequence: Frequence in Hertz
     * gain: Volume Gain between 0 and 100
     * pan: Stereo Pan set to either {-1,0,+1}
     * duration: Duration of the sine wave in seconds
     */
    public void playSine(Integer param1, Integer param2, Integer param3, Float param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("playSine", param1, param2, param3, param4);
        else
            service.call("playSine", param1, param2, param3, param4).get();
    }

    /**
     * 140 enableEnergyComputation   Void ()
     * Enables the computation of the energy of each microphone signal
     */
    public void enableEnergyComputation() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("enableEnergyComputation");
        else
            service.call("enableEnergyComputation").get();
    }

    /**
     * 141 disableEnergyComputation  Void ()
     * Disables the computation of the energy of each microphone signal
     */
    public void disableEnergyComputation() throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("disableEnergyComputation");
        else
            service.call("disableEnergyComputation").get();
    }

    /**
     * 142 getLeftMicEnergy          Float ()
     * Returns the energy of the left microphone signal
     * return: energy of the left microphone signal
     */
    public Float getLeftMicEnergy() throws CallError, InterruptedException {
        return (Float) service.call("getLeftMicEnergy").get();
    }

    /**
     * 143 getRightMicEnergy         Float ()
     * Returns the energy of the right microphone signal
     * return: energy of the right microphone signal
     */
    public Float getRightMicEnergy() throws CallError, InterruptedException {
        return (Float) service.call("getRightMicEnergy").get();
    }

    /**
     * 144 getFrontMicEnergy         Float ()
     * Returns the energy of the front microphone signal
     * return: energy of the front microphone signal
     */
    public Float getFrontMicEnergy() throws CallError, InterruptedException {
        return (Float) service.call("getFrontMicEnergy").get();
    }

    /**
     * 145 getRearMicEnergy          Float ()
     * Returns the energy of the rear microphone signal
     * return: energy of the rear microphone signal
     */
    public Float getRearMicEnergy() throws CallError, InterruptedException {
        return (Float) service.call("getRearMicEnergy").get();
    }

    /**
     * 147 setClientPreferences      Void (String,Int32,Int32,Int32)
     * Set AudioDevice Client preferences
     * name: name of the client
     * sampleRate: sample rate of the microphones data sent to the process function - must be 16000 or 48000
     * channelsConfiguration: An int (defined in ALSoundExtractor) indicating which microphones data will be send to the process function. ALLCHANNELS, LEFTCHANNEL, RIGHTCHANNEL, FRONTCHANNEL, REARCHANNEL are the configuration currently supported.
     * deinterleaved: indicates if the microphones data sent to the process function are interleaved or not - 0 : interleaved - 1 : deinterleaved
     */
    public void setClientPreferences(String param1, Integer param2, Integer param3, Integer param4) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setClientPreferences", param1, param2, param3, param4);
        else
            service.call("setClientPreferences", param1, param2, param3, param4).get();
    }

    /**
     * 148 setClientPreferences      Void (String,Int32,Value,Int32,Int32)
     * Set AudioDevice Client preferences. This function is deprecated, the use of the alternate 4 arguments setClientPreferences() is now prefered.
     * name: name of the client
     * sampleRate: sample rate of the microphones data sent to the processSound or processSoundRemote functions - must be 16000 or 48000
     * channelsVector: ALValue containing a vector of int indicating which microphones data will be send to the processSound or processSoundRemote functions
     * deinterleaved: indicates if the microphones data sent to the processSound or processSoundRemote functions are interleaved or not - 0 : interleaved - 1 : deinterleaved
     * timeStamp: parameter indicating if audio timestamps are sent to the processSound or processSoundRemote functions - 0 : no - 1 : yes
     */
    public void setClientPreferences(String param1, Integer param2, com.aldebaran.qimessaging.Object param3, Integer param4, Integer param5) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("setClientPreferences", param1, param2, param3, param4, param5);
        else
            service.call("setClientPreferences", param1, param2, param3, param4, param5).get();
    }

    /**
     * 149 muteAudioOut              Void (Bool)
     * mute the loudspeakers
     */
    public void muteAudioOut(Boolean param1) throws CallError, InterruptedException {
        if (isAsynchronous)
            service.call("muteAudioOut", param1);
        else
            service.call("muteAudioOut", param1).get();
    }

    /**
     * 151 isAudioOutMuted           Bool ()
     * check if loudspeakers are muted
     * return: 1 if true / 0 otherwise
     * * Signals:
     * 153 speakersPlaying (Bool)
     */
    public Boolean isAudioOutMuted() throws CallError, InterruptedException {
        return (Boolean) service.call("isAudioOutMuted").get();
    }


}
    