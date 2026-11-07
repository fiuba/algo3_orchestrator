package ar.edu.uba.fi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegionTest {

    @Test
    public void region_es_comparable() {
        assertEquals(0, new Region("Córdoba").compareTo(new Region("Córdoba")));
        assertTrue(new Region("Buenos Aires").compareTo(new Region("Rosario")) < 0);
    }
}
