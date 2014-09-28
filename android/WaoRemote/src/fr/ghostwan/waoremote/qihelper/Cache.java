package fr.ghostwan.waoremote.qihelper;

import android.app.Application;
import android.util.Log;

import java.io.File;

/**
 * Since there is only ~70Mo allowed to the application on the LG tablet,
 * here is a helper class to clean cache.
 * @author proullon
 *
 */
public class Cache {

    public static void clearApplicationData(Application application) {
        File cache = application.getCacheDir();
        File appDir = new File(cache.getParent());
        if (appDir.exists()) {
            String[] children = appDir.list();
            for (String s : children) {
                if (!s.equals("lib")) {
                    if (deleteDir(new File(appDir, s)) == false)
	                    Log.e("tabletbrowser", "****** Cannot delete /data/data/jp.softbank.custombrowser/" + s);
                    else
	                    Log.i("tabletbrowser", "****** File /data/data/APP_PACKAGE/" + s + " deleted");
                }
            }
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }

        return dir.delete();
    }
}