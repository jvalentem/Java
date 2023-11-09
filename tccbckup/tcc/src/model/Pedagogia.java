package model;

public class Pedagogia {
    
    private int pedagogiaID;
    private String nomePedagogo;
    private String senha;
    
    public String getNomePedagogo() {
        return nomePedagogo;
    }
    public void setNomePedagogia(String nomePedagogia) {
        this.nomePedagogo = nomePedagogia;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return senha;
    }
    public int getPedagogiaID() {
        return pedagogiaID;
    }

    public void setPedagogiaID(int coordenacaoID) {
        this.pedagogiaID = coordenacaoID;
    }
    
    
    
}
