package modelo.terrritorio;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Sietch_Tabr extends Territorio {

    public Sietch_Tabr(int extension, Tipologia tipologia, Capacidad capacidad_construccion, int superficie_construida, Capacidad capacidad_generacion_en, int energia_inicial, Capacidad capacidad_produccion, int reservas_almacenadas) {
        super(null, 20, Tipologia.MONTAÑOSO, Capacidad.ALTA, 80, Capacidad.BAJA, 100, Capacidad.BAJA, 200);
    }

}
