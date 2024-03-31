package pratica;

public abstract class Moeda {
	public double valor;
	
	// Escrevi este construtor para remover o construtor vazio e forçar as subclasses a ter um construtor com valor.
	public Moeda(double valor) {
		super();
		this.valor = valor;
	}
    
	public abstract void info();
	
	public abstract double converter();
}
