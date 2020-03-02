
/*
scopes are defined by the declaration
Global scope has no declaration
*/

x = 101;
var y = 102;
let z = 103;

console.log(x);
console.log(y);
console.log(z);

{
    a = 10;
    var b = 11;
    let c = 12;

    console.log(a);
    console.log(b);
    console.log(c);
}

console.log(a);
console.log(b);
//console.log(c);

function awfulness() {

    let w = 200;
    var a = 10;
    var a = 20;

    if(true) {
        w = 3;
        v = 1000;
        console.log(v);
    }

    console.log(v);

}

awfulness();
console.log(v);
//console.log(w);

