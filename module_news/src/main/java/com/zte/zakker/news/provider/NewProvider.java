package com.zte.zakker.news.provider;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zte.zakker.common.provider.INewsProvider;
import com.zte.zakker.news.fragment.MainNewsFragment;

/**
 * Description: <NewProvider><br>
 * Author:      mxdl<br>
 * Date:        2019/5/23<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
@Route(path = "/news/main",name = "新闻")
public class NewProvider implements INewsProvider {
    @Override
    public Fragment getMainNewsFragment() {
        return MainNewsFragment.newInstance();
    }

    @Override
    public void init(Context context) {

    }
}
