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
        Reader reader = new Reader();
        boolean menu = true;

        while (menu) {
            System.out.println("\n---BIENVENIDO---");
            System.out.println("1. HashMap");
            System.out.println("2. TreeMap");
            System.out.println("3. LinkedHashMap");
            System.out.println("4. Sallir");
            System.out.print("Seleccione la implementación de Map a utilizar: ");

            try {
                int mapOption = sc.nextInt();
                sc.nextLine();

                if (mapOption >= 1 && mapOption <= 3) {
                    boolean actionMenu = true;
                    Map<String, String> userDeck = MapFactory.createMap(mapOption);
                    Map<String, String> cards = reader.readCards(MapFactory.createMap(mapOption));
                    Map<String, Integer> cardCount = MapFactory.createMap(mapOption);
                    CardManagement cardManagement = new CardManagement(userDeck, cardCount, cards);

                    while (actionMenu) {
                        System.out.println("\n---MANEJO DE CARTAS---");
                        System.out.println("1. Agregar una carta");
                        System.out.println("2. Ver tipo de una carta");
                        System.out.println("3. Ver mi colección");
                        System.out.println("4. Ver mi colección (ordenada por tipo)");
                        System.out.println("5. Ver cartas existentes");
                        System.out.println("6. Ver cartas existentes (ordenadas por tipo)");
                        System.out.println("7. Salir");
                        System.out.print("¿Qué desea hacer? ");
                        String menuOption = sc.nextLine();

                        switch (menuOption) {
                            case "1":
                                System.out.print("\nCarta que desea agregar: ");
                                String newCard = sc.nextLine();
                                cardManagement.addCard(newCard);
                                break;
                        
                            case "2":
                                System.out.print("\n¿Qué carta desea consultar? ");
                                String card = sc.nextLine();
                                System.out.println(card + " es de tipo: " + cardManagement.getCardType(card));
                                break;

                            case "3":
                                if (!cardManagement.showUserDeck().equals("")) {
                                    System.out.println(cardManagement.showUserDeck());
                                } else {
                                    System.out.println("¡Tu colección está vacía!");
                                }
                                break;

                            case "4":
                                if (!cardManagement.showUserDeck().equals("")) {
                                    System.out.println(cardManagement.showSortedUserDeck());
                                } else {
                                    System.out.println("¡Tu colección está vacía!");
                                }
                                break;

                            case "5":
                                System.out.println(cardManagement.showAllCards());
                                break;

                            case "6":
                                System.out.println(cardManagement.showAllSortedCards());
                                break;

                            case "7":
                                actionMenu = false;
                                break;

                            default:    
                                System.out.println("\nSeleccione una opción del menú");
                                break;
                            }
                    }
                    
                } else if (mapOption == 4) {
                    menu = false;
                
                } else {
                    System.out.println("\nSeleccione una opción válida");
                }
               
            
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("\nDebe seleccionar un número");
            }

        }
        
        sc.close();
    }
}
