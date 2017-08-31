package br.umc.ex2.controller;

import br.umc.ex2.model.Produto;
import br.umc.ex2.model.dao.MarcaDAO;
import br.umc.ex2.model.dao.ProdutoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarProdutosController", urlPatterns = {"/produtos/ListarProdutos"})
public class ListarProdutosController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        //CONSULTAR NORMAL
        if (request.getParameter("id") == null) {
            
            List<Produto> prods = new ProdutoDAO().consultarTodos();
            
            request.setAttribute("listaDeProdutos", prods);
            
            
            MarcaDAO marcaDAO = new MarcaDAO();

            //Seto lista de marcas e obj produto
            request.setAttribute("marcasCombo", marcaDAO.consultarComboBoxMarca());
            
            //Dispacho para a JSP exibir a lista de produtos
            request.getRequestDispatcher("listarProd.jsp").forward(request, response);
            
        }else { //COMSULTAR POR ID
            //Pego ID pois será botão de alterar nao de listar
            int id = Integer.parseInt(request.getParameter("id"));
            
            // Produto recebe um OBJETO que retorna da consulta por ID
            Produto ProdUp = new ProdutoDAO().consultarPorId(id);
            
            MarcaDAO marcaDAO = new MarcaDAO();

            //Seto lista de marcas e obj produto
            request.setAttribute("marcas", marcaDAO.consultarComboBoxMarca());//COMBOBOX
            request.setAttribute("produtoParaEditar", ProdUp);
            
            //Dispacho para a JSP exibir a lista de produtos
            request.getRequestDispatcher("novoProduto.jsp").forward(request, response);
        } 
    }
    
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
            if(request.getParameter("comboBox").equals("cb")){
            MarcaDAO marcaDAO = new MarcaDAO();

            //Seto lista de marcas e obj produto
            request.setAttribute("marcas", marcaDAO.consultarComboBoxMarca());
            request.getRequestDispatcher("novoProduto.jsp").forward(request, response);
            
            }else{
                
                int id = Integer.parseInt(request.getParameter("marcaComboListProd"));
                
                List<Produto> prods = new ProdutoDAO().consultarProdPorMarca(id);
                
                MarcaDAO marcaDAO = new MarcaDAO();

                //Seto lista de marcas e obj produto
                request.setAttribute("marcasCombo", marcaDAO.consultarComboBoxMarca());

                
                request.setAttribute("listaDeProdutos", prods);
                request.getRequestDispatcher("listarProd.jsp").forward(request, response);
            }
            
            
            
     }
}
