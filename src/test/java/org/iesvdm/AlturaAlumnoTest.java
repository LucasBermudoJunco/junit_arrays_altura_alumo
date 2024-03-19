package org.iesvdm;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

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

    // Hacemos este test ante que el de ´´anyadeAlturaTest`` porque dicho test
    // tiene dentro este test
    @Test
    void modificaAlturaPosicionDentroDelArrayTest(){
        // when (cuando)
        double[] array = {1.6,1.7,1.8};
        // Hacemos una copia del array original
        double[] arrayCopia = Arrays.copyOf(array, array.length);

        int posicion = 1;
        double altura = 1.9;

        // do (hacer)
        AlturaAlumno.modificaAltura(array,posicion,altura);

        // then (entonces)
        assertTrue(altura == array[posicion]);

        // Comprobar que todos los demás elementos del array no cambian
        for(int i=0; i<array.length; i++){
            if(i != posicion){
                assertEquals(array[i],arrayCopia[i]);
            }
        }
    }

    // Hacemos este test ante que el de ´´anyadeAlturaTest`` porque dicho test
    // tiene dentro este test
    @Test
    void modificaAlturaPosicionFueraDelArrayTest(){
        // when (cuando)
        double[] array = {1.6,1.7,1.8};
        // Hacemos una copia del array original
        double[] arrayCopia = Arrays.copyOf(array, array.length);

        int posicion = array.length+2;
        double altura = 1.9;

        // do (hacer)
        AlturaAlumno.modificaAltura(array,posicion,altura);

        // then (entonces)
//        assertTrue(altura == array[posicion]);

        // Comprobar que todos los demás elementos del array no cambian
//        for(int i=0; i<array.length; i++){
//            if(i != posicion){
//                assertEquals(array[i],arrayCopia[i]);
//            }
//        }

        assertArrayEquals(array, arrayCopia);
    }

    @Test
    void anyadeAlturaTest(){
        double alturaPorDefecto = 1.5;


    }

}
