package controller;

import database.UsuarioDAO;
import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/usuarios/*"})
public class UsuarioServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo != null && !pathInfo.isEmpty()) {
            String[] components = pathInfo.split("/");
            String action = components[1]; // El componente [0] es vacío debido a que pathInfo empieza con un '/'.

            try {
                switch (action) {
                    case "delete":
                        deleteUser(components[2]); // El ID del usuario está en components[2].
                        response.sendRedirect(request.getContextPath() + "/usuarios");
                        break;

                    case "create":
                        request.getRequestDispatcher("/views/usuarios/crear.jsp").forward(request, response);
                        break;

                    case "edit":
                        request.setAttribute("usuario", getUser(Integer.parseInt(components[2]))); // El ID del usuario está en components[2].
                        request.getRequestDispatcher("/views/usuarios/editar.jsp").forward(request, response);
                        break;

                    case "detail":
                        request.setAttribute("usuario", getUser(Integer.parseInt(components[2]))); // El ID del usuario está en components[2].
                        request.getRequestDispatcher("/views/usuarios/ver-usuario.jsp").forward(request, response);
                        break;

                    default:
                        request.setAttribute("usuarios", getAll());
                        request.getRequestDispatcher("/views/usuarios/usuarios.jsp").forward(request, response);
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener usuarios");
            }
        } else {
            try {
                request.setAttribute("usuarios", getAll());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("/views/usuarios/usuarios.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        String  nombre = "";
        String apellido = "";
        String username = "";
        String password = "";
        String email = "";
        int id = 0;

        if (pathInfo != null && !pathInfo.isEmpty()) {
            String[] components = pathInfo.split("/");
            String action = components[1]; // El componente [0] es vacío debido a que pathInfo empieza con un '/'.

            try {
                switch (action) {
                    case "create":
                        nombre = request.getParameter("nombre");
                        apellido = request.getParameter("apellido");
                        username = request.getParameter("usuario");
                        email = request.getParameter("email");
                        password = request.getParameter("password");
                        Usuario newUser = new Usuario(username,password,nombre,apellido,email);
                        createUser(newUser);
                        response.sendRedirect(request.getContextPath() + "/usuarios");
                        break;
                    case "edit":
                        id = Integer.parseInt(request.getParameter("id"));
                        nombre = request.getParameter("nombre");
                        apellido = request.getParameter("apellido");
                        username = request.getParameter("usuario");
                        email = request.getParameter("email");
                        password = request.getParameter("password");
                        newUser = new Usuario(id,username,password,nombre,apellido,email);
                        editUser(newUser);
                        response.sendRedirect(request.getContextPath() + "/usuarios");
                        break;
                    default:
                        request.setAttribute("usuarios", getAll());
                        request.getRequestDispatcher("/views/usuarios/usuarios.jsp").forward(request, response);
                        break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al obtener usuarios");
            }
        }
    }


    private Usuario getUser(int userId) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.getUserById(userId);
    }

    private void deleteUser(String idUser) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.deleteUser(Integer.parseInt(idUser));
    }

    private List<Usuario> getAll() throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = null;

        usuarios = usuarioDAO.getAllUsers("usuarios");
        return usuarios;
    }

    private void createUser(Usuario usuario) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.createUser(usuario);
    }

    private void editUser(Usuario usuario) throws SQLException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.updateUser(usuario);
    }

}
