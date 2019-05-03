package com.tkb.android.rxbasic;

import android.app.Application;
import android.content.Context;

import leakcanary.LeakCanary;
import leakcanary.LeakSentry;
import leakcanary.RefWatcher;

public class RXApplication extends Application {

    RefWatcher watcher ;

    public static RefWatcher getRefWatcher (Context context){
        RXApplication application = (RXApplication)context.getApplicationContext();
        return application.watcher;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        watcher =   LeakSentry.INSTANCE.getRefWatcher();

    }
}
