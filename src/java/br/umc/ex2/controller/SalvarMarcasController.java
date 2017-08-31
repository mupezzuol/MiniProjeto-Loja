package br.umc.ex2.controller;

import br.umc.ex2.model.Marca;
import br.umc.ex2.model.Produto;
import br.umc.ex2.model.dao.MarcaDAO;
import br.umc.ex2.model.dao.ProdutoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SalvarMarcasController", urlPatterns = {"/marcas/salvarMarcas"})
public class SalvarMarcasController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
            //FARÁ O INSERT SE O CAMPO ID FOR VAZIU
            if(request.getParameter("id").equals("")){

                MarcaDAO MarcDAO = new MarcaDAO();

                //Estancio OBJ MArca
                Marca objMarc = new Marca();

                //Seto na Marca
                objMarc.setMarca(request.getParameter("marca"));

                //Cadastro enviando os produtos e marcas
                MarcDAO.cadastrar(objMarc);

                //mando para JSP index, para dar o efeito de atualizar a página
                response.sendRedirect("novoMarca.jsp"); 
            
           }else { //FARÁ ATUALIZAÇÃO SE O CAMPO ID TIVER ALGUMA COISA
                MarcaDAO MarcDAO = new MarcaDAO();

                //Estancio OBJ MArca
                Marca objMarc = new Marca();

                //Seto na Marca
                objMarc.setMarca(request.getParameter("marca"));
                objMarc.setId(Integer.parseInt(request.getParameter("id")));

                
                //Cadastro enviando os produtos e marcas
                MarcDAO.atualizar(objMarc);

                //mando para JSP index, para dar o efeito de atualizar a página
                response.sendRedirect("novoMarca.jsp"); 
            }
    }

}
