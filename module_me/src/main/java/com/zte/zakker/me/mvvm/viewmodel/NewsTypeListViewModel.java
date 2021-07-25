package com.zte.zakker.me.mvvm.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;

import com.zte.zakker.api.dto.RespDTO;
import com.zte.zakker.api.http.ExceptionHandler;
import com.zte.zakker.api.newstype.entity.NewsType;
import com.zte.zakker.common.event.EventCode;
import com.zte.zakker.common.event.me.NewsTypeCrudEvent;
import com.zte.zakker.common.mvvm.viewmodel.BaseRefreshViewModel;
import com.zte.zakker.common.util.ToastUtil;
import com.zte.zakker.me.mvvm.model.NewsTypeListModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Description: <NewsTypeListViewModel><br>
 * Author:      mxdl<br>
 * Date:        2019/07/02<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsTypeListViewModel extends BaseRefreshViewModel<NewsType, NewsTypeListModel> {
    private boolean isfirst = true;

    public NewsTypeListViewModel(@NonNull Application application, NewsTypeListModel model) {
        super(application, model);
    }

    @Override
    public boolean enableRefresh() {
        return true;
    }

    @Override
    public void refreshData() {
        postShowNoDataViewEvent(false);
        if (isfirst) {
            postShowInitLoadViewEvent(true);
        }
        mModel.getListNewsType().doOnSubscribe(this).subscribe(new Observer<RespDTO<List<NewsType>>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(RespDTO<List<NewsType>> listRespDTO) {
                List<NewsType> listNewsType = listRespDTO.data;
                if (listNewsType != null && listNewsType.size() > 0) {
                    mList.clear();
                    mList.addAll(listNewsType);
                } else {
                    postShowNoDataViewEvent(true);
                }
                if (isfirst) {
                    isfirst = false;
                    postShowInitLoadViewEvent(false);
                } else {
                    postStopRefreshEvent();
                }
            }

            @Override
            public void onError(Throwable e) {
                postShowInitLoadViewEvent(false);
            }

            @Override
            public void onComplete() {
            }
        });
    }

    @Override
    public void loadMore() {
        mModel.getListNewsType().doOnSubscribe(this).subscribe(new Observer<RespDTO<List<NewsType>>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RespDTO<List<NewsType>> listRespDTO) {
                List<NewsType> listNewsType = listRespDTO.data;
                if (listNewsType != null && listNewsType.size() > 0) {
                    mList.addAll(listNewsType);
                }
                postStopLoadMoreEvent();
            }

            @Override
            public void onError(Throwable e) {
                postStopLoadMoreEvent();
            }

            @Override
            public void onComplete() {
            }
        });
    }


    public void deleteNewsTypeById(final int id) {
        mModel.deleteNewsTypeById(id).subscribe(new Observer<RespDTO>() {
            @Override
            public void onSubscribe(Disposable d) {
                postShowTransLoadingViewEvent(true);
            }

            @Override
            public void onNext(RespDTO respDTO) {
                if (respDTO.code == ExceptionHandler.APP_ERROR.SUCC) {
                    ToastUtil.showToast("删除成功");
                    postAutoRefreshEvent();
                    EventBus.getDefault().post(new NewsTypeCrudEvent(EventCode.MeCode.NEWS_TYPE_DELETE));
                } else {
                    ToastUtil.showToast("删除失败");
                }
            }

            @Override
            public void onError(Throwable e) {
                postShowTransLoadingViewEvent(false);
            }

            @Override
            public void onComplete() {
                postShowTransLoadingViewEvent(false);
            }
        });
    }

}
