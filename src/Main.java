package src;

import java.util.HashMap;

/**
 * @author Nils Muralles & Víctor Pérerz
 * @since 28/02/24
 * @description Clase main del programa
 */

public class Main {
    public static void main(String[] args) {
        Reader reader = new Reader();
        CardManagement cardManagement = new CardManagement(new HashMap<String, String>(), new HashMap<String, Integer>(), reader.readCards(new HashMap<String, String>()));

        System.out.println(cardManagement.getCardType("A Rival Appears!"));
    }
}
