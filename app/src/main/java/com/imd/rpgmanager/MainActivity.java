package com.imd.rpgmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.imd.rpgmanager.fragments.ItemListaFragment;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ItemListaFragment itemListaFragment;
    private FragmentManager fragmentManagerItens;

    Spinner splineClasses;
    Button btnDescricao;
    Button btnItens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManagerItens = getSupportFragmentManager();
        itemListaFragment = (ItemListaFragment) fragmentManagerItens
                .findFragmentById(R.id.fragmentListaItens);

        // Configurando Spinner
        splineClasses = (Spinner) findViewById(R.id.splineClasses);
        btnDescricao = findViewById(R.id.btnDescricaoClasses);
        btnItens = findViewById(R.id.btnItensClasses);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.classes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        splineClasses.setAdapter(adapter);

        splineClasses.setOnItemSelectedListener(this);

        btnDescricao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDescricao.setBackground(getResources().getDrawable(R.drawable.rounded_button));
                btnDescricao.setTextColor(getResources().getColor(R.color.text_hilite));

                btnItens.setBackground(getResources().getDrawable(R.drawable.rounded_right_button));
                btnItens.setTextColor(getResources().getColor(R.color.text_disable));

                mostrarDetalhesItensClasse(splineClasses.getSelectedItem().toString(), 0);
            }
        });

        btnItens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnItens.setBackground(getResources().getDrawable(R.drawable.rounded_button));
                btnItens.setTextColor(getResources().getColor(R.color.text_hilite));

                btnDescricao.setBackground(getResources().getDrawable(R.drawable.rounded_left_button));
                btnDescricao.setTextColor(getResources().getColor(R.color.text_disable));

                mostrarDetalhesItensClasse(splineClasses.getSelectedItem().toString(), 1);
            }
        });

    }

    public void mostrarDetalhesItensClasse(String classe, int btnPrecionado){
        itemListaFragment.atualizar(classe, btnPrecionado);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        btnDescricao.setBackground(getResources().getDrawable(R.drawable.rounded_button));
        btnDescricao.setTextColor(getResources().getColor(R.color.text_hilite));

        btnItens.setBackground(getResources().getDrawable(R.drawable.rounded_right_button));
        btnItens.setTextColor(getResources().getColor(R.color.text_disable));

        mostrarDetalhesItensClasse(parent.getItemAtPosition(position).toString(), 0);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}