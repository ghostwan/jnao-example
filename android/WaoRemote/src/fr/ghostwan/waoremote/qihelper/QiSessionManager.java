package fr.ghostwan.waoremote.qihelper;

import android.os.Handler;
import com.aldebaran.qimessaging.Session;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author proullon, ekroeger
 */
public class QiSessionManager {

	public static final int DISCONNECTED = 0;
	public static final int CONNECTED_NOT_REGISTERED = 1;
	public static final int REGISTERED = 2;

//	private Lock mutex = null;
	private Session session = null;
	private String serviceDirectoryAddress;
	private Handler threadHandler = new Handler();
    private QiSessionCallback callback;


	public QiSessionManager(QiSessionCallback callback) {
        this.callback = callback;
	}

	/**
	 * Initialize tablet QiMessaging service
	 *
	 */
	public void init(String serviceDirectoryAddress) {
		this.serviceDirectoryAddress = serviceDirectoryAddress;

		this.session = new Session();
		threadHandler.post(connectionRunnbale);
	}

	private boolean isConnecting = false;

	private final Runnable connectionRunnbale = new Runnable() {
		public void run() {
			callback.log("Starting new connection " + serviceDirectoryAddress);
			isConnecting = true;
			if (session == null) {
                callback.log( "Unexpected: no session during reconnect.");
				session = new Session();
			}


			if (tryToConnect()) {
                callback.log( "Reconnection routine successful!");
				isConnecting = false;
			}
			else {
				threadHandler.postDelayed(this,1000);
			}
		}
	};


	/**
	 * Steps through all the connection steps.
	 */
	private boolean tryToConnect() {
		setConnectionState(DISCONNECTED);

		// Connect session to ServiceDirectory
		try {
            callback.log("Connecting to " + serviceDirectoryAddress);
			session.connect(serviceDirectoryAddress).sync(500, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			// If protocol is different from robot, update
			String message = e.getMessage();
            callback.log( "Session connection failed: " + message);
			return false;
		}

        callback.log( "Connected?");

		if (!session.isConnected()) {
            callback.log( "Stopping: not connected.");
			return false;
		}
		setConnectionState(CONNECTED_NOT_REGISTERED);

		// Set a callback to reconnected service if connection is lost at some
		// point
//		session.onDisconnected("onDisconnected", this);

        callback.log( "Connection, complete!.");

		ProxyHelper.setSession(session);
		setConnectionState(REGISTERED);
		// Finished!
		return true;
	}

	/**
	 * Called when connection between service and service directory is lost.
	 *
	 * @param message Error message
	 * @throws InterruptedException
	 */
	public void onDisconnected(String message) throws InterruptedException {
		// onDisconnected is called in a callback of disconnected session,
		// it is not possible to reconnected session while onDisconnected
		// session.
		// This is why we get a new one.
		if(!isConnecting) {
            callback.log( "Session diconnected from service directory: " + message);
			threadHandler.removeCallbacks(connectionRunnbale);
			threadHandler.post(connectionRunnbale);
		}

	}


	/**
	 * Close session to unregister service, set disposed to true to avoid
	 * reconnection routine to be started set session to null
	 */
	public void dispose() {
		setConnectionState(DISCONNECTED);
        callback.log( "Disposing!");
        threadHandler.removeCallbacks(connectionRunnbale);
		isConnecting = true;
		if (session != null) {
			session.close();
			session = null;
		}

	}


	/**
	 * Create a QiMessaging obj
	 *
	 * @return
	 * @throws Exception
	 */

	/**
	 * Helper
	 */

	// Used internally for debug
	private void setConnectionState(final int connectionState) {
        callback.onConnectionStateChanged(connectionState);
	}



	public boolean isSessionActive() {
		return session != null && session.isConnected();
	}

    public Session getSession() {
        return session;
    }
}
