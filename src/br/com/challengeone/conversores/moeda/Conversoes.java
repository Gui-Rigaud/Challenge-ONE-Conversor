package br.com.challengeone.conversores.moeda;


public class Conversoes {
	
	private Moeda moedaSelected;
	
	CotacaoAPI api = new CotacaoAPI();
	
	public Conversoes() {
		
	}
	
	public Conversoes(String codOfConvertion) {
		this.moedaSelected = api.cotacao(codOfConvertion);
	}
	
	public double realToX(double valor) {
		return valor / this.moedaSelected.getHigh();
	}
	
	public double xToReal(double valor) {
		return valor * this.moedaSelected.getHigh();
	}
}
