package br.com.challengeone.conversores.moeda;

import javax.swing.*;

public class Mostra extends JOptionPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4057321423999125362L;
	
	public Object input(String msg) {
		return showInputDialog(null, msg);
	}

	public Object select(String msg, String title, Object[] options) {
		return showInputDialog(null, msg
				, title, JOptionPane.PLAIN_MESSAGE, null,
				options, options[0]);
		
	}
	
	public void mensagem(Object msg) {
		showMessageDialog(null, msg);
	}
	
	public int confirma(String msg, String title) {
		return showConfirmDialog(null, msg, title, YES_NO_OPTION);
	}
	
	public void erro(String errorMsg) {
		showMessageDialog(null, errorMsg, "Erro", ERROR_MESSAGE);
	}
}
