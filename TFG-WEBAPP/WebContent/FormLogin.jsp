<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta charset="UTF-8">
<title>FormLogin-JSP</title>
</head>
<body>
<h2>Acceso</h2>

	<form action="FormLoginServlet">
		<input type="text" name="email" placeholder="Email">
		<input type="password" name="password" placeholder="Password">
		<button type="submit">Login</button>
	</form>
	
</body>
</html>