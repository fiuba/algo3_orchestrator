package ar.edu.uba.fi;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private List<Recurso> recursosLibres;
    private final Region region;
    private final List<Pod> pods;

    public Nodo(List<Recurso> recursosLibres, Region region) {
        this.recursosLibres = new ArrayList<>(recursosLibres);
        this.region = region;
        this.pods = new ArrayList<>();
    }

    public void alojar(Pod pod) {
        recursosLibres = pod.alojar(recursosLibres(), region);
        pods.add(pod);
    }

    public List<Recurso> recursosLibres() {
        return new ArrayList<>(recursosLibres);
    }

    public List<Pod> pods() {
        return new ArrayList<>(pods);
    }
}
