package src;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map;

/**
 * @author Nils Muralles & Víctor Pérerz
 * @since 28/02/24
 * @description Clase main del programa
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");
        System.out.print("Seleccione la implementación de Map a utilizar: ");

        try {
            int mapOption = sc.nextInt();
            sc.nextLine();

            Map<String, String> userDeck = MapFactory.createMap(mapOption);
        
        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Opción inválida");
        }

        sc.close();
    }
}
