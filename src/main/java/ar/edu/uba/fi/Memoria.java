package ar.edu.uba.fi;

import java.util.Objects;

public class Memoria extends Recurso implements Comparable<Memoria> {
    public Memoria(int unidades) {

        super(unidades);
    }

    @Override
    public Recurso restar(Recurso consumido) {
        if (!consumido.getClass().equals(this.getClass())) {
            return this;
        }

        Memoria other = (Memoria) consumido;
        // UMN > UMP
        if (compareTo(other) <= 0) {
            throw new RecursoInsuficienteException();
        }

        return new Memoria(unidades - other.unidades);
    }

    @Override
    public int compareTo(Memoria otra) {
        return Integer.compare(unidades, otra.unidades);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memoria memoria = (Memoria) o;
        return unidades == memoria.unidades;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unidades);
    }

    @Override
    public String toString() {
        return unidades + " UM";
    }
}
