/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1s1java;

import java.util.*;

public abstract class Carrera {
    private ArrayList<Bicicleta> bicicletas = new ArrayList<>();
    private int numeroBicicletas;
    
    public Carrera(int num){
        numeroBicicletas = num;
    }
    
    public void AniadeBicicleta(Bicicleta bici){
        bicicletas.add(bici);
    }
    
}