
package p1s4;


public class Controlador{
    private Objetivo obj = new Objetivo();
    private ControladorPanelBotones cpb;
    private ControladorSalpicadero cs;
    
    // *************************************************************************
    // CONSTRUCTOR:
    // *************************************************************************
    
    public Controlador(){
        HebraObjetivo ho = new HebraObjetivo(obj);
        ho.start();
    }
    
    // *************************************************************************
    // MÉTODOS AUXILIARES:
    // *************************************************************************
    // Cabe destacar la variedad en cuanto a la funcionalidad de estos métodos,
    // ya que esta clase se encarga de gestionar todas las comunicaciones más
    // genéricas entre el modelo y la vista.
    
    
    // Nos permite instanciar un nuevo controlador para el panel, asignándole el
    // objeto correspondiente
    
    public void nuevoControladorPanelBotones(PanelBotones p){
        cpb = new ControladorPanelBotones(p,obj);
        obj.addObserver(cpb);
    }
    
    // Nos permite instanciar un nuevo controlador para el salpicadero, asignándole
    // el objeto correspondiente.
    
    public void nuevoControladorSalpicadero(Salpicadero s){
        cs =new ControladorSalpicadero(s,obj);
        obj.addObserver(cs);
    }
    
    // Método para cambiar el aceite:
    public void cambiarAceite(){
        obj.setRevAceite(0);
    }
    
    // Método para cambiar las pastillas de frenos:
    public void cambiarPastillasFrenos(){
        obj.setRevPastillas(0);
    }
    
    // Método para realizar la revisión general;
    public void revisionGeneral(){
        obj.setRevRevgeneral(0);
    }
    
    // Método para cambiar el estado del motor (necesario para com. síncrona)
    public void cambioEstadoMotor(EstadoMotor e){
        obj.setEstadoMotor(e);
        obj.realizarPeticion();
    }
    
    // Método para cambiar el estado del SCACV (necesario para com. síncrona)
    public void cambioEstadoSCACV(EstadoSCACV e){
        obj.setEstadoSCACV(e);
        obj.realizarPeticion();
    }
    
    // Método para añadir más combustible
    public void aniadirCombustible(String c){
         System.out.println(obj.getCombustible());
        obj.setCombustible(obj.getCombustible()+Double.valueOf(c));
    }
}
