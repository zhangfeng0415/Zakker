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

public class PlayAdapter extends ArrayAdapter<PlayWay> {
    private int resourceId;
    public PlayAdapter(@NonNull Context context, int resource, List<PlayWay> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PlayWay playway = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        ImageView playwayImage = (ImageView) view.findViewById(R.id.play_image) ;
        TextView playwayTitle = (TextView) view.findViewById(R.id.play_title);
        TextView playwayText = (TextView) view.findViewById(R.id.play_text);
        ImageView playwayRight = (ImageView) view.findViewById(R.id.play_right);
        playwayImage.setImageResource(playway.getImageId_name());
        playwayTitle.setText(playway.getTitle());
        playwayText.setText(playway.getText());
        playwayRight.setImageResource(playway.getImageId_right());
        return view;
    }
}
