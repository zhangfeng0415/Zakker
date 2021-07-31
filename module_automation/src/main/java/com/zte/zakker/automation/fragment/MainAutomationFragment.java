package com.zte.zakker.automation.fragment;

import android.view.View;

import com.zte.zakker.common.mvvm.BaseFragment;
import com.zte.zakker.automation.R;

/**
 * Description: <发现Fragment><br>
 * Author:      mxdl<br>
 * Date:        2018/12/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainAutomationFragment extends BaseFragment {
    public static final String TAG = MainAutomationFragment.class.getSimpleName();
    public static MainAutomationFragment newInstance() {
        return new MainAutomationFragment();
    }
    @Override
    public int onBindLayout() {
        return R.layout.fragment_automation_main;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }

    @Override
    public String getToolbarTitle() {
        return null;
    }
}
