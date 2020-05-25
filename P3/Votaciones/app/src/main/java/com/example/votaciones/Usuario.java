package com.example.votaciones;

public class Usuario {
    private String nombre;
    private String pass;
    private boolean voted_pasta;
    private boolean voted_pizza;
    private boolean voted_yogur;

    Usuario(){
        voted_pasta = false;
        voted_pizza = false;
        voted_yogur = false;
    }

    Usuario(String nombre, String pass){
        this.nombre = nombre;
        this.pass = pass;
        voted_pasta = false;
        voted_pizza = false;
        voted_yogur = false;
    }

    public String getNombre(){
        return nombre;
    }

    public String getPass(){
        return pass;
    }

    public boolean isVoted_pasta() {
        return voted_pasta;
    }

    public boolean isVoted_pizza(){
        return voted_pizza;
    }

    public boolean isVoted_yogur(){
        return voted_yogur;
    }

    public void setVoted_pasta(){
        voted_pasta = true;
    }

    public void setVoted_pizza(){
        voted_pizza = true;
    }

    public void setVoted_yogur(){
        voted_yogur = true;
    }
}
