package modelo.terrritorio;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Arenas_de_Carthag extends Territorio {

    public Arenas_de_Carthag(int extension, Tipologia tipologia, Capacidad capacidad_construccion, int superficie_construida, Capacidad capacidad_generacion_en, int energia_inicial, Capacidad capacidad_produccion, int reservas_almacenadas) {
        super(null, 50, Tipologia.ARIDO, Capacidad.BAJA, 5, Capacidad.BAJA, 100, Capacidad.MEDIA, 150);
    }

}
