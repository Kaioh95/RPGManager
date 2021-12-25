package com.imd.rpgmanager.fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.imd.rpgmanager.R;


public class InfoDialogFragment extends DialogFragment
    implements DialogInterface.OnClickListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Informações");
        builder.setMessage("Autores:\nAlexandre Alves Andrade\nÁlvaro Prudêncio Araújo\nJoão Victor Fernandes Cabral\nKaio Henrique de Sousa");

        builder.setPositiveButton("Ver repositório", this);
        builder.setNegativeButton("Sair", this);

        return builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        Activity activity = getActivity();

        if(activity instanceof AoClicarEmInfo){
            AoClicarEmInfo listener = (AoClicarEmInfo) activity;
            listener.aoClicar(which);
        }

    }

    public interface AoClicarEmInfo{
        void aoClicar(int botao);
    }
}