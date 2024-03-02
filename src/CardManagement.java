package src;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @autor Nils Muralles & Víctor Pérez
 * @since 01/03/24
 * @description Clase que maneja el almacenamiento y uso de cartas
 */
public class CardManagement {
    private Map<String, String> cards;
    private Map<String, String> userDeck;
    private Map<String, Integer> cardCount;

    /**
     * Constructor de CardManagement que asigna la implementación de la interfaz Map que se utilizará 
     * @param userDeck Map que contiene las cartas del usuario
     * @param cardCount Map que lleva la cuenta de una carta del usuario
     * @param cards Map que contiene todas las cartas de cards_desc.txt
     */
    public CardManagement(Map<String, String> userDeck, Map<String, Integer> cardCount, Map<String, String> cards) {
        this.userDeck = userDeck;
        this.cardCount = cardCount;
        this.cards = cards;
    }

    /**
     * Método que añade una carta al mazo del usuario
     * @param cardName Carta que el usuario desea agregar
     */
    public void addCard(String cardName) {
        boolean cardFound = false;
        for (String card : cards.keySet()) {
            if (card.equals(cardName)) {
                userDeck.put(cardName, cards.get(card));
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
    
    /**
     * Devuelve el tipo de una carta
     * @param cardName Nombre de la carta
     * @return Tipo de la carta
     */
    public String getCardType(String cardName) {
        return cards.get(cardName);
    }
    
    /**
     * Formatea la colección del usuario en una String
     * @return String con el mazo del usuario
     */
    public String showUserDeck() {
        String deck = "";

        for (String card : this.userDeck.keySet()) {
            deck += card + " | " + cards.get(card) + " | " + "Cantidad: " + cardCount.get(card) + "\n";
        }

        return deck;
    }

    /**
     * Formatea todas las cartas disponibles en una String
     * @return String con todas las cartas disponibles
     */
    public String showAllCards() {
        String allCards = "";

        for (String card : this.cards.keySet()) {
            allCards += card + " | " + cards.get(card) + "\n";
        }

        return allCards;
    }

    /**
     * Devuelve las entredas clave-valor ordenadas de una implementación de la interfaz Map
     * @param <K> Clave
     * @param <V> Valor
     * @param map Mapa del que se desean obtener las entradas
     * @return Entradas ordenadas
     */
    public <K extends Comparable<K>, V extends Comparable<V>> List<Map.Entry<K,V>> sortByType(Map<K,V> map) {
        List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<K,V>>() {
            @Override
            public int compare(Entry<K, V> o1, Entry<K, V> o2) {
                return o1.getValue().toString().compareToIgnoreCase(o2.getValue().toString());
            }
        });

        return entries;
    }

    /**
     * Formatea las cartas del usuario ordenadas por tipo en un String
     * @return Cartas del usuario ordenadas
     */
    public String showSortedUserDeck() {
        String sortedCards = "";
        List<Map.Entry<String,String>> SortedEntries = sortByType(userDeck);

        for (Entry<String,String> entry : SortedEntries) {
            sortedCards += entry.getKey() + " | " + cards.get(entry.getKey()) + " | " + "Cantidad: " + cardCount.get(entry.getKey()) + "\n";
        }

        return sortedCards;
    }

    /**
     * Formatea todas las cartas ordenadas por tipo en un String
     * @return Cartas ordenadas
     */
    public String showAllSortedCards() {
        String sortedCards = "";
        List<Map.Entry<String,String>> SortedEntries = sortByType(cards);

        for (Entry<String,String> entry : SortedEntries) {
            sortedCards += entry.getKey() + " | " + cards.get(entry.getKey()) + "\n";
        }

        return sortedCards;
    }
        
}
