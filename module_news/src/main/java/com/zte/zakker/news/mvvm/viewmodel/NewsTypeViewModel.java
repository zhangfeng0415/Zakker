package com.zte.zakker.news.mvvm.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;
import com.zte.zakker.api.dto.RespDTO;
import com.zte.zakker.api.newstype.entity.NewsType;
import com.zte.zakker.common.event.SingleLiveEvent;
import com.zte.zakker.common.mvvm.viewmodel.BaseViewModel;
import com.zte.zakker.news.mvvm.model.NewsTypeModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Description: <NewsTypePresenter><br>
 * Author:      mxdl<br>
 * Date:        2019/6/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsTypeViewModel extends BaseViewModel<NewsTypeModel>{
    private SingleLiveEvent<List<NewsType>> mListSingleLiveEvent;
    public NewsTypeViewModel(@NonNull Application application, NewsTypeModel model) {
        super(application, model);
    }

    public void getListNewsType() {
        mModel.getListNewsType().subscribe(new Observer<RespDTO<List<NewsType>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RespDTO<List<NewsType>> listRespDTO) {
                getListSingleLiveEvent().postValue(listRespDTO.data);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
    public SingleLiveEvent<List<NewsType>> getListSingleLiveEvent() {
        return mListSingleLiveEvent = createLiveData(mListSingleLiveEvent);
    }
}
