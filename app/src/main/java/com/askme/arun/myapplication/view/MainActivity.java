package com.askme.arun.myapplication.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.askme.arun.myapplication.R;
import com.askme.arun.myapplication.controler.PriceListAPICall;
import com.askme.arun.myapplication.model.Item;

import java.util.ArrayList;

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
        PriceListAPICall.loadJSON(progress, data, adapter, recyclerView, this);
    }


    //Network Available check
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
