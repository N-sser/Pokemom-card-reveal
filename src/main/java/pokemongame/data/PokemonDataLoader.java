package pokemongame.data;

import pokemongame.model.*;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

import com.google.gson.Gson;

public class PokemonDataLoader {
    public List<PokemonPair> loadPokemonPairs() {
        try {
            // Creating gson instance to read the JSON
            Gson gson = new Gson();

            // Read the JSON file
            FileReader reader = new FileReader("src/main/resources/data/pokemon_pairs.json");

            // Parse the JSON into a simple object structure
            PokemonData data = gson.fromJson(reader, PokemonData.class);
                
            reader.close();
            
            // Convert the JSON data to PokemonPairs objects
            List<PokemonPair> pairs = new ArrayList<>();
            
            for (int i = 0; i < data.evolutionPairs.length; i++) {
                SinglePair jsonPair = data.evolutionPairs[i];

                // Create Pokemons from JSON data
                Pokemon stage1 = new Pokemon(
                        jsonPair.stage1.name,
                        jsonPair.stage1.id,
                        jsonPair.stage1.imagePath
                        );

                Pokemon stage2 = new Pokemon(
                        jsonPair.stage2.name,
                        jsonPair.stage2.id,
                        jsonPair.stage2.imagePath
                        );

                // Creater pair first then add it
                PokemonPair pair = new PokemonPair(i, stage1,stage2);
                pairs.add(pair);
            }
            
            return pairs;

        } catch(Exception e) {
            System.out.println("ERROR: " + e + "");
            return LoadHardcodedData();
        }
    }

    public List<PokemonPair> LoadHardcodedData() {
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
        return hardPairs;        
    }
    // Static classes to help with the structure of the JSON
    static class PokemonData {
        SinglePair[] evolutionPairs;
    }
    
    static class SinglePair {
        PokemonDataItem stage1;
        PokemonDataItem stage2;
    }
    
    static class PokemonDataItem {
        String name;
        int id;
        String imagePath;
    }
}