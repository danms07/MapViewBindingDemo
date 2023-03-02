package com.hms.demoandroid.mapdatabindingdemo

import android.app.Application
import com.huawei.hms.maps.MapsInitializer

class MyApplication:Application(){
    override fun onCreate() {
        MapsInitializer.initialize(this)
        MapsInitializer.setApiKey(getString(R.string.API_KEY))
        super.onCreate()
    }
}