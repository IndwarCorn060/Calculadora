package calculadora;

import javax.swing.JOptionPane;

public class Operaciones {
	
	private double n1;
	private double n2;
	private char op;
	
	public Operaciones(String n1, char op) {
		try {
			this.n1=Double.parseDouble(n1);
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Datos mal introducidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		this.op=op;
	}
	
	public double Suma(String n2) {
		try {
			this.n2=Double.parseDouble(n2);
			return this.n1+this.n2;
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Datos mal introducidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return 0;
	}
	

}
