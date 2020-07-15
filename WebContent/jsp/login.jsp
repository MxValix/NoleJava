<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - NoleJava</title>
</head>
<body>
	<h1>Effettua Login</h1>
	<form action="/Nolejava/loginServlet" method="POST">
		<label>Username:</label><br> <input type="email" name="email"
			value="" placeholder="inserisci la tua email"></input><br> <label>Password:</label><br>
		<input type="password" name="password" value=""
			placeholder="inserisci la tua password"></input><br> <input
			type="submit" value="Login"></input><br>
	</form>
</body>
</html>