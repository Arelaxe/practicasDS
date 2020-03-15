package ds_s1p1;


public class DS_S1P1{

    public static void main(String[] args) {
        FactoriaCarretera fac_car = new FactoriaCarretera();
        FactoriaMontana fac_mon = new FactoriaMontana();
        
        CarreraCarretera carrera_car = fac_car.crearCarrera(10);
        CarreraMontana carrera_mon = fac_mon.crearCarrera(10);
        
        carrera_car.start();
        carrera_mon.start();
    }
}

