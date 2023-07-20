<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Usuario" %>
<%@include file="/views/partials/header.jsp" %>

      <div class="container">
        <div class="row mt-3">
          <div class="col">
            <h1 class="text-start">Crear usuario</h1>
          </div>
          <div class="col text-end my-auto">
            <button class="btn btn-secondary text-end" onclick="volverListaUsuario()">Volver</button>
          </div>
        </div>
        <hr>
        <div class="row">
          <div class="col">
            <form action="/crud/usuarios/create" method="post">
              <div class="row">
                <div class="col-6">
                  <label for="nombre">Nombre: </label>
                  <input type="text" required name="nombre" id="nombre" class="form-control">
                </div>
                <div class="col-6">
                  <label for="apellido">Apellido: </label>
                  <input type="text" required name="apellido" id="apellido" class="form-control">
                </div>
                <div class="col-6">
                  <label for="usuario">usuario: </label>
                  <input type="text" required name="usuario" id="usuario" class="form-control">
                </div>
                <div class="col-6">
                  <label for="email">Email: </label>
                  <input type="email" required name="email" id="email" class="form-control">
                </div>
                <div class="col-12">
                  <label for="password">Password: </label>
                  <input type="password" required name="password" id="password" class="form-control">
                </div>
                <div class="col-12 mt-3">
                  <button type="submit" class="btn btn-secondary w-100">Crear usuario</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
      <script>
        function volverListaUsuario() {
          window.location.href = '/crud/usuarios';
        }
      </script>
      <%@include file="/views/partials/footer.jsp" %>

