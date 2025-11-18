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
    
    public void revealCard(int index){
        Card card = cards.get(index);

        if (card.IsMatched() || card.IsRevealed()) {
            return;
        }

        if (firstRevealed == null) {
            firstRevealed = card;
            card.reveal();
        } else if (secondRevealed == null && card != firstRevealed) { 
            secondRevealed = card;
            card.reveal();
        }
    }
    
    public boolean canCheckMatch() {
        if (firstRevealed != null && secondRevealed != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkMatch() {
        int first = firstRevealed.getPairId();
        int second = secondRevealed.getPairId();
        
        if (first == second) {
            matchesFound++;
            firstRevealed.setMatched(true);
            secondRevealed.setMatched(true);
            // Reset cards state for next check in the engine
            firstRevealed = null; 
            secondRevealed = null; 
            return true;
        } else {
            return false;
        }
    }
    
    public void hideUnmatched() {
        if (firstRevealed != null) {
            firstRevealed.hide();
            firstRevealed = null;
        } 
        if (secondRevealed != null) {
            secondRevealed.hide();
            secondRevealed = null;
        }
    }

    public boolean isGameWon() {
        return matchesFound == 4; // Its hardcoded
    }

    // Getters
    public List<Card> getCards() { return cards; }
    public int getMatchesFound() { return matchesFound; }

}