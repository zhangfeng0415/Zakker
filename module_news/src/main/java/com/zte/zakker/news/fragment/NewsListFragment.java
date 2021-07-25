package com.zte.zakker.news.fragment;


import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.zte.zakker.api.news.entity.NewsDetail;
import com.zte.zakker.api.newstype.entity.NewsType;
import com.zte.zakker.common.adapter.BaseBindAdapter;
import com.zte.zakker.common.event.KeyCode;
import com.zte.zakker.common.event.me.NewsDetailCurdEvent;
import com.zte.zakker.common.mvvm.BaseMvvmRefreshFragment;
import com.zte.zakker.common.util.ObservableListUtil;
import com.zte.zakker.common.util.log.KLog;
import com.zte.zakker.news.BR;
import com.zte.zakker.news.NewsDetailActivity;
import com.zte.zakker.news.R;
import com.zte.zakker.news.adapter.NewsListAdatper;
import com.zte.zakker.news.databinding.FragmentNewsListBinding;
import com.zte.zakker.news.mvvm.factory.NewsViewModelFactory;
import com.zte.zakker.news.mvvm.viewmodel.NewsListViewModel;

import com.refresh.lib.DaisyRefreshLayout;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
<<<<<<< HEAD
 * Description: <人工智能><br>
=======
 * Description: <NewsListFragment><br>
>>>>>>> 4.1.0
 * Author:      mxdl<br>
 * Date:        2018/12/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsListFragment extends BaseMvvmRefreshFragment<NewsDetail, FragmentNewsListBinding, NewsListViewModel> {
    private NewsType mNewsType;
    private NewsListAdatper mNewsListAdatper;

    public static NewsListFragment newInstance(NewsType newsType) {
        NewsListFragment newsListFragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putParcelable(KeyCode.News.NEWS_TYPE, newsType);
        newsListFragment.setArguments(args);

        return newsListFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mNewsType = getArguments().getParcelable(KeyCode.News.NEWS_TYPE);
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_news_list;
    }

    @Override
    public boolean enableLazyData() {
        return true;
    }

    @Override
    public void initView(View view) {
        KLog.v("MYTAG", "initView start:" + mNewsType.getTypename());

        mNewsListAdatper = new NewsListAdatper(mActivity, mViewModel.getList());
        mNewsListAdatper.setItemClickListener(new BaseBindAdapter.OnItemClickListener<NewsDetail>() {
            @Override
            public void onItemClick(NewsDetail newsDetail, int position) {
                NewsDetailActivity.startNewsDetailActivity(mActivity,newsDetail.getId());
            }
        });
        mViewModel.getList().addOnListChangedCallback(ObservableListUtil.getListChangedCallback(mNewsListAdatper));
        //mBinding.recview.setLayoutManager(new LinearLayoutManager(mActivity));
        mBinding.recview.setAdapter(mNewsListAdatper);
    }

    @Override
    public void initData() {
        mViewModel.setNewsType(mNewsType.getId());
        KLog.v("MYTAG", "initData start:" + mNewsType.getTypename());
        autoLoadData();
    }

    @Override
    public void initListener() {
//        mNewsListAdatper.setItemClickListener(new BaseAdapter.OnItemClickListener<NewsDetail>() {
//            @Override
//            public void onItemClick(NewsDetail newsDetail, int position) {
//                NewsDetailActivity.startNewsDetailActivity(mActivity, newsDetail.getId());
//            }
//        });
    }

    @Override
    public String getToolbarTitle() {
        return null;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(NewsDetailCurdEvent curdEvent) {
        if (curdEvent.getCode() == mNewsType.getId()) {
            autoLoadData();
        }
    }

    @Override
    public Class<NewsListViewModel> onBindViewModel() {
        return NewsListViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return NewsViewModelFactory.getInstance(mActivity.getApplication());
    }

    @Override
    public void initViewObservable() {

    }

    @Override
    public int onBindVariableId() {
        return BR.viewModel;
    }

    @Override
    public DaisyRefreshLayout getRefreshLayout() {
        return mBinding.refviewNewsType;
    }
}
