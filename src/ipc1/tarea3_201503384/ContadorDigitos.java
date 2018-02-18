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
public class ContadorDigitos {

    Scanner teclado = new Scanner(System.in);
    private int opcion, numero;

    public void menu() {
        do {
            System.out.println("\n1. Ingresar numero \n2. Mostrar numero de digitos \n3. Menu principal");
            opcion = teclado.nextInt();
            
            switch(opcion){
                case 1:
                    ingresarNumero();
                    break;
                case 2:
                    mostrarDigitos(numero);
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
    
    public void ingresarNumero(){
        System.out.println("\nIngrese un numero");
        numero = teclado.nextInt();
        menu();
    }
    
    public void mostrarDigitos(int numero){
        int contador = 0;
        while(numero > 0){
            numero = numero / 10;
            contador++;
        }
        System.out.println("\nEl numero " + this.numero + " tiene " + contador + " digitos.");
        menu();
    }
}