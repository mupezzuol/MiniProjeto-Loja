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
        <title>Consulta de Produtos</title>
    </head>
    <body>
        <h1 align="center">PRODUTOS </h1>
        <h2 align="center"><a class="btnNeutro" href="novoProduto.jsp">VOLTAR</a></h2>   
        
        <form method="post" action="ListarProdutos" align="center"></br>
            <input type="hidden" name="comboBox" value="cbListProd"/>
            <p>Marcas:</p><select class="selectNeutro" name="marcaComboListProd" style="width: 175px" value="2">  
                                       
                          <!--ooo-->      
                          <c:forEach var="m" items="${marcasCombo}">  
                            <option value="${m.id}">
                                ${m.marca}
                            </option>  
                          </c:forEach>      
                            
                        </select></br></br>
            <input class="btnNeutro" type="submit" value="Consultar por marca" />
        </form></br>
        
        
        
        <table border="0px" align="center" cellspacing>
                <tr>
                    <th height="50px">ID</th>
                    <th height="50px">NOME</th>
                    <th height="50px">MARCA</th>
                    <th height="50px">PREÇO</th>
                    <th height="50px">OPÇÕES</th>
                </tr>

                <!--Utilizo o JSTL para o FOR e fecho depois de utilizar ele-->
                <c:forEach items="${listaDeProdutos}" var="produto">   
                        
                    <tr>
                        <td>${produto.id}</td>
                        <td>${produto.nome}</td>
                        <td>${produto.marca.marca}</td><!--produto atributo Marca que é um objeto e dentro dele acesso o 'marca'-->
                        
                        <!--Formato o preço com JSTL usando 'setLocale' e 'formatNumber'-->
                        <td>
                            <fmt:setLocale value="pt-BR" />
                            <fmt:formatNumber value="${produto.preco}" type="currency"/>
                        </td>
                        
                        <td> 
                            <!--CHAMA SERVLET DELETAR-->
                            <form action="deletarProduto" method="post">
                                <!--BOTÃO DE CADA LINHA PARA DELETAR-->
                                <input type="hidden" name="id" value="${produto.id}">
                                <input class="btnNeutro" type="submit" value="EXCLUIR" align="center">
                            </form>
                            <!--CHAMA SERVLET ATUALIZAR-->    
                            <form action="ListarProdutos" method="get">
                                <!--BOTÃO DE CADA LINHA PARA DELETAR-->
                                <input type="hidden" name="id" value="${produto.id}">
                                <input class="btnNeutro" type="submit" name="" value="ALTERAR" align="center">
                            </form>
                        </td>
                    </tr>    
              <!--FIM DO FOR DO JSTL-->
              </c:forEach>
            </table>           
    </body>
</html>