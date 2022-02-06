package com.imd.rpgmanager.services;

import com.imd.rpgmanager.model.MonstroModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MonsterService {

    @GET("{monstro}")
    Call<MonstroModel> buscarMonstro(@Path("monstro") String monstro);
}
