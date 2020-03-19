
package p1s4;

public class HebraObjetivo extends Thread{
    private Objetivo obj;
    
    // *************************************************************************
    // CONSTRUCTOR:
    // *************************************************************************
    
    public HebraObjetivo(Objetivo o){
        obj = o;
    }
    
    // *************************************************************************
    // MÉTODO MODIFICADOR:
    // *************************************************************************
    
    public void setObjetivo(Objetivo o){
        obj = o;
    }
    
    // *************************************************************************
    // MÉTODOS AUXILIARES:
    // *************************************************************************
    
    // Inicia una hebra para ir monitorizando el tiempo
    @Override
    public void run(){
        obj.run();
    }
    
}
