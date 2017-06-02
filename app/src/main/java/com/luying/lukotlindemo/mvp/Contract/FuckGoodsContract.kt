package com.luying.lukotlindemo.mvp.Contract

import com.luying.lukotlindemo.entity.FuckGoods
import com.luying.lukotlindemo.entity.HttpResult
import rx.Observable

/**
 * 创建人：luying
 * 创建时间：2017/6/1
 * 类说明：
 */
interface FuckGoodsContract {
    interface View{
        fun showFuckGoods(results: List<FuckGoods>)
    }


    interface Model{
        fun loadFuckGoods(page: Int, type:String) : Observable<HttpResult<List<FuckGoods>>>
    }


    interface Presenter {
        open fun loadData(page: Int, type: String)
    }
}