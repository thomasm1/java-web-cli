
//This is a comment
/*
    Multi Line Comment
*/

//Let keyword, this defines its scope.
let thisisaboolean = true;
thisisaboolean = false;
{
    //this variable will not exist outside of these 
    //curly braces
    let thisisaboolean2 = true;
}

let thisisanumber = 1000;
thisisanumber = 'Ryan';

console.log(typeof(thisisanumber));

let thisisanothing = null;  //null
let thisvariable;           //undefined

console.log(typeof(thisisanothing));
console.log(typeof(thisvariable));

/*
    JavaScript engages in Type Coercion to determine
    if two variable are equivalent.

    == does type coercion where JS does not regard type
    in determining equivalency.
*/

console.log(10 == 10);
console.log(10 == "10");

//If you do want to enforce type comparison
// ===

console.log(10 === "10");

//null is only equal to itself *
console.log(null == null);
console.log(null == false);
console.log(null == true);

//undefined is only equal to itself
console.log(undefined == undefined);
console.log(undefined == false);
console.log(undefined == true);

//These are equal
//This is called a truthy value
console.log(null == undefined);

//truthy/falsy values are values other than
//true/false that evaluate to true/false.

//0 is considered false -> false == false
console.log(false == 0);

console.log(false == "");
console.log(false == "Ryan");
console.log(false == "0");
console.log(false === 0);
console.log(false == []);

console.log(false == {});

console.log(NaN == NaN);
console.log(typeof("Ryan" - "Brendan"));

console.log(true == 1);
console.log(true == 3);
console.log(true + true);
console.log(false == (true - true));
