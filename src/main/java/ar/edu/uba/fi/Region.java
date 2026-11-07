package ar.edu.uba.fi;

import java.util.Objects;

public class Region implements Comparable<Region> {
    private final String nombre;

    public Region(String nombre) {

        this.nombre = nombre;
    }

    @Override
    public int compareTo(Region otra) {
        return nombre.compareTo(otra.nombre);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return nombre.equals(region.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
