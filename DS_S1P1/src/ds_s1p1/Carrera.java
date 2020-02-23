/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_s1p1;

import java.util.*;

public abstract class Carrera extends Thread{
    private ArrayList<Bicicleta> bicicletas = new ArrayList<>();
    private ArrayList<Boolean> retiradas = new ArrayList<>();
    private Integer numeroBicicletas;
    double porcentajeRetiradas;
    FactoriaCarreraYBicicleta factoria;
    
    public Carrera(){}
    
    public Carrera(Integer num, FactoriaCarreraYBicicleta fac){
        numeroBicicletas = num;
        factoria = fac;
        
        if (fac instanceof FactoriaCarretera){
            for (Integer i=0; i<num; i++){
                BicicletaCarretera bici = (BicicletaCarretera) fac.crearBicicleta();
                bici.setIdentificador(i);
                AniadeBicicleta(bici);
                retiradas.add(false);
            }
        }
        if (fac instanceof FactoriaMontana){
            for (Integer i=0; i<num; i++){
                BicicletaMontana bici = (BicicletaMontana) fac.crearBicicleta();
                bici.setIdentificador(i);
                AniadeBicicleta(bici);
                retiradas.add(false);
            }
        }
        int numRetiradas = (int) Math.floor(numeroBicicletas*porcentajeRetiradas);
        
        int i=0;
        while (i<numRetiradas){
            int a_retirar = (int) Math.floor(Math.random()*numeroBicicletas);
            
            if (!retiradas.get(a_retirar)){
                retiradas.set(a_retirar,true);
                i++;
            }
        }
    }
    
    public void AniadeBicicleta(Bicicleta bici){
        bicicletas.add(bici);
    }
    
    public void IniciarCarrera(FactoriaCarreraYBicicleta fac){
        if (fac instanceof FactoriaCarretera){
            System.out.println("Empieza la carrera de carretera!");
            System.out.println("Van a participar "+numeroBicicletas+" bicicletas en la carrera de carretera");
        }
        else{
            System.out.println("Empieza la carrera de montaña!");
            System.out.println("Van a participar "+numeroBicicletas+" bicicletas en la carrera de montaña");
            
        }
        
        double to_retirada = Math.random()*(60-5)+5;
        
        for(int j=0; j<numeroBicicletas; j++){
            if(!retiradas.get(j)){
                bicicletas.get(j).start();
            }
        }
        
        Boolean ya_retiradas=false;
        
        for (int j=0; j<60; j++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Interrumpido");
            }
            
            System.out.println("\tSEGUNDO "+j);
            
            for (int k=0; k<numeroBicicletas; k++){
                
                if (!retiradas.get(k) && (j<bicicletas.get(k).getTiempo())){
                    if (factoria instanceof FactoriaCarretera)    
                        System.out.println("La bicicleta "+k+" de carretera sigue corriendo");
                    else
                        System.out.println("La bicicleta "+k+" de montaña sigue corriendo");
                }
                
                else if (retiradas.get(k) && !ya_retiradas) {
                    if (j<to_retirada)
                        if (factoria instanceof FactoriaCarretera)
                            System.out.println("La bicicleta "+k+" de carretera sigue corriendo");
                        else
                            System.out.println("La bicicleta "+k+" de montaña sigue corriendo");
                    else{
                        if (factoria instanceof FactoriaCarretera)
                            System.out.println("La bicicleta "+k+" de carretera se ha retirado");
                        else
                            System.out.println("La bicicleta "+k+" de montaña se ha retirado");
                        
                        ya_retiradas=true;
                    }
                }
            }
        }
        if (factoria instanceof FactoriaCarretera)
            System.out.println("Ha finalizado la carrera de carretera!");
        else
            System.out.println("Ha finalizado la carrera de montaña!");
    }
    
    @Override
    public void run(){
        IniciarCarrera(factoria);
    }
    
}
