package com.example.votaciones;
import java.util.ArrayList;

public class GlobalInfo {
    public static int votos_bol = 10;
    public static int votos_car = 30;
    public static int votos_pes = 5;
    public static int votos_pizza1 = 20;
    public static int votos_pizza2 = 30;
    public static int votos_pizza3= 10;
    public static int votos_yogur1 = 10;
    public static int votos_yogur2 = 20;
    public static int votos_yogur3 = 15;

    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static Usuario usuario_actual;
    public static int us_act;

    public static void addUsuarios(){
        usuarios.add(new Usuario ("noe", "pass"));
        usuarios.add(new Usuario ("alguien", "pass"));
        usuarios.add(new Usuario ("usu", "pass"));
    }
}
