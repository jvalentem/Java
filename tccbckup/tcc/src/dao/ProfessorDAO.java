package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;
import model.Professor;

public class ProfessorDAO implements GenericDAO<Professor>{
    
    private ConexaoBanco conexao;
    
    public ProfessorDAO(){
            this.conexao = new ConexaoBanco();
        }

    @Override
    public void inserir(Professor professor) {
        String sql = "INSERT INTO professor(nome, senha) VALUES(?,?)";
        try{
            if(this.conexao.conectar()) {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            sentenca.setString(1, professor.getNome());
            sentenca.setString(2, professor.getSenha());
            sentenca.execute();
            sentenca.close();
            this.conexao.getConnection().close();
            
            System.out.println("\nDOCENTE INSERIDO com SUCESSO");
        }
            }catch(SQLException ex) {
             throw new RuntimeException(ex);
             
            }catch(ClassNotFoundException ex){
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Professor> listar() {
        ArrayList<Professor> listaProfessor = new ArrayList<Professor>();
        String sql = "SELECT * FROM Professor";
         try{
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                while (resultadoSentenca.next()) { 
                    
                        Professor professor = new Professor();
                    
                    professor.setNome(resultadoSentenca.getString("nome"));   
                    
                    professor.setProfessorID(resultadoSentenca.getInt("professorID"));
                    professor.setSenha(resultadoSentenca.getString("senha"));
                    listaProfessor.add(professor);
                    
                }
            }    
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);      
        }
        return listaProfessor;
        }

    @Override
    public Object buscarID(Professor professor) {
        String sql = "SELECT * FROM professor WHERE professorid = ?";
        try{
             if (this.conexao.conectar()) {
             PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql); 
             sentenca.setInt(1, professor.getProfessorID());
           
             ResultSet resultadoSentenca = sentenca.executeQuery();
             
             if(resultadoSentenca.next()) {
                  
                 professor.setNome(resultadoSentenca.getString("nome"));
         
                 professor.setProfessorID(resultadoSentenca.getInt("professorID"));              
                 }
             return professor;
                 } 
        }catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professor;
        }

    @Override
    public void atualizar(Professor professor) {
        String sql = "UPDATE professor SET nome = ? , curso = ?"+
                "WHERE alunoID = ?";
        try {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            sentenca.setString(1, professor.getNome());
            sentenca.setInt(2, professor.getCodigoTurma());
            sentenca.setInt(3, professor.getProfessorID());
            sentenca.execute();
            sentenca.close();
    }   catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void excluir(Professor professor) {
        String sql = "DELETE FROM professor WHERE professorID = ?";
        PreparedStatement sentenca;
        
        try {
            sentenca = this.conexao.getConnection().prepareStatement(sql);
            
                sentenca.setInt(1, 1);
                sentenca.execute();
                sentenca.close();
            
        }catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


    