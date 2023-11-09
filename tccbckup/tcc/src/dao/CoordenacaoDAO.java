package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;
import model.Coordenacao;
import model.Professor;

public class CoordenacaoDAO implements GenericDAO<Coordenacao>{
    
    private ConexaoBanco conexao;
    
    public CoordenacaoDAO(){
            this.conexao = new ConexaoBanco();
        }

    @Override
    public void inserir(Coordenacao coordenacao) {
        String sql = "INSERT INTO coordenacao(nomeCoordenador, coordenacaoID) VALUES(?, ?)";
        try{
            if(this.conexao.conectar()) {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            sentenca.setString(1, coordenacao.getNomeCoordenador());
            sentenca.setInt(2, coordenacao.getCoordenacaoID());
            sentenca.execute();
            sentenca.close();
            this.conexao.getConnection().close();
            
            System.out.println("\nCOORDENADOR(A) INSERIDO com SUCESSO");
        }
            }catch(SQLException ex) {
             throw new RuntimeException(ex);
             
            }catch(ClassNotFoundException ex){
            Logger.getLogger(CoordenacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Coordenacao> listar() {
        ArrayList<Coordenacao> listaCoordenacao = new ArrayList<Coordenacao>();
        String sql = "SELECT * FROM Coordenacao";
        
        try{
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                while (resultadoSentenca.next()) {
                    
                    Coordenacao coordenacao = new Coordenacao();
                    
                    coordenacao.setNomeCoordenador(resultadoSentenca.getString("nomeCoordenador"));   
                    coordenacao.setCoordenacaoID(resultadoSentenca.getInt("coordenacaoID"));
                    coordenacao.setSenha(resultadoSentenca.getString("senha"));
                    listaCoordenacao.add(coordenacao);
                }
            }    
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(CoordenacaoDAO.class.getName()).log(Level.SEVERE, null, ex);      
        }
        return listaCoordenacao;
        }
                    
    @Override
    public Object buscarID(Coordenacao coordenacao) {
        String sql = "SELECT * FROM coordenacao WHERE coordenacaoid = ?";
        try{
             if (this.conexao.conectar()) {
             PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql); 
             sentenca.setInt(1, coordenacao.getCoordenacaoID());
           
             ResultSet resultadoSentenca = sentenca.executeQuery();
             
             if(resultadoSentenca.next()) {
                 
                  coordenacao.setNomeCoordenador(resultadoSentenca.getString("nomeCoordenador"));   
                  coordenacao.setCoordenacaoID(resultadoSentenca.getInt("coordenadorID"));
                 
             }
             return coordenacao;
                 } 
        }catch (SQLException ex) {
            Logger.getLogger(CoordenacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CoordenacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coordenacao;
        }
    
    @Override
    public void atualizar(Coordenacao coordenacao) {
        String sql = "UPDATE professor SET nomeCoordenador = ?"+
                "WHERE coordenacaoId = ?";
        try {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            sentenca.setString(1, coordenacao.getNomeCoordenador());
            sentenca.setInt(2, coordenacao.getCoordenacaoID());
            sentenca.execute();
            sentenca.close();
        }catch (SQLException ex) {
            Logger.getLogger(CoordenacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void excluir(Coordenacao coordenacao) {
    String sql = "DELETE FROM coordenacao WHERE coordenacaoID = ?";
        PreparedStatement sentenca;
        
        try {
            sentenca = this.conexao.getConnection().prepareStatement(sql);
            
                sentenca.setInt(1, 1);
                sentenca.execute();
                sentenca.close();
            
        }catch (SQLException ex) {
            Logger.getLogger(CoordenacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}


    
