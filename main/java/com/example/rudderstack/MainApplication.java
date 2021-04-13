package com.example.rudderstack;

import android.app.Application;


import com.rudderstack.android.sdk.core.RudderClient;
import com.rudderstack.android.sdk.core.RudderConfig;
import com.rudderstack.android.sdk.core.RudderLogger;
import com.rudderstack.android.sdk.core.RudderProperty;
public class MainApplication extends Application {
    //Create field 'rudderClient' in 'MainApplication
    public static RudderClient rudderClient;
    @Override
    public void onCreate() {
        super.onCreate();
        rudderClient = RudderClient.getInstance(
                this,
                "1r4gSLHXTs5BjiVFiHEiUmuCVVB",
                new RudderConfig.Builder()
                        .withTrackLifecycleEvents(true)
                        .withRecordScreenViews(true)
                        .build()
        );
    }
}