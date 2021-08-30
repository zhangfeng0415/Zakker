package com.zte.zakker.automation.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zte.zakker.automation.R;

import java.util.List;

public class RecommendAdapter  extends ArrayAdapter<Recommend> {
    private int resourceId;
    public RecommendAdapter(@NonNull Context context, int resource, List<Recommend> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Recommend recommend = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView recommendImage = (ImageView) view.findViewById(R.id.recommend_image) ;
        TextView recommendTitle = (TextView) view.findViewById(R.id.recommend_title);
        TextView recommendText = (TextView) view.findViewById(R.id.recommend_text);
        TextView recommendOpen = (TextView) view.findViewById(R.id.open);
        ImageView recommendRight = (ImageView) view.findViewById(R.id.recommend_right);
        recommendImage.setImageResource(recommend.getImageId_name());
        recommendTitle.setText(recommend.getTitle());
        recommendText.setText(recommend.getText());
        recommendOpen.setText(recommend.getOpen());
        recommendRight.setImageResource(recommend.getImageId_right());
        return view;
    }
}