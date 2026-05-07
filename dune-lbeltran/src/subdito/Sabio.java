package subdito;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Sabio extends Subdito {

    public Sabio(int energia, int experiencia) {
        super(energia, experiencia);
    }

    @Override
    public int getSalario() {
        return 2;
    }
}
