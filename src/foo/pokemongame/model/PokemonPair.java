package foo.pokemongame.model;

public class PokemonPair {
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
