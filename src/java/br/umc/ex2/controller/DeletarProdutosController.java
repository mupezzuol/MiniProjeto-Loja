package br.umc.ex2.controller;
import br.umc.ex2.model.Produto;
import br.umc.ex2.model.dao.MarcaDAO;
import br.umc.ex2.model.dao.ProdutoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeletarProdutosController", urlPatterns = {"/produtos/deletarProduto"})
public class DeletarProdutosController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            // instancio ProdutoDAO ara invocar seus métodos com banco
            ProdutoDAO ProdDAO = new ProdutoDAO();
            
            //Estancio OBJ Produto
            Produto objProd = new Produto();
            
            //Seto no produto o ID que vem do FORM
            objProd.setId(Integer.parseInt(request.getParameter("id")));
        
            //chamo a DAO e uso o delete passando o objeto
            ProdDAO.deletar(objProd);
     
            //mando para JSP atualizar a página
            response.sendRedirect("ListarProdutos");   
    }
}
