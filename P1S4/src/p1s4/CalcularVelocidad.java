package p1s4;

public class CalcularVelocidad implements Filtro{
    private static final double MAX_VEL = 5000;
    private static final double INC_VEL_APAGADO = 0;
    private static final double INC_VEL_FRENADO = -100;
    private static final double INC_VEL_ACELERACION = 100;
    private float incremento_velocidad;
    
    public double ejecutar(double r, EstadoMotor e){
        if (e==EstadoMotor.APAGADO || e==EstadoMotor.ENCENDIDO){
            return (r+INC_VEL_APAGADO);
        }
        else if (e==EstadoMotor.FRENANDO){
            return (r+INC_VEL_FRENADO);
        }
        else{
            return (r+INC_VEL_ACELERACION);
        }
    }
}
