<%@page import="br.umc.ex2.model.dao.ProdutoDAO"%>
<%@page import="br.umc.ex2.model.Produto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Marca</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../util/css/estilo.css">
    </head>
    <body>        
        <!--Form para chamar a SERVLET que salva meu produto-->
    <center><h1><div align="center">SALVAR MARCA</div></h1>
        <h2 align="center"><a class="btnNeutro" href="../index.jsp">HOME</a></h2>
        <form  method="post" action="salvarMarcas" align="center">
            <input type="hidden" name="id" value="${listaMarcasProds.id}"/>
            <p>Nome da Marca:</p><input class="inputNeutro" type="text" name="marca" value="${listaMarcasProds.marca}" placeholder="Marca" required/></br></br>
            <input class="btnNeutro" type="submit" value="Cadastrar" />
            <input class="btnNeutro" type="reset" value="Limpar" /> 
        </form>
        <div align="center"><a class="btnNeutro" href="ListarMarcas">Consultar Marcas</a></div></br> 
    </center>
    </body>
</html>