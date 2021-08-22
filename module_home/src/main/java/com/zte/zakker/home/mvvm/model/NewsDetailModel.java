package com.zte.zakker.home.mvvm.model;

import android.app.Application;

import com.zte.zakker.api.NewsDetailService;
import com.zte.zakker.api.RetrofitManager;
import com.zte.zakker.api.dto.RespDTO;
import com.zte.zakker.api.http.RxAdapter;
import com.zte.zakker.api.news.entity.NewsDetail;
import com.zte.zakker.common.mvvm.model.BaseModel;

import io.reactivex.Observable;

/**
 * Description: <NewsDetailModel><br>
 * Author:      mxdl<br>
 * Date:        2019/5/29<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsDetailModel extends BaseModel {
    private NewsDetailService mNewsDetailService;

    public NewsDetailModel(Application application) {
        super(application);
        mNewsDetailService = RetrofitManager.getInstance().getNewsDetailService();
    }

    public Observable<RespDTO<NewsDetail>> getNewsDetailById(int id) {
        return mNewsDetailService.getNewsDetailById(id)
                .compose(RxAdapter.schedulersTransformer())
                .compose(RxAdapter.exceptionTransformer());
    }
}
