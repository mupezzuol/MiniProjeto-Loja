<%@page import="java.util.ArrayList"%>
<%@page import="br.umc.ex2.model.dao.ProdutoDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.umc.ex2.model.Produto"%>
<%@page import="br.umc.ex2.model.Produto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem</title>
    </head>
    <body>
        <h1 align="center">PRODUTOS </h1>
        <h2 align="center"><a href="novo.jsp">HOME</a></h2>        
            <table border="1px" align="center" cellspacing>
                <tr>
                    <th height="50px">ID</th>
                    <th height="50px">NOME</th>
                    <th height="50px">MARCA</th>
                    <th height="50px">ALTERAÇÃO</th>
                </tr>

                <!--Utilizo o JSTL para o FOR e fecho depois de utilizar ele-->
                <c:forEach items="${listaDeProdutos}" var="produto">   
                        
                    <tr>
                        <td>${produto.id}</td>
                        <td>${produto.nome}</td>
                        <td>${produto.marca}</td>
                        <td> 
                            <!--CHAMA SERVLET DELETAR-->
                            <form action="deletar" method="post">
                                <!--BOTÃO DE CADA LINHA PARA DELETAR-->
                                <input type="hidden" name="id" value="${produto.id}">
                                <input type="submit" value="EXCLUIR" align="center">
                            </form>
                            <!--CHAMA SERVLET ATUALIZAR-->    
                            <form action="ListarProdutosController" method="get">
                                <!--BOTÃO DE CADA LINHA PARA DELETAR-->
                                <input type="hidden" name="id" value="${produto.id}">
                                <input type="submit" name="" value="ALTERAR" align="center">
                            </form>
                        </td>
                    </tr>    
              <!--FIM DO FOR DO JSTL-->
              </c:forEach>
            </table>           
    </body>
</html>