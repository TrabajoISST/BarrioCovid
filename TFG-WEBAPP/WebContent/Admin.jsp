<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN-JSP</title>
<link rel="stylesheet" type="text/css" href="main.css" />
</head>
<body>


	<table border="1">
		<tr>
			<th>Título</th>
			<th>Estudiante</th>
			<th>Email del estudiante</th>
			<th>Email del tutor</th>
			<th>Status</th>
			<!-- 			<th>Memoria</th> -->
			<th>Nota</th>
			<th>Actualizar</th>

			<c:forEach items="${tfgs}" var="tfgi">

				<form action="FormAdminServlet" method="post">
					<tr>
						<td><input type="text" id="title" name="title" value="${tfgi.title}" /></td>
						<td><input type="text" id="name" name="name"
							value="${tfgi.name}" /></td>
						<td><input type="hidden" id="email" name="email"
							value="${tfgi.email}" />${tfgi.email}</td>
						<td><input type="email" id="advisor" name="advisor"
							value="${tfgi.advisor}" /></td>
						<td><input type="number" id="status" name="status"
							value="${tfgi.status}" min="0" max="8" /></td>
						<td><input type="text" id="mark" name="mark"
							value="${tfgi.mark}" /></td>


						<td><button type="submit">Actualizar valores</button></td>
					   
					   <td><button type="submit">Eliminar TFG</button></td>
					   

				</form>
			</c:forEach>
	</table>

	<h3>Crear Nuevo TFG</h3>
	<form action="FormCreaTFGServlet">
		<input type="email" id="email" name="email" placeholder="Email">
		<input type="password" id="password" name="password"
			placeholder="Password"> <input type="text" id="name"
			name="name" placeholder="Nombre y apellidos"> <input
			type="text" id="titulo" name="titulo"
			placeholder="Título del proyecto"> <input type="email"
			id="profesor" name="profesor" placeholder="Profesor tutor">
		<button type="submit">Registrar</button>
	</form>






	<%@ include file="FormLogout.jsp"%>
	
	


</body>
</html>