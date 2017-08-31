package br.umc.ex2.controller;
import br.umc.ex2.model.Marca;
import br.umc.ex2.model.Produto;
import br.umc.ex2.model.dao.ProdutoDAO;
import java.io.IOException;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SalvarProdutosController", urlPatterns = {"/produtos/salvarProdutos"})
public class SalvarProdutosController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            if (request.getParameter("id").equals("")){
               // instancio, digo q DAO é a unica estanciada
                ProdutoDAO ProdDAO = new ProdutoDAO();

                //Estancio OBJ Produto e MArca
                Produto objProd = new Produto();
                Marca objMarc = new Marca();

                //Seto no Produto
                objProd.setNome(request.getParameter("nome"));
                objProd.setPreco(Double.parseDouble(request.getParameter("preco")));
                
                //Seto na Marca
                objMarc.setId(Long.parseLong(request.getParameter("marca")));

                objProd.setMarca(objMarc);
                
                //Cadastro enviando os produtos e marcas
                ProdDAO.cadastrar(objProd);

                //mando para JSP index, para dar o efeito de atualizar a página
                response.sendRedirect("novoProduto.jsp"); 
            }else { 
                //FARÁ ATUALIZAÇÃO
                
                ProdutoDAO ProdDAO = new ProdutoDAO();
                
                //Estancio OBJ Produto
                Produto objProd = new Produto();
                Marca objMarc = new Marca();
                
                
                //Seto no produto o name e marca que vem do FORM
                objProd.setId(Integer.parseInt(request.getParameter("id")));
                objProd.setNome(request.getParameter("nome"));
                objProd.setPreco(Double.parseDouble(request.getParameter("preco")));
                
                objMarc.setId(Long.parseLong(request.getParameter("marca")));
                
                objProd.setMarca(objMarc);

                //insiro com os dados que VEM do form
                ProdDAO.atualizar(objProd);

                //mando para JSP index, para dar o efeito de atualizar a página
                response.sendRedirect("novoProduto.jsp"); 
            }         
    }
}
