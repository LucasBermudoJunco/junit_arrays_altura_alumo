package org.iesvdm;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
import java.util.Arrays;

public class AlturaAlumnoTest {

    // TESTS DEL MÉTODO ´´menu()`` REALIZADAS DE FORMA COMPLEMENTARIA A LA TAREA
    // Los tests del método ´´menu()`` están diseñados para ser probados individualmente,
    // por lo que, cuando se quiere probar la clase entera, hay que convertir los tests
    // en comentarios para que no se ejecuten junto al resto de tests
    // porque si no el programa se queda colgado eternamente
//    @Test
//    void menuTest1ValorFueraNegativo(){
//        // WHEN
//        // Creamos la variable que queremos introducir, en forma de String
//        // con un salto de línea por cada entrada de teclado que queremos hacer,
//        // para tener en cuenta la limpieza del Buffer que se produce al leer el dato por teclado
//        String numIntrod = "-8\n";
//        // Creamos un objeto con el constructor de ´´ByteArrayInputStream`` y metiéndole
//        // el ´´numIntrod`` en forma de bytes
//        InputStream entradaPorTeclado = new ByteArrayInputStream(numIntrod.getBytes());
//        // Redirigimos la entrada por teclado hacia nuestro objeto ´´entradaPorTeclado``
//        System.setIn(entradaPorTeclado);
//
//        // DO & THEN
//        // Comprobamos que obtenemos el valor correcto
//        assertEquals(-8,AlturaAlumno.menu());
//    }
//
//    @Test
//    void menuTest2ValorDentro(){
//        // WHEN
//        String numIntrod = "4\n";
//        InputStream entradaPorTeclado = new ByteArrayInputStream(numIntrod.getBytes());
//        System.setIn(entradaPorTeclado);
//
//        // DO & THEN
//        // Comprobamos que obtenemos el valor correcto
//        assertEquals(4,AlturaAlumno.menu());
//    }
//
//    @Test
//    void menuTest3ValorFueraPositivo(){
//        // WHEN
//        String numIntrod = "34\n";
//        InputStream entradaPorTeclado = new ByteArrayInputStream(numIntrod.getBytes());
//        System.setIn(entradaPorTeclado);
//
//        // DO & THEN
//        // Comprobamos que obtenemos el valor correcto
//        assertEquals(34,AlturaAlumno.menu());
//    }

    @Test
    void anyadeNombreTest1TamanyoArrays(){
        // WHEN
        final String[] arrayOrig = new String[2];

        arrayOrig[0] = "Jose";
        arrayOrig[1] = "Paco";
        String nombreNuevo = "María";

        // DO
        // Llamada al método que amplía el array original con el nombre nuevo
        String[] arrayAmpliado = AlturaAlumno.añadeNombre(arrayOrig,nombreNuevo);

        // THEN
        // Comprobación de que el tamaño del array es 1 tamaño más grande que el array original
        assertEquals(arrayOrig.length + 1,arrayAmpliado.length);

    }

    @Test
    void anyadeNombreTest2NombreNuevoEnUltPos(){
        // WHEN
        final String[] arrayOrig = new String[2];

        arrayOrig[0] = "Jose";
        arrayOrig[1] = "Paco";
        String nombreNuevo = "María";

        // DO
        // Llamada al método que amplía el array original con el nombre nuevo
        String[] arrayAmpliado = AlturaAlumno.añadeNombre(arrayOrig,nombreNuevo);

        // THEN
        // Comprobación de que el último elemento del array ampliado es el nombre nuevo
        assertEquals(nombreNuevo,arrayAmpliado[arrayAmpliado.length - 1]);

    }

    @Test
    void anyadeNombreTest3RestoElemIgualesDelArray(){
        // WHEN
        final String[] arrayOrig = new String[2];

        arrayOrig[0] = "Jose";
        arrayOrig[1] = "Paco";
        String nombreNuevo = "María";

        // DO
        // Llamada al método que amplía el array original con el nombre nuevo
        String[] arrayAmpliado = AlturaAlumno.añadeNombre(arrayOrig,nombreNuevo);

        // THEN
        // Comprobación de que cada elemento del array original es igual a cada elemento
        // del array ampliado (excepto, claro está, el último elemento del array ampliado
        // (que es el que se acaba de añadir nuevo))
        for(int i=0; i<arrayOrig.length;i++){
            assertEquals(arrayOrig[i],arrayAmpliado[i]);
        }

    }

