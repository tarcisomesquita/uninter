package pratica;

import java.util.ArrayList;

public class Cofrinho {
	private ArrayList<Moeda> listaMoedas = new ArrayList<Moeda>();
	
	public void adicionar(Moeda m) {
		listaMoedas.add(m);
		System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\nMoeda adcionada\n");
	}
	
	public void remover(Moeda retirar) {
		System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
		// Lido com o fato do objeto retirar não fazer parte do array listaMoedas. Então comparo os conteúdos.
		for (Moeda m: listaMoedas) {
			// Uso a herança dos métodos nativos das classes Objeto e Classe
			if (m.getClass().getName() == retirar.getClass().getName() && m.valor == retirar.valor) {
				listaMoedas.remove(m);
				System.out.println("Moeda retirada");
				return;
			}
		}
		
		System.out.println("Nao tem a moeda solicitada no cofrinho");
	}
	
	public void listagemMoedas() {
		System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
		System.out.println("Lista de moedas no cofrinho:");
		
		for (Moeda m: listaMoedas) m.info();
	}
	
	public void totalConvertido() {
		double total = 0;
		
		for (Moeda m: listaMoedas) total += m.converter();
		
		System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
		System.out.printf("Total no cofrinho: R$%3.2f\n", total);
	}
}
