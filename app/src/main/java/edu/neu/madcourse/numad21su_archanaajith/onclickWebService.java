package edu.neu.madcourse.numad21su_archanaajith;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import android.widget.ProgressBar;

public class onclickWebService extends AppCompatActivity {
    private static String base_JSON_URL = "https://api.themoviedb.org/3/search/movie?&api_key=ae8d3cae334a9baa21a3abb5f5a61281&language=en-US&";
    private static String query ="query=";
    private static String pagination ="&page=1";
    private String searchText;
    private ProgressBar progressBar;


    List<TMDBModelClass> movieList;
    RecyclerView recyclerView;
    ImageView header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onclick_web_service);
        movieList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        header  = findViewById(R.id.imageView);
        progressBar=(ProgressBar) findViewById(R.id.progress_bar);

        Bundle bn=getIntent().getExtras();
        searchText=bn.getString("Search Text Value");
       // progressBar.setVisibility(View.VISIBLE);
        //progressBar.setProgress(0);
        GetData getData = new GetData();
        getData.execute();
    }
    public class GetData extends AsyncTask<String, String, String>{
        protected void onPreExecute (){
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        protected String doInBackground(String... strings) {

            String current= "";

            try{
                URL url;
                HttpURLConnection urlConnection = null;

                try {
                    url = new URL(base_JSON_URL+query+String.valueOf(searchText)+pagination);
                    urlConnection = (HttpURLConnection) url.openConnection();


                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while(data != -1){
                        current += (char) data;
                        data = isr.read();

                    }
                    return current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(urlConnection != null){
                        urlConnection.disconnect();
                    }
                }


            } catch (Exception e) {
                e.printStackTrace();
            }


            return current;
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar.setVisibility(View.GONE);
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray   = jsonObject.getJSONArray("results");

                for (int i = 0 ; i< jsonArray.length() ; i++){

                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);


                    TMDBModelClass model = new TMDBModelClass();
                    model.setName(jsonObject1.getString("title"));
                    model.setId("Rating:"+jsonObject1.getString("vote_average"));
                    model.setImg(jsonObject1.getString("poster_path"));
                    model.setDescription(jsonObject1.getString("overview"));

                    movieList.add(model);

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            PutDataIntoRecyclerView( movieList);

        }
    }

    private void PutDataIntoRecyclerView(List<TMDBModelClass> movieList){

        Adapter adapter = new Adapter(this, movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
    }


}