<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Usuario" %>


<%@include file="/views/partials/header.jsp" %>

<div class="container">
    <div class="row mt-3">
        <div class="col">
            <h1 class="text-start">Detalle usuario</h1>
        </div>
        <div class="col text-end my-auto">
            <button class="btn btn-secondary text-end" onclick="volverListaUsuario()">Volver</button>
        </div>
    </div>
    <hr>
    <div class="row">
        <div class="col-12">
            <p>Id : ${usuario.getId()}</p>
            <p>Usuario : ${usuario.getUsername()}</p>
            <p>Password : ${usuario.getPassword()}</p>
            <p>Apellido : ${usuario.getLast_name()}</p>
            <p>Email : ${usuario.getEmail()}</p>
        </div>
    </div>
</div>


<script>
    function volverListaUsuario() {
        window.location.href = '/crud/usuarios';
    }
</script>


<%@include file="/views/partials/footer.jsp" %>
