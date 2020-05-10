package p1s4;

public class CalcularVelocidad implements Filtro{
    private static final double INC_VEL_FRENADO = -100;
    private static final double INC_VEL_ACELERACION = 100;
    
    @Override
    public double ejecutar(double r, EstadoMotor e){
        double revoluciones;
        
        switch (e) {
            case APAGADO:   revoluciones=0; break;
            case ENCENDIDO: revoluciones=r; break;
            case FRENANDO:  revoluciones=r+INC_VEL_FRENADO; break;
            default: revoluciones=r+INC_VEL_ACELERACION; break;
        }
        
        if (revoluciones > Objetivo.MAX_VEL) 
            return (Objetivo.MAX_VEL);
        else 
            return (revoluciones);
    }
}
