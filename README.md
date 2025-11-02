# Pokemon evolution cards game
Welcome! This is a simple pokemon cards memory game made in java 
(and a lil bit of python).  
## Technical design
### folder and file structure
```
PokemonMatchGame/
├── src/
│   └── foo/
│       └── pokemongame/
│           ├── Main.java
│           │
│           ├── model/
│           │   ├── Pokemon.java
│           │   ├── PokemonPair.java
│           │   └── Card.java
│           │
│           ├── logic/
│           │   └── GameEngine.java
│           │
│           ├── ui/
│           │   ├── GameWindow.java
│           │   └── CardButton.java
│           │
│           └── data/
│               └── DataLoader.java
│
├── resources/
│   ├── data/
│   │   └── pokemon_pairs.json
│   └── images/
│       ├── charmander.png
│       ├── charmeleon.png
│       ├── bulbasaur.png
│       ├── ivysaur.png
│       ├── squirtle.png
│       ├── wartortle.png
│       ├── pikachu.png
│       └── raichu.png
│
└── pokeapi.py
```
### Roles
[**x-Emma-x**](https://github.com/x-Emma-x) is responsible of the
`Resources/` folder. The recommended structure of the json file 
`data/pokemon_pairs.json` should be something like this:
```
{
  "evolutionPairs": [
    {
      "stage1": {
        "name": "Charmander",
        "id": 4,
        "imagePath": "images/charmander.png"
      },
      "stage2": {
        "name": "Charmeleon", 
        "id": 5,
        "imagePath": "images/charmeleon.png"
      }
    },
    {
      "stage1": {
        "name": "Bulbasaur",
        "id": 1,
        "imagePath": "images/bulbasaur.png"
      },
      "stage2": {
        "name": "Ivysaur",
        "id": 2,
        "imagePath": "images/ivysaur.png"
      }
    }
  ]
}
```
> [!TIP]
> This is the recommended structure, if u have any diferent modify it and notify others.

---

[**AaronMex-19**](https://github.com/AaronMex-19) will create the classes of the `model/` folder. Theres the UML diagram of every class:

| Pokemon | 
| ------- | 
| -name : String <br> -pokedex : int <br> -imagePath : String|
| +getPokedexId() : int <br> +getName() : String <br> +getImagePath() : String |

| PokemonPair | 
| ----------- | 
| -pairId : int <br> -pokemon1 : Pokemon <br> -pokemon2 : Pokemon <br> |
| +getPairId() : int <br> +getPokemon1() : Pokemon <br> +getPokemon2() : Pokemon |

| Card | 
| ---- | 
| -pairId : int <br> -pokemon : Pokemon <br> -isRevealed : boolean <br> -isMatched : boolean|
| +getPokemon() : Pokemon <br> +getPairId() : int <br> +getIsRevealed() : boolean <br> +getIsMatched() : boolean <br> +hide() : void<br> +reveal() : void <br> +setMatched() : void |

> [!TIP] 
> Don't forget to override the toString() method for every class.

### Troubleshooting
Make sure to have at least java 17 LTS (no problem if u have the latest version) installed in ur machine and configured correctly the path in your IDE (e.g VSCode).

the `src/` folder should be the default source folder. If u present problems on VSCode search on settings:  
> Control + ',' --> "java source paths" --> Add item --> 'src'

if u have another IDE just look up on the internet.

If u have doubts, don't hesitate to adress [**N_sser**](https://github.com/N-sser).