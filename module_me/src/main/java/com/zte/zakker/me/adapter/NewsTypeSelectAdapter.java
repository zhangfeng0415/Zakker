package com.zte.zakker.me.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zte.zakker.api.newstype.entity.NewsType;
import com.zte.zakker.common.adapter.BaseAdapter;
import com.zte.zakker.me.R;

/**
 * Description: <NewsTypeShowAdapter><br>
 * Author:      mxdl<br>
 * Date:        2019/5/27<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsTypeSelectAdapter extends BaseAdapter<NewsType, NewsTypeSelectAdapter.MyViewHolder> {
    public NewsTypeSelectAdapter(Context context) {
        super(context);
    }

    @Override
    protected int onBindLayout() {
        return R.layout.item_news_type_select;
    }

    @Override
    protected MyViewHolder onCreateHolder(View view) {
        return new MyViewHolder(view);
    }

    @Override
    protected void onBindData(MyViewHolder holder, NewsType newsType, int positon) {
        holder.mTxtNewTypeTitle.setText(newsType.getTypename());
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTxtNewTypeTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtNewTypeTitle = itemView.findViewById(R.id.txt_me_news_type_title);

        }
    }
}
