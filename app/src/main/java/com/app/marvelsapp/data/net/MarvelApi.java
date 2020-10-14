/*
 * *
 *  * Created by Fernando Meregali  on 07/10/20 22:27
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 07/10/20 22:27
 *
 */

package com.app.marvelsapp.data.net;

import com.app.marvelsapp.data.net.model.Characters;
import com.app.marvelsapp.data.net.model.Comics;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelApi {

    @GET("/v1/public/characters")
    Call<Characters> getCharacters(@Query("ts") String timestamp, @Query("apikey") String apiKey, @Query("hash") String hash, @Query("limit") String limit);
    //Call<Characters> getCharacters(@Query("ts") String timestamp, @Query("apikey") String apiKey, @Query("hash") String hash);


    //request only caracter
    @GET("/v1/public/characters/")
    Call<Comics> getComics(@Query("ts") String timestamp, @Query("apikey") String apiKey, @Query("hash") String hash);



}
