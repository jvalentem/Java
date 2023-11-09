package model;

public class Turma {
    
    private int turmaID;
    private int qtdAlunos;
    private int qtdAlunosEspeciais;

    public int getQtdAlunosEspeciais() {
        return qtdAlunosEspeciais;
    }

    public void setQtdAlunosEspeciais(int qtdAlunosEspeciais) {
        this.qtdAlunosEspeciais = qtdAlunosEspeciais;
    }

    public Turma() {
    }

    public int getTurmaID() {
        return turmaID;
    }

    public void setTurmaID(int turmaID) {
        this.turmaID = turmaID;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }
    
    
    
}
