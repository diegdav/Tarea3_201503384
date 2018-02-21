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
public class ContadorDigitos {

    Scanner teclado = new Scanner(System.in);
    private int opcion, numero, contador;

    public void menu() {
        do {
            try {
                System.out.println("\nIngrese a una opcion (1-3): \n1. Ingresar numero \n2. Mostrar numero de digitos \n3. Menu principal");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        ingresarNumero();
                        break;
                    case 2:
                        mostrarDigitos();
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

    public void ingresarNumero() {
        //cada vez que el usuario ingrese un numero menor que 0 o mayor que 100000 le volvera a pedir
        //el valor
        do {
            System.out.print("\nIngrese un numero entre 0 y 100000: ");
            numero = teclado.nextInt();
            if (numero < 0 || numero > 100000){
                System.out.println("Error, rango invalido. Intentelo de nuevo.");
            }
        } while(numero < 0 || numero > 100000);
        contarDigitos(numero);          //el numero ingresado se manda como parametro al metodo
        menu();
    }

    public void mostrarDigitos() {
        System.out.println("\nEl numero " + this.numero + " tiene " + contador + " digitos.");
        menu();
    }

    //el metodo recibe como parametro un valor numerico
    public void contarDigitos(int numero) {
        while (numero > 0) {
            numero = numero / 10;   //se divide entre 10 el numero ingresado y luego este ocupa su lugar
            contador++;             //cada vez que se divida entre 10 se aumenta en 1 el contador, el cual
                                    //indica los digitos que tiene el numero ingresado
        }
    }
}
