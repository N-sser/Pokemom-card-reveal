package pokemongame.model;

public class Card {
    private final int pairId;
    private final Pokemon pokemon;
    private boolean isRevealed;
    private boolean isMatched;

    public Card(int pairId, Pokemon pokemon) {
        this.pairId = pairId;
        this.pokemon = pokemon;
        this.isRevealed = false;
        this.isMatched = false;
    }

    // Getters
    public Pokemon getPokemon() { return pokemon; }
    public int getPairId() { return pairId; }
    public boolean IsRevealed() { return isRevealed; }
    public boolean IsMatched() { return isMatched; }

    // Setters
    public void hide() { this.isRevealed = false; }
    public void reveal() { this.isRevealed = true; }
    public void setMatched(boolean m) { this.isMatched = m; }
}