package ds_s1p1;

public abstract class Bicicleta extends Thread{
    private Integer identificador;
    private double tiempo;
    FactoriaCarreraYBicicleta factoria;
    
    public Bicicleta(){
        tiempo=-1;
    }
    
    public Bicicleta(FactoriaCarreraYBicicleta factoria){
        this.factoria = factoria;
        tiempo=-1;
    }
    
    public void setIdentificador(int id){
        identificador = id;
    }
    
    public int getIdentificador(){
        return(identificador);
    }
    
    public void inicio(){
        tiempo = (int) Math.floor(Math.random()*(60-30+1)+30);
        
        try {
            Thread.sleep((long)tiempo*1000);
        } catch (InterruptedException ex) {
            System.out.println("Interrumpido");
        }
    }
    
    public double getTiempo(){
        return (tiempo);
    }
    
    @Override
    public void run(){
        inicio();
    }
}
