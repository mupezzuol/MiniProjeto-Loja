package br.umc.ex2.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    // Método de conexão
    public static Connection conectar(){
        // Atributos para alteração
        String hostname = "localhost";
        String banco = "exeOdairLojaBD2";
        String usuario = "postgres";
        String senha = "postgres";
        String porta = "5432";
        // 'con' Recebe null de 'Connection' 
        Connection con = null;
        
        // Try é o que ele vai fazer e pode dar erro
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://"+hostname+":"+porta+"/"+banco+"", ""+usuario+"", ""+senha+"");
        }catch(ClassNotFoundException | SQLException erro){ // Se der erro ele fará isso
            System.out.println(erro.getMessage());
        }finally{ // Vai retornar de qualquer jeito
            return con;
        }        
    }
}
