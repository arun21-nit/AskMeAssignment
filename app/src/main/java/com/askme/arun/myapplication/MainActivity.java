package com.askme.arun.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Arun on 18/5/16.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Item> data;
    private DataAdapter adapter;

    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (isNetworkAvailable())
            initViews();
        else {
            Toast.makeText(this, "Please connect to internet and try again", Toast.LENGTH_LONG).show();
            finish();
        }

    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Please wait while we are fetching data...");
        progress.show();
        loadJSON();
    }

    //Http Call using Retrofit
    private void loadJSON() {
        Retrofit retrofit = new Retrofit.Builder()
                //Publicly hosted json file on myjson free server
                .baseUrl("https://api.myjson.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<PriceList> call = request.getJSON();
        call.enqueue(new Callback<PriceList>() {
            @Override
            public void onResponse(Call<PriceList> call, Response<PriceList> response) {
                progress.dismiss();
                PriceList jsonResponse = response.body();
                data = jsonResponse.getResultSet().getItems();
                //setting data to adaptor
                adapter = new DataAdapter(data);
                //Setting adaptor to recyclerView
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PriceList> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(MainActivity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                Log.d("Error", t.getMessage());
            }
        });
    }

    //Network Available check
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
