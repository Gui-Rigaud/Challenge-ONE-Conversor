package br.com.challengeone.conversores.medidas;

import br.com.challengeone.conversores.moeda.*;

public class TelaMedida{
	
	public TelaMedida(Object valor) {
		Mostra mostra = new Mostra();
		Object converteDe;
		Object convertePara;
		Object[] options = {"km", "hm", "dam", "m", "dm", "cm", "mm", "mi"};
		
		String valorT, converteDeT, converteParaT;
		double resultado = 0.0;
		
		if (valor != null) {
			
			valorT = valor.toString();
			
			if (isNumeric(valorT)) {
				converteDe = mostra.select("Escolha a medida do valor informado", "Medida de Entrada", options);				
				convertePara = mostra.select("Escolha a medida a qual seu valor será convertido", "Medida de Saída", options);
				
				if(converteDe != null && convertePara != null) {
					converteDeT = converteDe.toString();
					converteParaT = convertePara.toString();		
				
					double valorDouble = Double.parseDouble(valorT);
					ConvertMedida convert = new ConvertMedida();
					
					resultado = convert.comprimento(converteDeT, converteParaT, valorDouble);
					
					mostra.mensagem("O resultado é " + resultado + " " +  converteParaT);
				}else {
					mostra.erro("Escolha as duas medidas!");
				}
				
			}else {
				mostra.erro("Valor inválido! Tente novamente");
			}
		}
	}
	
	public boolean isNumeric(String str) {
		return str != null && str.matches("[0-9]*");
	}
	
}
