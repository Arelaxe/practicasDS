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
public class CarreraCarretera extends Carrera {
    public CarreraCarretera (int num, FactoriaCarretera fac){
        super(num, fac);
        
        porcentajeRetiradas=0.1;
    }
}