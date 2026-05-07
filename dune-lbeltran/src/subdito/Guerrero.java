package subdito;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Guerrero extends Subdito {

    public Guerrero(int energia, int experiencia) {
        super(energia, experiencia);
    }

    @Override
    public int getSalario() {
        return 4;
    }

}
