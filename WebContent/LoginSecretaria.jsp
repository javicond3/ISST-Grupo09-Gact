<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">

<!-- CSS -->
<link rel="stylesheet" type="text/css" href="./style/style.css">
<!-- Bootstrap, Jquery -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Aplicación Gestión Docente</title>
</head>
<body>
	<div id="contenedor">
		<ul class="nav nav-tabs nav-users loginsecretaria">
			<li class="nav-item "><a href="LogoutServlet">Salir</a></li>
		</ul>
	</div>
	<div class="container">
		<div class="page-header">
			<h3>CREAR DEPARTAMENTO</h3>
		</div>
		<%@ include file="FormNuevoDepartamento.jsp"%>
	

			<div class="col-sm-4 loginsecretaria2">
				<a href="FormNuevoDepartamentoServlet?menu=1">Rellenar Departamento </a>
				
				
			</div>
			<div class="col-sm-4 loginsecretaria2">
				<a href="FormRespNuevoPlanServlet?menu=1">Rellenar Planes de Estudio </a>
				
			</div>
			<div class="col-sm-12">
				<h1></h1>
			</div>
	

		<div class="col-sm-12">
		    <h3></h3>
			<h3>DEPARTAMENTOS</h3>
		</div>
		<table class="table table-bordered">
			<tr>
				<th>Código</th>
				<th>Nombre</th>
				<th>Acrónimo</th>
				<th>Responsable</th>

			</tr>
			<c:forEach items="${departamento_list}" var="departamentoi">
				<tr>

					<td>${departamentoi.codigo}</td>
					<td>${departamentoi.nombre}</td>
					<td>${departamentoi.acronimo}</td>
					<td><%@ include file="FormNuevoResponsable.jsp"%>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>