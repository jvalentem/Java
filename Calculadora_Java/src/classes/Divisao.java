package classes;

public class Divisao extends Operacao {

	public Divisao() {
		super("Divisão");
				
	}
	
	public static String getNome() {return nomeOperacao;}

	public static double dividir(double n1, double n2) {return n1 / n2;}
	
	
}
