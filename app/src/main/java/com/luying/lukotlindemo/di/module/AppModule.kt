package com.luying.lukotlindemo.di.module

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * 创建人：luying
 * 创建时间：2017/5/27
 * 类说明：
 */
@Module
class AppModule(private val context: Context){
    @Provides
    fun provideContext() = context

}