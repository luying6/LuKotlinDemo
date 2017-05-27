package com.luying.lukotlindemo.ui.fragment

import android.os.Bundle
import android.view.View
import com.luying.lukotlindemo.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * 创建人：luying
 * 创建时间：2017/5/26
 * 类说明：
 */
class DashboardFragment : BaseFragment(){
    companion object {
        fun newInstance(): DashboardFragment {
            val fragment = DashboardFragment()
            fragment.arguments = Bundle()
            return fragment
        }
    }

    override fun setLayout() = R.layout.fragment_home

    override fun initView(view: View?) {
        my_text.text = "aashboard"
    }
}