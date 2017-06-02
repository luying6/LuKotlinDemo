package com.luying.lukotlindemo.di.component

import com.luying.lukotlindemo.mvp.Contract.FuckGoodsContract
import com.luying.lukotlindemo.ui.fragment.HomeFragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 * 创建人：luying
 * 创建时间：2017/6/2
 * 类说明：
 */
@Subcomponent(modules = arrayOf(FuckGoodsModule::class))
interface FuckGoodsComponent{
    //需要注入的fragment
    fun inject(fragment: HomeFragment)
}


@Module
class FuckGoodsModule(private val mView: FuckGoodsContract.View){
    @Provides
    fun getView() = mView
}