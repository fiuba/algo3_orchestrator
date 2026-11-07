package ar.edu.uba.fi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MemoriaTest {

    @Test
    public void restar_memoria_solo_si_la_libre_es_mayor_a_la_requerida() {
        assertEquals(new Memoria(10), new Memoria(100).restar(new Memoria(90)));
        assertThrows(RecursoInsuficienteException.class, () -> new Memoria(100).restar(new Memoria(100)));
    }

    @Test
    public void restar_un_recurso_de_otro_tipo_no_la_modifica() {
        Memoria memoria = new Memoria(100);

        assertSame(memoria, memoria.restar(new Cpu(1)));
    }

    @Test
    public void memoria_es_comparable() {
        assertTrue(new Memoria(100).compareTo(new Memoria(90)) > 0);
        assertEquals(0, new Memoria(90).compareTo(new Memoria(90)));
    }
}
