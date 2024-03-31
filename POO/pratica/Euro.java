package pratica;

public class Euro extends Moeda {
	
	public Euro(double valor) {
		super(valor);
		super.valor = valor;
	}
	
	@Override
	public void info() {
		System.out.printf("€%3.2f\n", super.valor);		
	}
	
	@Override
	public double converter() {
		// Pela cotação em 30/03/2024: €1,00 = R$5,42
		return super.valor * 5.42;
	}
}
