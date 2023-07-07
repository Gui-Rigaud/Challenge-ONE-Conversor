package br.com.challengeone.conversores.moeda;

import br.com.challengeone.conversores.moeda.utils.*;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class CotacaoAPI {
	
	private static String url = "https://economia.awesomeapi.com.br/json/last/USD-BRL,GBP-BRL,EUR-BRL,JPY-BRL,ARS-BRL,UYU-BRL,USD-BRL,EUR-BRL,GBP-BRL,JPY-BRL";

	public Moeda cotacao(String codigoConversao) throws JsonSyntaxException {
		
		Mostra mostra = new Mostra();
		
		HTTPClient http = new HTTPClient();
		String json = http.buscaDados(url);
		 
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Moeda>>(){}.getType();
		Map<String, Moeda> moedas = gson.fromJson(json,type);
		
		Moeda moedaSelected = moedas.get(codigoConversao);
		
		try {
		 
			if(moedaSelected != null) {
				return moedaSelected;
			}else {
				mostra.erro("Código de conversão inexistente no sistema!");
			}
		}catch(IllegalArgumentException e) {
			mostra.erro("Esta API não contem informações suficientes para a conversão selecionada");
		}
       
		return null;
	}
	
}
