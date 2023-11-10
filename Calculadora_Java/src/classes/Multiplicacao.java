package classes;

public class Multiplicacao extends Operacao {

	public Multiplicacao() {
		super("Multiplicacao");
	}
	public static String getNome() { return nomeOperacao; }
	
	public static double multiplicar(double n1, double n2) {return n1 * n2;}
}
