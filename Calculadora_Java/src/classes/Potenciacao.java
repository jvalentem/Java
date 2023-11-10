package classes;
import java.math.*;
public class Potenciacao extends Operacao {
	
	
	public Potenciacao() {
		super("Potenciacao");
		
	}
	public static String getNome() { return nomeOperacao; }
	
	public static double elevar(double n1, double n2) {return Math.pow(n1, n2);}
}
