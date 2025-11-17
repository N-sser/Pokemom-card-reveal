package pokemongame.data;

import pokemongame.model.*;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;

import com.google.gson.Gson;

public class PokemonDataLoader {
    public static List<PokemonPair> loadPokemonPairs() throws IOException {
        // Instead of FileReader("resources/data/pokemon_pairs.json")
        // Use:
        InputStream stream = PokemonDataLoader.class.getResourceAsStream("/data/pokemon_pairs.json");

        // Read the filel
        Gson gson = new Gson();

        return null;
    }

    private static class JsonWrapper {
       List<JsonPair> evolutionPairs;
   }
   
   private static class JsonPair {
       JsonPokemon stage1;
       JsonPokemon stage2;
   }
   
   private static class JsonPokemon {
       String name;
       int id;
       String imagePath;
   }
}