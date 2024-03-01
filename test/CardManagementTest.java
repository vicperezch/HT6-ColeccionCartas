package test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import src.CardManagement;
import src.Reader;

public class CardManagementTest {
    
    @Test
    public void testAddingOneCard() {
        Reader reader = new Reader();
        HashMap<String, String> deck = new HashMap<String, String>();
        HashMap<String, Integer> cardCount = new HashMap<String, Integer>();
        Map<String, String> cards = reader.readCards(new HashMap<String, String>());
        CardManagement cardManagement = new CardManagement(deck, cardCount, cards);
        String newCard = "Achacha Archer";
        cardManagement.addCard(newCard);

        assertEquals(1, (int) cardCount.get(newCard));
        assertEquals("Monstruo", (String) deck.get(newCard));
    }
}
