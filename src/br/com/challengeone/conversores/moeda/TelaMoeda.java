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

			Object[] moedas = { "De Reais para Dólares", "De Reais para Euros", "De Reais para Libras",
					"De Reais para Iene Japonês", "De Reais para Peso Argentino", "De Reais para Peso Uruguaio",
					"De Dólares para Reais", "De Euros para Reais", "De Libras para Reais",
					"De Iene Japonês para Reais" };

			Object opt = mostra.select("Escolha a moeda para a qual deseja converter seu dinheiro", "Moedas",
					moedas);
			
			if(opt != null) {
				switch ((String) opt) {
					case "De Reais para Dólares":
						convert = new Conversoes("USDBRL");
						resultado = convert.realToX(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado é $ " + resultado);
						break;
					case "De Reais para Euros":
						convert = new Conversoes("EURBRL");
						resultado = convert.realToX(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado é € " + resultado);
						break;
					case "De Reais para Libras":
						convert = new Conversoes("GBPBRL");
						resultado = convert.realToX(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado é £ " + resultado);
						break;
					case "De Reais para Iene Japonês":
						convert = new Conversoes("JPYBRL");
						resultado = convert.realToX(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado é ¥ " + resultado);
						break;
					case "De Reais para Peso Argentino":
						convert = new Conversoes("ARSBRL");
						resultado = convert.realToX(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado é AR$ " + resultado);
						break;
					case "De Reais para Peso Uruguaio":
						convert = new Conversoes("UYUBRL");
						resultado = convert.realToX(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado é $U " + resultado);
						break;
					case "De Dólares para Reais":
						convert = new Conversoes("USDBRL");
						resultado = convert.xToReal(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado é R$ " + resultado);
						break;
					case "De Euros para Reais":
						convert = new Conversoes("EURBRL");
						resultado = convert.xToReal(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado é R$ " + resultado);
						break;
					case "De Libras para Reais":
						convert = new Conversoes("GBPBRL");
						resultado = convert.xToReal(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado é R$ " + resultado);
						break;
					case "De Iene Japonês para Reais":
						convert = new Conversoes("JPYBRL");
						resultado = convert.xToReal(valorDouble);
						resultado = arredonda(resultado);
						mostra.mensagem("O resultado é R$ " + resultado);
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
