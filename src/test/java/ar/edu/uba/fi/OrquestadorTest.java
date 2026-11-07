package ar.edu.uba.fi;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrquestadorTest {

    @Test
    public void caso_1_agregar_pod1_al_nodo1() {
        Nodo nodo1 = new Nodo(List.of(new Memoria(100), new Cpu(5)), new Region("Buenos Aires"));
        Pod pod1 = new Pod(List.of(new Memoria(90), new Cpu(4)),
                new UnidadDeAlmacenamiento(new Region("Rosario")));

        assertThrows(PodNoAlojableException.class, () -> nodo1.alojar(pod1));
        assertEquals(List.of(new Memoria(100), new Cpu(5)), nodo1.recursosLibres());
        assertEquals(List.of(), nodo1.pods());
    }

    @Test
    public void caso_2_agregar_pod1_y_pod2_al_cluster1() {
        Nodo nodo1 = new Nodo(List.of(new Memoria(100), new Cpu(5)), new Region("Buenos Aires"));
        Nodo nodo2 = new Nodo(List.of(new Memoria(200), new Cpu(10)), new Region("Córdoba"));
        Cluster cluster1 = new Cluster(nodo1, nodo2);
        Pod pod1 = new Pod(List.of(new Memoria(90), new Cpu(4)),
                new UnidadDeAlmacenamiento(new Region("Buenos Aires")));
        Pod pod2 = new Pod(List.of(new Memoria(100), new Cpu(9)));

        cluster1.alojar(pod1);
        cluster1.alojar(pod2);

        assertEquals(List.of(new Memoria(100 - 90), new Cpu(5 - 4)), nodo1.recursosLibres());
        assertEquals(List.of(new Memoria(200 - 100), new Cpu(10 - 9)), nodo2.recursosLibres());
        assertEquals(List.of(pod1), nodo1.pods());
        assertEquals(List.of(pod2), nodo2.pods());
    }
}
