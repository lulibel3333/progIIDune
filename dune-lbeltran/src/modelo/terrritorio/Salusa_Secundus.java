package modelo.terrritorio;

import modelo.casas.Corrino;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Salusa_Secundus extends Territorio {

    public Salusa_Secundus(int extension, Tipologia tipologia, Capacidad capacidad_construccion, int superficie_construida, Capacidad capacidad_generacion_en, int energia_inicial, Capacidad capacidad_produccion, int reservas_almacenadas) {
        super(new Corrino(), 90, Tipologia.MONTAÑOSO, Capacidad.BAJA, 10, Capacidad.MEDIA, 100, Capacidad.BAJA, 2000);
    }

}
