public class Pokemon {
    private String name;
    private int pokedex;
    private String imagePath;

    public Pokemon(String name, int pokedex, String imagePath) {
        this.name = name;
        this.pokedex = pokedex;
        this.imagePath = imagePath;
    }

    public int getPokedexId() {
        return pokedex;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }
}

// ---------------------------------------------------------

class PokemonPair {
    private int pairId;
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    public PokemonPair(int pairId, Pokemon pokemon1, Pokemon pokemon2) {
        this.pairId = pairId;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public int getPairId() {
        return pairId;
    }

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }
}

// ---------------------------------------------------------

class Card {
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