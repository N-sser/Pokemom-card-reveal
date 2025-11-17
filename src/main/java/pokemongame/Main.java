package pokemongame;

import pokemongame.model.*;
import pokemongame.data.*;
import pokemongame.logic.*;
import pokemongame.ui.*;
import java.util.List;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to another Pokemon Evolution Cards Game!");
        // Using the librarie Gson or jackson
        System.out.println("🐛 Debug: Starting Pokemon Game...");
        
        // Simple Gson test
        Gson gson = new Gson();
        String testJson = "{\"name\":\"Pikachu\",\"type\":\"Electric\"}";
        System.out.println("Gson test: " + gson.fromJson(testJson, Object.class));
        
        System.out.println("✅ Everything works! Ready to code!");
        // Hardcoded
        List<PokemonPair> pairs = List.of(
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
        GameEngine engineHard = new GameEngine(pairs);
        
        var res = engineHard.getCards();
        var res1 = engineHard.getMatchesFound();
        System.out.println(res);
        System.out.println(res1);
        System.out.println("Working directory: " + System.getProperty("user.dir"));
    }
}
