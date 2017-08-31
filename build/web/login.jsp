<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Login</title>
        <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
            <!--ícones bootstrap-->
        <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
        <link rel="stylesheet" type="text/css" href="util/css/login.css">
    </head>

<body>
  
<div class="pen-title">
  <h1>Sistema de Controle</h1><span>Versão 1.0 <i class='fa fa-paint-brush'></i>  by <a href='http://andytran.me'>Murillo Pezzuol</a></span>
</div>
<!-- Form Module-->
<div class="module form-module">
  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
    
  </div>
  <div class="form">
    <h2>Acesse já!</h2>
    <form action="autenticarLogin" method="post">
      <input type="text" name="usuario" placeholder="Usuário" required/>
      <input type="password" name="senha" placeholder="Senha" required/>
      <input class="inputLogin" type="submit" value="Login" />
      
      ${autenticacao}
    </form>
  </div>
  <div class="cta"><a href="login.jsp">Esqueceu sua senha? Foda-se</a></div>
</div>

</body>
</html>
