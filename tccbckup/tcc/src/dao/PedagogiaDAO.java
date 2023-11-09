package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;
import model.Pedagogia;
import model.Professor;

public class PedagogiaDAO implements GenericDAO<Pedagogia>{
    
    private ConexaoBanco conexao;
    
    public PedagogiaDAO(){
            this.conexao = new ConexaoBanco();
        }

    @Override
    public void inserir(Pedagogia pedagogia) {
        String sql = "INSERT INTO pedagogia(nomePedagogo, pedagogiaID) VALUES(?, ?)";
        try{
            if(this.conexao.conectar()) {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            sentenca.setString(1, pedagogia.getNomePedagogo());
            sentenca.setInt(2, pedagogia.getPedagogiaID());
            sentenca.execute();
            sentenca.close();
            this.conexao.getConnection().close();
            
            System.out.println("\nCOORDENADOR(A) INSERIDO com SUCESSO");
        }
            }catch(SQLException ex) {
             throw new RuntimeException(ex);
             
            }catch(ClassNotFoundException ex){
            Logger.getLogger(PedagogiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Pedagogia> listar() {
        ArrayList<Pedagogia> listaPedagogia = new ArrayList<Pedagogia>();
        String sql = "SELECT * FROM pedagogia";
        
        try{
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                while (resultadoSentenca.next()) {
                    
                    Pedagogia pedagogia = new Pedagogia();
                    
                    pedagogia.setNomePedagogia(resultadoSentenca.getString("nomePedagogo"));   
                    pedagogia.setPedagogiaID(resultadoSentenca.getInt("pedagogiaID"));
                    pedagogia.setSenha(resultadoSentenca.getString("senha"));
                    listaPedagogia.add(pedagogia);
                }
            }    
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(PedagogiaDAO.class.getName()).log(Level.SEVERE, null, ex);      
        }
        return listaPedagogia;
        }
                    
    @Override
    public Object buscarID(Pedagogia pedagogia) {
        String sql = "SELECT * FROM pedagogia WHERE pedagogiaid = ?";
        try{
             if (this.conexao.conectar()) {
             PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql); 
             sentenca.setInt(1, pedagogia.getPedagogiaID());
           
             ResultSet resultadoSentenca = sentenca.executeQuery();
             
             if(resultadoSentenca.next()) {
                 
                  pedagogia.setNomePedagogia(resultadoSentenca.getString("nomeCoordenador"));   
                  pedagogia.setPedagogiaID(resultadoSentenca.getInt("coordenadorID"));
                 
             }
             return pedagogia;
                 } 
        }catch (SQLException ex) {
            Logger.getLogger(PedagogiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedagogiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pedagogia;
        }
    
    @Override
    public void atualizar(Pedagogia pedagogia) {
        String sql = "UPDATE pedagogia SET nomepedagogo = ?"+
                "WHERE pedagogiaid = ?";
        try {
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            sentenca.setString(1, pedagogia.getNomePedagogo());
            sentenca.setInt(2, pedagogia.getPedagogiaID());
            sentenca.execute();
            sentenca.close();
        }catch (SQLException ex) {
            Logger.getLogger(PedagogiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void excluir(Pedagogia pedagogia) {
    String sql = "DELETE FROM pedagogia WHERE pedagogiaid = ?";
        PreparedStatement sentenca;
        
        try {
            sentenca = this.conexao.getConnection().prepareStatement(sql);
            
                sentenca.setInt(1, pedagogia.getPedagogiaID());
                sentenca.execute();
                sentenca.close();
            
        }catch (SQLException ex) {
            Logger.getLogger(PedagogiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}


    
