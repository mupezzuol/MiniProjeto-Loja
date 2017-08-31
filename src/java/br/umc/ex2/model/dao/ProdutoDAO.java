package br.umc.ex2.model.dao;
import br.umc.ex2.model.Produto;
import br.umc.ex2.model.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {
 
        //CADASTRAR
        public void cadastrar(Produto prod){ 
            // ELE FAZ MAS PODE DAR ERRO
            try {
                // 'con' do tipo 'Connection' RECEBE classe 'Conexao' que chama 'conectar'
                Connection con = Conexao.conectar();
                
                //Preparo minha QUERY
                PreparedStatement comando = con.prepareStatement("insert into produtos (nome, idMarca, preco) values (?, ?, ?)");

                //Seto os valores da Query com oq temos no obj 'Produto'
                comando.setString(1, prod.getNome());
                comando.setInt(2, (int) prod.getMarca().getId());
                comando.setDouble(3, prod.getPreco());
                comando.execute();//Executo a minha query

                con.close();//Fecho conexão
            } catch (SQLException e) {
                System.out.println("Erro:" + e);
            }
    } 
        
        
        
        //ATUALIZAR
        public void atualizar(Produto prod){ 
            // ELE FAZ MAS PODE DAR ERRO
            try {
                // 'con' do tipo 'Connection' RECEBE classe 'Conexao' que chama 'conectar'
                Connection con = Conexao.conectar();
                
                //Preparo minha QUERY
                PreparedStatement comando = con.prepareStatement("update produtos set nome = ?, idmarca = ?, preco = ? where id = ?");

                //Seto os valores da Query com oq temos no obj 'Produto'
                comando.setString(1, prod.getNome());
                comando.setInt(2, (int) prod.getMarca().getId());
                comando.setDouble(3, prod.getPreco());
                comando.setInt(4, (int) prod.getId());

                comando.execute();//Executo a minha query

                con.close();//Fecho conexão
            } catch (SQLException e) {
                System.out.println("Erro:" + e);
            }
    } 
        
        //CONSULTAR TODOS
        public List<Produto> consultarTodos(){
            // ELE FAZ MAS PODE DAR ERRO
            try {
                // 'con' do tipo 'Connection' RECEBE classe 'Conexao' que chama 'conectar'
                Connection con = Conexao.conectar();

                //Preparo minha QUERY
                PreparedStatement comando = con.prepareStatement("select p.id, p.nome, m.marca, p.preco from produtos p, marcas m where p.idmarca = m.id");
                
                //Para executar uma QUERY de seleção, devo usar a classe 'ResultSet' e comando de 'executeQuery'
                ResultSet resultado = comando.executeQuery();

                // Crio lista de produtos, com nome de 'todos produtos'
                List<Produto> todosProdutos = new ArrayList<Produto>();

                //Enquanto houver próxima linha, ele fará o processo dentro do while
                while (resultado.next()){
                    Produto objProd = new Produto(); 
                    objProd.setId(resultado.getInt("id"));
                    objProd.setNome(resultado.getString("nome"));
                    objProd.setPreco(resultado.getDouble("preco"));
                    
                    //crio obj marca e seto valor lá do banco
                    Marca objMarca = new Marca();
                    objMarca.setMarca(resultado.getString("marca"));
                    
                    //seto no produto uma marca que é um objeto 
                    objProd.setMarca(objMarca);
                    
                    todosProdutos.add(objProd);
                }

                con.close();// Fecha conexao
                return todosProdutos; // Retorna um ARRAY com os OBJ que foram consultados no banco
            } catch (SQLException e) {
                System.out.println("Erro:" + e);
            }
            return null;
        }
        
        public List<Produto> consultarProdPorMarca(int id){
            try {
                // 'con' do tipo 'Connection' RECEBE classe 'Conexao' que chama 'conectar'
                Connection con = Conexao.conectar();

                //Preparo minha QUERY
                PreparedStatement comando = con.prepareStatement("select p.id, p.nome, m.marca, p.idMarca, p.preco from produtos p, marcas m where p.idmarca = ? and m.id = p.idmarca");
                comando.setInt(1, id);
                
                //Para executar uma QUERY de seleção, devo usar a classe 'ResultSet' e comando de 'executeQuery'
                ResultSet resultado = comando.executeQuery();

                // Crio lista de produtos, com nome de 'todos produtos'
                List<Produto> todosProdutos = new ArrayList<Produto>();

                //Enquanto houver próxima linha, ele fará o processo dentro do while
                while (resultado.next()){
                    Produto objProd = new Produto(); 
                    
                    objProd.setId(resultado.getInt("id"));
                    objProd.setNome(resultado.getString("nome"));
                    objProd.setPreco(resultado.getDouble("preco"));
                    
                    //crio obj marca e seto valor lá do banco
                    Marca objMarca = new Marca();
                    objMarca.setId(resultado.getInt("idMarca"));
                    objMarca.setMarca(resultado.getString("marca"));
                    
                    //seto no produto uma marca que é um objeto 
                    objProd.setMarca(objMarca);
                    
                    todosProdutos.add(objProd);
                }

                con.close();// Fecha conexao
                return todosProdutos; // Retorna um ARRAY com os OBJ que foram consultados no banco
            } catch (SQLException e) {
                System.out.println("Erro:" + e);
            }
            return null;
        }
        
        
        
        
        
        
        
        public Produto consultarPorId(int id){
            Produto objProd = null; //Declaro meu produto
            Marca objMarc = null; // Declaro minha marca
            Connection con = null;
            
            try {
                // 'con' do tipo 'Connection' RECEBE classe 'Conexao' que chama 'conectar'
                con = Conexao.conectar();

                //Preparo minha QUERY
                PreparedStatement comando = con.prepareStatement("select p.id, p.nome, p.idMarca, m.marca, p.preco from produtos p, marcas m where p.id = ? and p.idMarca = m.id");
                comando.setInt(1, id);
                
                //Para executar uma QUERY de seleção, devo usar a classe 'ResultSet' e comando de 'executeQuery'
                ResultSet resultado = comando.executeQuery();
                
                if(resultado.next()){
                    objProd = new Produto();
                    objMarc = new Marca();
                    
                    //Seto os valores do banco no meu PRODUTO
                    objProd.setId(resultado.getInt("id"));
                    objProd.setNome(resultado.getString("nome"));
                    objProd.setPreco(Double.parseDouble(resultado.getString("preco")));
                    
                    //Seto os valores do banco na minha MARCA
                    objMarc.setId(Long.parseLong(resultado.getString("idMarca")));
                    objMarc.setMarca(resultado.getString("marca"));
                    
                    //Seto tudo do obj Marca no atributo MARCA na classe produto
                    objProd.setMarca(objMarc);
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
                return objProd;
            }
            //return p;
        }
            
        //DELETAR PRODUTO
        public void deletar(Produto prod){
            try {
                // 'con' do tipo 'Connection' RECEBE classe 'Conexao' que chama 'conectar'
                Connection con = Conexao.conectar();

                //Preparo minha QUERY
                PreparedStatement comando = con.prepareStatement("delete from produtos where id = ?");

                //Seto os valores da Query com oq temos no obj 'Produto'
                comando.setInt(1, (int) prod.getId());
                comando.execute();//Execute a query

                con.close();//Fecho conexão do banco
            } catch (SQLException e) {
                System.out.println("Erro:" + e);
            }
        }   
}
