<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro BarrioCovid</title>
</head>
<body>

	<h1>Bienvenido al servicio BarrioCovid</h1>

	<img src="img/barrio.png" width="200" height="200">
	
	<h2>Registro Compradores</h2>
	<form action="FormRegistroUsuarioServlet">
		<input type="email" id="email" name="email" placeholder="Email">
		<input type="password" id="password" name="password" placeholder="Password"> 
		<input type="text" id="zona" name="zona" placeholder="Zona"> 
		<input type="text" id="direccion" name="direccion" placeholder="Direccion">
		<input type="hidden" id="rol" name="rol" value="comprador"> 
		<input type="hidden" id="pedidosRealizados" name="pedidosRealizados" value=0>
		<input type="hidden" id="pedidosEntregados" name="pedidosEntregados" value=0>  
		<input type="hidden" id="idUsuario" name="idUsuario">
		<button type="submit">Sign in</button>
	</form>
	
	<h2>Registro Voluntarios</h2>
	<form action="FormRegistroUsuarioServlet">
		<input type="email" id="email" name="email" placeholder="Email">
		<input type="password" id="password" name="password" placeholder="Password"> 
		<input type="text" id="zona" name="zona" placeholder="Zona"> 
		<input type="text" id="direccion" name="direccion" placeholder="Direccion">
		<input type="hidden" id="rol" name="rol" value="voluntario"> 
		<input type="hidden" id="pedidosRealizados" name="pedidosRealizados" value=0>
		<input type="hidden" id="pedidosEntregados" name="pedidosEntregados" value=0>  
		<input type="hidden" id="idUsuario" name="idUsuario">
		<button type="submit">Sign in</button>
	</form>
	
	<h2>Registro Compradores</h2>
	<form action="FormRegistroUsuarioServlet">
		<input type="email" id="email" name="email" placeholder="Email">
		<input type="password" id="password" name="password" placeholder="Password"> 
		<input type="text" id="zona" name="zona" placeholder="Zona"> 
		<input type="text" id="direccion" name="direccion" placeholder="Direccion">
		<input type="hidden" id="rol" name="rol" value="vendedor"> 
		<input type="hidden" id="pedidosRealizados" name="pedidosRealizados" value=-1>
		<input type="hidden" id="pedidosEntregados" name="pedidosEntregados" value=-1>  
		<input type="hidden" id="idUsuario" name="idUsuario">
		<button type="submit">Sign in</button>
	</form>

</body>
</html>