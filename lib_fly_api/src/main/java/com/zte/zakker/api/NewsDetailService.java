package com.zte.zakker.api;


import com.zte.zakker.api.config.API;
import com.zte.zakker.api.dto.RespDTO;
import com.zte.zakker.api.news.entity.NewsDetail;
import com.zte.zakker.api.newstype.entity.NewsType;

import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewsDetailService {
    @POST("/newsapi/newsdetail/query/all")
    Observable<RespDTO<List<NewsDetail>>> getListNewsDetailByType(@Query("typid") int typeid);

    @GET("/newsapi/newsdetail/{id}/detail")
    Observable<RespDTO<NewsDetail>> getNewsDetailById(@Path("id") int id);

    @POST("/newsapi/newsdetail/save")
    Observable<RespDTO<NewsDetail>> addNewsDetail(@Body NewsDetail newsDetail);

}
