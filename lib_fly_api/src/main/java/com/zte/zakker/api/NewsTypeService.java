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

public interface NewsTypeService {
    @POST("/newsapi/newstype/query/all")
    Observable<RespDTO<List<NewsType>>> getListNewsType();

    @GET("/newsapi/newstype/{id}/delete")
    Observable<RespDTO> deleteNewsTypeById(@Path("id") int id);

    @POST("/newsapi/newstype/save")
    Observable<RespDTO<NewsType>> addNewsType(@Body NewsType type);
}
