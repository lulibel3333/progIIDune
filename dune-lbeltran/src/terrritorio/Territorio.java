package terrritorio;

import java.util.*;
import subdito.Recolector;
import subdito.Sabio;
import subdito.Subdito;
import static terrritorio.Capacidad.ALTA;
import static terrritorio.Capacidad.BAJA;
import static terrritorio.Capacidad.MEDIA;

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

    private List<Subdito> listaSubditos;

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

        this.listaSubditos = new ArrayList<>();
    }

    //getters necesarios
    public int getSuperficie_construida() {
        return this.superficie_construida;
    }

    public int getEnergia_inicial() {
        return this.energia_inicial;
    }

    public Capacidad getCapacidad_produccion() {
        return this.capacidad_produccion;

    }

    public int getReservas_almacenadas() {
        return this.reservas_almacenadas;
    }

    public int getExtension() {
        return this.extension;
    }

    // hacer algo de superfice contruida que de erro cuando sobrepasa 100
    public void SumarPuntosPorSuperficie() {

        if (this.superficie_construida > 60) {
            this.energia_inicial = this.energia_inicial + 2;
            System.out.println(" bonificación aplicada, nueva energía: " + this.energia_inicial);
        } else {
            System.out.println("superficie insuficiente");
        }
    }

    public void cosecharMelange() {
        int alfa = 0; //inicializas a 0
        switch (this.capacidad_produccion) {
            case ALTA:
                alfa = 10;
                break;
            case MEDIA:
                alfa = 5;
                break;
            case BAJA:
                alfa = 2;
                break;
        }

        double experiencia = 0;
        int numRecolectores = 0;

        for (Subdito s : listaSubditos) {
            if (s instanceof Recolector) {
                Recolector r = (Recolector) s; // haces cast
                experiencia = r.getExperiencia();
                numRecolectores++;

            }
        }

        if (numRecolectores > 0) {
            double beta = experiencia / numRecolectores; //calculo de la media
            // ahora aplico la formula del enunciado

            double cantidadEspecia = alfa * ((numRecolectores * beta) / 100);

            //ahora tienes q sumar lo que has recolectado a las reservas
            this.reservas_almacenadas = this.reservas_almacenadas + (int) cantidadEspecia;//haces cast para poder sumar en mismas "unidades"

        }
    }

    /*
    public void añadirSubdito(Subdito s) {
        this.listaSubditos.add(s);
    }
     */
    public int CalculoEnergiaRequerida() {
        double alfa = 0.0;
        int beta = 1;
        double resultadoFinal = 0;
        switch (this.capacidad_construccion) {
            case ALTA:
                alfa = 0.5;
                break;
            case MEDIA:
                alfa = 1.0;
                break;
            case BAJA:
                alfa = 3.0;
                break;
        }

        if (this.superficie_construida < 33) {
            beta = 3;
        }
        if (this.superficie_construida >= 33 && this.superficie_construida < 80) {
            beta = 2;
        }
        if (this.superficie_construida >= 80) {
            beta = 1;
        }

        //me da error mirar
        double energiaRequerida = alfa * beta * (this.extension / this.superficie_construida);

        double sumaExperienciaSabios = 0;
        int numSabios = 0;
        for (Subdito s : listaSubditos) {
            if (s instanceof Sabio) {
                sumaExperienciaSabios = sumaExperienciaSabios + s.getExperiencia();
                numSabios++;
            }
        }

        if (numSabios > 0) {
            double mediaExperiencia = sumaExperienciaSabios / numSabios;
            resultadoFinal = (energiaRequerida * (mediaExperiencia / 4.0));
        }

        return (int) resultadoFinal;
    }

    public int CalculoEnergiaGenerada() {
        double alfa = 0;
        double energiaGenerada = 0;

        switch (this.capacidad_generacion_en) {
            case ALTA:
                alfa = 2.0;
                break;
            case MEDIA:
                alfa = 1.0;
                break;
            case BAJA:
                alfa = 0.5;
                break;
        }

        energiaGenerada = alfa * (this.superficie_construida * this.extension) / 100;

        return (int) energiaGenerada;
    }
}
