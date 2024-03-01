package src;

import java.util.Map;
import src.Reader;

/**
 * @autor Nils Muralles & Víctor Pérez
 * @since 01/03/24
 * @description Clase que maneja el almacenamiento y uso de cartas
 */
public class CardManagement {
    private Map<String, String> cards;
    private Map<String, String> deck;
    private Map<String, Integer> cardCount;
    private Reader reader;

    /**
     * Constructor de CardManagement que asigna la implementación de la interfaz Map que se utilizará 
     * @param deck Map que contiene las cartas del usuario
     * @param cardCount Map que lleva la cuenta de una carta del usuario
     * @param cards Map que contiene todas las cartas de cards_desc.txt
     */
    public CardManagement(Map<String, String> deck, Map<String, Integer> cardCount, Map<String, String> cards) {
        this.deck = deck;
        this.cardCount = cardCount;
        this.reader = new Reader();
        this.cards = reader.readCards(cards);
    }

    /**
     * Método que añade una carta al mazo del usuario
     * @param cardName Carta que el usuario desea agregar
     */
    public void addCard(String cardName) {
        boolean cardFound = false;
        for (String card : cards.keySet()) {
            if (card.equals(cardName)) {
                deck.put(cardName, cards.get(card));
                cardFound = true;
            }
        }

        if (cardFound) {
            boolean cardAlreadyInDeck = false;
            for (String card : cardCount.keySet()) {
                if (card.equals(cardName)) {
                    int count = cardCount.get(cardName);
                    count++;
                    cardCount.put(cardName, count);
                    cardAlreadyInDeck = true;
                } 
            }

            if (!cardAlreadyInDeck) {
                cardCount.put(cardName, 1);
            }

            System.out.println(cardName + " agregada exitosamente");

        } else {
            System.out.println("Carta no encontrada");
        }
    }
    
    
}
