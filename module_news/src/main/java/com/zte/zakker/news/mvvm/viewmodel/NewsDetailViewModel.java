package com.zte.zakker.news.mvvm.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import com.zte.zakker.api.dto.RespDTO;
import com.zte.zakker.api.news.entity.NewsDetail;
import com.zte.zakker.common.mvvm.viewmodel.BaseViewModel;
import com.zte.zakker.common.util.NetUtil;
import com.zte.zakker.news.mvvm.model.NewsDetailModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Description: <NewsDetailPresenter><br>
 * Author:      mxdl<br>
 * Date:        2019/5/29<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsDetailViewModel extends BaseViewModel<NewsDetailModel> {
    public ObservableField<NewsDetail> mNewsDetails = new ObservableField<>();
    public NewsDetailViewModel(@NonNull Application application, NewsDetailModel model) {
        super(application, model);
    }

    public void getNewsDetailById(final int id) {
        if (!NetUtil.checkNetToast()) {
            postShowNetWorkErrViewEvent(true);
            return;
        }
        mModel.getNewsDetailById(id).subscribe(new Observer<RespDTO<NewsDetail>>() {
            @Override
            public void onSubscribe(Disposable d) {
                postShowInitLoadViewEvent(true);
            }

            @Override
            public void onNext(RespDTO<NewsDetail> newsDetailRespDTO) {
                NewsDetail newsDetail = newsDetailRespDTO.data;
                if (newsDetail != null) {
                    //todo getNewsDetailSingleLiveEvent().postValue(newsDetail);
                    mNewsDetails.set(newsDetail);
                } else {
                    postShowNoDataViewEvent(true);
                }
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
//    public SingleLiveEvent<NewsDetail> getNewsDetailSingleLiveEvent() {
//        return mNewsDetailSingleLiveEvent = createLiveData(mNewsDetailSingleLiveEvent);
//    }

}
