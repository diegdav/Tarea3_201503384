/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.tarea3_201503384;

import java.util.Scanner;
import static javafx.application.Platform.exit;

public class Menu {

    Scanner teclado = new Scanner(System.in);
    int opcion;

    public Menu() {
    }

    public void principal() {
        do {
            System.out.println("1. Usuarios \n2. Contador de digitos \n3. Tres numeros de mayor a menor "
                    + "\n4. Calcular promedio \n5. Salir");
            opcion = teclado.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Opcion 1");
                    break;
                case 2:
                    System.out.println("Opcion 2");
                    break;
                case 3:
                    System.out.println("Opcion 3");
                    break;
                case 4:
                    System.out.println("Opcion 4");
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
                    principal();
            }
        } while (opcion < 1 || opcion > 5);
    }
}