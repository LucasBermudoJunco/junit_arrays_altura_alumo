package org.iesvdm;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class AlturaAlumnoTest {

    @Test
    void menuTest(){
//        // Creamos la variable que queremos introducir, en forma de String
//        // con un salto de línea por cada entrada de teclado que queremos hacer,
//        // para tener en cuenta la limpieza del Buffer que se produce al leer el dato por teclado
//        String numIntrod = "-8\n1\n3\n6\n25\n";
//        // Creamos un objeto con el constructor de ´´ByteArrayInputStream`` y metiéndole
//        // el ´´numIntrod`` en forma de bytes
//        InputStream entradaPorTeclado = new ByteArrayInputStream(numIntrod.getBytes());
//        // Redirigimos la entrada por teclado hacia nuestro objeto ´´entradaPorTeclado``
//        System.setIn(entradaPorTeclado);
//
//        // Comprobamos que obtenemos el valor correcto
//        assertEquals(-8,AlturaAlumno.menu());
//        assertEquals(1,AlturaAlumno.menu());
//        assertEquals(3,AlturaAlumno.menu());
//        assertEquals(6,AlturaAlumno.menu());
//        assertEquals(25,AlturaAlumno.menu());
    }

    @Test
    void anyadeNombreTest1(){
        final String[] arrayOrig = new String[2];

        arrayOrig[0] = "Jose";
        arrayOrig[1] = "Paco";
        String nombreNuevo = "María";

        // Llamada al método que amplía el array original con el nombre nuevo
        String[] arrayAmpliado = AlturaAlumno.añadeNombre(arrayOrig,nombreNuevo);

        // Comprobación de que el tamaño del array es 1 tamaño más grande que el array original
        assertTrue(arrayAmpliado.length == arrayOrig.length+1);
        // Comprobación de que el último elemento del array ampliado es el nombre nuevo
        assertTrue(arrayAmpliado[arrayAmpliado.length-1].equals(nombreNuevo));
        // Comprobación de que cada elemento del array original es igual a cada elemento
        // del array ampliado (excepto, claro está, el último elemento del array ampliado
        // (que es el que se acaba de añadir nuevo))
        for(int i=0; i<arrayOrig.length;i++){
            assertEquals(arrayOrig[i],arrayAmpliado[i]);
        }

//        // Modo alternativo
//        String[] arrayExpected = Arrays.copyOf(array, array.length+1);
//        arrayExpected[arrayExpected.length-1] = nombreNuevo;
//
//        assertEquals(arrayExpected,arrayActual);

    }

    @Test
    void anyadeNombreTest2(){
        final String[] arrayOrig = new String[10];
        int longInicial = arrayOrig.length;

        arrayOrig[0] = "Jose";
        String nombreNuevo = "María";

        String[] arrayAmpliado = AlturaAlumno.añadeNombre(arrayOrig,nombreNuevo);

        assertEquals(nombreNuevo,arrayAmpliado[longInicial]);

    }

    // Hacemos este test antes que el de ´´anyadeAltura`` porque dicho método
    // tiene dentro este método
    @Test
    void modificaAlturaPosicionDentroDelArrayTest(){
        // when (cuando)
        double[] arrayOrig = {1.6,1.7,1.8};
        // Hacemos una copia del array original
        double[] arrayCopia = Arrays.copyOf(arrayOrig, arrayOrig.length);

        // Establecemos una posición que sepamos que está dentro del array
        int posicion = 1;
        double altura = 1.9;

        // do (hacer)
        AlturaAlumno.modificaAltura(arrayOrig,posicion,altura);

        // then (entonces)
        assertTrue(altura == arrayOrig[posicion]);

        // Comprobamos que todos los demás elementos del array no cambian
        for(int i=0; i<arrayOrig.length; i++){
            // Justo el elemento que hemos cambiado no lo comprobamos porque
            // precisamente el método lo que ha hecho es modificarlo
            if(i != posicion){
                assertEquals(arrayOrig[i],arrayCopia[i]);
            }
        }
    }

    // Hacemos este test antes que el de ´´anyadeAltura`` porque dicho método
    // tiene dentro este método
    @Test
    void modificaAlturaPosicionFueraDelArrayTest(){
        // when (cuando)
        double[] arrayOrig = {1.6,1.7,1.8};
        // Hacemos una copia del array original
        double[] arrayCopia = Arrays.copyOf(arrayOrig, arrayOrig.length);

        // Establecemos una posición que sepamos que está fuera del array
        int posicion = arrayOrig.length+2;
        double altura = 1.9;

        // do (hacer)
        AlturaAlumno.modificaAltura(arrayOrig,posicion,altura);

        // Comprobamos que el array sigue igual que al principio ya que, como
        // la posición estaba fuera del array, no se ha modificado ningún valor
        assertArrayEquals(arrayOrig, arrayCopia);
    }

    @Test
    void anyadeAlturaTest(){
        double[] arrayOrig = {5.9,1.47,2.9,32.41};
        double[] arrayCopia = Arrays.copyOf(arrayOrig, arrayOrig.length);

        double alturaNuevaEsperada = 1.5;

        // Llamamos al método ´´añadeAltura`` y almacenamos su retorno en un nuevo array
        double[] arrayAmpliado = AlturaAlumno.añadeAltura(arrayOrig);

        // Comprobamos que el tamaño del arrayAmpliado es de 1 tamaño más que el
        // array original
        assertTrue(arrayAmpliado.length == arrayOrig.length+1);
        // Comprobamos que el último elemento del nuevo array es el valor por defecto
        assertTrue(arrayAmpliado[arrayAmpliado.length-1] == alturaNuevaEsperada);
        // Comprobamos que el array original sigue intacto
        assertTrue(Arrays.equals(arrayOrig,arrayCopia));

    }

    @Test
    void buscaNombreTestEncontrado(){
        // When
        String[] arrayOriginal = {"Sandra","Roberto","María","David"};
        String nomBusc = "Sandra";

        // Do & Then
        // Comprobación de que el índice obtenido es el correcto
        assertEquals(0,AlturaAlumno.buscaNombre(arrayOriginal,nomBusc));
    }

    @Test
    void buscaNombreTestNoEncontrado(){
        // When
        String[] arrayOriginal = {"Sandra","Roberto","María","David"};
        String nomBusc = "Pepe";

        // Do & Then
        // Comprobación de que el índice obtenido es el correcto
        assertEquals(-1,AlturaAlumno.buscaNombre(arrayOriginal,nomBusc));
    }

    @Test
    void buscaNombreTestArrayTam0(){
        // When
        String[] arrayOriginal = new String[0];
        String nomBusc = "Andrés";

        // Do & Then
        // Comprobación de que el índice obtenido es el correcto
        assertEquals(-1,AlturaAlumno.buscaNombre(arrayOriginal,nomBusc));
    }

    @Test
    void buscaNombreTestNombreVacioONula(){
        // When
        String[] arrayOriginal = {"Sandra","Roberto","María","David"};
        String nomBusc = "";

        // Do & Then
        // Comprobación de que el índice obtenido es el correcto
        assertEquals(-1,AlturaAlumno.buscaNombre(arrayOriginal,nomBusc));
        assertEquals(-1,AlturaAlumno.buscaNombre(arrayOriginal,null));
    }

    @Test
    void mostrarTestFuncCorrecto(){
        // When
        String[] nombres = {"Sandra","Roberto","María","David"};
        double[] alturas = {5.9,1.47,2.9,32.41};

        // Do & Then
        assertDoesNotThrow(() -> {AlturaAlumno.mostrar(nombres,alturas);});
    }

    @Test
    void mostrarTestFuncIncorrecto(){
        // When
        String[] nombres = {"Sandra","Roberto","María","David"};
        double[] alturas = {5.9,1.47,2.9};

        // Do & Then
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {AlturaAlumno.mostrar(nombres,alturas);});
    }

    @Test
    void calculaMaximoTest(){
        double[] arrayOrigLleno = {5.9,1.47,2.9,32.41};
        double[] arrayOrigVacio = new double[0];

        // Llamada al método ´´calculaMaximo`` y almacenamiento de su retorno
        // en un nuevo array
        double[] arrayObtDelLleno = AlturaAlumno.calculaMaximo(arrayOrigLleno);
        double[] arrayObtDelVacio = AlturaAlumno.calculaMaximo(arrayOrigVacio);

        // Comprobación de que el tamaño de los arrays obtenidos es 2
        assertTrue(arrayObtDelLleno.length == 2);
        assertTrue(arrayObtDelVacio.length == 2);
        // Comprobación de que los valores de los arrays obtenidos son los correctos

        // Comprobación para arrays llenos
        assertTrue(arrayObtDelLleno[0] == 3);
        assertTrue(arrayObtDelLleno[1] == 32.41);

        // Comprobación para arrays vacíos
        for(int i=0; i<arrayObtDelVacio.length; i++){
            assertTrue(arrayObtDelVacio[i] == 0);
        }
    }

    @Test
    void calculaMediaTest(){
        double[] arrayOrigLleno = {5.9,1.47,2.9,32.41};
        double[] arrayOrigVacio = new double[0];

        // Llamada al método ´´calculaMedia`` y almacenamiento de su retorno
        // en una nueva variable
        double mediaObtDelLleno = AlturaAlumno.calculaMedia(arrayOrigLleno);
        double mediaObtDelVacio = AlturaAlumno.calculaMedia(arrayOrigVacio);

        // Comprobación de que los resultados obtenidos son correctos
        assertTrue(mediaObtDelLleno == ((5.9+1.47+2.9+32.41)/4));
        assertTrue(mediaObtDelVacio == 0);

    }

}
