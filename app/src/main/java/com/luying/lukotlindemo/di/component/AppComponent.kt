package com.luying.lukotlindemo.di.component

import android.content.Context
import com.luying.lukotlindemo.di.module.AppModule
import dagger.Component

/**
 * 创建人：luying
 * 创建时间：2017/5/27
 * 类说明：
 */
@Component(modules = arrayOf(AppModule::class))
 interface AppComponent {
    //向下层提供context对象
    fun proContext() : Context
}