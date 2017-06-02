package com.luying.lukotlindemo.di.module

import android.content.Context
import android.util.Log
import com.luying.lukotlindemo.api.GankApi
import com.luying.lukotlindemo.di.qualifier.QGankApi
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers
import java.io.File
import javax.inject.Singleton

/**
 * 创建人：luying
 * 创建时间：2017/6/1
 * 类说明：
 */
@Module(includes = arrayOf(AppModule::class))
class RetrofitModule{
    @Provides
    fun provideOkhttp(context: Context, interceptor: HttpLoggingInterceptor): OkHttpClient {
        val cacheSize = 1024 * 1024 * 10L
        val cacheDir = File(context.cacheDir, "http")
        val cache = Cache(cacheDir, cacheSize)
        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor)
                .build()
    }

    @Provides
    fun provideInterceptor() :HttpLoggingInterceptor{
        val interceptor = HttpLoggingInterceptor{
            msg -> Log.d("okhttp",msg)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }



    @Singleton
    @Provides
    @QGankApi
    internal fun provideGankRetrofit(builder: Retrofit.Builder, client: OkHttpClient): Retrofit {
        return provideRetrofit(builder, client, "http://gank.io/api/" )
    }



    @Singleton
    @Provides
    internal fun provideGankApi(@QGankApi retrofit: Retrofit): GankApi {
        return retrofit.create<GankApi>(GankApi::class.java)
    }


    fun provideRetrofit(builder: Retrofit.Builder, client: OkHttpClient, url: String): Retrofit {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}