<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrati - NoleJava</title>
</head>
<body>
	<h1>Effettua Registrazione</h1>
	<form action="/Nolejava/registrazioneServlet" method="POST">
		<input type="text" placeholder="nome" name="nome" value=""> <br>
		 <input type="text" placeholder="cognome" name="cognome" value=""><br>
		<input type="date" placeholder="data di nascita" name="dataNascita" value=""><br>
		<input type="text" placeholder="email" name="email" value=""> <br>
		<input type="password" placeholder="password" name="password" value=""><br>
		<label>Selezionare casella in caso di registrazione Staff</label><br>
		<input type="checkbox" name="staff" value=""> <input type="submit" value="Registrati ora">
	</form>
</body>
</html>
