package ar.edu.uba.fi;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClusterTest {

    @Test
    public void cluster_sin_nodo_con_lugar_para_el_pod_lanza_excepcion() {
        Nodo nodo1 = new Nodo(List.of(new Memoria(100), new Cpu(5)), new Region("Buenos Aires"));
        Nodo nodo2 = new Nodo(List.of(new Memoria(200), new Cpu(10)), new Region("Córdoba"));
        Cluster cluster1 = new Cluster(nodo1, nodo2);
        Pod pod = new Pod(List.of(new Memoria(500), new Cpu(1)));

        assertThrows(PodNoAlojableException.class, () -> cluster1.alojar(pod));
        assertEquals(List.of(new Memoria(100), new Cpu(5)), nodo1.recursosLibres());
        assertEquals(List.of(new Memoria(200), new Cpu(10)), nodo2.recursosLibres());
        assertEquals(List.of(), nodo1.pods());
        assertEquals(List.of(), nodo2.pods());
    }
}
