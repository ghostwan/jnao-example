package fr.ghostwan.waoremote.qihelper;

import android.util.Log;
import com.aldebaran.qimessaging.CallError;
import com.aldebaran.qimessaging.Future;
import com.aldebaran.qimessaging.Session;
import fr.ghostwan.waoremote.qihelper.AL;

import java.util.HashMap;

/**
 * Created by epinault on 10/03/14.
 */
public class ProxyHelper {

	private static HashMap<String, com.aldebaran.qimessaging.Object> proxies = new HashMap<String, com.aldebaran.qimessaging.Object>();
	private static Session session;


	public static void setSession(Session sessionValue) {
		proxies.clear();
		session = sessionValue;
	}
	public static com.aldebaran.qimessaging.Object getProxy(String name) throws ProxyException {

		com.aldebaran.qimessaging.Object proxy = proxies.get(name);
		if (proxy == null) {
			if (session != null && session.isConnected()) {
				try {
					proxy = session.service(name);
					proxies.put(name, proxy);
				} catch (Exception e) {
					throw new ProxyException(" Can create proxy " + name);
				}
			} else {
				throw new ProxyException("Session is not connected");
			}
		}

		return proxy;
	}



	public static <T> Future<T> call(String proxyName, String event, Object... objetcs) throws ProxyException {

		com.aldebaran.qimessaging.Object proxy = getProxy(proxyName);
		try {
			return proxy.call(event, objetcs);
		} catch (CallError callError) {
			throw new ProxyException("Error calling "+event);
		}
	}

	public static void raiseEvent (String type, Object... value) throws ProxyException {
		call(AL.MEMORY, "raiseEvent", "ALTabletService/" + type, value);

	}

	public static Object get(String proxyName, String name, String... params) throws ProxyException {

		com.aldebaran.qimessaging.Object proxy = getProxy(proxyName);
		try {
			return proxy.call(name, params).get();
		} catch (Exception e) {
            Log.e("Proxy","error" ,e);
            throw new ProxyException("Error calling "+name);
		}
	}

	public static Object getMemoryData(String... params) throws ProxyException {
		return get(AL.MEMORY, "getData", params);
	}

	public static Object getPreferenceValue(String... params) throws ProxyException {
		return get(AL.PREFERENCE_MANAGER, "getValue", params);
	}

//	public static void subscribeToEvent(String event, String callBack) {
//		try {
//			call(AL.MEMORY, "subscribeToEvent", event, "ALTabletService", callBack);
//		} catch (ProxyException e) {
//			ALLog.e(TAG,e);
//		}
//	}


	public static Float getMemoryDataFloat(String... params) throws ProxyException {

		Object result = getMemoryData(params);
		if (result instanceof Float)
			return (Float) result;
		else
			return null;
	}

	public static Integer getMemoryDataInteger(String... params) throws ProxyException {

		Object result = getMemoryData(params);
		if (result instanceof Integer)
			return (Integer) result;
		else
			return null;
	}

	public static Boolean getMemoryDataBoolean(String... params) throws ProxyException {

		Object result = getMemoryData(params);
		if (result instanceof Boolean)
			return (Boolean) result;
		else
			return null;
	}

	public static String getMemoryDataString(String... params) throws ProxyException {

		Object result = getMemoryData(params);
		if (result instanceof String)
			return (String) result;
		else
			return null;
	}


	public static String getPreferenceValueString(String... params) throws ProxyException {

		Object result = getPreferenceValue(params);
		if (result instanceof String)
			return (String) result;
		else
			return null;
	}


	public static class ProxyException extends Exception {

		public ProxyException(String detailMessage) {
			super(detailMessage);
		}
	}
}
