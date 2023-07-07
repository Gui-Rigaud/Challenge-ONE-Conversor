package br.com.challengeone.conversores.medidas;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ConvertMedida {
	
	private double res;
	private double valorEmMetros;
	
	public double comprimento(String converteDe, String convertePara, double valor) {
		
		if(converteDe == "mi" || convertePara == "mi") {
			if(converteDe == "mi") {
				this.res = valor / (multiplicador(converteDe) * multiplicador(convertePara));
				this.res = arredonda(this.res);
			}else if(convertePara == "mi") {
				this.valorEmMetros = valor * multiplicador(converteDe);
				this.res = this.valorEmMetros * multiplicador(convertePara);
			}
		}else {
			this.valorEmMetros = valor * multiplicador(converteDe);
			this.res = this.valorEmMetros / multiplicador(convertePara);
		}
		return this.res;
	}
	
	public double multiplicador(String med) {
		double mult = 0.0;
		
		switch(med) {
			case "km":
				mult = 1000.0;
				break;
			case "hm":
				mult = 100.0;
				break;
			case "dam":
				mult = 10.0;
				break;
			case "m":
				mult = 1.0;
				break;
			case "dm":
				mult = 0.1;
				break;
			case "cm":
				mult = 0.01;
				break;
			case "mm":
				mult = 0.001;
				break;
			case "mi":
				mult = 0.000622;
				break;
			default:
				break;
		}
		
		return mult;
	}
	
	public double arredonda(double valor) {
		BigDecimal bd = new BigDecimal(valor).setScale(2, RoundingMode.HALF_EVEN);
		return bd.doubleValue();
	}
	
}
