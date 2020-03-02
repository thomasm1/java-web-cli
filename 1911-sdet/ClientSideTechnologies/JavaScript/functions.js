//There are several ways to create functions in JS.

hello();

//1st way
//Is hoisted
function hello() {
    console.log("Hello!");
}

hello();

//2nd way
//store the function in a variable.

//hola();
let hola = function() {
    console.log("Hola!");
}

hola();
console.log(hola);
//always remember to invoke your functions!

let add = function(num1,num2) {
    return (num1 + num2);
}

let subtract = function(num1,num2) {
    return (num1 - num2);
}

console.log(add(9,10));
console.log(add("9","10"));
console.log(add(9,"10"));
console.log(add("10",9));

console.log(subtract(9,10));
console.log(subtract("9","10"));
console.log(subtract(9,"10"));
console.log(subtract(add("9","10"),10));
console.log(typeof(subtract("Nine","Ten")));

//3rd way to make a function
//arrow notation

let nihao = () => {
    console.log("Ni hao");
}

nihao();

let multiply = (num1,num2) => {
    return num1 * num2;
}

console.log(multiply(9,10));
console.log(multiply("9","10"));
console.log(multiply(9,"10"));


function greetings(greet1, greet2) {
    greet1();
    greet2();
}

greetings(hello, hola);
greetings(hola, nihao);


function calculate(num1, num2, op1, op2) {
    console.log(op1(num1, num2));
    console.log(op2(num1, num2));
}

calculate(9,10,add,subtract);
calculate("9","10",add,subtract);
calculate("9","10",subtract,multiply);

function addNumbers(num1,num2) {
    console.log(typeof(num2));
    if(num2 != undefined) {
        return num1 + num2;
    }
    else {
        return num1;
    }
}

function addNumbers2(num1,num2 = 0) {
    console.log(typeof(num2));
    return num1 + num2;
}

console.log(addNumbers(3,4));
console.log(addNumbers(3));
console.log(addNumbers2(3));


//Self-invoking
//Anonymous IIFE
//Immediately Invoked Function Expression

(function() {
    console.log("I am a self-invoking function");
})();