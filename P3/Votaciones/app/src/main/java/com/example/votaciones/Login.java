package com.example.votaciones;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Login extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView text_user;
    private TextView text_pass;
    private TextView text_msg;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Login() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Login.
     */
    // TODO: Rename and change types and number of parameters
    public static Login newInstance(String param1, String param2) {
        Login fragment = new Login();
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
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        text_user = (TextView) view.findViewById(R.id.username);
        text_pass = (TextView) view.findViewById(R.id.pass);
        text_msg = (TextView) view.findViewById(R.id.msg);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us = text_user.getText().toString();
                String p = text_pass.getText().toString();
                boolean login_correcto = false;
                int i=0;
                for (Usuario usu: GlobalInfo.usuarios){
                    if (usu.getNombre().equals(us) && usu.getPass().equals(p)){
                        login_correcto = true;
                        GlobalInfo.usuario_actual = usu;
                        GlobalInfo.us_act = i;
                    }
                    i++;
                }
               if (login_correcto) {
                    NavHostFragment.findNavController(Login.this)
                            .navigate(R.id.action_login_to_FirstFragment);
               }
               else{
                    text_msg.setText("Credenciales incorrectos");
               }
            }
        });
    }
}
