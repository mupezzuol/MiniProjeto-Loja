package br.umc.ex2.model;
public class Produto {
    //Atributos
    private long id;
    private String nome;
    private double preco;
    private Marca marca;

    // CONSTRUTOR COM PARAMETROS
    public Produto(String nome, Marca marca){
        this.nome = nome;
    }
    public Produto(){  }
    
    //Get's e Set's
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    //EQUALS compara para ser usado em metodos de DELETAR etc.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    } 

   
}