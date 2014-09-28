package fr.ghostwan.waoremote.qihelper;

/**
 * Created by erwan on 26/04/2014.
 */
public interface QiSessionCallback {
    public void onConnectionStateChanged(int connectionState);

    void log(String s);

}
