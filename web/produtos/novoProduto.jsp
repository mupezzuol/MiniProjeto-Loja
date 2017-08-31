<%@page import="br.umc.ex2.model.dao.ProdutoDAO"%>
<%@page import="br.umc.ex2.model.Produto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Produto</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="../util/css/estilo.css">
    </head>
    <body>        
        <!--Form para chamar a SERVLET que salva meu produto-->
        <h1><div align="center">SALVAR PRODUTO</div></h1></br>
        <h2 align="center"><a class="btnNeutro" href="../index.jsp">HOME</a></h2>
        
        <form method="post" action="salvarProdutos" align="center"></br>
            <input class="inputNeutro" type="hidden" name="id" value="${produtoParaEditar.id}"/>
            <p>Nome:</p><input class="inputNeutro" type="text" name="nome" value="${produtoParaEditar.nome}" placeholder="Nome" required/></br></br>
            <p>Marcas:</p><select class="selectNeutro" name="marca" style="width: 175px" value="${produtoParaEditar.marca.id}">  
                                       
                          <!--ooo-->      
                          <c:forEach var="m" items="${marcas}">  
                            <option value="${m.id}" ${m.id == produtoParaEditar.marca.id?'selected':''}>
                                ${m.marca}
                            </option>  
                          </c:forEach>      
                            
                   </select></br></br>
            <p>Preço:</p> <input class="inputNeutro" type="text" name="preco" value="${produtoParaEditar.preco}" placeholder="Preco" required /></br></br>
            <input class="btnNeutro" type="submit" value="Cadastrar" />
            <input class="btnNeutro" type="reset" value="Limpar" /> 
        </form></br></br>
        <!--Form para chamar a SERVLET que lista meus produtos-->
        <div align="center"><a class="btnNeutro" href="ListarProdutos">Consultar Produtos</a></div></br>      
    </body>
</html>