package modelo.terrritorio;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Arrakeen extends Territorio {

    public Arrakeen(int extension, Tipologia tipologia, Capacidad capacidad_construccion, int superficie_construida, Capacidad capacidad_generacion_en, int energia_inicial, Capacidad capacidad_produccion, int reservas_almacenadas) {
        super(80, Tipologia.COSTERO, Capacidad.MEDIA, 10, Capacidad.MEDIA, 100, Capacidad.MEDIA, 100);
    }

}
