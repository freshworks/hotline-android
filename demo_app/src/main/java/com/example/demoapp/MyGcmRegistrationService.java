package com.example.demoapp;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.freshdesk.hotline.Hotline;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

/**
 * @author Prasannan N
 */
public class MyGcmRegistrationService extends IntentService {

	private static final String TAG = "MyGcmRegService";
	private static final String ANDROID_PROJECT_SENDER_ID = "<YOUR_SENDER_ID_GOES_HERE>";

	public MyGcmRegistrationService() {
		super(TAG);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		try {
			Log.d(TAG, "Asking GCM for Token");
			// Initially this call goes out to the network to retrieve the token, subsequent calls are local.
			InstanceID instanceID = InstanceID.getInstance(this);
			String token = instanceID.getToken(ANDROID_PROJECT_SENDER_ID, GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
			Log.i(TAG, "GCM Registration Token: " + token);

			sendRegistrationToServer(this, token);
		} catch (Exception e) {
			Log.d(TAG, "Failed to complete token refresh", e);
			// If an exception happens while fetching the new token or updating our registration data
			// on a third-party server, make sure to attempt the update at a later time.
		}
	}

	private void sendRegistrationToServer(Context context, String token) {
		Hotline.getInstance(context).updateGcmRegistrationToken(token);
		Log.d(TAG, "Sending GCM Token to Hotline: " + token);
	}
}
