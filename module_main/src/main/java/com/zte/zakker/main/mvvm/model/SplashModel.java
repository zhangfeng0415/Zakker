package com.zte.zakker.main.mvvm.model;

import android.app.Application;
import android.content.Context;

import com.zte.zakker.api.CommonService;
import com.zte.zakker.api.RetrofitManager;
import com.zte.zakker.api.dto.RespDTO;
import com.zte.zakker.api.http.RxAdapter;
import com.zte.zakker.api.security.Token;
import com.zte.zakker.api.user.LoginDTO;
import com.zte.zakker.common.mvvm.model.BaseModel;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Description: <SplashModel><br>
 * Author:      mxdl<br>
 * Date:        2019/6/22<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class SplashModel extends BaseModel {
    private CommonService mCommonService;

    public SplashModel(Application application) {
        super(application);
        mCommonService = RetrofitManager.getInstance().getCommonService();
    }


    public Observable<RespDTO<LoginDTO>> login(String username, String password) {
        return mCommonService.login(username, password)
                .compose(RxAdapter.schedulersTransformer())
                .compose(RxAdapter.exceptionTransformer());
    }
    public Observable<Token> getToken(String username, String password) {
        return mCommonService.getToken("Basic bXhkbC1jbGllbnQ6bXhkbC1zZWNyZXQ=","password",username, password)
                .compose(RxAdapter.schedulersTransformer())
                .compose(RxAdapter.exceptionTransformer());
    }
}