package p2;

import p2.Filtro;
import p2.EstadoMotor;
import p2.EstadoSCACV;

public class RepercutirRozamiento implements Filtro{
    public static final double ROZAMIENTO = 1;
    
    
    // *************************************************************************
    // MÉTODOS AUXILIARES:
    // *************************************************************************
    
    // Este método nos permite aplicar el segundo filtro sobre las rpm
    
    @Override
    public double ejecutar(double r, EstadoMotor e, EstadoSCACV es, boolean c){
        double rpm = r;
        
        if (es != EstadoSCACV.MANTENER) 
            rpm-=ROZAMIENTO;
        
        return Math.max(0, rpm);
    }
}
