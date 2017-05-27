package com.luying.lukotlindemo.ui.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.luying.lukotlindemo.R
import com.luying.lukotlindemo.ui.fragment.DashboardFragment
import com.luying.lukotlindemo.ui.fragment.HomeFragment
import com.luying.lukotlindemo.ui.fragment.NotificationsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var manager: FragmentManager = supportFragmentManager
    private lateinit var fragment: MutableList<Fragment>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initFragment()
    }

    private fun initFragment() {
        fragment = ArrayList()
        fragment.add(HomeFragment.newInstance())
        fragment.add(DashboardFragment.newInstance())
        fragment.add(NotificationsFragment.newInstance())
        manager.beginTransaction().add(R.id.content, fragment[0]).commit()
    }

    private fun initView() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                selectFragment(0)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                selectFragment(1)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                selectFragment(2)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun selectFragment(tab: Int) {

        if (fragment[tab].isAdded) {
            if (fragment[tab].isHidden) {
                manager.beginTransaction().show(fragment[tab]).commit()
            }
        } else {
            manager.beginTransaction().add(R.id.content, fragment[tab]).commit()
        }
        (0..(fragment.size - 1))
                .filter { it != tab && fragment[it].isAdded }
                .forEach { manager.beginTransaction().hide(fragment[it]).commit() }
    }
}

