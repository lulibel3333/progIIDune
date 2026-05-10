package modelo.subdito;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Explorador extends Subdito {

    public Explorador(int energia, int experiencia) {
        super(energia, experiencia);
    }

    public Explorador() {
        super(100, 0);
    }

    @Override
    public int recibirSalario() {
        return 2;
    }
}
