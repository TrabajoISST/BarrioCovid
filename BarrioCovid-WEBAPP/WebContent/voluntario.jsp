<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>VOLUNTARIO</title>
<link href="pedido.css" rel="stylesheet" type="text/css">
</head>
<body>
<table border="1">
	<tr>
		<th>ID</th>
		<th>Comprador</th>
		<th>Vendedor</th>
		<th>Estado</th>
	</tr>
	<c:forEach items="${pedidos}" var="pedidoi">
		<tr>
			<td>${pedidoi.idped}</td>
			<td>${pedidoi.comprador}</td>
			<td>${pedidoi.vendedor}</td>
			<td>${pedidoi.status}</td>
			<c:if test="${pedidoi.status == 2}">
			        <td>
				        <form action="VoluntarioServlet">
					        <input type="submit">Pedido Recogido</input>
				        </form>
			        </td>
			</c:if>
			<c:if test="${pedidoi.status != 2 }">
				<td></td>
			</c:if>
		</tr>
	</c:forEach>
</table>
</body>
<%@ include file="FormLogout.jsp"%>
</html>