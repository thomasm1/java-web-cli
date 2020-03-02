/*

    hoisting is a 'feature' in JavaScript
    wherein declared variables are hoisted to the top
    of their scope but values are not.
    this ONLY applies to var scope.

*/
test();

//The greeting variable is hoisted to the top of the scope
console.log(greeting);

var greeting = "Hello";

console.log(greeting);

function test() {
    let testvar = 100;
    console.log("Value: " + iftest2);

    if(true) {
        let iftest = true;
        var iftest2 = false;
    }
    console.log("Hello World!");
}

test();




var foo = 1;

function bar() {
    if (!foo) {
        var foo = 10;
    }
    console.log(foo);
}
bar();



console.log(!undefined);
console.log(undefined == true);
console.log(undefined == false);

console.log((!undefined) == true);
console.log((!undefined) == false);


var a = 1;
function b() {
	a = 10;
	return;
	function a() {}
}
b();
console.log(a);
