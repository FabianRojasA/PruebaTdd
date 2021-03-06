package cl.ucn.disc.pdbp.tdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Model test.
 */
public final class ModelTest {

    /**
     * The Logger (console)
     */
    private static final Logger log = LoggerFactory.getLogger(ModelTest.class);

    /**
     * Test the Persona.
     * - El nombre no puede ser null.
     * - El nombre debe tener al menos 2 letras.
     * - El apellido no puede ser null.
     * - El apellido debe tener al menos 3 letras.
     * - El rut no puede ser null
     * - El rut debe ser valido.
     */
    @Test
    public void testPersona() {

        log.debug("Testing Persona ..");

        // The data!
        log.debug(".. valid ..");
        String nombre = "Andrea";
        String nombreError = "A";
        String apellido = "Contreras";
        String apellidoError = "Co";
        String nombreApellido = nombre + " " + apellido;
        String rutOk =      "152532873";
        String rutError =   "15253287K";

        // Test constructor and getters
        Persona persona = new Persona(nombre, apellido, rutOk);
        Assertions.assertEquals(persona.getNombre(), nombre);
        Assertions.assertEquals(persona.getApellido(), apellido);
        Assertions.assertEquals(persona.getNombreApellido(), nombreApellido);

        // Testing nullity
        log.debug(".. nullity ..");
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(null, null, null));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(null, null, rutOk));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(null, apellido, null));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(null, apellido, rutOk));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(nombre, null, null));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(nombre, null, rutOk));
        Assertions.assertThrows(NullPointerException.class, () -> new Persona(nombre, apellido, null));

        // Testing invalid rut
        log.debug(".. rut ..");
        Assertions.assertThrows(RuntimeException.class, () -> new Persona(nombre, apellido, rutError));

        // Testing parameter's size
        Assertions.assertThrows(RuntimeException.class, ()-> new Persona("",apellido,rutOk));
        Assertions.assertThrows(RuntimeException.class, ()-> new Persona("a",apellido,rutOk));
        Assertions.assertThrows(RuntimeException.class, ()-> new Persona(nombre,"",rutOk));
        Assertions.assertThrows(RuntimeException.class, ()-> new Persona(nombre,"a",rutOk));
        Assertions.assertThrows(RuntimeException.class, ()-> new Persona(nombre,"aa",rutOk));

        Assertions.assertThrows(RuntimeException.class, ()-> new Persona("","",rutOk));
        Assertions.assertThrows(RuntimeException.class, ()-> new Persona("","a",rutOk));
        Assertions.assertThrows(RuntimeException.class, ()-> new Persona("","aa",rutOk));

        Assertions.assertThrows(RuntimeException.class, ()-> new Persona("a","",rutOk));
        Assertions.assertThrows(RuntimeException.class, ()-> new Persona("a","a",rutOk));
        Assertions.assertThrows(RuntimeException.class, ()-> new Persona("a","aa",rutOk));


        log.debug("Done.");

    }

    /**
     * Test the digito verificador.
     */
    @Test
    public void testDigitoVerificador() {

        log.debug("Testing digito verificador ..");
        Assertions.assertFalse(Validation.isRutValid(null));

        Assertions.assertTrue(Validation.isRutValid("152532873"));
        Assertions.assertTrue(Validation.isRutValid("21195194K"));
        Assertions.assertTrue(Validation.isRutValid("121244071"));
        Assertions.assertTrue(Validation.isRutValid("198127949"));
        Assertions.assertTrue(Validation.isRutValid("202294316"));

        Assertions.assertFalse(Validation.isRutValid("1525A2873"));
        Assertions.assertFalse(Validation.isRutValid("15253287K"));
        Assertions.assertFalse(Validation.isRutValid("15253287-"));
        log.debug("Done.");
    }

}
