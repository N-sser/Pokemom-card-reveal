package pokemongame;

import pokemongame.model.*;
import pokemongame.data.*;
import pokemongame.logic.*;
import pokemongame.ui.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to another Pokemon Evolution Cards Game!");

        PokemonDataLoader jsonPairs = new PokemonDataLoader();
        List<PokemonPair> pairs = jsonPairs.loadPokemonPairs();
        
        GameEngine engine = new GameEngine(pairs);

        javax.swing.SwingUtilities.invokeLater(() -> {
            GameWindow window = new GameWindow(engine); // Pass engine to UI
            window.show();
        });
        
        System.out.println("Game has started. Enjoy!");
    }
}