package modelo.casas;

import java.util.*;
import modelo.Territorio;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public abstract class Casa {

    private ApellidoNobiliario apellidoNobiliario;
    private String lider;
    private String capital; // o usar lo de la clase territorio??
    private List<Territorio> territorios;

    public Casa(ApellidoNobiliario apellido, String lider) {
        this.apellidoNobiliario = apellido;
        this.lider = lider;
        this.territorios = new Arraylist();

    }
}
