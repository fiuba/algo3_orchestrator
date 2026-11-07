package ar.edu.uba.fi;

import java.util.ArrayList;
import java.util.List;

public class Pod {
    private final List<Recurso> recursosNecesarios;
    private final Almacenamiento almacenamiento;

    public Pod(List<Recurso> recursos) {
        this(recursos, new SinAlmacenamiento());
    }

    public Pod(List<Recurso> recursos, Almacenamiento almacenamiento) {
        this.recursosNecesarios = new ArrayList<>(recursos);
        this.almacenamiento = almacenamiento;
    }

    public List<Recurso> alojar(List<Recurso> recursosLibres, Region region) {
        List<Recurso> misRecursosRequeridos = new ArrayList<>(recursosNecesarios);
        List<Recurso> nuevosRecursosLibres = new ArrayList<>();
        for (Recurso libre : recursosLibres) {
            nuevosRecursosLibres.add(consumir(libre, misRecursosRequeridos));
        }

        if (!almacenamiento.estaEn(region)) {
            throw new PodNoAlojableException();
        }

        return nuevosRecursosLibres;
    }

    private Recurso consumir(Recurso libre, List<Recurso> recursoRequerido) {
        Recurso restante = libre;
        for (Recurso requerido : new ArrayList<>(recursoRequerido)) {
            Recurso nuevo = restante.restar(requerido);
            if (nuevo != restante) {
                recursoRequerido.remove(requerido);
                restante = nuevo;
            }
        }

        return restante;
    }
}
