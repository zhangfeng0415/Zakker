package com.zte.zakker.automation.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zte.zakker.common.mvvm.BaseFragment;
import com.zte.zakker.automation.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: <发现Fragment><br>
 * Author:      mxdl<br>
 * Date:        2018/12/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainAutomationFragment extends BaseFragment {
    private List<Recommend> recommendlist = new ArrayList<>();
    private List<PlayWay> playlist = new ArrayList<>();
    private View view;
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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_automation_main, container,false);
        initRecommends();
        RecommendAdapter adapter = new RecommendAdapter(getContext(), R.layout.recommend_list, recommendlist);
        ListView listView = (ListView) view.findViewById(R.id.list_recommend);
        listView.setAdapter(adapter);
        initPlay();
        PlayAdapter padapter = new PlayAdapter(getContext(), R.layout.play_list, playlist);
        ListView plistView = (ListView) view.findViewById(R.id.list_play);
        plistView.setAdapter(padapter);
        return view;
    }

    private void initPlay() {
        PlayWay zekker = new PlayWay(R.drawable.box, "Zekker盒子的智能玩法", "一碰尽享智能联动", R.drawable.chevron_right);
        playlist.add(zekker);
        PlayWay sleep = new PlayWay(R.drawable.sleep_mode, "睡眠模式", "安享智能睡眠", R.drawable.chevron_right);
        playlist.add(sleep);
    }

    private void initRecommends() {
        Recommend switch_re = new Recommend(R.drawable.switch_re,"回家开灯", "晚上回家自动开灯", "去开启", R.drawable.chevron_right);
        recommendlist.add(switch_re);
        Recommend go_out = new Recommend(R.drawable.go_out,"我出门了", "关灯并打开扫地机", "去开启", R.drawable.chevron_right);
        recommendlist.add(go_out);
        Recommend good_night = new Recommend(R.drawable.good_night,"晚安", "关灯和窗帘", "去开启", R.drawable.chevron_right);
        recommendlist.add(good_night);
    }

    @Override
    public void initData() {

    }

    @Override
    public String getToolbarTitle() {
        return null;
    }
}
