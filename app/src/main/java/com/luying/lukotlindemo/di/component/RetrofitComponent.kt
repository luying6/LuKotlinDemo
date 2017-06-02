package com.luying.lukotlindemo.di.component
import com.luying.lukotlindemo.App
import com.luying.lukotlindemo.di.module.RetrofitModule
import dagger.Component

/**
 * 创建人：luying
 * 创建时间：2017/6/1
 * 类说明：
 */
@Component(modules = arrayOf(RetrofitModule::class))
interface RetrofitComponent {
    fun inject(app: App)

}