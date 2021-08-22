package com.zte.zakker.home.adapter;

import android.content.Context;
import android.databinding.ObservableArrayList;
import android.view.View;
import com.zte.zakker.api.news.entity.NewsDetail;
import com.zte.zakker.common.adapter.BaseBindAdapter;
import com.zte.zakker.home.R;
import com.zte.zakker.home.databinding.ItemNewsListBinding;

/**
 * Description: <NewsListAdatper><br>
 * Author:      mxdl<br>
 * Date:        2019/5/28<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsListAdatper extends BaseBindAdapter<NewsDetail, ItemNewsListBinding> {


    public NewsListAdatper(Context context, ObservableArrayList<NewsDetail> items) {
        super(context, items);
    }

    @Override
    protected int getLayoutItemId(int viewType) {
        return R.layout.item_news_list;
    }

    @Override
    protected void onBindItem(ItemNewsListBinding binding, final NewsDetail item, final int position) {
        binding.setNewsDetail(item);
        binding.viewNewsDetal.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if(mItemClickListener != null){
                    mItemClickListener.onItemClick(item,position);
                }
            }
        });
    }


}
