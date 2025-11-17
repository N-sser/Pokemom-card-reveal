package pokemongame;

import pokemongame.model.*;
import pokemongame.data.*;
import pokemongame.logic.*;
import pokemongame.ui.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to another Pokemon Evolution Cards Game!");

        // Using the librarie Gson or jackson
        PokemonDataLoader jsonPairs = new PokemonDataLoader();
        List<PokemonPair> pairs = jsonPairs.loadPokemonPairs();
        
        GameEngine engine = new GameEngine(pairs);

        var ress = engine.getCards();
        var ress1 = engine.getMatchesFound();
        
        System.out.println(ress);
        System.out.println(ress1);
        for (PokemonPair pair : pairs) {
            System.out.println("Loaded: " + pair.getPokemon1().getName() + 
                             " → " + pair.getPokemon2().getName());
        }
    }
}
