<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="/views/partials/header.jsp" %>

<div class="container">
    <div class="row mt-3">
        <div class="col">
            <h1 class="text-start">Lista de usuarios</h1>
        </div>
        <div class="col text-end my-auto">
            <a href="/crud/usuarios/create" class="btn btn-secondary text-end">Agregar usuario</a>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-12">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Usuario</th>
                    <th scope="col">Contraseña</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">email</th>
                    <th scope="col" colspan="3">Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="usuario" items="${usuarios}">
                    <tr>
                        <td>${usuario.username}</td>
                        <td>${usuario.password}</td>
                        <td>${usuario.name}</td>
                        <td>${usuario.last_name}</td>
                        <td>${usuario.email}</td>
                        <td>
                            <a class="cursor"href="/crud/usuarios/detail/${usuario.id}">Ver</a>
                        </td>
                        <td class="cursor">
                            <a href="/crud/usuarios/edit/${usuario.id}">Editar</a>
                        <td>
                            <a href="/crud/usuarios/delete/${usuario.id}">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<%@include file="/views/partials/footer.jsp" %>

