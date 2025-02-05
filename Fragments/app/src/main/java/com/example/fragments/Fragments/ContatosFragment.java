package com.example.fragments.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragments.R;

import org.w3c.dom.Text;

public class ContatosFragment extends Fragment {

    public ContatosFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contatos, container, false);
        // Inflate the layout for this fragment

        TextView textViewContatos = view.findViewById(R.id.textContatos);
        textViewContatos.setText("Contatos Alterados");

        return view;
    }
}