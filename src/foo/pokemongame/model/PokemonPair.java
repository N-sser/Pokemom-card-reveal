package foo.pokemongame.model;

public class PokemonPair {
    private final int pairId;
    private final Pokemon pokemon1;
    private final Pokemon pokemon2;

    public PokemonPair(int pairId, Pokemon pokemon1, Pokemon pokemon2) {
        this.pairId = pairId;
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    // Getters
    public int getPairId() { return pairId; }
    public Pokemon getPokemon1() { return pokemon1; }
    public Pokemon getPokemon2() { return pokemon2; }

    @Override
    public String toString() {
        return "PokemonPair{\n\tPokemon1:" + pokemon1 + ",\n\tPokemon2:" + pokemon2 + "\n}";
    }
}