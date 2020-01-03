
const sessionInfo = function() {
	 sessUser = getCookie("sessUser"); 
	 sessId = getCookie("sessId"); 
	 sessSuper = getCookie("sessSuper"); 
	 sessDept = getCookie("sessDept"); 
	 killCookie("username");
	 document.cookie=`username=${sessUser}`; 
	 killCookie("userid");
	 document.cookie=`userid=${sessId}`; 
	 killCookie("usersuper");
	 document.cookie=`usersuper=${sessSuper}`; 
	 killCookie("userdept");
	 document.cookie=`userdept=${sessDept}`;
	let username = getCookie("username");   
    let headerName = document.getElementById("headerId");
    headerName.innerHTML = ` ${username}`;
    
    let userid = getCookie("userid"); 
    let id = document.getElementById("userId");
    id.innerHTML = ` ${userid}`;
    
    let usersuper = getCookie("usersuper"); 
    let superid = document.getElementById("userSuper");
    superid.innerHTML = ` ${usersuper}`;
    
    let userdept = getCookie("userdept"); 
    let deptid = document.getElementById("userDept");
    deptid.innerHTML = ` ${userdept}`;
}    

let username;  // just declare
let login = function () { 

    let u = document.getElementById("username");
    username = u.value; // overwrite

    let p = document.getElementById("password");
    let password;
    password = p.value;

    let xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) { 
            console.log("readyState: " + this.readyState + ", status: " + this.status);
        }
    }
    xhttp.open("POST", "http://localhost:8090/project1/login.do", true);
//        xhttp.open("POST", "http://localhost:8090/project1/login2.do", true);
    
    xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xhttp.send( "username=" + username + "&password=" + password);
    console.log(" submitted by: *" + username + ", password *" + password);
	redirect(username);

    }   

let sessUser; 
let sessId; 
let sessSuper;
let sessDept; 
let logout = function() {
	killCookie("username");
	killCookie("userid");
	killCookie("usersuper");
	killCookie("userdept");
	
	killCookie("sessUser");
	killCookie("sessId");
	killCookie("sessSuper");
	killCookie("sessDept");
}
let redirect = function(username) {     
	 sessUser = getCookie("sessUser"); 
	 sessId = getCookie("sessId"); 
	 sessSuper = getCookie("sessSuper"); 
	 sessDept = getCookie("sessDept"); 
	  if (username) { 
	
		 console.log("sessDept: "+sessDept+",sessUser:"+sessUser+" logged in as "+username );
		 killCookie("username");
		 document.cookie=`username=${username}`; 
		 killCookie("userid");
		 document.cookie=`userid=${sessId}`; 
		 killCookie("usersuper");
		 document.cookie=`usersuper=${sessSuper}`; 
		 killCookie("userdept");
		 document.cookie=`userdept=${sessDept}`;  

		 let spinner = document.getElementById("spinner");
		 spinner.style.display = "block";
		 setTimeout(function(){ 
			 window.location.href="/project1/index.html";
			 }, 3000);
	  } else {
	    alert("please try again! entered "+username+", x " + username ); 
	    window.location.href="/project1/login.html";
	  }  
	}
let killCookie = function (cname) {
 
	    document.cookie = cname + 
	    '=; expires=Thu, 01-Jan-70 00:00:01 GMT;';
}
let getCookie = function(cname) {
	  var name = cname + "=";
	  var decodedCookie = decodeURIComponent(document.cookie);
	  var ca = decodedCookie.split(';');
	  for(var i = 0; i <ca.length; i++) {
	    var c = ca[i];
	    while (c.charAt(0) == ' ') {
	      c = c.substring(1);
	    }
	    if (c.indexOf(name) == 0) {
	      return c.substring(name.length, c.length);
	    }
	  }
	  return "";
	}