package ar.edu.uba.fi;

public class UnidadDeAlmacenamiento implements Almacenamiento {
    private final Region region;

    public UnidadDeAlmacenamiento(Region region) {

        this.region = region;
    }

    @Override
    public boolean estaEn(Region region) {
        return this.region.equals(region);
    }
}
