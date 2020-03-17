package p1s4;

public class RepercutirRozamiento implements Filtro{
    public static final double ROZAMIENTO = 1;
    
    @Override
    public double ejecutar(double r, EstadoMotor e){
        return Math.max(0, r-ROZAMIENTO);
    }
}
