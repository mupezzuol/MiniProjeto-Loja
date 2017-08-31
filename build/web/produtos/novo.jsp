<%@page import="br.umc.ex2.model.Produto"%>
<html>
    <head>
        <title>Home</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>        
        <!--Form para chamar a SERVLET que salva meu produto-->
        <div align="center">SALVAR PRODUTO</div></br>
        <form method="post" action="salvar" align="center"></br>
            <input type="text" name="id" value="${produtoParaEditar.id}"/></br></br>
            Nome:  <input type="text" name="nome" value="${produtoParaEditar.nome}" placeholder="Nome" required/></br></br>
            Marca: <input type="text" name="marca" value="${produtoParaEditar.marca}" placeholder="Marca" required /></br></br>
            <input type="submit" value="Enviar" />
            <input type="reset" value="Limpar" /> 
        </form></br></br>
        
        <!--Form para chamar a SERVLET que lista meus produtos-->
        <div align="center"><a href="ListarProdutosController">BUSCAR PRODUTOS</a></div></br>      
    </body>
</html>