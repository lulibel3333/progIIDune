package subdito;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Sabio extends Subdito {

    public Sabio(int energia, int experiencia) {
        super(energia, experiencia);
    }

    public Sabio() {
        super(100, 0);
    }

    @Override
    public int recibirSalario() {
        return 2;
    }
}
