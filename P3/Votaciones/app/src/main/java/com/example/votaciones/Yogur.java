package com.example.votaciones;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Yogur#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Yogur extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView text1;
    TextView text2;
    TextView text3;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Yogur() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Yogur.
     */
    // TODO: Rename and change types and number of parameters
    public static Yogur newInstance(String param1, String param2) {
        Yogur fragment = new Yogur();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_yogur, container, false);
        text1 = (TextView) view.findViewById(R.id.votos_y1);
        text1.setText(GlobalInfo.votos_yogur1+" votos");
        text2 = (TextView) view.findViewById(R.id.votos_y2);
        text2.setText(GlobalInfo.votos_yogur2+" votos");
        text3 = (TextView) view.findViewById(R.id.votos_y3);
        text3.setText(GlobalInfo.votos_yogur3+" votos");

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Yogur.this)
                        .navigate(R.id.action_yogur_to_FirstFragment);
            }
        });

        view.findViewById(R.id.vote_y1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!GlobalInfo.usuarios.get(GlobalInfo.us_act).isVoted_yogur()) {
                    GlobalInfo.votos_yogur1++;
                    text1.setText(GlobalInfo.votos_yogur1 + " votos");
                    GlobalInfo.usuarios.get(GlobalInfo.us_act).setVoted_yogur();
                }
            }
        });

        view.findViewById(R.id.vote_y2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!GlobalInfo.usuarios.get(GlobalInfo.us_act).isVoted_yogur()) {
                    GlobalInfo.votos_yogur2++;
                    text2.setText(GlobalInfo.votos_yogur2 + " votos");
                    GlobalInfo.usuarios.get(GlobalInfo.us_act).setVoted_yogur();
                }
            }
        });

        view.findViewById(R.id.vote_y3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!GlobalInfo.usuarios.get(GlobalInfo.us_act).isVoted_yogur()) {
                    GlobalInfo.votos_yogur3++;
                    text3.setText(GlobalInfo.votos_yogur3 + " votos");
                    GlobalInfo.usuarios.get(GlobalInfo.us_act).setVoted_yogur();
                }
            }
        });
    }
}
