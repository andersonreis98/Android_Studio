package com.example.bonequinhos.v2;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.bonequinhos.Helpers.MaskEditUtil;
import com.example.bonequinhos.Helpers.ValidaCPF;
import com.example.bonequinhos.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class FisicaFragment extends Fragment {

    private RadioGroup radioGroupAtivoEmpresa;
    private EditText editTextID, editTextCPF,editTextDataNascimento,editTextContato;
    private TextInputLayout textInputLayoutV2IdVinculacao;

    public FisicaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fisica, container, false);

//        radioGroupAtivoEmpresa = view.findViewById(R.id.radioGroupAtivaV2);
//        editTextID = view.findViewById(R.id.editTextV2IdVinculacao);
        editTextCPF = view.findViewById(R.id.editTextV2CPF);
//        textInputLayoutV2IdVinculacao = view.findViewById(R.id.textInputLayoutV2IdVinculacao);
        editTextDataNascimento = view.findViewById(R.id.editTextV2DataNascimento);
        editTextContato = view.findViewById(R.id.editTextV2FContato);


        editTextCPF.addTextChangedListener(MaskEditUtil.mask(editTextCPF, "###.###.###-##"));
        editTextDataNascimento.addTextChangedListener(MaskEditUtil.mask(editTextDataNascimento, "##/##/####"));
        editTextContato.addTextChangedListener(MaskEditUtil.mask(editTextContato, "(##)#####-####"));

//        radioGroupAtivoEmpresa.check(R.id.radioButtonV2AtivaNao);
        textInputLayoutV2IdVinculacao.setVisibility(View.GONE);
        editTextID.setVisibility(View.GONE);


        radioGroupAtivoEmpresa.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (checkedId == R.id.radioButtonV2AtivaSim) {
//                    textInputLayoutV2IdVinculacao.setVisibility(View.VISIBLE);
//                    editTextID.setVisibility(View.VISIBLE);
//                    editTextID.requestFocus();
//                }
//                if (checkedId == R.id.radioButtonV2AtivaNao) {
//
//                    textInputLayoutV2IdVinculacao.setVisibility(View.GONE);
//                    editTextID.setVisibility(View.GONE);
//
//                }

            }
        });
        return view;
    }
}