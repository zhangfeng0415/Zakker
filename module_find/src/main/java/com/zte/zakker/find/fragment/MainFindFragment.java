package com.zte.zakker.find.fragment;

import android.view.View;

import com.zte.zakker.common.mvvm.BaseFragment;
import com.zte.zakker.find.R;

/**
 * Description: <发现Fragment><br>
 * Author:      mxdl<br>
 * Date:        2018/12/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainFindFragment extends BaseFragment {
    public static final String TAG = MainFindFragment.class.getSimpleName();
    public static MainFindFragment newInstance() {
        return new MainFindFragment();
    }
    @Override
    public int onBindLayout() {
        return R.layout.store_speed_plan;
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
