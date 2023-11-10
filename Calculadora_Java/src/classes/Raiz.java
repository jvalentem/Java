package classes;
import java.math.*;
public class Raiz extends Operacao {

	public Raiz() {
		super("Radiciação");
		
	}

	public static String getNome() { return nomeOperacao; }
	
	public static double quadradaDe(double n1) {return Math.sqrt(n1);}
}
