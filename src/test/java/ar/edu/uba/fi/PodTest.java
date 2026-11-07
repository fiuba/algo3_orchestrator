package ar.edu.uba.fi;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class PodTest {

    @Test
    public void pod_devuelve_una_lista_nueva_sin_modificar_los_recursos_libres_recibidos() {
        List<Recurso> recursosLibres = new ArrayList<>(List.of(new Memoria(100), new Cpu(5)));
        Pod pod = new Pod(List.of(new Memoria(90), new Cpu(4)));

        List<Recurso> nuevosRecursosLibres = pod.alojar(recursosLibres, new Region("Buenos Aires"));

        assertNotSame(recursosLibres, nuevosRecursosLibres);
        assertEquals(List.of(new Memoria(10), new Cpu(1)), nuevosRecursosLibres);
        assertEquals(List.of(new Memoria(100), new Cpu(5)), recursosLibres);
    }
}
