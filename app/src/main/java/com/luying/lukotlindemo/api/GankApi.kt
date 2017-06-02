package com.luying.lukotlindemo.api

import com.luying.lukotlindemo.entity.FuckGoods
import com.luying.lukotlindemo.entity.HttpResult
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable
/**
 * 创建人：luying
 * 创建时间：2017/6/1
 * 类说明：
 */
interface GankApi {
    /**
     * Android所有数据
     */
    @GET("data/Android/10/{page}")
    fun getAndroidData(@Path("page") page:Int): Observable<HttpResult<List<FuckGoods>>>

    /**
     * iOS所有数据
     */
    @GET("data/iOS/10/{page}")
    fun getiOSData(@Path("page") page:Int): Observable<HttpResult<List<FuckGoods>>>
}