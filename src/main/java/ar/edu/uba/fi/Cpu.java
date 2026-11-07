package ar.edu.uba.fi;

import java.util.Objects;

public class Cpu extends Recurso implements Comparable<Cpu> {
    private static final int PORCENTAJE_UTILIZABLE = 90;

    public Cpu(int unidades) {

        super(unidades);
    }

    @Override
    public Recurso restar(Recurso consumido) {
        if (!consumido.getClass().equals(this.getClass())) {
            return this;
        }

        Cpu other = (Cpu) consumido;
        // UCN * .90 >= UCP, en enteros para evitar errores de punto flotante
        if (Integer.compare(unidades * PORCENTAJE_UTILIZABLE, other.unidades * 100) < 0) {
            throw new RecursoInsuficienteException();
        }

        return new Cpu(unidades - other.unidades);
    }

    @Override
    public int compareTo(Cpu otra) {
        return Integer.compare(unidades, otra.unidades);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cpu cpu = (Cpu) o;
        return unidades == cpu.unidades;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unidades);
    }

    @Override
    public String toString() {
        return unidades + " UC";
    }
}
