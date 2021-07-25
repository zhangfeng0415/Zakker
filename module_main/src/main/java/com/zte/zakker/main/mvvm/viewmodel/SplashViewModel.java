package com.zte.zakker.main.mvvm.viewmodel;

import android.app.Application;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.zte.zakker.api.RetrofitManager;
import com.zte.zakker.api.dto.RespDTO;
import com.zte.zakker.api.http.ExceptionHandler;
import com.zte.zakker.api.security.Token;
import com.zte.zakker.api.user.LoginDTO;
import com.zte.zakker.common.event.SingleLiveEvent;
import com.zte.zakker.common.mvvm.viewmodel.BaseViewModel;
import com.zte.zakker.main.mvvm.model.SplashModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Description: <SplashPresenter><br>
 * Author:      mxdl<br>
 * Date:        2019/6/22<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class SplashViewModel extends BaseViewModel<SplashModel>{
    public static String TAG = SplashViewModel.class.getSimpleName();
    private SingleLiveEvent<Void> mVoidSingleLiveEvent;

    public SplashViewModel(@NonNull Application application, SplashModel model) {
        super(application, model);
    }
    public void login() {
        mModel.getToken("mxdl","123456").subscribe(new Observer<Token>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Token token) {
                if(token != null){
                    RetrofitManager.getInstance().addToken(token.getAccess_token());
                }else{
                    Log.v(TAG,"token is null");
                }
            }

            @Override
            public void onError(Throwable e) {
                getmVoidSingleLiveEvent().call();
            }

            @Override
            public void onComplete() {
                getmVoidSingleLiveEvent().call();
            }
        });
    }

    private void login1() {
        mModel.login("gxl","123456").subscribe(new Observer<RespDTO<LoginDTO>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(RespDTO<LoginDTO> loginDTORespDTO) {
                if(loginDTORespDTO.code == ExceptionHandler.APP_ERROR.SUCC){
                    //RetrofitManager.getInstance().TOKEN = "Bearer "+loginDTORespDTO.data.getToken();
                    RetrofitManager.getInstance().addToken(loginDTORespDTO.data.getToken());
                }else{
                    Log.v(TAG,"error:"+loginDTORespDTO.error);
                }
            }

            @Override
            public void onError(Throwable e) {
                getmVoidSingleLiveEvent().call();
            }

            @Override
            public void onComplete() {
                getmVoidSingleLiveEvent().call();
            }
        });
    }

    public SingleLiveEvent<Void> getmVoidSingleLiveEvent() {
        return mVoidSingleLiveEvent = createLiveData(mVoidSingleLiveEvent);
    }
}