package com.example.lamp.di

import android.content.Context
import com.example.lamp.MyApplication

val Context.appComponent: AppComponent
    get() = when(this){
        is MyApplication -> this.appComponent
        else -> applicationContext.appComponent
    }

/*val Context.appComponent: AppComponent
    get() = (this.applicationContext as MyApplication).appComponent*/