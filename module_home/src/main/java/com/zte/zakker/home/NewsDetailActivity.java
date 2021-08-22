package com.zte.zakker.home;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import com.zte.zakker.common.event.KeyCode;
import com.zte.zakker.common.mvvm.BaseMvvmActivity;
import com.zte.zakker.home.databinding.ActivityNewsDetailBinding;
import com.zte.zakker.home.mvvm.factory.NewsViewModelFactory;
import com.zte.zakker.home.mvvm.viewmodel.NewsDetailViewModel;
/**
 * Description: <NewsDetailActivity><br>
 * Author:      mxdl<br>
 * Date:        2019/05/25<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */

public class NewsDetailActivity extends BaseMvvmActivity<ActivityNewsDetailBinding, NewsDetailViewModel> {
    public static void startNewsDetailActivity(Context context,int id){
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra(KeyCode.News.NEWS_ID,id);
        context.startActivity(intent);
    }

    @Override
    public int onBindLayout() {
        return R.layout.activity_news_detail;
    }


    @Override
    public void initData() {
        int newsid = getIntent().getIntExtra(KeyCode.News.NEWS_ID,-1);
        mViewModel.getNewsDetailById(newsid);
    }

    @Override
    public Class<NewsDetailViewModel> onBindViewModel() {
        return NewsDetailViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return NewsViewModelFactory.getInstance(getApplication());
    }

    @Override
    public void initViewObservable() {

    }

    @Override
    public int onBindVariableId() {
        return BR.viewModel;
    }
}
