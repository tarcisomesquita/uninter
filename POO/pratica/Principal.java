package pratica;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal {
	// defini como variáveis globais para eu usar em vários métodos desta classe
	private static Scanner teclado = new Scanner(System.in);
	private static Moeda m;
	// Moeda é abstract, mas a uso como referência para usar o polimorfismo paramétrico
	
	public static void main(String[] args) {
		System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
		System.out.println("Software Cofrinho");
		System.out.println("Autor: Tarciso Mesquita de Oliveira");
		System.out.println("RA: 980158");
		System.out.println("Prática da disciplina Programacao Orientada a Objetos");
		System.out.println("Curso: Engenharia de Software na UNINTER");
		System.out.println("Ano: 2024");
		System.out.println("https://github.com/tarcisomesquita/uninter/POO/");
		
		Cofrinho cofre = new Cofrinho();
		
		int opcao;
		
		while(true) {
			// Na interface com o usuário, cada linha tracejada é como se fosse a separação para janela
			System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
			System.out.println("1 - Adicionar moeda ao cofrinho");
			System.out.println("2 - Remover moeda do cofrinho");
			System.out.println("3 - Listar todas as moedas no cofrinho");
			System.out.println("4 - Calcular valor em Real no cofrinho");
			System.out.println("0 - Encerrar programa");
			System.out.println("");
			System.out.print("Digite o numero da opcao: ");
			try {
				opcao = teclado.nextInt();
			}
			catch (InputMismatchException e) {
				// um usuário pode pressionar qualquer tecla, então tento cuidar disso
				System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
				System.out.println("Digitou valor invalido: " + teclado.next());
				continue;
			}
			
			// Sei que aqui eu poderia usar um enum e switch, mas optei pela simplicidade do código com apenas if else
			if (opcao == 0) {
				System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
				System.out.println("Programa encerrado");
				break;
			}
			else if (opcao == 1) {
				if (! gerarMoeda()) continue;
				
				cofre.adicionar(m);
			}
			else if (opcao == 2) {
				if (! gerarMoeda()) continue;
				
				cofre.remover(m);
			}
			else if (opcao == 3) cofre.listagemMoedas();
			else if (opcao == 4) cofre.totalConvertido();
			// Optei por não usar acentos devido à diferenças entre sistemas.
            // Inclusive uso Linux e provavelmente isto será testado em Windows.
			else {
				System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
				System.out.printf("%d eh opcao invalida\n", opcao);
			}
		}
		teclado.close();
	}
	
	/* Os métodos gerarMoeda(), lerTipo(), lerValor() e checarValor() não estavam como prerequisito desta pratica,
	 * porém, os criei principalmente para evitar repetição de código.
	*/ 
	
	private static boolean gerarMoeda() {
		String tipo = lerTipo();
		if (tipo == "menu") return false;
		
		double valor = lerValor(tipo);
		
		// Exemplo de uso de polimorfismo paramétrico para Moeda m
		if (tipo == "real") m = new Real(valor);
		else if (tipo == "dolar") m = new Dolar(valor);
		else if (tipo == "euro") m = new Euro(valor);
		else return false;
		
		return true;
	}
	
	private static String lerTipo() {
		int opcao;
		
		while(true) {
			System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
			System.out.println("1 - Real");
			System.out.println("2 - Dolar");
			System.out.println("3 - Euro");
			System.out.println("0 - Retornar ao menu anterior");
			System.out.println("");
			System.out.print("Digite o numero da opcao: ");
			try {
				opcao = teclado.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
				System.out.println("Digitou valor invalido: " + teclado.next());
				continue;
			}
			
			if (opcao == 0) return "menu";
			else if (opcao == 1) return "real";
			else if (opcao == 2) return "dolar";
			else if (opcao == 3) return "euro";
			else {
				System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
				System.out.printf("%d eh opcao invalida\n", opcao);
			}
		}
	}
	
	private static double lerValor(String tipo) {
		while(true) {
			System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
			
			// É sempre importante avisar o usuário sobre o que ele pode digitar
			if (tipo == "real" || tipo == "dolar") System.out.println("Moedas: 0.01; 0.05; 0.10; 0.25; 0.50; 1.00");
			else System.out.println("Moedas: 0.01; 0.02; 0.05; 0.10; 0.20; 0.50; 1.00; 2.00");
			
			System.out.print("\nDigite o valor da moeda: ");
			
			double opcao;
			try {
				opcao = teclado.nextDouble();
			}
			catch (InputMismatchException e) {
				System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
				System.out.println("Digitou valor invalido: " + teclado.next());
				continue;
			}
			
			if (checarValor(tipo, opcao)) return opcao;
			else {
				System.out.print("\n = = = = = = = = = = = = = = = = = = = =\n\n");
				System.out.printf("%3.2f eh um valor invalido\n", opcao);
			}
		}
	}
	
	// É sempre importante checar se o usuário digitou valores válidos
	private static boolean checarValor(String tipo, double valor) {
		if (
			(tipo == "real" || tipo == "dolar") && 
			(valor == 0.01 || valor == 0.05 || valor == 0.10 || valor == 0.25 || valor == 0.50 || valor == 1.00)
		) return true;
		else if (
			tipo == "euro" && 
			(valor == 0.01 || valor == 0.02 || valor == 0.05 || valor == 0.10 || 
			 valor == 0.20 || valor == 0.50 || valor == 1.00 || valor == 2.00)
		) return true;
		
		return false;
	}
}
