/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Observacao;

/**
 *
 * @author Joaov
 */
public class ObservacaoDAO implements GenericDAO<Observacao> {
    private ConexaoBanco conexao;
    
    public ObservacaoDAO(){
        this.conexao = new ConexaoBanco();
    }
    
    @Override
    public void inserir(Observacao obs) {
        String sql = "insert into observacoes(titulo,conteudo,publidata) values (?,?,?)";
        System.out.println("Sql preparado");
        try{
            if(this.conexao.conectar()){
                
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                System.out.println("Sentença preparada");
                sentenca.setString(1, obs.getTitulo());
                sentenca.setString(2, obs.getConteudo());
                sentenca.setString(3, obs.getPubliData());
                sentenca.execute();
                System.out.println("Sentença executada");
                sentenca.close();
                this.conexao.getConnection().close();
                System.out.println("Observação adicionada com sucesso");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<Observacao> listar() {
        String sql = "select * from observacoes order by titulo asc";
        ArrayList<Observacao> observacoes = new ArrayList<Observacao>();
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                while(resultadoSentenca.next()){
                    Observacao obs = new Observacao();
                    System.out.println("Class:" + obs);
                    obs.setTitulo(resultadoSentenca.getString("titulo"));
                    obs.setConteudo(resultadoSentenca.getString("conteudo"));
                    obs.setPublidata(resultadoSentenca.getString("publidata"));
                    observacoes.add(obs);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return observacoes;
    }

    @Override
    public Object buscarID(Observacao obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public Observacao buscarIdPorTitulo(String titulo){
        String sql = "select * from observacoes where id = (select id from observacoes where titulo = ?)";
        Observacao obs = new Observacao();
        
        try{
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                sentenca.setString(1,titulo);
                ResultSet resultadoSentenca = sentenca.executeQuery();
                
                if(resultadoSentenca.next()){
                    obs.setTitulo(resultadoSentenca.getString("titulo"));
                    obs.setConteudo(resultadoSentenca.getString("conteudo"));
                    obs.setPublidata(resultadoSentenca.getString("publidata"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return obs;
    }
    @Override
    public void atualizar(Observacao obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(Observacao obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
