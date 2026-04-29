package src.dunee.casas;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public abstract class Casa {

    private ApellidoNobiliario apellidoNobiliario;
    private String lider;
    private String capital; // o usar lo de la clase territorio??

    // private subditos ; no se si es un entero o herde dela clase
    //private territorios como llamo a CAladan pro ejemplo
    public Casa(ApellidoNobiliario apellidoNobiliario, String lider) {
        this.apellidoNobiliario = apellidoNobiliario;
        this.lider = lider;
    }

}
