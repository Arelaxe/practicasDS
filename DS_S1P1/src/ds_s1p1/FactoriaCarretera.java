/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds_s1p1;

/**
 *
 * @author escaleranm
 */
public class FactoriaCarretera implements FactoriaCarreraYBicicleta {
    @Override
    public BicicletaCarretera crearBicicleta(){
        BicicletaCarretera bici = new BicicletaCarretera();
        
        return bici;
    }
    
    @Override
    public CarreraCarretera crearCarrera(int num){
        CarreraCarretera carrera = new CarreraCarretera(num, this);
        
        return carrera;
    }
}