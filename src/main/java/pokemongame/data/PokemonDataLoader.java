package pokemongame.data;

import pokemongame.model.*;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class PokemonDataLoader {
    public List<PokemonPair> loadPokemonPairs() throws IOException {
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