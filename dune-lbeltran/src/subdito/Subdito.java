package subdito;

import src.dunee.casas.Casa;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public abstract class Subdito {

    private Casa casa; //esto deberia ser un enumerado dentro de lo q es la clase subdito?
    private int energia;
    private int experiencia;

    public Subdito(int energia, int experiencia) {
        this.energia = energia;
        this.experiencia = experiencia;

    }

}
