package com.viet.news.ui.mine.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.viet.mine.R
import com.viet.news.core.ui.BaseFragment


/**
 * @author null
 */
class MineFragment : BaseFragment() {

    private var mContainerView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mContainerView = inflater.inflate(R.layout.fragment_mine, container, false)
        return mContainerView
    }

    override fun initView(view: View) {
    }
}