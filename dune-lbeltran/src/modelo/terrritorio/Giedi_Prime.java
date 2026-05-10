package modelo.terrritorio;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Giedi_Prime extends Territorio {

    public Giedi_Prime(int extension, Tipologia tipologia, Capacidad capacidad_construccion, int superficie_construida, Capacidad capacidad_generacion_en, int energia_inicial, Capacidad capacidad_produccion, int reservas_almacenadas) {
        super(100, Tipologia.ARIDO, Capacidad.ALTA, 50, Capacidad.ALTA, 100, Capacidad.MEDIA, 1000);
    }

}
