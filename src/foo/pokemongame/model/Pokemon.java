package foo.pokemongame.model;

public class Pokemon {
    private final String name;
    private final int pokedex;
    private final String imagePath;

    public Pokemon(String name, int pokedex, String imagePath) {
        this.name = name;
        this.pokedex = pokedex;
        this.imagePath = imagePath;
    }

    // Getter methods
    public String getName() { return name; }
    public int getPokedexId() { return pokedex; }
    public String getImagePath() { return imagePath; }

    @Override
    public String toString() {
        return "Pokemon[Name=" + name + ", pokedexId=" + pokedex + ",imagepath=" + imagePath + "]";
    }
}