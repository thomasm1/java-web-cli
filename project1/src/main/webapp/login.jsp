<%@ page language="java" contentType="text/html; charset=ISO-8859-1" taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<head>
   
<meta charset="ISO-8859-1">
    <title>Project-1</title>
</head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<style>
body {
        background-color: aliceblue;
        padding: 3%; 
    }
    h2,h3 {
        text-align:center;
    }  
    
    button.btn-info a {
    color:white;
    float:right;
    } 
    #info {
        background-color: lightblue; 
        width:100%;
        padding: 15px;
        margin: 10px;
        border:solid 1px blue;
    }

    table,
    tr,
    th,
    td {
        background-color: lightblue;
        padding: 15px;
        margin: 10px;
        border: solid 1px blue;
    }

    td {
        color: blue;
        width: 200px;
    } 
    button.btn-info a {
    color:white;
    }
</style> 
  <link rel="shortcut favicon"  href="favicon.ico"  /> 
<body> 
<br />
    <hr>
    <h2>* PROJECT-1 *</h2>
    <h3>MEMBER PORTAL</h3>
   <div id="info">
   
    <button class="btn btn-primary" onclick="login()">Login</button>
    <hr> 
    <h4 id="text">USERNAME</h4>
    <input id="username" type="text">
    <h4 id="text">PASSWORD</h4>
    <input id="password" type="text">
    </div>
    <hr></body>
<script>


    let login = function () { 

        let u = document.getElementById("username");
        let username;  // just declare
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

        xhttp.open("POST", "http://localhost:8090/dailytech/login.do", true);

        xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
        xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

        xhttp.send( "username=" + username + "&password=" + password);
        console.log(" submitted by: *" + username + ", password *" + password);


    }  
</script>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</HTML>