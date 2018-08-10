package com.charleyskills.mafiaprojectpro;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import java.util.HashMap;

public class MafiaProjectProApp extends Application
{
    public MafiaProjectProApp() {
        super();
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    private static Context mContext;

    public static void setContext(Context context)
    {
        mContext = context;
    }

    public static Context getContext()
    {
        return mContext;
    }
}
