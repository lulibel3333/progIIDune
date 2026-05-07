package subdito;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Explorador extends Subdito {

    public Explorador(int energia, int experiencia) {
        super(energia, experiencia);
    }

    @Override
    public int recibirSalario() {
        return 2;
    }
}
