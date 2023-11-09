package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;
import model.Turma;

public class TurmaDAO implements GenericDAO<Turma>{
    
    private ConexaoBanco conexao;
    
    public TurmaDAO(){
            this.conexao = new ConexaoBanco();
        }

    @Override
    public void inserir(Turma turma) {
        String sql = "INSERT INTO aluno(qtdAlunos, qtdAlunosEspeciais) VALUES(?, ?)";
        try{
            if(this.conexao.conectar()) {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            sentenca.setInt(1, turma.getQtdAlunos());
            sentenca.setInt(2, turma.getQtdAlunosEspeciais());
            sentenca.execute();
            sentenca.close();
            this.conexao.getConnection().close();
            
            System.out.println("\nTURMA INSERIDA com SUCESSO");
        }
            }catch(SQLException ex) {
             throw new RuntimeException(ex);
             
            }catch(ClassNotFoundException ex){
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Turma> listar() {
        ArrayList<Turma> listaTurma = new ArrayList<Turma>();
        String sql = "SELECT * FROM Turma";
         try{
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                while (resultadoSentenca.next()) { 
                    
                        Turma turma = new Turma();
                    
                    turma.setQtdAlunos(resultadoSentenca.getInt("qtdAlunos"));   
                    turma.setQtdAlunosEspeciais(resultadoSentenca.getInt("qtdAlunosEspeciais"));
                    turma.setTurmaID(resultadoSentenca.getInt("turmaID"));
                    listaTurma.add(turma);
                }
            }    
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);      
        }
        return listaTurma;
        }
    
    
    @Override
    public Object buscarID(Turma turma) {
        String sql = "SELECT * FROM turma WHERE turmaid = ?";
        try{
             if (this.conexao.conectar()) {
             PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql); 
             sentenca.setInt(1, turma.getTurmaID());
           
             ResultSet resultadoSentenca = sentenca.executeQuery();
             
             if(resultadoSentenca.next()) {
                  
                 turma.setQtdAlunos(resultadoSentenca.getInt("qtdAlunos"));
                 turma.setQtdAlunosEspeciais(resultadoSentenca.getInt("qtdAlunosEspeciais"));
                 turma.setTurmaID(resultadoSentenca.getInt("turmaID"));              
                 }
           
                 } 
        }catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return turma;
        }

    @Override
    public void atualizar(Turma turma) {
        String sql = "UPDATE turma SET qtdAlunos = ?, qtdAlunosEspeciais =?"+
                "WHERE turmaID = ?";
        try {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            sentenca.setInt(1, turma.getQtdAlunos());
            sentenca.setInt(2, turma.getQtdAlunosEspeciais());
            sentenca.setInt(3, turma.getTurmaID());
            sentenca.execute();
            sentenca.close();
    }   catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Turma turma) {
        String sql = "DELETE FROM turma WHERE turmaID = ?";
        PreparedStatement sentenca;
        
        try {
            sentenca = this.conexao.getConnection().prepareStatement(sql);
            
                sentenca.setInt(1, 1);
                sentenca.execute();
                sentenca.close();
            
        }catch (SQLException ex) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    

