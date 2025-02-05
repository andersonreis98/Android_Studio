package com.example.bonequinhos.v2.Precos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.bonequinhos.R;
import com.example.bonequinhos.v2.AcessoActivity;

public class PrecoIndividualFragment extends Fragment
{
    Button buttonContratar;
    Context context;

    public void abrirToast() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Politica de experimentação")
                .setMessage("Devido ao aplicativo se tratar de uma versão beta antes de efetuar a contratação de um de nossos planos solicitamos que por favor efetue a degustação de nosso app a partir do 'Plano Degustação'. De acordo?")
                .setCancelable(false)
                .setIcon(R.drawable.logo1)
                .setPositiveButton("SIM", (dialog, which) -> {
                    Intent intent = new Intent(context, AcessoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("plano", 2);
                    intent.putExtra("dados", bundle);
                    startActivity(intent);
                })
                .setNegativeButton("NÃO", (dialog, which) -> {
                })
                .create()
                .show();
    }

    @Override
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = layoutInflater.inflate(R.layout.fragment_precos_individual, viewGroup, false);
        context = view.getContext();
        buttonContratar = view.findViewById(R.id.buttonContratarOferta);
        buttonContratar.setOnClickListener(v -> {
            abrirToast();
        });
        return view;
    }
}
