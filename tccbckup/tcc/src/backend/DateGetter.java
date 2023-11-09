/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Joaov
 */
public class DateGetter {
    public static String getDate(){
        String data = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm:ss").format(LocalDateTime.now());
        return data;
    }
    
    public static String titleGenerator(String cb_title){
        //turma + nome + data
        return cb_title + " | " + getDate();
    }
}
