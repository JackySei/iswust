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

import com.example.work4.Individual.Music;
import com.example.work4.R;

import java.util.List;

public class MusicAdapter extends ArrayAdapter<Music> {
    private int resourceId;
    public MusicAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        resourceId=resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Music music= (Music) getItem(position);
        //View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        //提升效率
        View view;
        if (convertView==null)
        {
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else{
            view=convertView;
        }
        ImageView imageView =view.findViewById(R.id.music_image);
        TextView textView =view.findViewById(R.id.music_name);
        imageView.setImageResource(music.getImageId());
        textView.setText(music.getName());
        return view;
    }
}
