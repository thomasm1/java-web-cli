
let person = {
    name: "Ryan",
    age: 100,
    sayHello: () => {
        console.log("Hello Everyone");
    }
}

console.log(person.name);
person.sayHello();

person.name = "Adam"
console.log(person.name)

person.profession = "Trainer";
console.log(person.profession);

function Pokemon(name, type, level) {
    this.name = name;
    this.type = type;
    this.level = level;
}

let pikachu = new Pokemon("Pikachu", "Electric", 50);
let arcanine = new Pokemon("Arcanine", "Fire", 51);

console.log(pikachu);
console.log(arcanine);

pikachu.attack = () => {
    console.log("Pikachu! Use Thunderbolt!");
}

pikachu.attack();
//arcanine.attack();

//JSON - JavaScript Object Notation
//a JSON is JUST a string format for storing information.

console.log("---");
console.log(pikachu);

let pikachuJSON = JSON.stringify(pikachu);
console.log(pikachuJSON);

let pokemonTeam = [pikachu, arcanine];
console.log(pokemonTeam);
console.log(JSON.stringify(pokemonTeam));

let parsedpikachu = JSON.parse(pikachuJSON);
console.log(parsedpikachu);
console.log(parsedpikachu.name);