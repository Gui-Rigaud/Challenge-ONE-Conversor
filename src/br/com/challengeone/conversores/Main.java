package br.com.challengeone.conversores;

import br.com.challengeone.conversores.moeda.*;
import br.com.challengeone.conversores.medidas.*;

public class Main {

	public static void main(String[] args) {

		Mostra mostra = new Mostra();
		int controle = 0;
		Object[] options = { "Conversor de Moeda", "Conversor de Medidas" };
		Object opcao;
		Object valor;

		do {
			opcao = mostra.select("Escolha um conversor: ", "Menu", options);

			if (opcao == null) {
				int confirmou = mostra.confirma("Voc� deseja continuar?", "Selecione uma op��o");

				if (confirmou != 0) {
					mostra.mensagem("Programa finalizado");
					break;
				}
			}else {

				valor = mostra.input("Digite o valor: ");
				
				if (valor != null) {
					if(opcao == "Conversor de Moeda") {
						new TelaMoeda(valor);
					}else if(opcao == "Conversor de Medidas") {
						new TelaMedida(valor);
					}
				}else {
					mostra.erro("Valor inv�lido! Tente novamente");
				}
	
				int result = mostra.confirma("Voc� deseja continuar?", "Selecione uma op��o");
	
				if (result != 0) {
					controle = 1;
					mostra.mensagem("Programa finalizado");
				}
			}

		} while (controle == 0);

	}

}
