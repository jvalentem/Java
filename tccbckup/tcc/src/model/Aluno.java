package model;

public class Aluno {
    
    private String nome;   
    private String curso;
    private String necessidade;
    private int alunoID;
    private int codigoTurma;

    public Aluno() {
        
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCodigoTurma(int codigoTurma){
        this.codigoTurma = codigoTurma;
    }
    
    public int getCodigoTurma(){
        return codigoTurma;
    }
    
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNecessidade() {
        return necessidade;
    }

    public void setNecessidade(String necessidade) {
        this.necessidade = necessidade;
    }

    public int getAlunoID() {
        return alunoID;
    }

    public void setAlunoID(int alunoID) {
        this.alunoID = alunoID;
    }
    

    
    
}
