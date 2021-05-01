<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="UTF-8">
<title>TFG-JSP</title>
</head>
<body>


	<h2>Datos TFG</h2>

	<table border="1">
		<tr>

					<td>Nombre: ${tfg.name}</td>

					<td>Email: ${tfg.email}</td>

					<td>Titulo: ${tfg.title}</td>

					<td>Email tutor: ${tfg.advisor}</td>
					<td>Estado: ${tfg.status}</td>
					<td>Nota: ${tfg.mark}</td>
					
					
				<td>
				
				
					<c:if test="${tfg.status == 3}">
						<form action="FormSubeMemoriaServlet" method="post"
							enctype="multipart/form-data">
							<input type="hidden" name="tfgemail" value="${tfg.email}" /> <input
								type="file" name="file" />
							<button type="submit">Subir memoria</button>
						</form>
					</c:if>
					<c:if test="${tfgi.status > 3}">
						<form action="FormBajaMemoriaServlet" method="get">
							<input type="hidden" name="tfgemail" value="${tfgi.email}" />
							<button type="submit">Descargar memoria</button>
						</form>
					</c:if>
					</td>

			
	</table>


<%@ include file="FormLogout.jsp"%>
</body>
</html>