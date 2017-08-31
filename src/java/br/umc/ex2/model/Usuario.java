package br.umc.ex2.model;

public class Usuario {
   //Atributos
    private String usuario;
    private String senha;
    private int nva;

    //Métodos Set's e Get's
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public int getNva() {
        return nva;
    }
    public void setNva(int nva) {
        this.nva = nva;
    }
 
}
