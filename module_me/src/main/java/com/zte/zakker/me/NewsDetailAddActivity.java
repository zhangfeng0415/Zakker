package com.zte.zakker.me;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.Nullable;

import com.zte.zakker.api.newstype.entity.NewsType;
import com.zte.zakker.common.adapter.BaseAdapter;
import com.zte.zakker.common.mvvm.BaseMvvmActivity;
import com.zte.zakker.me.databinding.ActivityNewsDetailAddBinding;
import com.zte.zakker.me.mvvm.factory.MeViewModelFactory;
import com.zte.zakker.me.mvvm.model.NewsDetailAddModel;
import com.zte.zakker.me.mvvm.viewmodel.NewsDetailAddViewModel;
import com.zte.zakker.me.view.NewsTypeBottomSelectDialog;

import java.util.List;

/**
 * Description: <NewsDetailAddActivity><br>
 * Author:      mxdl<br>
 * Date:        2019/07/02<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsDetailAddActivity extends BaseMvvmActivity<ActivityNewsDetailAddBinding,NewsDetailAddViewModel> {
    @Override
    public int onBindLayout() {
        return R.layout.activity_news_detail_add;
    }

    @Override
    public void initData() {
    }

    public void showNewsType(List<NewsType> typeList) {
        NewsTypeBottomSelectDialog newsTypeBottomSelectDialog = NewsTypeBottomSelectDialog.newInstance(typeList);
        newsTypeBottomSelectDialog.setItemClickListener(new BaseAdapter.OnItemClickListener<NewsType>() {
            @Override
            public void onItemClick(NewsType newsType, int position) {
                mViewModel.setNewsType(newsType);
                mBinding.viewMeSetNewsType.setContent(newsType.getTypename());
            }
        });
        newsTypeBottomSelectDialog.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public Class<NewsDetailAddViewModel> onBindViewModel() {
        return NewsDetailAddViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return MeViewModelFactory.getInstance(getApplication());
    }

    @Override
    public void initViewObservable() {
        mViewModel.getSingleNewsTypeLiveEvent().observe(this, new Observer<List<NewsType>>() {
            @Override
            public void onChanged(@Nullable List<NewsType> newsTypes) {
                showNewsType(newsTypes);
            }
        });
    }

    @Override
    public int onBindVariableId() {
        return BR.viewModel;
    }
}
