package com.zte.zakker.me.mvvm.model;

import android.app.Application;

import com.zte.zakker.api.NewsTypeService;
import com.zte.zakker.api.RetrofitManager;
import com.zte.zakker.api.dto.RespDTO;
import com.zte.zakker.api.http.RxAdapter;
import com.zte.zakker.api.newstype.entity.NewsType;
import com.zte.zakker.common.mvvm.model.BaseModel;

import io.reactivex.Observable;

/**
 * Description: <NewsTypeAddModel><br>
 * Author:      mxdl<br>
 * Date:        2019/07/02<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsTypeAddModel extends BaseModel{
    private NewsTypeService mNewsTypeService;
    public NewsTypeAddModel(Application application) {
        super(application);
        mNewsTypeService = RetrofitManager.getInstance().getNewsTypeService();
    }
    public Observable<RespDTO<NewsType>> addNewsType(NewsType type) {
        return mNewsTypeService.addNewsType(type)
                .compose(RxAdapter.schedulersTransformer())
                .compose(RxAdapter.exceptionTransformer());
    }

}