    // Hacemos este test antes que el de ´´anyadeAltura`` porque dicho método
    // tiene dentro este método
    @Test
    void modificaAlturaTest1PosicionDentroDelArrayAlturaModificada(){
        // WHEN
        double[] arrayOrig = {1.6,1.7,1.8};

        // Establecemos una posición que sepamos que está dentro del array
        int posicion = 1;
        double altura = 1.9;

        // DO
        AlturaAlumno.modificaAltura(arrayOrig,posicion,altura);

        // THEN
        // Comprobamos que la altura de la posición introducida es la misma que
        // la altura introducida
        assertEquals(altura, arrayOrig[posicion]);
    }

    // Hacemos este test antes que el de ´´anyadeAltura`` porque dicho método
    // tiene dentro este método
    @Test
    void modificaAlturaTest2PosicionDentroDelArrayRestoElemIntactos(){
        // WHEN
        double[] arrayOrig = {1.6,1.7,1.8};
        // Hacemos una copia del array original
        double[] arrayCopia = Arrays.copyOf(arrayOrig, arrayOrig.length);

        // Establecemos una posición que sepamos que está dentro del array
        int posicion = 1;
        double altura = 1.9;

        // DO
        AlturaAlumno.modificaAltura(arrayOrig,posicion,altura);

        // THEN
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
    void modificaAlturaTest3PosicionFueraDelArray(){
        // WHEN
        double[] arrayOrig = {1.6,1.7,1.8};
        // Hacemos una copia del array original
        double[] arrayCopia = Arrays.copyOf(arrayOrig, arrayOrig.length);

        // Establecemos una posición que sepamos que está fuera del array
        int posicion = arrayOrig.length+2;
        double altura = 1.9;

        // DO
        AlturaAlumno.modificaAltura(arrayOrig,posicion,altura);

        // THEN
        // Comprobamos que el array sigue igual que al principio ya que, como
        // la posición estaba fuera del array, no se ha modificado ningún valor
        assertArrayEquals(arrayOrig, arrayCopia);
    }

    @Test
    void anyadeAlturaTest1TamAmpliadoEn1(){
        // WHEN
        double[] arrayOrig = {5.9,1.47,2.9,32.41};

        // DO
        // Llamamos al método ´´añadeAltura`` y almacenamos su retorno en un nuevo array
        double[] arrayAmpliado = AlturaAlumno.añadeAltura(arrayOrig);

        // THEN
        // Comprobamos que el tamaño del arrayAmpliado es de 1 tamaño más que el
        // array original
        assertEquals(arrayOrig.length + 1,arrayAmpliado.length);

    }

    @Test
    void anyadeAlturaTest2ElemAnyadidoCorrecto(){
        // WHEN
        double[] arrayOrig = {5.9,1.47,2.9,32.41};

        double alturaNuevaEsperada = 1.5;

        // DO
        // Llamamos al método ´´añadeAltura`` y almacenamos su retorno en un nuevo array
        double[] arrayAmpliado = AlturaAlumno.añadeAltura(arrayOrig);

        // THEN
        // Comprobamos que el último elemento del nuevo array es el valor por defecto
        assertEquals(alturaNuevaEsperada,arrayAmpliado[arrayAmpliado.length - 1]);

    }

    @Test
    void anyadeAlturaTest3ArrayOrigIntacto(){
        // WHEN
        double[] arrayOrig = {5.9,1.47,2.9,32.41};
        double[] arrayCopia = Arrays.copyOf(arrayOrig, arrayOrig.length);

        // DO
        // Llamamos al método ´´añadeAltura`` sin almacenar su retorno en un nuevo array
        // ya que ahora mismo no nos hace falta
        AlturaAlumno.añadeAltura(arrayOrig);

        // THEN
        // Comprobamos que el array original sigue intacto
        assertArrayEquals(arrayOrig, arrayCopia);

    }

    @Test
    void buscaNombreTest1Encontrado(){
        // WHEN
        String[] arrayOriginal = {"Sandra","Roberto","María","David"};
        String nomBusc = "Sandra";

        // DO & THEN
        // Comprobación de que el índice obtenido es el correcto
        assertEquals(0,AlturaAlumno.buscaNombre(arrayOriginal,nomBusc));
    }

    @Test
    void buscaNombreTest2NoEncontrado(){
        // WHEN
        String[] arrayOriginal = {"Sandra","Roberto","María","David"};
        String nomBusc = "Pepe";

        // DO & THEN
        // Comprobación de que el índice obtenido es el correcto
        assertEquals(-1,AlturaAlumno.buscaNombre(arrayOriginal,nomBusc));
    }

    @Test
    void buscaNombreTest3ArrayTam0(){
        // WHEN
        String[] arrayOriginal = new String[0];
        String nomBusc = "Andrés";

        // DO & THEN
        // Comprobación de que el índice obtenido es el correcto
        assertEquals(-1,AlturaAlumno.buscaNombre(arrayOriginal,nomBusc));
    }

    @Test
    void buscaNombreTest4NombreVacioONulo(){
        // WHEN
        String[] arrayOriginal = {"Sandra","Roberto","María","David"};
        String nomBusc = "";

        // DO & THEN
        // Comprobación de que el índice obtenido es el correcto
        assertEquals(-1,AlturaAlumno.buscaNombre(arrayOriginal,nomBusc));
        assertEquals(-1,AlturaAlumno.buscaNombre(arrayOriginal,null));
    }

    @Test
    void mostrarTest1FuncCorrecto(){
        // WHEN
        String[] nombres = {"Sandra","Roberto","María","David"};
        double[] alturas = {5.9,1.47,2.9,32.41};

        // DO & THEN
        assertDoesNotThrow(() -> {AlturaAlumno.mostrar(nombres,alturas);});
    }

    @Test
    void mostrarTest2FuncIncorrecto(){
        // WHEN
        String[] nombres = {"Sandra","Roberto","María","David"};
        double[] alturas = {5.9,1.47,2.9};

        // DO & THEN
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {AlturaAlumno.mostrar(nombres,alturas);});
    }

