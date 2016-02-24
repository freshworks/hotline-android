package com.example.demoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.freshdesk.hotline.Hotline;
import com.google.android.gms.gcm.GcmListenerService;

/**
 * @author Prasannan N
 */
public class MyGcmListenerService extends GcmListenerService {

	private static final String TAG = "MyGcmListenerService";

	/**
	 * Called when message is received.
	 *
	 * @param from SenderID of the sender.
	 * @param data Data bundle containing message data as key/value pairs.
	 *			   For Set of keys use data.keySet().
	 */
	// [START receive_message]
	@Override
	public void onMessageReceived(String from, Bundle data) {
		String message = data.getString("message");
		Log.d(TAG, "From: " + from);
		Log.d(TAG, "Message: " + message);

		if (from.startsWith("/topics/")) {
			// Process message received from some topic and return
			return;
		}
		// Else process normal downstream message.
		Hotline instance = Hotline.getInstance(this);
		Intent intent = new Intent();
		intent.putExtras(data);

		if (instance.isHotlineNotification(intent)) {
			instance.handleGcmMessage(intent);
			return;
		} else {
			//process your app's notification messages
		}
	}
	// [END receive_message]
}
