package ar.edu.uba.fi;

import java.util.ArrayList;
import java.util.List;

public class Cluster {

    private final ArrayList<Nodo> nodos;

    public Cluster(Nodo... nodos) {
        this.nodos = new ArrayList<>();

        this.nodos.addAll(List.of(nodos));
    }

    public void alojar(Pod pod) {
        for (Nodo nodo : nodos) {
            try {
                nodo.alojar(pod);
                return;
            } catch (PodNoAlojableException e) {
                // El nodo no tiene lugar para el pod, se prueba con el siguiente.
            }
        }

        throw new PodNoAlojableException();
    }
}
