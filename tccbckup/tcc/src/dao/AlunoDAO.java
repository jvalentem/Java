package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Aluno;

public class AlunoDAO implements GenericDAO<Aluno>{
    
    private ConexaoBanco conexao;
    
    public AlunoDAO(){
            this.conexao = new ConexaoBanco();
        }

    @Override
    public void inserir(Aluno aluno) {
        String sql = "INSERT INTO aluno(nome, curso, necessidade, codigoTurma) VALUES(?, ?, ?, ?)";
        System.out.println("sql definido");
        try{
            if(this.conexao.conectar()) {
            System.out.println("conectado");
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            System.out.println("Sql preparado");
            
            System.out.println("Iniciando registro de aluno");
            System.out.println("Nome:" + aluno.getNome());
            sentenca.setString(1, aluno.getNome());
                System.out.println("Curso:" + aluno.getCurso());
            sentenca.setString(2, aluno.getCurso());
                System.out.println("Necessidade:" + aluno.getNecessidade());
            sentenca.setString(3, aluno.getNecessidade());
                System.out.println("Codigo da turma:" + aluno.getCodigoTurma());
            sentenca.setInt(4, aluno.getCodigoTurma());
            sentenca.execute();
            sentenca.close();
            this.conexao.getConnection().close();
            
            System.out.println("\nALUNO INSERIDO com SUCESSO");
        }
            }catch(SQLException ex) {
             throw new RuntimeException(ex);
             
            }catch(ClassNotFoundException ex){
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ArrayList<Aluno> listar() {
        ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
        String sql = "select * from aluno order by nome asc";
        
        try{
            if (this.conexao.conectar()) {
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);

               
                ResultSet resultadoSentenca = sentenca.executeQuery();
 
               
                while (resultadoSentenca.next()) {
                    
                    Aluno aluno = new Aluno();
                    
                    aluno.setNome(resultadoSentenca.getString("nome"));
                    aluno.setAlunoID(resultadoSentenca.getInt("alunoid"));
                    aluno.setNecessidade(resultadoSentenca.getString("necessidade"));
                    aluno.setCodigoTurma(resultadoSentenca.getInt("codigoTurma"));
                    aluno.setCurso(resultadoSentenca.getString("curso"));
                    
                    listaAluno.add(aluno);
                }
            }    
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(PedagogiaDAO.class.getName()).log(Level.SEVERE, null, ex);      
        }
        return listaAluno;
        }
    
    public ArrayList<Aluno> listarPorNome(String nome) throws Exception{
        String sql = "select * from aluno where nome like ?";
        ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
        
       try{
            if(this.conexao.conectar()){
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            sentenca.setString(1,nome + "%");
            
            ResultSet resultadoSentenca = sentenca.executeQuery();
            
            while(resultadoSentenca.next()){
                Aluno aluno = new Aluno();
                aluno.setNome(resultadoSentenca.getString("nome"));
                aluno.setAlunoID(resultadoSentenca.getInt("alunoid"));
                aluno.setCurso(resultadoSentenca.getString("curso"));
                aluno.setCodigoTurma(resultadoSentenca.getInt("codigoTurma"));
                aluno.setNecessidade(resultadoSentenca.getString("necessidade"));
                listaAlunos.add(aluno);
                
               
            
            }
        }
       }catch(ClassNotFoundException | SQLException e){
           System.out.println(e.toString());
       }
       return listaAlunos;
    }
    
    public ArrayList<Aluno> listarPorTurma(int codigoTurma) throws Exception{
        String sql = "select * from aluno where codigoTurma = ? order by nome asc";
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        
        try{
            if(conexao.conectar()){
               PreparedStatement sentenca = conexao.getConnection().prepareStatement(sql);
               sentenca.setInt(1,codigoTurma);
               ResultSet resultado = sentenca.executeQuery();
               
               while(resultado.next()){
                   Aluno aluno = new Aluno();
                    
                    aluno.setNome(resultado.getString("nome"));
                    aluno.setAlunoID(resultado.getInt("alunoid"));
                    aluno.setNecessidade(resultado.getString("necessidade"));
                    aluno.setCodigoTurma(resultado.getInt("codigoTurma"));
                    aluno.setCurso(resultado.getString("curso"));
                    System.out.println(listaAlunos);
                    listaAlunos.add(aluno);
               }
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
        return listaAlunos;
    }
    
    
    public ArrayList<Aluno> listarPorTurmaeNome(int codigoTurma, String nome) throws Exception{
        String sql = "select * from aluno where codigoTurma = ? and nome like ? order by nome asc";
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        
        try{
            if(conexao.conectar()){
               PreparedStatement sentenca = conexao.getConnection().prepareStatement(sql);
               sentenca.setInt(1,codigoTurma);
               sentenca.setString(2, nome + "%");
               ResultSet resultado = sentenca.executeQuery();
               
               while(resultado.next()){
                   Aluno aluno = new Aluno();
                    
                    aluno.setNome(resultado.getString("nome"));
                    aluno.setAlunoID(resultado.getInt("alunoid"));
                    aluno.setNecessidade(resultado.getString("necessidade"));
                    aluno.setCodigoTurma(resultado.getInt("codigoTurma"));
                    aluno.setCurso(resultado.getString("curso"));
                    System.out.println(listaAlunos);
                    listaAlunos.add(aluno);
               }
            }
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
        return listaAlunos;
    }
    
    @Override
    
    public Object buscarID(Aluno aluno) {
        String sql = "SELECT * FROM aluno WHERE alunoid = ?";
        try{
            
             if (this.conexao.conectar()) {
             PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql); 
             sentenca.setInt(1, aluno.getAlunoID());
           
             ResultSet resultadoSentenca = sentenca.executeQuery();
             
             if(resultadoSentenca.next()) {
                
                 aluno.setNome(resultadoSentenca.getString("nome"));
                 aluno.setCurso(resultadoSentenca.getString("curso"));
                 aluno.setNecessidade(resultadoSentenca.getString("necessidade"));
                 aluno.setAlunoID(resultadoSentenca.getInt("alunoID"));              
                 }
             return aluno;
                 } 
        }catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno;
        }

    public Aluno buscarPorID(int id) {
        
        String sql = "SELECT * FROM aluno WHERE alunoid = ?";
        
        
        Aluno aluno = new Aluno();
        try{
            
             if (this.conexao.conectar()) {
             PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql); 
             sentenca.setInt(1, id);
           
             ResultSet resultadoSentenca = sentenca.executeQuery();
             
             if(resultadoSentenca.next()) {
                 
                 aluno.setNome(resultadoSentenca.getString("nome"));
                 aluno.setCurso(resultadoSentenca.getString("curso"));
                 aluno.setNecessidade(resultadoSentenca.getString("necessidade"));
                 aluno.setAlunoID(resultadoSentenca.getInt("alunoid"));        
                 aluno.setCodigoTurma(resultadoSentenca.getInt("codigoTurma"));
                 }
                
                 } 
             
        }catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno;
        }
    
    
    @Override
    public void atualizar(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ? , curso = ?, codigoTurma = ?, necessidade =? WHERE alunoID = ?";
        try {
            System.out.println("preparando sentença");
            if(this.conexao.conectar()){
            PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
            System.out.println("Sentença preparada");
            sentenca.setString(1, aluno.getNome());
            sentenca.setString(2, aluno.getCurso());
            sentenca.setInt(3,aluno.getCodigoTurma());
            sentenca.setString(4, aluno.getNecessidade());
            sentenca.setInt(5, aluno.getAlunoID());
            System.out.println("Aluno definido");
            sentenca.execute();
            sentenca.close();
            }
    }   catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void excluir(Aluno aluno){
        
        
        String sql = "delete from aluno where alunoid = ?";
        System.out.println("sql declarado");
        
        
        
        try {
            if(this.conexao.conectar()){
                PreparedStatement sentenca = this.conexao.getConnection().prepareStatement(sql);
                System.out.println("sentença declarada");
            
                System.out.println("Nome:" + aluno.getNome());
                System.out.println("ID:" + aluno.getAlunoID());
                sentenca.setInt(1, aluno.getAlunoID());
                sentenca.execute();
                sentenca.close();
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    
    
    
    
    

