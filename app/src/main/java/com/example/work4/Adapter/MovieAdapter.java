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

import com.example.work4.Individual.Movie;
import com.example.work4.R;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<Movie> {
    private int resourceId;

    public MovieAdapter(@NonNull Context context, int resource, @NonNull List<Movie> objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Movie movie=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView img=view.findViewById(R.id.movie_image);
        TextView nameMovie=view.findViewById(R.id.movie_name);
        TextView dataMovie =view.findViewById(R.id.moive_data);
        TextView directorMovie =view.findViewById(R.id.movie_director);
        img.setImageResource(movie.img);
        nameMovie.setText(movie.getName());
        dataMovie.setText(movie.getData());
        directorMovie.setText(movie.getDirector());
        return view;
    }
}
