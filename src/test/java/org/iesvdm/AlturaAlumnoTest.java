package org.iesvdm;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AlturaAlumnoTest {

    @Test
    void verdadero(){
        assertTrue(1==1);
    }

    @Test
    void anyadeNombreTest1(){
        final String[] array = new String[2];

        array[0] = "Jose";
        array[1] = "Paco";
        String nombreNuevo = "María";

        String[] arrayActual = AlturaAlumno.añadeNombre(array,nombreNuevo);

        assertTrue(arrayActual[arrayActual.length-1].equals(nombreNuevo));

        for(int i=0; i<array.length;i++){
            assertEquals(array[i],arrayActual[i]);
        }
//        String[] arrayExpected = Arrays.copyOf(array, array.length+1);
//        arrayExpected[arrayExpected.length-1] = nombreNuevo;
//
//
//        assertEquals(arrayExpected,arrayActual);

    }

//    @Test
//    void anyadeNombreTest2(){
//        final String[] array = new String[10];
//        int longInicial = array.length;
//
//        array[0] = "Jose";
//        String nombreNuevo = "María";
//
//        String[] arrayActual = AlturaAlumno.añadeNombre(array,nombreNuevo);
//
//        assertEquals(nombreNuevo,arrayActual[longInicial-1]);
//
//    }

    @Test
    void anyadeAlturaTest(){
        double alturaPorDefecto = 1.5;


    }

}
