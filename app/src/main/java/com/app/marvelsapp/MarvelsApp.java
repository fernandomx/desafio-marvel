/*
 * *
 *  * Created by Fernando Meregali  on 08/10/20 12:56
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 08/10/20 12:56
 *
 */

package com.app.marvelsapp;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class MarvelsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}