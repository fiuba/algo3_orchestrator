package ar.edu.uba.fi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CpuTest {

    @Test
    public void restar_cpu_solo_hasta_el_90_por_ciento() {
        assertEquals(new Cpu(1), new Cpu(10).restar(new Cpu(9)));
        assertThrows(RecursoInsuficienteException.class, () -> new Cpu(10).restar(new Cpu(10)));
    }

    @Test
    public void restar_un_recurso_de_otro_tipo_no_la_modifica() {
        Cpu cpu = new Cpu(100);

        assertSame(cpu, cpu.restar(new Memoria(1)));
    }

    @Test
    public void cpu_es_comparable() {
        assertTrue(new Cpu(4).compareTo(new Cpu(5)) < 0);
    }
}
