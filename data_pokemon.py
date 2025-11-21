import json
import os

base_path = os.path.dirname(os.path.abspath(__file__))


resources_path = os.path.join(base_path, "src/main/resources")
data_path = os.path.join(resources_path, "data")
os.makedirs(data_path, exist_ok=True)

pokemon_data = {
    "evolutionPairs": [
        {
            "stage1": {
                "name": "Charmander",
                "id": 4,
                "imagePath": "/images/charmander.png"
            },
            "stage2": {
                "name": "Charmeleon",
                "id": 5,
                "imagePath": "/images/charmeleon.png"
            }
        },
        {
            "stage1": {
                "name": "Bulbasaur",
                "id": 1,
                "imagePath": "/images/bulbasaur.png"
            },
            "stage2": {
                "name": "Ivysaur",
                "id": 2,
                "imagePath": "/images/ivysaur.png"
            }
        },
        {
            "stage1": {
                "name": "Squirtle",
                "id": 7,
                "imagePath": "/images/squirtle.png"
            },
            "stage2": {
                "name": "Wartortle",
                "id": 8,
                "imagePath": "/images/wartortle.png"
            }
        },
        {
            "stage1": {
                "name": "Pikachu",
                "id": 25,
                "imagePath": "/images/pikachu.png"
            },
            "stage2": {
                "name": "Raichu",
                "id": 26,
                "imagePath": "/images/raichu.png"
            }
        }
    ]
}

json_path = os.path.join(data_path, "pokemon_pairs.json")

with open(json_path, "w", encoding="utf-8") as file:
    json.dump(pokemon_data, file, indent=4, ensure_ascii=False)

print(f" Archivo creado correctamente en: {json_path}")
