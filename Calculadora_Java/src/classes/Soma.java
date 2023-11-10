package classes;

public class Soma extends Operacao{
	public Soma() {
		super("Soma");
	}
	
	public static String getNome() { return nomeOperacao; }
	
	public static double somar(double n1, double n2) {return n1 + n2;}
	
}