    @Test
    void calculaMaximoTest1ArrayLlenoTam2(){
        // WHEN
        double[] arrayOrigLleno = {5.9,1.47,2.9,32.41};

        // DO
        // Llamada al método ´´calculaMaximo`` y almacenamiento de su retorno
        // en un nuevo array
        double[] arrayObtDelLleno = AlturaAlumno.calculaMaximo(arrayOrigLleno);

        // THEN
        // Comprobación de que el tamaño del array obtenido es 2
        assertEquals(2, arrayObtDelLleno.length);
    }

    @Test
    void calculaMaximoTest2ArrayLlenoValoresCorrectos(){
        // WHEN
        double[] arrayOrigLleno = {5.9,1.47,2.9,32.41};

        // DO
        // Llamada al método ´´calculaMaximo`` y almacenamiento de su retorno
        // en un nuevo array
        double[] arrayObtDelLleno = AlturaAlumno.calculaMaximo(arrayOrigLleno);

        // THEN
        // Comprobación de que los valores del array obtenido son los correctos
        assertEquals(3, arrayObtDelLleno[0]);
        assertEquals(32.41, arrayObtDelLleno[1]);
    }

    @Test
    void calculaMaximoTest3ArrayVacioTam2(){
        // WHEN
        double[] arrayOrigVacio = new double[0];

        // DO
        // Llamada al método ´´calculaMaximo`` y almacenamiento de su retorno
        // en un nuevo array
        double[] arrayObtDelVacio = AlturaAlumno.calculaMaximo(arrayOrigVacio);

        // THEN
        // Comprobación de que el tamaño del array obtenido es 2
        assertEquals(2, arrayObtDelVacio.length);
    }

    @Test
    void calculaMaximoTest4ArrayVacioValoresCorrectos(){
        // WHEN
        double[] arrayOrigVacio = new double[0];

        // DO
        // Llamada al método ´´calculaMaximo`` y almacenamiento de su retorno
        // en un nuevo array
        double[] arrayObtDelVacio = AlturaAlumno.calculaMaximo(arrayOrigVacio);

        // THEN
        // Comprobación de que los valores del array obtenido son los correctos
        for (double v : arrayObtDelVacio) {
            assertEquals(0, v);
        }
    }

    @Test
    void calculaMediaTest1ArrayLLeno(){
        // WHEN
        double[] arrayOrigLleno = {5.9,1.47,2.9,32.41};

        // DO
        // Llamada al método ´´calculaMedia`` y almacenamiento de su retorno
        // en una nueva variable
        double mediaObtDelLleno = AlturaAlumno.calculaMedia(arrayOrigLleno);

        // THEN
        // Comprobación de que los resultados obtenidos son correctos
        assertEquals(((5.9 + 1.47 + 2.9 + 32.41) / 4), mediaObtDelLleno);

    }

    @Test
    void calculaMediaTest1ArrayVacio(){
        // WHEN
        double[] arrayOrigVacio = new double[0];

        // DO
        // Llamada al método ´´calculaMedia`` y almacenamiento de su retorno
        // en una nueva variable
        double mediaObtDelVacio = AlturaAlumno.calculaMedia(arrayOrigVacio);

        // THEN
        // Comprobación de que los resultados obtenidos son correctos
        assertEquals(0, mediaObtDelVacio);

    }

}