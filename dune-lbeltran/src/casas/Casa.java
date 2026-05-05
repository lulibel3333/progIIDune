package src.dunee.casas;

import terrritorio.Territorio;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public abstract class Casa {

    private ApellidoNobiliario apellidoNobiliario;
    private String lider;
    private String capital; // o usar lo de la clase territorio??
    private Territorio territorio;

    public Casa(ApellidoNobiliario apellido, String lider, Territorio territorio) {
        this.apellidoNobiliario = apellido;
        this.lider = lider;
        this.territorio = territorio;

    }
}
