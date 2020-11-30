package com.example.work4.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.work4.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyFragment3 extends Fragment {
Button button;
EditText editText;
TextView textView;
String str;
    class Myhandler extends Handler
    {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 1:textView.setText((String)msg.obj);
                break;
                case 2:Toast.makeText(getContext(), "请求失败", Toast.LENGTH_LONG).show();
                break;
            }
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_3, container, false);
        final Myhandler myhandler = new Myhandler();
        button = view.findViewById(R.id.get_data);
        editText = view.findViewById(R.id.url);
        textView = view.findViewById(R.id.txt3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "加载中-----", Toast.LENGTH_LONG).show();
                OkHttpClient mOkHttpClient = new OkHttpClient();
                final Request request = new Request.Builder()
                        .url(editText.getText().toString())
                        .build();
                Call call = mOkHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Message message2=Message.obtain();
                        message2.what=2;
                        myhandler.sendMessage(message2);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        str = response.body().string();
                        Message message = Message.obtain();
                        message.what = 1;
                        message.obj = str;
                        myhandler.sendMessage(message);
                    }
                });
            }
        });
        return view;
    }
//        myhandler.post(new Runnable() {
//            @Override
//            public void run() {
//                textView.setText(str);
//            }
//        });

}