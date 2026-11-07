package ar.edu.uba.fi;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NodoTest {

    @Test
    public void si_falta_cpu_no_se_consume_la_memoria_del_nodo() {
        Nodo nodo = new Nodo(List.of(new Memoria(100), new Cpu(5)), new Region("Buenos Aires"));
        Pod pod = new Pod(List.of(new Memoria(10), new Cpu(5)));

        assertThrows(PodNoAlojableException.class, () -> nodo.alojar(pod));
        assertEquals(List.of(new Memoria(100), new Cpu(5)), nodo.recursosLibres());
        assertEquals(List.of(), nodo.pods());
    }
}
