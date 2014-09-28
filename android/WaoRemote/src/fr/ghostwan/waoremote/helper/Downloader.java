package fr.ghostwan.waoremote.helper;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Take in charge the download of a file on SD card.
 *
 * @author mpicard
 *
 */
public class Downloader {

	private DownloadInterface installerInterface;

	public Downloader(DownloadInterface instInt) {
		super();
		this.installerInterface = instInt;
	}

	public boolean hasNetWorkInfo(Context context) throws NetworkErrorException {

		try {
			ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
			if (networkInfo != null && networkInfo.isConnected()) {

				return true;
			} else {
				throw new NetworkErrorException();
			}
		} catch (Exception e) {
			throw new NetworkErrorException();
		}
	}

	public void startDownload(String pathIN, String pathOUT) {
		Boolean result = true;
		try {
			File writeFile = new File(pathOUT);
			writeFile.createNewFile();
			writeFile.mkdirs(); // create directories if needed

			FileOutputStream fos = new FileOutputStream(writeFile);
			try {
				result = downloadUrl(pathIN, fos);

			} catch (IOException e) {
				result = false;
			}
			fos.flush();
			fos.close();

		} catch (IOException e) {
			result = false;
		}

		installerInterface.onDownloadFinished(result);
	}

	// read input stream and add it to output stream
	private void readIt(InputStream stream, FileOutputStream fos) throws IOException, UnsupportedEncodingException {

		int bufferLength = 0;
		byte[] buffer = new byte[512];

		while ((bufferLength = stream.read(buffer)) > 0) {
			fos.write(buffer, 0, bufferLength);
		}
	}

	// connect to url and download
	private boolean downloadUrl(String myurl, FileOutputStream fos) throws IOException {
		InputStream is = null;

		try {
			URL url = new URL(myurl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(2000 /* milliseconds */);
			conn.setConnectTimeout(5000 /* milliseconds */);
			conn.setRequestMethod("GET");
			conn.setDoInput(true);

			// Starts the query
			conn.connect();

			int response = conn.getResponseCode();
			if (response == 200) {
				is = conn.getInputStream();
				readIt(is, fos);
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}

		finally {
			// in all cases, close input stream
			if (is != null) {
				is.close();
			}
		}
		return true;
	}


	public interface DownloadInterface {

		public void onDownloadFinished(Boolean result);
	}


}
