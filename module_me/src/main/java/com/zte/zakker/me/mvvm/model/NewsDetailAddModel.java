package com.zte.zakker.me.mvvm.model;

import android.app.Application;
import android.content.Context;

import com.zte.zakker.api.NewsDetailService;
import com.zte.zakker.api.NewsTypeService;
import com.zte.zakker.api.RetrofitManager;
import com.zte.zakker.api.dto.RespDTO;
import com.zte.zakker.api.http.RxAdapter;
import com.zte.zakker.api.news.entity.NewsDetail;
import com.zte.zakker.api.newstype.entity.NewsType;
import com.zte.zakker.common.mvvm.model.BaseModel;
import com.zte.zakker.common.util.DateUtil;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Description: <NewsDetailAddModel><br>
 * Author:      mxdl<br>
 * Date:        2019/07/02<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsDetailAddModel extends BaseModel {
    private NewsTypeService mNewsTypeService;
    private NewsDetailService mNewsDetailService;

    public NewsDetailAddModel(Application application) {
        super(application);
        mNewsTypeService = RetrofitManager.getInstance().getNewsTypeService();
        mNewsDetailService = RetrofitManager.getInstance().getNewsDetailService();
    }

    public Observable<RespDTO<NewsDetail>> addNewsDetail(int type, String title, String content) {
        NewsDetail newsDetail = new NewsDetail();
        newsDetail.setTypeid(type);
        newsDetail.setTitle(title);
        newsDetail.setContent(content);
        newsDetail.setAddtime(DateUtil.formatDate(new Date(), DateUtil.FormatType.yyyyMMddHHmmss));
        return mNewsDetailService.addNewsDetail(newsDetail)
                .compose(RxAdapter.schedulersTransformer())
                .compose(RxAdapter.exceptionTransformer());
    }

    public Observable<RespDTO<List<NewsType>>> getNewsType() {
        return mNewsTypeService.getListNewsType()
                .compose(RxAdapter.schedulersTransformer())
                .compose(RxAdapter.exceptionTransformer());
    }
}
