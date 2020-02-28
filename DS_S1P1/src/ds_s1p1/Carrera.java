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
        
        double to_retirada = (int)Math.floor(Math.random()*(29));
        
        for(int j=0; j<numeroBicicletas; j++){
            bicicletas.get(j).start();
        }
        
        int num_retiradas = (int) Math.floor(numeroBicicletas*porcentajeRetiradas);
        
        for (int j=0; j<=60; j++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Interrumpido");
            }
            
            if(j==to_retirada){
                int i=0;
                while (i<num_retiradas){
                    int a_retirar = (int) Math.floor(Math.random()*numeroBicicletas);
                        
                    if (factoria instanceof FactoriaCarretera)
                        System.out.println("La bicicleta "+a_retirar+" de carretera se ha retirado en el segundo "+j);
                    else
                        System.out.println("La bicicleta "+a_retirar+" de montaña se ha retirado en el segundo "+j);
                        
                    if (!retiradas.get(a_retirar)){
                        retiradas.set(a_retirar,true);
                        i++;
                    }
                }
            }
            for (int k=0; k<numeroBicicletas; k++){
                if (!retiradas.get(k) && (j<=bicicletas.get(k).getTiempo())){
                    if (bicicletas.get(k).getTiempo()==j){
                        if (factoria instanceof FactoriaCarretera)
                            System.out.println("La bicicleta "+bicicletas.get(k).getIdentificador()+" de carretera ha llegado ("+bicicletas.get(k).getTiempo()+" seg.)");
                        else
                            System.out.println("La bicicleta "+bicicletas.get(k).getIdentificador()+" de montaña ha llegado ("+bicicletas.get(k).getTiempo()+" seg.)");
                    }
                    else{
                        if (factoria instanceof FactoriaCarretera)    
                            System.out.println("La bicicleta "+k+" de carretera sigue corriendo en el segundo "+j);
                        else
                            System.out.println("La bicicleta "+k+" de montaña sigue corriendo en el segundo "+j);   
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
