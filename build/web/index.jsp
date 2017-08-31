<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="util/css/estilo.css">
        <title>Home</title>
    </head>
    <body>
        <center>
            <h1>SEJA BEM VINDO!</h1>
        </center>
        
        <center>
            <h2>Cadastro de Produtos</h2>
            <form action="produtos/ListarProdutos" method="post">
                <input type="hidden" name="comboBox" value="cb"/>
                <input class="btnNeutro" type="submit" value="Cadastrar Produtos">
            </form>
        </center>
        
    
    
    
        <c:if test="${nva == 1 or nva == 2}">
            
            <center>
                <h2>Cadastro de marcas</h2>
                <form action="marcas/novoMarca.jsp" method="post">
                    <input class="btnNeutro" type="submit" value="Cadastrar Marcas">
                </form>
            </center>
            
        </c:if>
    
        
    </body>
</html>
