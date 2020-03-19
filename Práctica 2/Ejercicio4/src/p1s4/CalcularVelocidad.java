package p1s4;

public class CalcularVelocidad implements Filtro{
    static final double MAX_VEL = 5000;
    private static final double INC_VEL_FRENADO = -100;
    private static final double INC_VEL_ACELERACION = 100;
    
    // *************************************************************************
    // MÉTODOS AUXILIARES:
    // *************************************************************************
    
    // Este método nos permite aplicar el primer filtro de velocidad
    
    @Override
    public double ejecutar(double r, EstadoMotor e, EstadoSCACV es, boolean c){
        double rpm;
        
        if (es == EstadoSCACV.MANTENER)
            rpm = r;
        else {
            switch (e) {
                case APAGADO:   rpm=0; break;
                case ENCENDIDO: rpm=r; break;
                case FRENANDO:  rpm=r+INC_VEL_FRENADO; break;
                default:        rpm=r+INC_VEL_ACELERACION; break;
            }
        }
        
        if (!c)                 return (0);
        else if (rpm > MAX_VEL) return (MAX_VEL);
        else                    return (rpm);
    }
}
