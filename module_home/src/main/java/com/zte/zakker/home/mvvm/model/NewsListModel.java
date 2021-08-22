package com.zte.zakker.home.mvvm.model;

import android.app.Application;

import com.zte.zakker.api.NewsDetailService;
import com.zte.zakker.api.RetrofitManager;
import com.zte.zakker.api.dto.RespDTO;
import com.zte.zakker.api.http.RxAdapter;
import com.zte.zakker.api.news.entity.NewsDetail;
import com.zte.zakker.common.mvvm.model.BaseModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Description: <NewsListModel><br>
 * Author:      mxdl<br>
 * Date:        2019/5/28<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsListModel extends BaseModel {
    private NewsDetailService mNewsDetailService;

    public NewsListModel(Application application) {
        super(application);
        mNewsDetailService = RetrofitManager.getInstance().getNewsDetailService();
    }

    public Observable<RespDTO<List<NewsDetail>>> getListNewsByType(int typeid) {
        return mNewsDetailService.getListNewsDetailByType(typeid)
        .compose(RxAdapter.exceptionTransformer())
        .compose(RxAdapter.schedulersTransformer());
    }
}
