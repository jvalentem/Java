package model;

public class Professor {
    
    private int professorID;
    private String nome;
    private int codigoTurma;
    private String senha;
    public Professor() {
    }

    public int getProfessorID() {
        return professorID;
    }

    public void setProfessorID(int professorID) {
        this.professorID = professorID;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return senha;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(int codigo) {
        this.codigoTurma = codigo;
    }
    
    

}
