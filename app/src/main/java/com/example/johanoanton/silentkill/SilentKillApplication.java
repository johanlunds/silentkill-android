package com.example.johanoanton.silentkill;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by johan_lunds on 2017-03-10.
 */

public class SilentKillApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

}
