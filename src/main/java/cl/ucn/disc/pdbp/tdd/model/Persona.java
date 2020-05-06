/*
 *El código de la validación del rut fue sacado de la pagina
 * https://www.qualityinfosolutions.com/validador-de-rut-chileno-en-java/
 */
package cl.ucn.disc.pdbp.tdd.model;
/**
 *
 */
public class Persona {
    /**
     *
     */
    private String nombre;
    private String apellido;
    private String rut;

    /**
     * Constructor de una persona
     * @param nombre a usar
     * @param apellido a usar
     * @param rut valido
     */
    public Persona(String nombre, String apellido, String rut) {
        if (nombre == null){ throw new NullPointerException("Nombre invalido");}
        if (apellido == null) {throw new NullPointerException("Apellido invalido");}
        if (rut == null) {throw new NullPointerException("Rut invalido");}
        if (!Validation.isRutValid(rut)) { throw new RuntimeException();}

        if (nombre.length() <2 ){ throw new RuntimeException("Nombre invalido");}
        if (apellido.length() <3 ){ throw new RuntimeException("Apellido invalido");}
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getNombreApellido() {
        return this.nombre + " " + this.apellido;
    }



}
