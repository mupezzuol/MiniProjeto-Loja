<%@page import="java.util.ArrayList"%>
<%@page import="br.umc.ex2.model.dao.ProdutoDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.umc.ex2.model.Produto"%>
<%@page import="br.umc.ex2.model.Produto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../util/css/estilo.css">
        <title>Consulta de Marcas</title>
    </head>
    <body>
        <h1 align="center">Marcas</h1>
        <h2 align="center"><a class="btnNeutro" href="novoMarca.jsp">VOLTAR</a></h2>        
        <table border="0px" align="center" cellspacing>
                <tr>
                    <th height="50px">ID</th>
                    <th height="50px">MARCA</th>
                    <th height="50px">QTD DE PRODUTOS</th>
                    <th height="50px">OPÇÕES</th>
                </tr>

                <!--Utilizo o JSTL para o FOR e fecho depois de utilizar ele-->
                <c:forEach items="${listaMarcasProds}" var="marca">   
                        
                    <tr>
                        <td>${marca.id}</td>
                        <td>${marca.marca}</td>
                        <td>${marca.qtdProdutos}</td><!--produto atributo Marca que é um objeto e dentro dele acesso o 'marca'-->
                        
                        <td> 
                            <!--CHAMA SERVLET DELETAR-->
                            <form action="" method="post">
                                <!--BOTÃO DE CADA LINHA PARA DELETAR-->
                                <input type="hidden" name="id" value="${marca.id}">
                                <input class="btnNeutro" type="submit" value="EXCLUIR" align="center">
                            </form>
                            <!--CHAMA SERVLET ATUALIZAR-->    
                            <form action="ListarMarcas" method="get">
                                <!--BOTÃO DE CADA LINHA PARA DELETAR-->
                                <input type="hidden" name="id" value="${marca.id}">
                                <input class="btnNeutro" type="submit" name="" value="ALTERAR" align="center">
                            </form>
                        </td>
                    </tr>    
              <!--FIM DO FOR DO JSTL-->
              </c:forEach>
            </table>           
    </body>
</html>