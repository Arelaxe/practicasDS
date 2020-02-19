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
public class CarreraMontana extends Carrera {
    public CarreraMontana (int num, FactoriaMontana fac){
        super(num, fac);
        porcentajeRetiradas = 0.2;
    }
}
