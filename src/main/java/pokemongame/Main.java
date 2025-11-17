package pokemongame;

import pokemongame.model.*;
import pokemongame.data.*;
import pokemongame.logic.*;
import pokemongame.ui.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
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

        // Hardcoded
        List<PokemonPair> hardPairs = List.of(
            new PokemonPair(0, 
                new Pokemon("Charmander", 4, "images/charmander.png"),
                new Pokemon("Charmeleon", 5, "images/charmeleon.png")),
            new PokemonPair(1,
                new Pokemon("Bulbasaur", 1, "images/bulbasaur.png"),
                new Pokemon("Ivysaur", 2, "images/ivysaur.png")),
            new PokemonPair(2,
                new Pokemon("Squirtle", 7, "images/squirtle.png"),
                new Pokemon("Wartortle", 8, "images/wartortle.png")),
            new PokemonPair(3,
                new Pokemon("Pikachu", 25, "images/pikachu.png"),
                new Pokemon("Raichu", 26, "images/raichu.png"))
        );

        // Testing the game engine to work hardcoded
        //GameEngine engineHard = new GameEngine(hardPairs);
        //
        //var res = engineHard.getCards();
        //var res1 = engineHard.getMatchesFound();

        //System.out.println(res);
        //System.out.println(res1);
    }
}
