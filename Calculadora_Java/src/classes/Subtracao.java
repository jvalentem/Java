package classes;

public class Subtracao extends Operacao {

	public Subtracao() {
		super("Subtração");
	}
	
	public static String getNome() { return nomeOperacao; }
	public static double subtrair(double n1, double n2) { return n1 - n2; }
	
	

}
