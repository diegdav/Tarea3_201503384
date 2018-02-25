/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.tarea3_201503384;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class MayorMenor {

    Scanner teclado = new Scanner(System.in);

    private int opcion;
    private final int[] numeros;

    public MayorMenor() {
        numeros = new int[3];
    }

    public void menu() {
        opcion = 0;
        do {
            try {
                System.out.println("\nIngrese a una opcion (1-3): \n1. Ingresar numeros \n2. Mostrar ordenados \n3. Menu principal");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        ingresarNumeros();
                        break;
                    case 2:
                        int i;
                        for (i = 0; i <numeros.length; i++){
                            if (numeros[i] == 0) {
                                System.out.println("\nDebe de ingresar de primero los numeros");
                                menu();
                            } else {
                                mostrarOrdenados();
                            }
                        }
                        break;
                    case 3:
                        System.out.println("");
                        Menu menuPrincipal = new Menu();
                        menuPrincipal.principal();
                        break;
                    default:
                        System.out.println("Opcion incorrecta. Intente de nuevo.\n");
                }
            } catch (InputMismatchException e) {
                teclado.nextLine();
            }
        } while (opcion < 1 || opcion > 3);
    }

    public void ingresarNumeros() {
        System.out.print("\nIngrese el primer numero: ");
        numeros[0] = teclado.nextInt();
        System.out.print("Ingrese el segundo numero: ");
        numeros[1] = teclado.nextInt();
        System.out.print("Ingrese el tercer numero: ");
        numeros[2] = teclado.nextInt();

        ordenarNumeros(numeros[0], numeros[1], numeros[2]);                     //se mandan como parametro los valores ingresados
        menu();
    }

    public void ordenarNumeros(int numero1, int numero2, int numero3) {         //solicita tres valores enteros para poder usar el metodo
        int i, j, aux;

        for (i = 0; i < numeros.length - 1; i++) {                              //se recorre el for hasta el tamaño del array - 1 
            for (j = 0; j < numeros.length - i - 1; j++) {                      //se recorre el for hasta el tamaño del array -i-1 para que no exceda el tamaño
                if (numeros[j + 1] > numeros[j]) {                              //del array. Si el numero en la posicion j+1 es mayor al de la posicion j
                    aux = numeros[j + 1];                                       //entonces se guarda en una variable auxiliar, esto para que no se borre ya que
                    numeros[j + 1] = numeros[j];                                //el valor de j+1 sera sustituido por el valor de j, y luego el valor de j es
                    numeros[j] = aux;                                           //sustituido por el valor de la variable auxiliar, es decir, del anterior j+1
                }                                                               
            }
        }
    }

    public void mostrarOrdenados() {
        System.out.println("\nLos numeros ordenados de mayor a menor son: ");
        for (Integer mostrar : numeros) {                                       //Se utiliza el for each para que pueda recorrer el arreglo ya ordenado
            System.out.println(mostrar);                                        //y luego se imprima. Para formarlo se pone el tipo de arreglo y el nombre que se
        }                                                                       //quiera poner los valores del arreglo y luego se coloca el nombre del arreglo
        menu();
    }
}
