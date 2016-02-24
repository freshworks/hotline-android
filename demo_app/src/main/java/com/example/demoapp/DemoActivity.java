package com.example.demoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.freshdesk.hotline.Hotline;
import com.freshdesk.hotline.HotlineConfig;
import com.freshdesk.hotline.HotlineUser;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class DemoActivity extends AppCompatActivity {

    private Hotline hotlineInstance;
    private Button btnShowConversations, btnShowFAQs;
    public static final int PLAY_SERVICES_RESOLUTION_REQUEST = 4329;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        //init
        HotlineConfig hotlineConfig=new HotlineConfig("<YOUR-APP-ID>","<YOUR-APP-KEY>");
        Hotline.getInstance(getApplicationContext()).init(hotlineConfig);

        //Update user information
        HotlineUser user = Hotline.getInstance(getApplicationContext()).getUser();
        user.setName("John Doe").setEmail("john@john.doe").setPhone("001", "2542542544");
        Hotline.getInstance(getApplicationContext()).updateUser(user);

        btnShowFAQs = (Button) findViewById(R.id.btnShowFAQs);
        btnShowConversations = (Button) findViewById(R.id.btnShowConversations);
        btnShowFAQs.setOnClickListener(viewClickListener);
        btnShowConversations.setOnClickListener(viewClickListener);

        if(checkPlayServices(this)) {
            Intent intent = new Intent(this, MyGcmRegistrationService.class);
            startService(intent);
        }
    }

    View.OnClickListener viewClickListener = new View.OnClickListener() {
        @Override
        public void onClick (View v) {
            if(v.getId() == R.id.btnShowFAQs) {

                Hotline.showFAQs(DemoActivity.this);

            } else if(v.getId() == R.id.btnShowConversations) {

                Hotline.showConversations(DemoActivity.this);

            }
        }
    };

    /**
     * Check the device to make sure it has the Google Play Services APK. If
     * it doesn't, display a dialog that allows users to download the APK from
     * the Google Play Store or enable it in the device's system settings.
     */
    private boolean checkPlayServices(Activity activityContext) {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(activityContext);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(activityContext, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i("demoapp", "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }

}
