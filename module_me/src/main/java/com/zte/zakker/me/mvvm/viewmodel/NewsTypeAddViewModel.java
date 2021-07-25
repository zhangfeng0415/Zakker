package com.zte.zakker.me.mvvm.viewmodel;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.zte.zakker.api.dto.RespDTO;
import com.zte.zakker.api.http.ExceptionHandler;
import com.zte.zakker.api.newstype.entity.NewsType;
import com.zte.zakker.common.event.SingleLiveEvent;
import com.zte.zakker.common.mvvm.viewmodel.BaseViewModel;
import com.zte.zakker.common.util.DateUtil;
import com.zte.zakker.common.util.ToastUtil;
import com.zte.zakker.common.util.log.KLog;
import com.zte.zakker.me.mvvm.model.NewsTypeAddModel;

import java.util.Date;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
/**
 * Description: <NewsTypeAddModel><br>
 * Author:      mxdl<br>
 * Date:        2019/07/02<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsTypeAddViewModel extends BaseViewModel<NewsTypeAddModel> {
    public static final String TAG = NewsTypeAddModel.class.getSimpleName();
    private SingleLiveEvent<Void> addNewsTypeSuccViewEvent;
    public ObservableField<String> typeName = new ObservableField<>();

    public NewsTypeAddViewModel(@NonNull Application application, NewsTypeAddModel model) {
        super(application, model);
    }

    public void addNewsType() {
        if (TextUtils.isEmpty(typeName.get())) {
            ToastUtil.showToast("请输入新闻类型");
            return;
        }
        NewsType newsType = new NewsType();
        newsType.setTypename(typeName.get());
        newsType.setAddtime(DateUtil.formatDate(new Date(), DateUtil.FormatType.yyyyMMddHHmmss));
        mModel.addNewsType(newsType).doOnSubscribe(this).subscribe(new Observer<RespDTO<NewsType>>() {
            @Override
            public void onSubscribe(Disposable d) {
                KLog.v("MYTAG","viewmodel postShowTransLoadingViewEvent start...");
                postShowTransLoadingViewEvent(true);
            }

            @Override
            public void onNext(RespDTO<NewsType> newsTypeRespDTO) {
                if (newsTypeRespDTO.code == ExceptionHandler.APP_ERROR.SUCC) {
                    ToastUtil.showToast("添加成功");
                    addNewsTypeSuccViewEvent.call();
                } else {
                    ToastUtil.showToast("添加失败");
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
    public SingleLiveEvent<Void> getAddNewsTypeSuccViewEvent() {
        return addNewsTypeSuccViewEvent = createLiveData(addNewsTypeSuccViewEvent);
    }

}
