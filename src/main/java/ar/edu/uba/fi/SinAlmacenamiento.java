package ar.edu.uba.fi;

public class SinAlmacenamiento implements Almacenamiento {

    @Override
    public boolean estaEn(Region region) {
        // Un pod sin almacenamiento no restringe la region del nodo.
        return true;
    }
}
