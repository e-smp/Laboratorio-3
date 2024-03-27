package com.mycompany.lab_3;

//Emilio San Martin Pezoa

import java.util.Scanner;
import java.util.Random;

public class Lab_3 {
    
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        int opcion;
        int[] uno = null; //Declaramos las variables fuera del switch para que no de error.
        int[] dos = null;
        
        //Esto representa un bucle "do-while", que se ejecuta al menos una vez cuando la variable "opcion" sea distinta a 7.
        do {
            System.out.println("********************* menú *********************");
            System.out.println("1. Generar array 1 con números aleatorios");
            System.out.println("2. Generar array dos con números ingresados por el usuario");
            System.out.println("3. Generar array 'producto'");
            System.out.println("4. Generar array 'resta'");
            System.out.println("5. Generar array 'par-impar'");
            System.out.println("6. Generar matriz");
            System.out.println("7. Salir");
            opcion = leer.nextInt();
            
            //Se utiliza para elegir una acción según la opción ingresada por el usuario.
            switch (opcion){
                case 1:
                    uno = Array_uno(10, 1, 20);
                    System.out.println("Array 1 generado: ");
                    imprimir_array(uno);
                    break;//Detiene el bucle
                
                case 2:
                    dos = Array_dos(10, 5, 10);
                    System.out.println("Array 2 generado: ");
                    imprimir_array(dos);
                    break;
                case 3:
                    if (uno == null || dos == null){
                        System.out.println("error: Verifica que se hayan generado los arrays 1 y 2.");
                        break;
                    }
                    int[] producto = Array_producto(uno,dos);
                    System.out.println(producto);
                    break;
                case 4:
                    if (uno == null || dos == null){
                        System.out.println("error: Verifica que se hayan generado los arrays 1 y 2.");
                        break;
                    }
                    int[] resta = Array_resta(uno, dos);
                    System.out.println("Array resta generado con éxito: ");
                    imprimir_array(resta);
                    break;
                case 5:
                    if (uno == null || dos == null) {
                        System.out.println("error: Verifica que se hayan generado los arrays 1 y 2.");
                        break;
                    }
                    int[] parimpar = Array_parImpar(uno, dos);
                    System.out.println("Array par-impar generado con éxito: ");
                    imprimir_array(parimpar);
                    break;
                case 6:
                    if (uno == null || dos == null) {
                        System.out.println("error: Verifica que se hayan generado los arrays 1 y 2.");
                        break;
                    }
                    int[][] matriz = generarMatriz(uno, dos);
                    System.out.println("Matriz generada: ");
                    imprimirMatriz(matriz);
                    break;
                case 7:
                    System.out.println("Saliendo del programa, nos vemos!!");
                    break;
                default:
                    System.out.println("Opción erronea. Por favor, ingrese una opción válida.");
            }
        } while(opcion != 7);
        leer.close();
    //este método recibe tres parámetros: la longitud del array a generar (longitud, el valor mínimo (min) y 
    // el valor máximo (max) y utiliza un objeto Random para generar números aleatorios y llenar la array "1".
    }
    private static int[] Array_uno(int longitud, int min, int max) {
        Random rand = new Random();
        int[] array = new int[longitud];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(max - min + 1) + min;
        }
        return array;
    }
    //este método solicita 10 números al usuario, los cuales deben ser mayores que 5 y menores que 10.
    private static int[] Array_dos(int longitud, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[longitud];
        for (int i = 0; i < array.length; i++) {
            int num;
            do {
                System.out.printf("Ingrese el número %d (mayor que %d y menor que %d): ", i + 1, min, max);
                num = scanner.nextInt();
            } while (num <= min || num >= max);
            array[i] = num;
        }
        return array;
    }
    //este método recibe dos arrays como sus parámetros y da como salida un nuevo array que contiene el producto de los elementos del array 1 y dos. 
    private static int[] Array_producto(int[] array1, int[] array2) {
        int[] producto = new int[array1.length];
        for (int i = 0; i < producto.length; i++) {
            producto[i] = array1[i] * array2[i];
        }
        return producto;
    }
    //este método hace un nuevo array, el cual contiene el resultado de la resta de los elementes del array 1 y 2.
    private static int[] Array_resta(int[] array1, int[] array2) {
        int[] resta = new int[array1.length];
        for (int i = 0; i < resta.length; i++) {
            resta[i] = array1[i] - array2[i];
        }
        return resta;
    }
    //este método hace un nuevo array que devuelve un 1 si la suma de los elementos del array 
    //uno y dos es par, y 0 si es impar.
    private static int[] Array_parImpar(int[] array1, int[] array2) {
        int[] parimpar = new int[array1.length];
        for (int i = 0; i < parimpar.length; i++) {
            int suma = array1[i] + array2[i];
            parimpar[i] = suma % 2 == 0 ? 1 : 0;
        }
        return parimpar;
    }
    //este método crea una matriz con todos los elementos de las cinco array generadas anteriormente.
    private static int[][] generarMatriz(int[] uno, int[] dos) {
        int[][] matriz = new int[5][10];
        matriz[0] = uno;
        matriz[1] = dos;
        matriz[2] = Array_producto(uno, dos);
        matriz[3] = Array_resta(uno, dos);
        matriz[4] = Array_parImpar(uno, dos);
        return matriz;
    }
    //este método recibe un array como parámetro y lo imprime en la consola.
    private static void imprimir_array(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    //este método recibe una matriz 2D como parámetro para luego imprimirla en la consola, con cada elemento separado por tabulaciones.
    private static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int num : fila) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}