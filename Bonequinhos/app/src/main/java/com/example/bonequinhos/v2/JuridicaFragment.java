package com.example.bonequinhos.v2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.bonequinhos.Helpers.MaskEditUtil;
import com.example.bonequinhos.R;

public class JuridicaFragment extends Fragment {

    private Spinner spinnerSeguimentos;
    private EditText editTextCNPJ, editTextContato;

    public JuridicaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_juridica, container, false);
        spinnerSeguimentos = view.findViewById(R.id.spinnerV2Seguimento);
        populaSpinnerSeguimentos();
        editTextCNPJ = view.findViewById(R.id.editTextV2CNPJ);
        editTextContato = view.findViewById(R.id.editTextV2JContato);

        editTextCNPJ.addTextChangedListener(MaskEditUtil.mask(editTextCNPJ, "##.###.###/####-##"));
        editTextContato.addTextChangedListener(MaskEditUtil.mask(editTextContato, "(##)#####-####"));

        // Inflate the layout for this fragment
        return view;
    }

    void populaSpinnerSeguimentos() {
        String[] seguimentos = new String[]{
                "Escolher",
                "Alimentação e Bebidas",
                "Saúde",
                "Educação",
                "Serviços pessoais",
                "Vestuário e calçados",
                "Construção",
                "Serviços especializados",
                "Informática",
                "Vendas e marketing",
                "Entretenimento"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(), android.R.layout.simple_spinner_item,
                seguimentos
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSeguimentos.setAdapter(adapter);
    }
}