package com.standard.library.base;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {

    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
}
