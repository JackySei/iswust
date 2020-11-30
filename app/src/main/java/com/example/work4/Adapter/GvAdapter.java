package com.example.work4.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.work4.Individual.Music2;
import com.example.work4.R;

import java.util.List;

public class GvAdapter extends ArrayAdapter<Music2> {

    int resourceId;
    public GvAdapter(@NonNull Context context, int resource, @NonNull List<Music2> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Music2 music =getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView imageView = view.findViewById(R.id.img_music);
        TextView textView= view.findViewById(R.id.txt_music);
        imageView.setImageResource(music.getMusicId());
        textView.setText(music.getText());
        return view;
    }
}
