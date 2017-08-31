package br.umc.ex2.controller;

import br.umc.ex2.model.Marca;
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

@WebServlet(name = "ListarMarcasController", urlPatterns = {"/marcas/ListarMarcas"})
public class ListarMarcasController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

            if (request.getParameter("id") == null){
            
            List<Marca> listMarca = new MarcaDAO().consultarPorProduto();
            
            request.setAttribute("listaMarcasProds", listMarca);
            
            //Dispacho para a JSP exibir a lista de produtos
            request.getRequestDispatcher("listarMarca.jsp").forward(request, response);
            
            }else{
                //Pego ID pois será botão de alterar nao de listar
                int id = Integer.parseInt(request.getParameter("id"));

                // Produto recebe um OBJETO que retorna da consulta por ID
                Marca MarcaUp = new MarcaDAO().consultarPorId(id);

                MarcaDAO marcaDAO = new MarcaDAO();
                
                marcaDAO.atualizar(MarcaUp);

                request.setAttribute("listaMarcasProds", MarcaUp);

                //Dispacho para a JSP exibir a lista de produtos
                request.getRequestDispatcher("novoMarca.jsp").forward(request, response);
            } 
    }
}
