package pratica;

public class Real extends Moeda {
	
	public Real(double valor) {
		super(valor); // valor é herdado da superclasse Moeda
		super.valor = valor;
	}
	
	// Uso o polimorfismo de subtipagem ao sobreescrever uma info() própria para cada subclasse: Real, Dolar e Euro.
	@Override
	public void info() {
		System.out.printf("R$%3.2f\n", super.valor);		
	}
	
	// Outro caso de polimorfismo paramétrico
	@Override
	public double converter() {
		return super.valor;
	}
}
