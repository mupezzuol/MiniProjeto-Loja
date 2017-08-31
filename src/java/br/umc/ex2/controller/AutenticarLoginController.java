package br.umc.ex2.controller;

import br.umc.ex2.model.Usuario;
import br.umc.ex2.model.dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AutenticarLoginController", urlPatterns = {"/autenticarLogin"})
public class AutenticarLoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //obtendo usuario e senha do formulário
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        //Chamo metodo da dao de autentica usuario e retorno um USUARIO
        Usuario objUserValida = new UsuarioDAO().autenticarUsuario(usuario,senha);
        
        if (objUserValida == null){
            request.setAttribute("autenticacao", "Usuário ou Senha incorreto!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else {            
            request.setAttribute("nva", objUserValida.getNva());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }  
}
