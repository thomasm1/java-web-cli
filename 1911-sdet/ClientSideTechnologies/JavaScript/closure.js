

function outer() {

    console.log("I am in the outer function");
    let count = 100;

    return function inner() {
        console.log("I am in the inner function");
        console.log(count);
        count++;
    }
    /*
    The count variable has been enclosed
    even though the outer has already executed
    and is not being called that variable is still
    able to be used.

    This is closure
    */
}

let func = outer();
console.log("func: " + func);

func();
func();
func();



func.count = 100;
console.log(func.count);


function outer2() {

    console.log("I am in the outer function");
    let count = 100;

    return function setCount(num1) {
        count = num1;
        console.log(count);
    }
}

let func2 = outer2();
func2(200);
func2(300);

func2.count = 555;
console.log(func2.count);