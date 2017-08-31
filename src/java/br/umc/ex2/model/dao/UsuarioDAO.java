package br.umc.ex2.model.dao;


import br.umc.ex2.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
     public Usuario autenticarUsuario(String user, String senha){
            Connection con = null;
            Usuario objUser = null;
            try {
                // 'con' do tipo 'Connection' RECEBE classe 'Conexao' que chama 'conectar'
                con = Conexao.conectar();

                //Preparo minha QUERY
                PreparedStatement comando = con.prepareStatement("select * from usuarios where usuario = ? and senha = ?");
                comando.setString(1, user);
                comando.setString(2, senha);
                
                //Para executar uma QUERY de seleção, devo usar a classe 'ResultSet' e comando de 'executeQuery'
                ResultSet rs = comando.executeQuery();
                //Se tiver próximo
                if(rs.next()){
                    objUser = new Usuario();
                    objUser.setUsuario(rs.getString("usuario"));
                    objUser.setSenha(rs.getString("senha"));
                    objUser.setNva(rs.getInt("nva"));
                }  
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
                
            }finally{
                try{
                    con.close();
                }catch(SQLException exception){
                    throw new RuntimeException(exception.getMessage());
                }
                return objUser;
            }
            //return p;
    }
}
