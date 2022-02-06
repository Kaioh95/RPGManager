package com.imd.rpgmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.imd.rpgmanager.model.MonstroModel;
import com.imd.rpgmanager.services.MonsterService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MonstrosActivity extends AppCompatActivity {

    EditText edMonster;
    Button searchMonster;
    TextView txtMonsterName;
    TextView txtMonsterType;
    TextView txtMonsterLvl;
    TextView txtMonsterHealth;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monstros);

        edMonster = findViewById(R.id.edMonsterName);
        searchMonster = findViewById(R.id.searchMonsterBtn);
        txtMonsterName = findViewById(R.id.monsterNameGET);
        txtMonsterType = findViewById(R.id.monsterTypeGET);
        txtMonsterLvl = findViewById(R.id.monsterLvlGET);
        txtMonsterHealth = findViewById(R.id.monsterHealthGET);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.dnd5eapi.co/api/monsters/")
                .build();

        searchMonster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarMonstroRetrofit(edMonster.getText().toString());
            }
        });
    }

    private void buscarMonstroRetrofit(String monsterName){
        MonsterService monsterService = retrofit.create(MonsterService.class);

        Call<MonstroModel> call = monsterService.buscarMonstro(monsterName);

        call.enqueue(new Callback<MonstroModel>() {
            @Override
            public void onResponse(Call<MonstroModel> call, Response<MonstroModel> response) {
                if(response.isSuccessful()){
                    MonstroModel monstroModel = response.body();
                    txtMonsterHealth.setText(monstroModel.getName());
                    txtMonsterType.setText((monstroModel.getType()));
                    txtMonsterLvl.setText(monstroModel.getChallenge_rating());
                    txtMonsterHealth.setText(monstroModel.getHit_points());
                }
            }

            @Override
            public void onFailure(Call<MonstroModel> call, Throwable t) {

            }
        });
    }
}