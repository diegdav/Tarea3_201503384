/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.tarea3_201503384;

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
        do {
            System.out.println("\n1. Ingresar numeros \n2. Mostrar ordenados \n3. Menu principal");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    ingresarNumeros();
                    break;
                case 2:
                    mostrarOrdenados();
                    break;
                case 3:
                    System.out.println("");
                    Menu menuPrincipal = new Menu();
                    menuPrincipal.principal();
                    break;
                default:
                    System.out.println("Opcion incorrecta. Intente de nuevo.\n");
            }
        } while (opcion < 1 || opcion > 3);
    }

    public void ingresarNumeros() {
        System.out.print("Ingrese el primer numero: ");
        numeros[0] = teclado.nextInt();
        System.out.print("Ingrese el segundo numero: ");
        numeros[1] = teclado.nextInt();
        System.out.print("Ingrese el tercer numero: ");
        numeros[2] = teclado.nextInt();

        ordenarNumeros(numeros[0], numeros[1], numeros[2]);
        menu();
    }

    public void ordenarNumeros(int numero1, int numero2, int numero3) {
        int i, j, aux;

        for (i = 0; i < numeros.length - 1; i++) {
            for (j = 0; j < numeros.length - i - 1; j++) {
                if (numeros[j + 1] < numeros[j]) {
                    aux = numeros[j + 1];
                    numeros[j + 1] = numeros[j];
                    numeros[j] = aux;
                }
            }
        }
        mostrarOrdenados();
    }

    public void mostrarOrdenados() {
        for(Integer mostrar: numeros){
            System.out.println(mostrar);
        }
        menu();
    }
}
