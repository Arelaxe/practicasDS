package p2;

public interface Filtro {
    // Los argumentos indican el número de rpm anterior, el estado del motor
    // y si posee combustible
    
    public abstract double ejecutar(double r, EstadoMotor e, EstadoSCACV es, boolean c);
}
