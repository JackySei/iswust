package com.example.work4.Fragment;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.work4.Activities.BookActivity;
import com.example.work4.Activities.MovieActivity;
import com.example.work4.Adapter.AdAdapter;
import com.example.work4.R;

public class MyFragment1 extends Fragment {
    View view;
    ViewPager advpager = null;
    Button buttona,buttonb,buttonc,buttond,buttone,buttonf,buttong,buttontext,button_movie;
    CheckBox buttonh;
    boolean isVisible =true;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fg_1, container, false);
        AdAdapter adAdapter = new AdAdapter(getChildFragmentManager());
        advpager = view.findViewById(R.id.advpager);
        advpager.setAdapter(adAdapter);
        buttona=view.findViewById(R.id.btn_a);
        buttonb=view.findViewById(R.id.btn_b);
        buttonc=view.findViewById(R.id.btn_c);
        buttond=view.findViewById(R.id.btn_d);
        buttone=view.findViewById(R.id.btn_e);
        buttonf=view.findViewById(R.id.btn_f);
        buttong=view.findViewById(R.id.btn_g);
        buttonh=view.findViewById(R.id.btn_h);
        buttontext=view.findViewById(R.id.btn_text);
        button_movie=view.findViewById(R.id.btn_movie);
        buttontext.setVisibility(View.INVISIBLE);
        button_movie.setVisibility(View.INVISIBLE);
        buttontext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), BookActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(),"请选择章节",Toast.LENGTH_SHORT).show();

            }
        });
        button_movie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MovieActivity.class);
                startActivity(intent);
            }
        });
        buttonh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isVisible)
                {
                    buttontext.setVisibility(View.VISIBLE);
                    button_movie.setVisibility(View.VISIBLE);
                    isVisible=false;
                }
                else
                {
                    buttontext.setVisibility(View.INVISIBLE);
                    button_movie.setVisibility(View.INVISIBLE);
                    isVisible=true;
                }
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mHandler.sendEmptyMessageDelayed(1,3000);
    }
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    int count = 3;
                    int currentItem=advpager.getCurrentItem();
                    int now=(currentItem+1)%count;
                    advpager.setCurrentItem(now,true);
                    this.sendEmptyMessageDelayed(1,3000);
            }
        }
    };
}