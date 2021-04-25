package beans;

/* Clase de tipo Java Bean, que debe cumplir las siguientes reglas para que sea
considerada como tal:

- Debe tener el constructor vacío
- Los atributos deben ser privados
- Debe tener getter y setter para cada atributo
 */
public class Rectangulo {

    private int base;
    private int altura;

    /* El constructor vacío se agregaría de forma automática si no hay otro
    constructor. */
    public Rectangulo() {
    }

    public int getAltura() {
        return this.altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getBase() {
        return this.base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getArea() {
        return this.base * this.altura;
    }
}
