/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1s1java;

/**
 *
 * @author escaleranm
 */
public class CarreraCarretera extends Carrera {
    public CarreraCarretera (int num){
        super(num);
        for (int i=0; i<num; i++){
            BicicletaCarretera bici = new BicicletaCarretera();
            bici.setIdentificador(i);
            AniadeBicicleta(bici);
        }
    }
}
