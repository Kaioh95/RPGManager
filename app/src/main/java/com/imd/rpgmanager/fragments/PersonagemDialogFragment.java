package com.imd.rpgmanager.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.imd.rpgmanager.R;
import com.imd.rpgmanager.model.ClassesRPG;
import com.imd.rpgmanager.model.Personagem;

import java.util.Random;


public class PersonagemDialogFragment extends DialogFragment
        implements AdapterView.OnItemSelectedListener {

    public static final String DIALOG_TAG = "addDialog";

    private EditText etNome;
    private EditText etIdade;
    private EditText etSexo;
    private Spinner spnClasse;
    private Spinner spnRaca;
    private Button btnSalvar;
    private TextView tvBonus;

    Personagem mPersonagem;

    public PersonagemDialogFragment() {
        // Required empty public constructor
    }

    public static PersonagemDialogFragment novaInstancia(){
        PersonagemDialogFragment personagemDialogFragment = new PersonagemDialogFragment();

        return personagemDialogFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPersonagem = new Personagem();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_personagem_dialog, container, false);

        etNome = layout.findViewById(R.id.etNomePersonagem);
        etIdade = layout.findViewById(R.id.etIdadePersonagem);
        etSexo = layout.findViewById(R.id.etSexoPersonagem);
        spnClasse = layout.findViewById(R.id.spnClassesCriar);
        spnRaca = layout.findViewById(R.id.spnRacasCriar);
        tvBonus = layout.findViewById(R.id.tvBonus);

        ArrayAdapter<CharSequence> adapterClasse = ArrayAdapter.createFromResource(getContext(),
                R.array.classes_array, android.R.layout.simple_spinner_item);
        adapterClasse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnClasse.setAdapter(adapterClasse);

        ArrayAdapter<CharSequence> adapterRaca = ArrayAdapter.createFromResource(getContext(),
                R.array.racas_array, android.R.layout.simple_spinner_item);
        adapterRaca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnRaca.setAdapter(adapterRaca);

        spnRaca.setOnItemSelectedListener(this);

        btnSalvar = layout.findViewById(R.id.btnCriarPersonagem);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarPersonagem();
            }
        });

        getDialog().setTitle("Novo Personagem");

        return layout;
    }

    public void salvarPersonagem(){

        Activity activity = getActivity();

        if(activity instanceof AoSalvarPersonagem){
            ClassesRPG classeNova = new ClassesRPG(spnClasse.getSelectedItem().toString());
            if(etIdade.getText().toString().isEmpty()){
                return;
            }

            mPersonagem.setNome(etNome.getText().toString());
            mPersonagem.setIdade(Integer.parseInt(etIdade.getText().toString()));
            mPersonagem.setSexo(etSexo.getText().toString());
            mPersonagem.setClasse(classeNova.getNome());
            mPersonagem.setItens(classeNova.getItens());
            mPersonagem.setRaca(spnRaca.getSelectedItem().toString());

            mPersonagem.setNivel(1);
            mPersonagem.setForca(8);
            mPersonagem.setConstituicao(8);
            mPersonagem.setInteligencia(8);
            mPersonagem.setDestreza(8);
            mPersonagem.setSabedoria(8);
            mPersonagem.setCarisma(8);

            int bonusVida = new Random().nextInt(7)+1;
            mPersonagem.setVida(8 + bonusVida);

        }

        AoSalvarPersonagem listener = (AoSalvarPersonagem) activity;
        listener.salvouPersonagem(mPersonagem);

        dismiss();
    }

    public interface AoSalvarPersonagem{
        void salvouPersonagem(Personagem personagem);
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getItemAtPosition(position).toString()){
            case "Anão":
                tvBonus.setText("(Constituição +2)");
                break;
            case "Elfo":
                tvBonus.setText("(Destreza +2)");
                break;
            case "Halfing":
                tvBonus.setText("(Destreza +2)");
                break;
            case "Humano":
                tvBonus.setText("(+1 todos os atributos)");
                break;
            case "Draconato":
                tvBonus.setText("(+1 carisma e +2 força)");
                break;
            case "Gnomo":
                tvBonus.setText("(Inteligência +2)");
                break;
            case "Meio-elfo":
                tvBonus.setText("(+2 carisma, +1 destreza e intel)");
                break;
            case "Meio-orc":
                tvBonus.setText("(+2 carisma , +1 destreza e força)");
                break;
            case "Tiefling":
                tvBonus.setText("(+1 inteligência e +2 carisma)");
                break;
            default:
                throw new IllegalArgumentException("Raça Inválida!");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}