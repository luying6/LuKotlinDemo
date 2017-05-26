package com.luying.lukotlindemo.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.luying.lukotlindemo.R

class MainActivity : AppCompatActivity() {

    private var mTextMessage: TextView? = null
    private var navigation: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()


    }

    private fun initView() {
        mTextMessage = findViewById(R.id.message) as TextView
        navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation!!.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home            -> mTextMessage!!.setText(R.string.title_home)
            R.id.navigation_dashboard       -> mTextMessage!!.setText(R.string.title_dashboard)
            R.id.navigation_notifications   -> mTextMessage!!.setText(R.string.title_notifications)
        }
        false
    }
}
