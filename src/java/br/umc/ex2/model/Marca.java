package br.umc.ex2.model;
public class Marca {
    //Atributos
    private long id;
    private String marca;
    private int qtdProdutos;
    
    //Get's e Set's
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }
    

    public void setString(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}