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
                BicicletaCarretera bici = new BicicletaCarretera();
                bici.setIdentificador(i);
                AniadeBicicleta(bici);
                retiradas.add(false);
            }
        }
        if (fac instanceof FactoriaMontana){
            for (Integer i=0; i<num; i++){
                BicicletaMontana bici = new BicicletaMontana();
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
        
        int numRetiradas = (int) Math.floor(numeroBicicletas*porcentajeRetiradas);
        System.out.println("Se han retirado "+numRetiradas+" bicicletas");
        
        int i=0;
        while (i<numRetiradas){
            int a_retirar = (int) Math.floor(Math.random()*numeroBicicletas);
            
            if (!retiradas.get(a_retirar)){
                retiradas.set(a_retirar,true);
                if (fac instanceof FactoriaCarretera)
                    System.out.println("Se ha retirado la bicicleta "+a_retirar+" de carretera");
                else
                    System.out.println("Se ha retirado la bicicleta "+a_retirar+" de montaña");
                i++;
            }
        }
        
        for(int j=0; j<numeroBicicletas; j++){
            if(!retiradas.get(j)){
                bicicletas.get(j).start();
            }
        }
        
        try {
            Thread.sleep(60*1000);
        } catch (InterruptedException ex) {
            System.out.println("Interrumpido");
        }
        System.out.println("Ha finalizado la carrera!");
    }
    
    @Override
    public void run(){
        IniciarCarrera(factoria);
    }
    
}
