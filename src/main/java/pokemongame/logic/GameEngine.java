package pokemongame.logic;

import pokemongame.model.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GameEngine {
    private List<Card> cards;              // All 8 cards
    private Card firstRevealed;            // First card clicked
    private Card secondRevealed;           // Second card clicked  
    private int matchesFound;              // How many pairs matched (0-4)   
    
    public GameEngine(List<PokemonPair> pairs) {
        this.cards = new ArrayList<>();
        this.matchesFound = 0;
        this.firstRevealed = null;
        this.secondRevealed = null;
        
        for (PokemonPair pair : pairs) {
            cards.add(new Card(pair.getPairId() ,pair.getPokemon1()));
            cards.add(new Card(pair.getPairId() ,pair.getPokemon2()));
        }
        
        Collections.shuffle(cards);
    }
    
    // Getters
    public List<Card> getCards() { return cards; }
    public int getMatchesFound() { return matchesFound; }

}