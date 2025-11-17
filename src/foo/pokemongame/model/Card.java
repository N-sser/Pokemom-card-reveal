package foo.pokemongame.model;

public class Card {
    private int pairId;
    private Pokemon pokemon;
    private boolean isRevealed;
    private boolean isMatched;

    public Card(int pairId, Pokemon pokemon) {
        this.pairId = pairId;
        this.pokemon = pokemon;
        this.isRevealed = false;
        this.isMatched = false;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public int getPairId() {
        return pairId;
    }

    public boolean getIsRevealed() {
        return isRevealed;
    }

    public boolean getIsMatched() {
        return isMatched;
    }

    public void hide() {
        this.isRevealed = false;
    }

    public void reveal() {
        this.isRevealed = true;
    }

    public void setMatched() {
        this.isMatched = true;
    }
}