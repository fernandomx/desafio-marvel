/*
 * *
 *  * Created by Fernando Meregali  on 07/10/20 22:50
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 07/10/20 22:50
 *
 */

package com.app.marvelsapp.ui.home.characters;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.marvelsapp.R;
import com.app.marvelsapp.data.net.MarvelApi;
import com.app.marvelsapp.data.net.model.Characters;
import com.app.marvelsapp.data.net.model.Comics;
import com.app.marvelsapp.data.net.model.Result;
import com.app.marvelsapp.utils.Constants;
import com.facebook.stetho.BuildConfig;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CharactersFragment extends Fragment {

    private RecyclerView characterRV;
    private ProgressBar progressBar;
    private CharacterRVAdapter adapter;
    private List<Result> resultList = new ArrayList<>();

    public static CharactersFragment newInstance() {

        Bundle args = new Bundle();
        CharactersFragment fragment = new CharactersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_characters, container, false);
        setUp(view);
        getCharacters();

        //test get comics
        //getComics();

        return view;
    }

    private void setUp(View view) {
        characterRV = view.findViewById(R.id.characterRV);
        progressBar = view.findViewById(R.id.progressBar);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        characterRV.addItemDecoration(new CharacterItemDecoration(50));
        characterRV.setHasFixedSize(true);
        adapter = new CharacterRVAdapter(resultList);
        characterRV.setLayoutManager(gridLayoutManager);
        characterRV.setItemAnimator(new CharacterLikeAnimator());
        characterRV.setAdapter(adapter);
    }

    private void getCharacters() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if(BuildConfig.DEBUG){
            builder.addNetworkInterceptor(new StethoInterceptor());
        }

        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String timeStamp = new Date().getTime()+"";
        String md5 = md5(timeStamp+Constants.PRIVATE_KEY+Constants.API_KEY);
        MarvelApi marvelApi = retrofit.create(MarvelApi.class);

        Call<Characters> call = marvelApi.getCharacters(timeStamp, Constants.API_KEY,md5,"100");
        //Call<Characters> call = marvelApi.getCharacters(timeStamp, Constants.API_KEY,md5);

        call.enqueue(new Callback<Characters>() {
            @Override
            public void onResponse(Call<Characters> call, Response<Characters> response) {
                progressBar.setVisibility(View.GONE);

                resultList.addAll(response.body().getData().getResults());

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Characters> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    private void getComics() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if(BuildConfig.DEBUG){
            builder.addNetworkInterceptor(new StethoInterceptor());
        }

        OkHttpClient client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        String timeStamp = new Date().getTime()+"";
        String md5 = md5(timeStamp+Constants.PRIVATE_KEY+Constants.API_KEY);
        MarvelApi marvelApi = retrofit.create(MarvelApi.class);

        //Call<Characters> call = marvelApi.getCharacters(timeStamp, Constants.API_KEY,md5,"80");
        Call<Comics> call = marvelApi.getComics(timeStamp, Constants.API_KEY,md5);

        call.enqueue(new Callback<Comics>() {
            @Override
            public void onResponse(Call<Comics> call, Response<Comics> response) {
                progressBar.setVisibility(View.GONE);

                //Log.i("MISSIONS", "FLIGHT: " + flights.id + "-" + flights.status + "/")

                Log.i("COmics","Comics:" + response.body().toString());

                //resultList.addAll(response.body().getData().getResults());

                //adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Comics> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }





    public String md5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
