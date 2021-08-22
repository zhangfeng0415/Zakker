package com.zte.zakker.home.mvvm.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.zte.zakker.api.dto.RespDTO;
import com.zte.zakker.api.news.entity.NewsDetail;
import com.zte.zakker.common.mvvm.viewmodel.BaseRefreshViewModel;
import com.zte.zakker.common.util.NetUtil;
import com.zte.zakker.home.mvvm.model.NewsListModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Description: <NewsListPresenter><br>
 * Author:      mxdl<br>
 * Date:        2019/5/28<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsListViewModel extends BaseRefreshViewModel<NewsDetail, NewsListModel> {
    private int newsType = 0;

    public NewsListViewModel(@NonNull Application application, NewsListModel model) {
        super(application, model);
    }

    public void refreshData() {
        postShowNoDataViewEvent(false);
        if (!NetUtil.checkNetToast()) {
            postShowNetWorkErrViewEvent(true);
            return;
        }
        mModel.getListNewsByType(newsType).subscribe(new Observer<RespDTO<List<NewsDetail>>>() {
            @Override
            public void onSubscribe(Disposable d) {
                postShowInitLoadViewEvent(true);
            }

            @Override
            public void onNext(RespDTO<List<NewsDetail>> listRespDTO) {
                List<NewsDetail> datailList = listRespDTO.data;
                if (datailList != null && datailList.size() > 0) {
                    mList.clear();
                    mList.addAll(datailList);
                } else {
                    postShowNoDataViewEvent(true);
                }
                postStopRefreshEvent();
            }

            @Override
            public void onError(Throwable e) {
                postShowInitLoadViewEvent(false);
            }

            @Override
            public void onComplete() {
                postShowInitLoadViewEvent(false);
            }
        });
    }

    @Override
    public void loadMore() {
        mModel.getListNewsByType(newsType).subscribe(new Observer<RespDTO<List<NewsDetail>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RespDTO<List<NewsDetail>> listRespDTO) {
                List<NewsDetail> datailList = listRespDTO.data;
                if (datailList != null && datailList.size() > 0) {
                    mList.addAll(datailList);
                }
            }

            @Override
            public void onError(Throwable e) {
                postStopLoadMoreEvent();
            }

            @Override
            public void onComplete() {
                postStopLoadMoreEvent();
            }
        });
    }


    public void setNewsType(int newsType) {
        this.newsType = newsType;
    }
}
