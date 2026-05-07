package subdito;

/**
 *
 * @author Luana Beltrán <luana.beltranrodas@usp.ceu.es>
 */
public abstract class Subdito {

    // private Territorio territorio;
    private int energia;
    private int experiencia;

    //private int salario; ???
    public Subdito(int energia, int experiencia) {
        this.energia = energia;
        this.experiencia = experiencia;

    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getEnergia() {
        return this.energia;
    }

    public abstract int recibirSalario();

    /*
    sobrevivirán, sino que recuperarán 2 puntos
de energía y ganarán 5 unidades de experiencia.

     */
    public void sobrevivir() {
        this.energia += 2;
        this.experiencia += 5;
    }

    /*
    public int getEnergia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     */
}
