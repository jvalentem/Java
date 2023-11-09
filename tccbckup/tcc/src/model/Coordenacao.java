package model;

public class Coordenacao {
    
    private int coordenacaoID;
    private String nomeCoordenador;
    private String senha;
    
    public String getNomeCoordenador() {
        return nomeCoordenador;
    }
    public void setNomeCoordenador(String nomeCoordenador) {
        this.nomeCoordenador = nomeCoordenador;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return senha;
    }
    public int getCoordenacaoID() {
        return coordenacaoID;
    }

    public void setCoordenacaoID(int coordenacaoID) {
        this.coordenacaoID = coordenacaoID;
    }
    
    
    
}
