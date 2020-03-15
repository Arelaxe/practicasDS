package ds_s1p1;

public class FactoriaMontana implements FactoriaCarreraYBicicleta {
    
    @Override
    public BicicletaMontana crearBicicleta(){
        BicicletaMontana bici = new BicicletaMontana(this);
        
        return bici;
    }
    
    @Override
    public CarreraMontana crearCarrera(int num){
        CarreraMontana carrera = new CarreraMontana(num, this);
        
        return carrera;
    }
}
