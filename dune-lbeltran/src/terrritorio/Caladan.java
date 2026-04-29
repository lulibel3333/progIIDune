package terrritorio;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Caladan extends Territorio {

    //en superficie poner un static final 100 ,tipo como que lo maximo es 100 y no se puede sobrepasar????'
    public Caladan(int extension, Tipologia tipologia, Capacidad capacidad_construccion, int superficie_construida, Capacidad capacidad_generacion_en, int energia_inicial, Capacidad capacidad_produccion, int reservas_almacenadas) {
        super(80, Tipologia.COSTERO, Capacidad.MEDIA, 20, Capacidad.MEDIA, 100, Capacidad.ALTA, 1500);
    }

}
