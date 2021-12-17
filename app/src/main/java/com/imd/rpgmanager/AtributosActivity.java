package com.imd.rpgmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.imd.rpgmanager.model.Personagem;

public class AtributosActivity extends AppCompatActivity {

    Personagem personagem;

    Button btnMaisNivel;

    Button btnMenosForca;
    Button btnMaisForca;

    Button btnMenosConstituicao;
    Button btnMaisConstituicao;

    Button btnMenosInteligencia;
    Button btnMaisInteligencia;

    Button btnMenosDestreza;
    Button btnMaisDestreza;

    Button btnMenosSabedoria;
    Button btnMaisSabedoria;

    Button btnMenosCarisma;
    Button btnMaisCarisma;

    Button btnMenosVida;
    Button btnMaisVida;

    Button btnResetar;
    Button btnConfirmar;


    TextView tvPontosAtuais;
    TextView tvNivel;
    TextView tvForca;
    TextView tvConstituicao;
    TextView tvInteligencia;
    TextView tvDestreza;
    TextView tvSabedoria;
    TextView tvCarisma;
    TextView tvVida;

    ProgressBar pbForca;
    ProgressBar pbConstituicao;
    ProgressBar pbInteligencia;
    ProgressBar pbDestreza;
    ProgressBar pbSabedoria;
    ProgressBar pbCarisma;
    ProgressBar pbVida;

    int Nivel = 0;
    int Forca = 0;
    int Constituicao = 0;
    int Inteligencia = 0;
    int Destreza = 0;
    int Sabedoria = 0;
    int Carisma = 0;
    int Vida = 0;

    int VidaMax = 0;

