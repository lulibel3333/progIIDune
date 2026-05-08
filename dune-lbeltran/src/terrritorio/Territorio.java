package terrritorio;

import java.util.*;
import src.dunee.casas.Casa;
import subdito.Explorador;
import subdito.Guerrero;
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

    public List<Subdito> getListaSubditos() {
        return listaSubditos;
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

    /*
    Además, aquellos afortunados que habiten
    territorios con más de un 60 % de la superficie
construída, disfrutarán de unas comodidades que
  les otorgará 2 puntos extra de energía por cada ciclo
     */
    public void VerSiMuere() {

        for (Subdito s : listaSubditos) {

            ////devuelve el salario en funcion del tipo de subdito que sea
           // int sueldoDelSubdito = s.recibirSalario();
            /* si las reservas del territorio tienen suficiente
melagne para pagar entocnes le quitas el sueldo
             */
            if (this.reservas_almacenadas >= s.recibirSalario()) {

                this.reservas_almacenadas = this.reservas_almacenadas - s.recibirSalario();

                if (this.superficie_construida > 60) {
                    int energiaExtra = s.getEnergia() + 2;
                    s.setEnergia(energiaExtra);
                }

            } else {
                // Si no puedo pagar el sueldo, muere ,y lo añaades al arraylist de fallecidos

                listaSubditos.remove(s);
            }
        }

        //quitas de la lista subditos la gente q ha fallecido
    }

    /*
    demografía natural hace que nazcan entre 1 y 3 súbditos, cada 5 ciclos.
    La actividad a la quese dedicarán es una incógnita
    y depende del azar. Lo único que se sabe es que el 30 % de los
súbditos prefieren las labores de recolección, el 40 % prefieren
    actividades guerreras, el 20 % lesgustan las tareas
    de exploración y el 10 % son estudiosos que llegarán a ser sabios.
     */
    public void Nacimientos(int ciclo) {

        //ocurren nacimientos cada 5 ciclos
        if (ciclo % 5 == 0) {

            //es un random entrw 1 y 3
            int cantidadNacimientos = 0;

            for (int i = 0; i < cantidadNacimientos; i++) {

                //es un numero aleatorio entre 0 a 100
                double azar = Math.random() * 100;
                //creas un subdito nuevo
                Subdito subditoNuevo;

                if (azar < 30) {
                    subditoNuevo = new Recolector(); // 30%
                } else if (azar < 70) {
                    subditoNuevo = new Guerrero();   // 40% (30 + 40)
                } else if (azar < 90) {
                    subditoNuevo = new Explorador(); // 20% (70 + 20)
                } else {
                    subditoNuevo = new Sabio();      // 10% (el resto hasta 100)
                }

                this.listaSubditos.add(subditoNuevo);
                // System.out.println("Ha nacido un nuevo " + nuevo.getClass().getSimpleName());
            }

        }

    }

    public void trasladoSubditos(Territorio origen, Territorio destino) {
        for (Subdito s : origen.getListaSubditos()) {
            s.setEnergia(s.getEnergia() - 20);

            destino.getListaSubditos().add(s);
            origen.getListaSubditos().remove(s);
        }
    }

    public void Expedicion(Casa casaDeAtaque, List<Explorador> expedicion) {

        double sumaExperiencia = 0;
        double sumaEnergia = 0;
        int contadorExploradores = 0;

        for (Subdito s : this.listaSubditos) {
            if (s instanceof Explorador) {
                sumaExperiencia += s.getExperiencia();
                sumaEnergia += s.getEnergia();
                contadorExploradores++;
            }
            double mediaExperiencia = sumaExperiencia / contadorExploradores;
            double mediaEnergia = sumaEnergia / contadorExploradores;
            double factorEstabilizacion = mediaExperiencia * mediaEnergia;

            double aleatorio = Math.random() * (3 * factorEstabilizacion);

            /*
            Si el número aleatorio es inferior
            al factor de estabilización, el territorio es conquistado
            por la casa a la que pertenecen los exploradores
             */
            if (aleatorio < factorEstabilizacion) {

                System.out.println("Territorio estabilizado por los exploradores.");
                // Aquí asignarías el dueño: this.casaDuena = casaAtacante;

                /*
                ◦ Si el número aleatorio es igual
                o superior al factor de estabilización,
                los exploradores fallan en su hazaña y mueren intentando
                finalizar su misión.
                 */
            } else {
                // FRACASO: Los exploradores mueren.
                // Como no quieres listas extra, usamos el Iterator o el for hacia atrás para borrarlos
                System.out.println("Los exploradores no han podido estabilizar el sector y han muerto.");

                for (Subdito subdito : listaSubditos) {
                    if (subdito instanceof Explorador) {
                        listaSubditos.remove(subdito); // <--- ¡¡ERROR AQUÍ!!
                    }
                }

            }
        }
    }
}
