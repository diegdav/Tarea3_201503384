/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipc1.tarea3_201503384;

import java.util.InputMismatchException;
import java.util.Scanner;
import static javafx.application.Platform.exit;

public class Menu {

    Scanner teclado = new Scanner(System.in);
    Usuario usuario;
    ContadorDigitos contadorDigitos;
    MayorMenor mayormenor;
    Promedio promedio;
    private int opcion;

    public Menu() {
        usuario = new Usuario();
        contadorDigitos = new ContadorDigitos();
        mayormenor = new MayorMenor();
        promedio = new Promedio();
    }

    public void principal() {
        opcion = 0;
        do {
            try {
                System.out.println("Ingrese a una opcion (1-5): \n1. Usuarios \n2. Contador de digitos \n3. Tres numeros de mayor a menor "
                        + "\n4. Calcular promedio \n5. Salir");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        usuario.menu();
                        break;
                    case 2:
                        contadorDigitos.menu();
                        break;
                    case 3:
                        mayormenor.menu();
                        break;
                    case 4:
                        promedio.menu();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opcion incorrecta. Intente de nuevo.\n");
                        principal();
                }
            } catch (InputMismatchException e){
                System.out.println("");
                teclado.nextLine();
            }
        } while (opcion < 1 || opcion > 5);
    }
}
