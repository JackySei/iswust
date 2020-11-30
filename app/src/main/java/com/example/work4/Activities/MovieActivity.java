package com.example.work4.Activities;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import com.example.work4.Individual.Movie;
import com.example.work4.Adapter.MovieAdapter;
import com.example.work4.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class MovieActivity extends AppCompatActivity {
 private List<Movie> movieList=new ArrayList<>();
 ImageView imageView;
 ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        listView=findViewById(R.id.movie_list);
        MovieAdapter adapter=new MovieAdapter(MovieActivity.this,R.layout.movie_item,movieList);
        sendRequest();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie=movieList.get(position);
                Intent intent =new Intent(MovieActivity.this,MovieWebActivity.class);
                switch (movie.getName())
                {
                    case "Titanic":intent.putExtra("movie_url","https://baike.baidu.com/item/%E6%B3%B0%E5%9D%A6%E5%B0%BC%E5%85%8B%E5%8F%B7/6162581?fr=aladdin");
                        break;
                    case "your name":intent.putExtra("movie_url","https://baike.baidu.com/item/%E4%BD%A0%E7%9A%84%E5%90%8D%E5%AD%97%E3%80%82/19127928?fromtitle=%E4%BD%A0%E7%9A%84%E5%90%8D%E5%AD%97&fromid=19126915&fr=aladdin");
                        break;
                }
                startActivity(intent);
                /*Intent intent =new Intent(Intent.ACTION_VIEW);
                switch (movie.name)
                {
                    case "Titanic":intent.setData(Uri.parse("https://baike.baidu.com/item/%E6%B3%B0%E5%9D%A6%E5%B0%BC%E5%85%8B%E5%8F%B7/6162581?fr=aladdin"));
                    break;
                }
                 startActivity(intent);*/
            }
        });
    }
    private void sendRequest() {
        OkHttpClient client=new OkHttpClient();
        Request request =new Request.Builder()
                //.url("http://192.168.1.107/get_data.json")
                .url("http://www.lazypet.top:3000/")
                .build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.w("result","fail to ask");
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Gson gson =new Gson();
                String str=response.body().string();
                System.out.println(str);
                List<Movie> jsonsList=gson.fromJson(str,new TypeToken<List<Movie>>(){}.getType());
                for(int i=0;i<5;i++) {
                    Movie movie1 = new Movie(R.mipmap.titanic, jsonsList.get(0).getName(), jsonsList.get(0).getData(), jsonsList.get(0).getDirector());
                    Movie movie2 = new Movie(R.mipmap.yourname, jsonsList.get(1).getName(), jsonsList.get(1).getData(), jsonsList.get(1).getDirector());
                    movieList.add(movie1);
                    movieList.add(movie2);
                }
            }
        });
    }

}