
let numbers = [10,20,30,40,50];
console.log(numbers);

//Pop - will remove the last element
console.log("Pop: " + numbers.pop());
console.log(numbers);

//Push - will add element(s) to the end of the array
console.log("Push: " + numbers.push(60));
console.log(numbers);

//Shift - will remove the first element
console.log("Shift: " + numbers.shift());
console.log(numbers);

//Unshift - will add element(s) to the beginning of the array
console.log("Shift: " + numbers.unshift(0));
console.log(numbers);

numbers = numbers.map(num => num*10);
console.log(numbers);

numbers = numbers.map(num => someFunction(num));
console.log(numbers);

function someFunction(num) {
    return num*num;
}

//The array prototype is where the methods are stored
//for arrays. JavaScript does not have classes.

let ray = [1,2,"Ryan", null, undefined, [], {}];
console.log(ray);
console.log(ray.length);

