package terrritorio;


import terrritorio.Tipologia;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public abstract class Territorio {

    private int extension;
    private Tipologia tipologia;
    private Capacidad capacidad_construccion;
    private int superficie_construida;
    private Capacidad capacidad_generacion_en;
    private int energia_inicial;
    private Capacidad capacidad_produccion;
    private int reservas_almacenadas;

    public Territorio(int extension, Tipologia tipologia, Capacidad capacidad_construccion,
            int superficie_construida, Capacidad capacidad_generacion_en,
            int energia_inicial, Capacidad capacidad_produccion, int reservas_almacenadas) {

        this.extension = extension;
        this.tipologia = tipologia;
        this.capacidad_construccion = capacidad_construccion;
        this.superficie_construida = superficie_construida;
        this.capacidad_generacion_en = capacidad_generacion_en;
        this.energia_inicial = energia_inicial;
        this.capacidad_produccion = capacidad_produccion;
        this.reservas_almacenadas = reservas_almacenadas;

    }

}
