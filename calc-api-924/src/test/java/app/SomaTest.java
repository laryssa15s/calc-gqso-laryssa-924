package app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SomaTest {
    Soma soma;

    @BeforeEach
    public void setup() {
        soma = new Soma();
    }

    @Test
    public void testSoma_OK() {
        assertEquals(2+2, soma.soma("2.","2."));
    }

    @Test
    public void testSoma_nao_pode_letra(){
        assertThrows(IllegalArgumentException.class, ()->{
            soma.soma("a","n");
        });
    }

    @Test
    public void testSoma_nao_pode_nulo(){
        assertThrows(IllegalArgumentException.class, ()->{
            soma.soma("null","null");
        });
    }
            


};