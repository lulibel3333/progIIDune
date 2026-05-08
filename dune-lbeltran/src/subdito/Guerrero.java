package subdito;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Guerrero extends Subdito {

    public Guerrero(int energia, int experiencia) {
        super(energia, experiencia);
    }

    public Guerrero() {
        // Llamamos al constructor del padre con valores iniciales
        // Por ejemplo: 100 de energía y 0 de experiencia
        super(100, 0);
    }

    @Override
    public int recibirSalario() {
        return 4;
    }

}
