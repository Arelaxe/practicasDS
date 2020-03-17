package p1s3;

public class HebraPantallaTemperatura extends Thread{
    private PantallaTemperatura pantalla;
    
    HebraPantallaTemperatura(PantallaTemperatura p){
        pantalla = p;
    }
    
    @Override
    public void run(){
        pantalla.run();
    }
}
