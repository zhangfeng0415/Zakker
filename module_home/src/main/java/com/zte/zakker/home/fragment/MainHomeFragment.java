package com.zte.zakker.home.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.zte.zakker.api.newstype.entity.NewsType;
import com.zte.zakker.common.event.me.NewsTypeCrudEvent;
import com.zte.zakker.common.mvvm.BaseMvvmFragment;
import com.zte.zakker.common.util.log.KLog;
import com.zte.zakker.home.R;
import com.zte.zakker.home.mvvm.factory.NewsViewModelFactory;
import com.zte.zakker.home.mvvm.viewmodel.NewsTypeViewModel;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: <MainHomeFragment><br>
 * Author:      mxdl<br>
 * Date:        2018/12/27<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MainHomeFragment extends BaseMvvmFragment<ViewDataBinding,NewsTypeViewModel> {
    private List<String> titles = new ArrayList<>();
    private List<NewsListFragment> mListFragments = new ArrayList<>();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private HomeFragmentAdapter mHomeFragmentAdapter;
    private boolean mIsfresh;

    public static MainHomeFragment newInstance() {
        return new MainHomeFragment();
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_home_main;
    }

    @Override
    public void initView(View view) {
        mViewPager = view.findViewById(R.id.pager_tour);
        mTabLayout = view.findViewById(R.id.layout_tour);
    }

    @Override
    public void initData() {
        mViewModel.getListNewsType();
    }

    @Override
    public void initListener() {
        //mViewPager.setOffscreenPageLimit(mListFragments.size());
    }

    public void initTabLayout() {
        mHomeFragmentAdapter = new HomeFragmentAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mHomeFragmentAdapter);
        mHomeFragmentAdapter.refreshViewPager(mListFragments);

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mListFragments.get(tab.getPosition()).autoLoadData();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mTabLayout.setupWithViewPager(mViewPager);
    }


    public void showListNewsType(List<NewsType> listNewsType) {
        KLog.v("MYTAG", "initNewsListFragment start..." + listNewsType.toString());
        mListFragments.clear();
        titles.clear();
        if (listNewsType != null && listNewsType.size() > 0) {
            for (int i = 0; i < listNewsType.size(); i++) {
                NewsType newsType = listNewsType.get(i);
                mListFragments.add(NewsListFragment.newInstance(newsType));
                titles.add(newsType.getTypename());
            }
        }
    }

    @Override
    public Class<NewsTypeViewModel> onBindViewModel() {
        return NewsTypeViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return NewsViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {
        mViewModel.getListSingleLiveEvent().observe(this, new Observer<List<NewsType>>() {
            @Override
            public void onChanged(@Nullable List<NewsType> newsTypes) {
                showListNewsType(newsTypes);
                initTabLayout();
            }
        });
    }

    @Override
    public int onBindVariableId() {
        return 0;
    }

    class HomeFragmentAdapter extends FragmentPagerAdapter {
        public FragmentManager mFragmentManager;
        List<NewsListFragment> pages;

        public HomeFragmentAdapter(FragmentManager fm) {
            super(fm);
            mFragmentManager = fm;
        }


        @Override
        public Fragment getItem(int position) {
            if (pages != null) {
                return pages.get(position);
            }
            return null;
        }


        @Override
        public int getCount() {
            return pages != null ? pages.size() : 0;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            return POSITION_NONE;
        }

        public void refreshViewPager(List<NewsListFragment> listFragments) {
            if (pages != null && pages.size() > 0) {
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                for (NewsListFragment fragment : pages) {
                    fragmentTransaction.remove(fragment);
                }
                fragmentTransaction.commit();
                mFragmentManager.executePendingTransactions();
            }
            pages = listFragments;
            notifyDataSetChanged();

            mViewPager.setCurrentItem(0);
        }
    }

    @Override
    public String getToolbarTitle() {
        return null;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(NewsTypeCrudEvent event) {
        mIsfresh = true;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        KLog.v("MYTAG", "onHiddenChanged start..." + hidden);
        if (mIsfresh && !hidden) {
            KLog.v("MYTAG", "ViewPager refresh start...");
            mIsfresh = false;
            mViewPager.setCurrentItem(mListFragments.size() - 1);
            initData();
            mHomeFragmentAdapter.refreshViewPager(mListFragments);
        }
    }
}
