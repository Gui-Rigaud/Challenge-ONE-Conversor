package br.com.challengeone.conversores.moeda;

import java.math.*;

public class TelaMoeda {
	
	public TelaMoeda(Object valor) {
		Mostra mostra = new Mostra();
		String valorTratado;
			
		valorTratado = valor.toString();
		
		if (isNumeric(valorTratado)) {
			double valorDouble = Double.parseDouble(valorTratado);

			Conversoes convert;

			double resultado = 0.0;

			Object[] moedas = { "De Reais para D�lares", "De Reais para Euros", "De Reais para Libras",
					"De Reais para Iene Japon�s", "De Reais para Peso Argentino", "De Reais para Peso Uruguaio",
					"De D�lares para Reais", "De Euros para Reais", "De Libras para Reais",
					"De Iene Japon�s para Reais" };

			Object opt = mostra.select("Escolha a moeda para a qual deseja converter seu dinheiro", "Moedas",
					moedas);
			
			if(opt != null) {
				switch ((String) opt) {
					case "De Reais para D�lares":
						convert = new Conversoes("USDBRL");
						resultado = convert.realToX(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado � $ " + resultado);
						break;
					case "De Reais para Euros":
						convert = new Conversoes("EURBRL");
						resultado = convert.realToX(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado � � " + resultado);
						break;
					case "De Reais para Libras":
						convert = new Conversoes("GBPBRL");
						resultado = convert.realToX(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado � � " + resultado);
						break;
					case "De Reais para Iene Japon�s":
						convert = new Conversoes("JPYBRL");
						resultado = convert.realToX(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado � � " + resultado);
						break;
					case "De Reais para Peso Argentino":
						convert = new Conversoes("ARSBRL");
						resultado = convert.realToX(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado � AR$ " + resultado);
						break;
					case "De Reais para Peso Uruguaio":
						convert = new Conversoes("UYUBRL");
						resultado = convert.realToX(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado � $U " + resultado);
						break;
					case "De D�lares para Reais":
						convert = new Conversoes("USDBRL");
						resultado = convert.xToReal(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado � R$ " + resultado);
						break;
					case "De Euros para Reais":
						convert = new Conversoes("EURBRL");
						resultado = convert.xToReal(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado � R$ " + resultado);
						break;
					case "De Libras para Reais":
						convert = new Conversoes("GBPBRL");
						resultado = convert.xToReal(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado � R$ " + resultado);
						break;
					case "De Iene Japon�s para Reais":
						convert = new Conversoes("JPYBRL");
						resultado = convert.xToReal(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado � R$ " + resultado);
						break;
					default:
						break;
				}
			}
		}
	}
			
	public boolean isNumeric(String str) {
		return str != null && str.matches("[0-9]*");
	}

	public double arredonda(double valor) {
		BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_EVEN);
		return bd.doubleValue();
	}
	
}