    int PONTOS_POR_NIVEL = 5;
    int ponto_atuais = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atributos);

        btnMaisNivel = findViewById(R.id.btnMaisNivel);

        btnMenosForca = findViewById(R.id.btnMenosForca);
        btnMaisForca = findViewById(R.id.btnMaisForca);

        btnMenosConstituicao = findViewById(R.id.btnMenosConstituicao);
        btnMaisConstituicao = findViewById(R.id.btnMaisConstituicao);

        btnMenosInteligencia = findViewById(R.id.btnMenosInteligencia);
        btnMaisInteligencia = findViewById(R.id.btnMaisInteligencia);

        btnMenosDestreza = findViewById(R.id.btnMenosDestreza);
        btnMaisDestreza = findViewById(R.id.btnMaisDestreza);

        btnMenosSabedoria = findViewById(R.id.btnMenosSabedoria);
        btnMaisSabedoria = findViewById(R.id.btnMaisSabedoria);

        btnMenosCarisma = findViewById(R.id.btnMenosCarisma);
        btnMaisCarisma = findViewById(R.id.btnMaisCarisma);

        btnMenosVida = findViewById(R.id.btnMenosVida);
        btnMaisVida = findViewById(R.id.btnMaisVida);

        btnConfirmar = findViewById(R.id.btnCorfirmar);
        btnResetar = findViewById(R.id.btnResetar);

        //Valor dos atributos
        tvPontosAtuais = findViewById(R.id.tvPontosAtuais);
        tvNivel = findViewById(R.id.tvNivel);
        tvForca = findViewById(R.id.tvForca);
        tvConstituicao = findViewById(R.id.tvConstituicao);
        tvInteligencia = findViewById(R.id.tvInteligencia);
        tvDestreza = findViewById(R.id.tvDestreza);
        tvSabedoria = findViewById(R.id.tvSabedoria);
        tvCarisma = findViewById(R.id.tvCarisma);
        tvVida = findViewById(R.id.tvVida);

        //Barra de atributos
        pbForca = findViewById(R.id.pbForca);
        pbConstituicao = findViewById(R.id.pbConstituicao);
        pbInteligencia = findViewById(R.id.pbInteligencia);
        pbDestreza = findViewById(R.id.pbDestreza);
        pbSabedoria = findViewById(R.id.pbSabedoria);
        pbCarisma = findViewById(R.id.pbCarisma);
        pbVida = findViewById(R.id.pbVida);

        personagem = new Personagem();

        tvNivel.setText(personagem.getNivel());
        tvForca.setText(personagem.getForca());
        tvConstituicao.setText(personagem.getConstituicao());
        tvInteligencia.setText(personagem.getInteligencia());
        tvDestreza.setText(personagem.getDestreza());
        tvSabedoria.setText(personagem.getSabedoria());
        tvCarisma.setText(personagem.getCarisma());
        tvVida.setText(personagem.getVida());

        //atualizarProgressBars()

        btnMaisNivel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvNivel.setText(String.valueOf(Integer.parseInt(String.valueOf(tvNivel.getText())) + 1));
                tvPontosAtuais.setText(String.valueOf(PONTOS_POR_NIVEL + ponto_atuais));
            }
        });


        //Força
        btnMenosForca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ponto_atuais < PONTOS_POR_NIVEL){
                    tvForca.setText(String.valueOf(Integer.parseInt(String.valueOf(tvForca.getText()))-1));
                    ponto_atuais += 1;
                }
            }
        });
        btnMaisForca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ponto_atuais > 0){
                    tvForca.setText(String.valueOf(Integer.parseInt(String.valueOf(tvForca.getText())) + 1));
                    ponto_atuais -=1;
                }
            }
        });

        //Constituicao
        btnMenosConstituicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ponto_atuais < PONTOS_POR_NIVEL){
                    tvConstituicao.setText(String.valueOf(Integer.parseInt(String.valueOf(tvConstituicao.getText()))-1));
                    ponto_atuais += 1;
                }
            }
        });
        btnMaisConstituicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ponto_atuais > 0){
                    tvConstituicao.setText(String.valueOf(Integer.parseInt(String.valueOf(tvConstituicao.getText())) + 1));
                    ponto_atuais -=1;
                }
            }
        });

        //Inteligência
        btnMenosInteligencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ponto_atuais < PONTOS_POR_NIVEL){
                    tvInteligencia.setText(String.valueOf(Integer.parseInt(String.valueOf(tvInteligencia.getText()))-1));
                    ponto_atuais += 1;
                }
            }
        });
        btnMaisInteligencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ponto_atuais > 0){
                    tvInteligencia.setText(String.valueOf(Integer.parseInt(String.valueOf(tvInteligencia.getText())) + 1));
                    ponto_atuais -=1;
                }
            }
        });

        //Destreza
        btnMenosDestreza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ponto_atuais < PONTOS_POR_NIVEL){
                    tvDestreza.setText(String.valueOf(Integer.parseInt(String.valueOf(tvDestreza.getText()))-1));
                    ponto_atuais += 1;
                }
            }
        });
        btnMaisDestreza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ponto_atuais > 0){
                    tvDestreza.setText(String.valueOf(Integer.parseInt(String.valueOf(tvDestreza.getText())) + 1));
                    ponto_atuais -=1;
                }
            }
        });

        //Sabedoria
        btnMenosSabedoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ponto_atuais < PONTOS_POR_NIVEL){
                    tvSabedoria.setText(String.valueOf(Integer.parseInt(String.valueOf(tvSabedoria.getText()))-1));
                    ponto_atuais += 1;
                }
            }
        });
        btnMaisSabedoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ponto_atuais > 0){
                    tvSabedoria.setText(String.valueOf(Integer.parseInt(String.valueOf(tvSabedoria.getText())) + 1));
                    ponto_atuais -=1;
                }
            }
        });

        //Carisma
        btnMenosCarisma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ponto_atuais < PONTOS_POR_NIVEL){
                    tvCarisma.setText(String.valueOf(Integer.parseInt(String.valueOf(tvCarisma.getText()))-1));
                    ponto_atuais += 1;
                }
            }
        });
        btnMaisCarisma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ponto_atuais > 0){
                    tvCarisma.setText(String.valueOf(Integer.parseInt(String.valueOf(tvCarisma.getText())) + 1));
                    ponto_atuais -=1;
                }
            }
        });

        //Vida
        btnMenosVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(String.valueOf(tvVida.getText())) > 0){
                    tvVida.setText(String.valueOf(Integer.parseInt(String.valueOf(tvVida.getText())) - 1));
                }
            }
        });
        btnMaisVida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(String.valueOf(tvVida.getText())) < VidaMax){
                    tvVida.setText(String.valueOf(Integer.parseInt(String.valueOf(tvVida.getText())) + 1));
                }
            }
        });

        //Botão para resetar os atributos
        btnResetar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPontosAtuais.setText(0);
                tvNivel.setText(0);
                tvForca.setText(0);
                tvConstituicao.setText(0);
                tvInteligencia.setText(0);
                tvDestreza.setText(0);
                tvSabedoria.setText(0);
                tvCarisma.setText(0);
                tvVida.setText(0);
                VidaMax = 0;
            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personagem.setNivel(Integer.parseInt((String) tvNivel.getText()));
                personagem.setForca(Integer.parseInt((String) tvForca.getText()));
                personagem.setConstituicao(Integer.parseInt((String) tvConstituicao.getText()));
                personagem.setInteligencia(Integer.parseInt((String) tvInteligencia.getText()));
                personagem.setDestreza(Integer.parseInt((String) tvDestreza.getText()));
                personagem.setSabedoria(Integer.parseInt((String) tvSabedoria.getText()));
                personagem.setCarisma(Integer.parseInt((String) tvCarisma.getText()));
                personagem.setVida(Integer.parseInt((String) tvVida.getText()));

            }
        });
    }
}