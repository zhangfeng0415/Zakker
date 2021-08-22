package com.zte.zakker.home.mvvm.model;

import android.app.Application;
import com.zte.zakker.api.NewsTypeService;
import com.zte.zakker.api.RetrofitManager;
import com.zte.zakker.api.dto.RespDTO;
import com.zte.zakker.api.http.RxAdapter;
import com.zte.zakker.api.newstype.entity.NewsType;
import com.zte.zakker.common.mvvm.model.BaseModel;
import java.util.List;

import io.reactivex.Observable;
/**
 * Description: <NewsDetailModel><br>
 * Author:      mxdl<br>
 * Date:        2019/5/29<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsTypeModel extends BaseModel {
    private NewsTypeService mNewsTypeService;

    public NewsTypeModel(Application application) {
        super(application);
        mNewsTypeService = RetrofitManager.getInstance().getNewsTypeService();
    }

    public Observable<RespDTO<List<NewsType>>> getListNewsType() {
        return mNewsTypeService.getListNewsType()
                .compose(RxAdapter.schedulersTransformer())
                .compose(RxAdapter.exceptionTransformer());
    }
}
