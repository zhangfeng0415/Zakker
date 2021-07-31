package com.zte.zakker.main;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.zte.zakker.common.mvvm.BaseActivity;
import com.zte.zakker.common.provider.IAutomationProvider;
import com.zte.zakker.common.provider.IFindProvider;
import com.zte.zakker.common.provider.IMeProvider;
import com.zte.zakker.common.provider.INewsProvider;
import com.zte.zakker.main.entity.MainChannel;

/**
 * Description: <BaseRefreshLayout><br>
 * Author:      mxdl<br>
 * Date:        2019/02/25<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainActivity extends BaseActivity {
    @Autowired(name = "/news/main")
    INewsProvider mNewsProvider;

    @Autowired(name = "/find/main")
    IFindProvider mFindProvider;

    @Autowired(name = "/automation/main")
    IAutomationProvider mAutomationProvider;

    @Autowired(name = "/me/main")
    IMeProvider mMeProvider;

    private Fragment mNewsFragment;
    private Fragment mFindFragment;
    private Fragment mAutomationFragment;
    private Fragment mMeFragment;
    private Fragment mCurrFragment;

    @Override
    public int onBindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int i = menuItem.getItemId();
                if (i == R.id.navigation_trip) {
                    switchContent(mCurrFragment, mNewsFragment, MainChannel.NEWS.name);
                    mCurrFragment = mNewsFragment;

                    return true;
                } else if (i == R.id.navigation_discover) {
                    switchContent(mCurrFragment, mFindFragment, MainChannel.FIND.name);
                    mCurrFragment = mFindFragment;

                    return true;
                } else if (i == R.id.navigation_automation) {
                    switchContent(mCurrFragment, mAutomationFragment, MainChannel.AUTOMATION.name);
                    mCurrFragment = mAutomationFragment;

                    return true;
                } else if (i == R.id.navigation_me) {
                    switchContent(mCurrFragment, mMeFragment, MainChannel.ME.name);
                    mCurrFragment = mMeFragment;

                    return true;
                }
                return false;
            }
        });
        if(mNewsProvider != null){
            mNewsFragment = mNewsProvider.getMainNewsFragment();
        }
        if(mFindProvider != null){
            mFindFragment = mFindProvider.getMainFindFragment();
        }
        if(mAutomationProvider != null){
            mAutomationFragment = mAutomationProvider.getMainFindFragment();
        }
        if(mMeProvider != null){
            mMeFragment = mMeProvider.getMainMeFragment();
        }
        mCurrFragment = mNewsFragment;
        if(mNewsFragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, mNewsFragment, MainChannel.NEWS.name).commit();
        }
    }

    @Override
    public void initData() {

    }

    public void switchContent(Fragment from, Fragment to, String tag) {
        if (from == null || to == null) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!to.isAdded()) {
            transaction.hide(from).add(R.id.frame_content, to, tag).commit();
        } else {
            transaction.hide(from).show(to).commit();
        }
    }
}
