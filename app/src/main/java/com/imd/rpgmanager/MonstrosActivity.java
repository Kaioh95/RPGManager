package com.imd.rpgmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MonstrosActivity extends AppCompatActivity {

    EditText edMonster;
    Button searchMonster;
    TextView txtMonsterName;
    TextView txtMonsterType;
    TextView txtMonsterLvl;
    TextView txtMonsterHealth;

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
    }
}