
package br.umc.ex2.model.dao;

import br.umc.ex2.model.Marca;
import br.umc.ex2.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarcaDAO {
    
    //COMSULTAR POR PRODUTOS EXISTENTES NA MARCA
    public List<Marca> consultarPorProduto(){
            // ELE FAZ MAS PODE DAR ERRO
            try {
                // 'con' do tipo 'Connection' RECEBE classe 'Conexao' que chama 'conectar'
                Connection con = Conexao.conectar();

                //Preparo minha QUERY
                PreparedStatement comando = con.prepareStatement("select *, (select COUNT(*) from produtos where idMarca = marcas.id) as QuantidadeProdutos from marcas");
                
                //Para executar uma QUERY de seleção, devo usar a classe 'ResultSet' e comando de 'executeQuery'
                ResultSet resultado = comando.executeQuery();

                // Crio lista de produtos, com nome de 'todos produtos'
                List<Marca> listMarcasProds = new ArrayList<Marca>();

                //Enquanto houver próxima linha, ele fará o processo dentro do while
                while (resultado.next()){

                    //crio obj marca e seto valor lá do banco
                    Marca objMarca = new Marca();
                    objMarca.setId(resultado.getInt("id"));
                    objMarca.setMarca(resultado.getString("marca"));
                    objMarca.setQtdProdutos(resultado.getInt("QuantidadeProdutos"));
                    
                    listMarcasProds.add(objMarca);
                }

                con.close();// Fecha conexao
                return listMarcasProds; // Retorna um ARRAY com os OBJ que foram consultados no banco
            } catch (SQLException e) {
                System.out.println("Erro:" + e);
            }
            return null;
        }
    
    //PREENCHER MINHA COMBOBOX DE MARCAS
    public List<Marca> consultarComboBoxMarca(){
            // ELE FAZ MAS PODE DAR ERRO
            try {
                Connection con = Conexao.conectar();

                PreparedStatement comando = con.prepareStatement("select * from marcas");
                ResultSet resultado = comando.executeQuery();
                List<Marca> todasMarcas = new ArrayList<Marca>();

                while (resultado.next()){
                    // estancia obj Produto
                    Marca objMarc = new Marca(); 

                    objMarc.setId(resultado.getInt("id"));
                    objMarc.setMarca(resultado.getString("marca"));
                    todasMarcas.add(objMarc);
                }

                con.close();// Fecha conexao
                return todasMarcas; // Retorna um ARRAY com os OBJ que foram consultados no banco
            } catch (SQLException e) {
                System.out.println("Erro:" + e);
            }
            return null;
        }
    
    //CADASTRAR
        public void cadastrar(Marca marc){ 
            // ELE FAZ MAS PODE DAR ERRO
            try {
                // 'con' do tipo 'Connection' RECEBE classe 'Conexao' que chama 'conectar'
                Connection con = Conexao.conectar();
                
                //Preparo minha QUERY
                PreparedStatement comando = con.prepareStatement("insert into marcas (marca) values (?)");

                //Seto os valores da Query com oq temos no obj 'Produto'
                comando.setString(1, marc.getMarca());
                comando.execute();//Executo a minha query

                con.close();//Fecho conexão
            } catch (SQLException e) {
                System.out.println("Erro:" + e);
            }
    }
        
    //ATUALIZAR
    public void atualizar(Marca marc){ 
        // ELE FAZ MAS PODE DAR ERRO
        try {
            // 'con' do tipo 'Connection' RECEBE classe 'Conexao' que chama 'conectar'
            Connection con = Conexao.conectar();

            //Preparo minha QUERY
            PreparedStatement comando = con.prepareStatement("update marcas set marca = ? where id = ?");

            //Seto os valores da Query com oq temos no obj 'Produto'
            comando.setString(1, marc.getMarca());
            comando.setInt(2, (int) marc.getId());


            comando.execute();//Executo a minha query

            con.close();//Fecho conexão
        } catch (SQLException e) {
            System.out.println("Erro:" + e);
        }
    }   
    
    //CONSULTAR POR ID
    public Marca consultarPorId(int id){
            Marca objMarc = null; // Declaro minha marca
            Connection con = null;
            
            try {
                // 'con' do tipo 'Connection' RECEBE classe 'Conexao' que chama 'conectar'
                con = Conexao.conectar();

                //Preparo minha QUERY
                PreparedStatement comando = con.prepareStatement("select id,marca from marcas where id = ?");
                comando.setInt(1, id);
                
                //Para executar uma QUERY de seleção, devo usar a classe 'ResultSet' e comando de 'executeQuery'
                ResultSet resultado = comando.executeQuery();
                
                if(resultado.next()){
                    objMarc = new Marca();
                    
                    //Seto os valores do banco na minha MARCA
                    objMarc.setId(Long.parseLong(resultado.getString("id")));
                    objMarc.setMarca(resultado.getString("marca"));

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
                return objMarc;
            }
            //return p;
    }
}
