/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import dao.*;
import java.util.ArrayList;
import model.*;
/**
 *
 * @author Joaov
 */
public class Autenticacao {
    
    ArrayList<Professor> professores = new ProfessorDAO().listar();
    ArrayList<Pedagogia> pedagogos = new PedagogiaDAO().listar();
    
    
     
    
     
    
    public boolean cadastrar(String user, String senha){return true;}
   
    
    public boolean loginProfessor(String user, String senha){
        for(int i=0;i<professores.toArray().length;i++){
      
                System.out.println("Nome do professor:" + user);
                System.out.println("Senha:" + senha);
                //se os inputs inseridos baterem com as informações de algum professor na lista, o método retorna true e a tela é aberta
                if(user.equals(professores.get(i).getNome()) 
                    && senha.equals(professores.get(i).getSenha())){   
                System.out.println("login sucessful");
                return true;
            
            }
        }
        return false;
    }
    
    public boolean loginPedagogia(String user, String senha){
       
        System.out.println("Nome do coordenador:" + user);
        for(int i=0;i<pedagogos.toArray().length;i++){
            
                //se os inputs inseridos baterem com as informações de algum professor na lista, o método retorna true e a tela é aberta
                if(user.equals(pedagogos.get(i).getNomePedagogo()) &&
                        senha.equals(pedagogos.get(i).getSenha())){
                    System.out.println("login sucessful");
                    return true;
                }
        }
        return false;
    }
    
    
    
    
 
    
}
