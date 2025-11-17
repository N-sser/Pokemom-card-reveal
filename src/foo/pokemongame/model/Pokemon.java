package foo.pokemongame.model;

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
