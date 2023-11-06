package backend;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FuncTelaRegistro {
	public static void limpaDados(JTextField input1, JTextField input2, JPasswordField input3, JPasswordField input4 ) {
		input1.setText("");
		input2.setText("");
		input3.setText("");
		input4.setText("");
	}
	
	public static String charToString(char[] character) {
		String senha = "";
		for(int i = 0; i < character.length; i++) {
			senha += character[i];
		}
		return senha;
	}
}
