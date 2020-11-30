package com.example.work4.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import androidx.fragment.app.Fragment;

import com.example.work4.Adapter.GvAdapter;
import com.example.work4.Adapter.MusicAdapter;
import com.example.work4.Individual.Music;
import com.example.work4.Individual.Music2;
import com.example.work4.R;

import java.util.ArrayList;
import java.util.List;

public class MyFragment2 extends Fragment {
private List<Music> musicList=new ArrayList<>();
    private List<Music2> musicList2=new ArrayList<>();
        GridView ms_gridView;
    GvAdapter gvadapter;
int flag=0;
    MediaPlayer mMediaPlayer=new MediaPlayer();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_2, container, false);
        initMusics();
        MusicAdapter musicAdapter=new MusicAdapter(getContext(),R.layout.music_item,musicList);
        gvadapter=new GvAdapter(getContext(),R.layout.music_item2,musicList2);
        ListView listView=view.findViewById(R.id.music_list);
        listView.setAdapter(musicAdapter);
        ms_gridView=view.findViewById(R.id.gv_music);
        ms_gridView.setAdapter(gvadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Music music=musicList.get(position);
        switch (music.getName()) {
            case "演员":
                if (!mMediaPlayer.isPlaying()) {
                    mMediaPlayer = MediaPlayer.create(getContext(), R.raw.music5);
                    mMediaPlayer.start();
                }
                else
                {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    mMediaPlayer=null;
                    mMediaPlayer = MediaPlayer.create(getContext(), R.raw.music5);
                    mMediaPlayer.start();
                }
                break;
            case "天外来物":
                if (!mMediaPlayer.isPlaying()) {
                    mMediaPlayer = MediaPlayer.create(getContext(), R.raw.music4);
                    mMediaPlayer.start();
                }
                else
                {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    mMediaPlayer=null;
                    mMediaPlayer = MediaPlayer.create(getContext(), R.raw.music4);
                    mMediaPlayer.start();
                }
                break;
            case "MELANCHOLY":
                if (!mMediaPlayer.isPlaying()) {
                    mMediaPlayer = MediaPlayer.create(getContext(), R.raw.music1);
                    mMediaPlayer.start();
                }
                else
                {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    mMediaPlayer=null;
                    mMediaPlayer = MediaPlayer.create(getContext(), R.raw.music1);
                    mMediaPlayer.start();
                }
                break;
            case "深海少女":
                if (!mMediaPlayer.isPlaying()) {
                    mMediaPlayer = MediaPlayer.create(getContext(), R.raw.music2);
                    mMediaPlayer.start();
                }
                else
                {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    mMediaPlayer=null;
                    mMediaPlayer = MediaPlayer.create(getContext(), R.raw.music2);
                    mMediaPlayer.start();
                }
                break;
            case "目不转睛":
                if (!mMediaPlayer.isPlaying()) {
                    mMediaPlayer = MediaPlayer.create(getContext(), R.raw.music3);
                    mMediaPlayer.start();
                }
                else
                {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    mMediaPlayer=null;
                    mMediaPlayer = MediaPlayer.create(getContext(), R.raw.music3);
                    mMediaPlayer.start();
                }
                break;
            case "失眠症":
                if (!mMediaPlayer.isPlaying()) {
                    mMediaPlayer = MediaPlayer.create(getContext(), R.raw.music6);
                    mMediaPlayer.start();
                }
                else
                {
                    mMediaPlayer.stop();
                    mMediaPlayer.release();
                    mMediaPlayer=null;
                    mMediaPlayer = MediaPlayer.create(getContext(), R.raw.music6);
                    mMediaPlayer.start();
                }
        }
    }
});
        return view;
    }
    private void initMusics() {
        for(int i=0;i<5;i++) {
            Music music1 = new Music("MELANCHOLY", R.mipmap.pic1);
            musicList.add(music1);
            Music music2 = new Music("深海少女", R.mipmap.pic2);
            musicList.add(music2);
            Music music3 = new Music("目不转睛", R.mipmap.pic3);
            musicList.add(music3);
            Music music4 = new Music("天外来物", R.mipmap.pic4);
            musicList.add(music4);
            Music music5 = new Music("演员", R.mipmap.pic5);
            musicList.add(music5);
            Music music6 = new Music("失眠症", R.mipmap.pic6);
            musicList.add(music6);
        }
        musicList2.add(new Music2(R.drawable.pic7,"第1~8季合集"));
        musicList2.add(new Music2(R.drawable.pic8,"好听到单曲循环"));
        musicList2.add(new Music2(R.mipmap.pic3,"温柔男声"));
        musicList2.add(new Music2(R.mipmap.pic4,"写作业必备歌单"));
        musicList2.add(new Music2(R.mipmap.pic5,"声声入耳 句句戳心"));
        musicList2.add(new Music2(R.mipmap.pic6,"减肥！跑步歌单"));
    }


}