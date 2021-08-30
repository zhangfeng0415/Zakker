package com.zte.zakker.me.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zte.zakker.common.mvvm.BaseFragment;
import com.zte.zakker.common.view.SettingBarView;
import com.zte.zakker.me.NewsDetailAddActivity;
import com.zte.zakker.me.NewsTypeListActivity;
import com.zte.zakker.me.R;
import com.zte.zakker.me.adapter.SettingAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Description: <MainMeFragment><br>
 * Author:      mxdl<br>
 * Date:        2018/12/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainMeFragment extends BaseFragment {

    private SettingBarView mSetNewsType;
    private SettingBarView mSetNewsDetail;
    private List<Setting> settingList = new ArrayList<>();
    private View lview;

    public static MainMeFragment newInstance() {
        return new MainMeFragment();
    }


    @Override
    public int onBindLayout() {
        return R.layout.fragment_me_main;
    }

    @Override
    public void initView(View view) {
        //mSetNewsType = view.findViewById(R.id.view_setting_news_type);
        //mSetNewsDetail = view.findViewById(R.id.view_setting_news_detail);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        lview = inflater.inflate(R.layout.fragment_me_main, container,false);
        initSettings();
        SettingAdapter adapter = new SettingAdapter(getContext(), R.layout.setting_item, settingList);
        ListView listView = (ListView) lview.findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        return lview;

    }

    @Override
    public void initListener() {
        /*mSetNewsType.setOnClickSettingBarViewListener(new SettingBarView.OnClickSettingBarViewListener() {
            @Override
            public void onClick() {
                startActivity(new Intent(mActivity,NewsTypeListActivity.class));
            }
        });
        mSetNewsDetail.setOnClickSettingBarViewListener(new SettingBarView.OnClickSettingBarViewListener() {
            @Override
            public void onClick() {
                startActivity(new Intent(mActivity,NewsDetailAddActivity.class));
            }
        });*/
    }

    @Override
    public void initData() {

    }

    @Override
    public String getToolbarTitle() {
        return "我的";
    }

    private void initSettings() {
        Setting set_share = new Setting("共享", R.drawable.share, R.drawable.chevron_right);
        settingList.add(set_share);
        Setting set_combine = new Setting("设备耗材", R.drawable.combine, R.drawable.chevron_right);
        settingList.add(set_combine);
        Setting set_voice = new Setting("语音设置", R.drawable.voice_guide, R.drawable.chevron_right);
        settingList.add(set_voice);
        Setting set_view = new Setting("小组件", R.drawable.view_quilt, R.drawable.chevron_right);
        settingList.add(set_view);
        Setting set_watch = new Setting("WATCH", R.drawable.watch, R.drawable.chevron_right);
        settingList.add(set_watch);
        Setting set_bluetooth = new Setting("蓝牙网关", R.drawable.bluetooth, R.drawable.chevron_right);
        settingList.add(set_bluetooth);
        Setting set = new Setting("设置", R.drawable.settings, R.drawable.chevron_right);
        settingList.add(set);
    }
}
