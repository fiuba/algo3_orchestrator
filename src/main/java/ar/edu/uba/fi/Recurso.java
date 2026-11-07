package ar.edu.uba.fi;

public abstract class Recurso {
    protected final int unidades;

    protected Recurso(int unidades) {

        this.unidades = unidades;
    }

    // Devuelve el recurso restante. Si el consumido es de otro tipo devuelve
    // este mismo recurso; si no alcanza lanza RecursoInsuficienteException.
    public abstract Recurso restar(Recurso consumido);
}
