package com.askme.arun.myapplication.controler;

import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.askme.arun.myapplication.model.Item;
import com.askme.arun.myapplication.model.PriceList;
import com.askme.arun.myapplication.view.DataAdapter;
import com.askme.arun.myapplication.view.MainActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Arun on 18/5/16.
 */
public class PriceListAPICall {
    public static void loadJSON(final ProgressDialog progress, ArrayList<Item> data, final DataAdapter adapter, final RecyclerView recyclerView, final MainActivity mContext) {
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
                recyclerView.setAdapter(new DataAdapter(jsonResponse.getResultSet().getItems()));
            }

            @Override
            public void onFailure(Call<PriceList> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(mContext, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.d("Error", t.getMessage());
            }
        });
    }
}
