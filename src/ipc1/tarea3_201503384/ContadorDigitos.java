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
        do {
            System.out.print("\nIngrese un numero entre 0 y 100000: ");
            numero = teclado.nextInt();
            if (numero < 0 || numero > 100000){
                System.out.println("Error, rango invalido. Intentelo de nuevo.");
            }
        } while(numero < 0 || numero > 100000);
        contarDigitos(numero);
        menu();
    }

    public void mostrarDigitos() {
        System.out.println("\nEl numero " + this.numero + " tiene " + contador + " digitos.");
        menu();
    }

    public void contarDigitos(int numero) {
        while (numero > 0) {
            numero = numero / 10;
            contador++;
        }
    }
}
