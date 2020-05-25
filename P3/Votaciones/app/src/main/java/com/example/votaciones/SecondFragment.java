package com.example.votaciones;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

public class SecondFragment extends Fragment {
    private TextView text1;
    private TextView text2;
    private TextView text3;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        text1 = (TextView) view.findViewById(R.id.votos_bol);
        text1.setText(GlobalInfo.votos_bol + " votos");
        text2 = (TextView) view.findViewById(R.id.votos_car);
        text2.setText(GlobalInfo.votos_car + " votos");
        text3 = (TextView) view.findViewById(R.id.votos_pes);
        text3.setText(GlobalInfo.votos_pes + " votos");

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.vote_bol).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!GlobalInfo.usuario_actual.isVoted_pasta()) {
                    GlobalInfo.votos_bol++;
                    text1.setText(GlobalInfo.votos_bol + " votos");
                    GlobalInfo.usuario_actual.setVoted_pasta();
                }
            }
        });

        view.findViewById(R.id.vote_car).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!GlobalInfo.usuario_actual.isVoted_pasta()) {
                    GlobalInfo.votos_car++;
                    text2.setText(GlobalInfo.votos_car + " votos");
                    GlobalInfo.usuario_actual.setVoted_pasta();
                }
            }
        });

        view.findViewById(R.id.vote_pes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!GlobalInfo.usuario_actual.isVoted_pasta()) {
                    GlobalInfo.votos_pes++;
                    text3.setText(GlobalInfo.votos_pes + " votos");
                    GlobalInfo.usuario_actual.setVoted_pasta();
                }
            }
        });

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}
