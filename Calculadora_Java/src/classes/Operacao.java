package classes;

public abstract class Operacao {
	
	protected static String nomeOperacao;
	public Operacao(String nomeOperacao) {
		this.nomeOperacao = nomeOperacao;
	}
	
	public static String getNome() { return nomeOperacao; }
	
}
