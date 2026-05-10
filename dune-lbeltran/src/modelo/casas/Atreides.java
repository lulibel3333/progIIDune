package modelo.casas;


import src.dunee.casas.ApellidoNobiliario;
import modelo.casas.Casa;
import modelo.terrritorio.Arrakeen;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Atreides extends Casa {

    //domina caladan , eso como ponerlo ????
    public Atreides() {
        super(ApellidoNobiliario.ATREIDES, "Duke Leto Atreides", new Arrakeen());
    }

}
