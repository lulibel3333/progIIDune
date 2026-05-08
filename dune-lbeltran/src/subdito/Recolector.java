package subdito;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public class Recolector extends Subdito {

    public Recolector(int energia, int experiencia) {
        super(energia, experiencia);
    }

    public Recolector() {
        super(100, 0);
    }

    /*
    Finalmente, los recolectores, cuyo trabajo es
    fundamental para la cosecha de la especia,
tienen un salario de 3 unidades.

     */
    @Override
    public int recibirSalario() {
        return 3;
    }

}
