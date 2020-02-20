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
public class FactoriaMontana implements FactoriaCarreraYBicicleta {
    
    @Override
    public BicicletaMontana crearBicicleta(){
        BicicletaMontana bici = new BicicletaMontana(this);
        
        return bici;
    }
    
    @Override
    public CarreraMontana crearCarrera(int num){
        CarreraMontana carrera = new CarreraMontana(num, this);
        
        return carrera;
    }
}
