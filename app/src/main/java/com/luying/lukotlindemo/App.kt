package com.luying.lukotlindemo

import android.app.Application

/**
 * 创建人：luying
 * 创建时间：2017/5/25
 * 类说明：
 */
class App : Application(){
    init {
        app = this
    }

    override fun onCreate() {
        super.onCreate()

    }

    companion object{
        lateinit var app: App
    }
}