package ds_s1p1;

public class FactoriaCarretera implements FactoriaCarreraYBicicleta {
    @Override
    public BicicletaCarretera crearBicicleta(){
        BicicletaCarretera bici = new BicicletaCarretera(this);
        
        return bici;
    }
    
    @Override
    public CarreraCarretera crearCarrera(int num){
        CarreraCarretera carrera = new CarreraCarretera(num, this);
        
        return carrera;
    }
}
