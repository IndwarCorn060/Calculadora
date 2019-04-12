package calculadora;

import java.awt.event.*;

import javax.swing.JOptionPane;


public class Controlador implements ActionListener {
	
	private Vista mivista;
	
	public Controlador(Vista v) {
		this.mivista = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		double n1, n2;
		Operaciones op ;
		if(e.getSource()==this.mivista.getBotones2(0)) {
			op = new Operaciones(this.mivista.getPantalla().getText(),this.mivista.getBotones2(0).getText().charAt(0));
			this.mivista.getPantalla().setText(null);
		}
		else if(e.getSource()==this.mivista.getBotones2(1)) {
			op = new Operaciones(this.mivista.getPantalla().getText(),this.mivista.getBotones2(0).getText().charAt(0));
		}
		else if(e.getSource()==this.mivista.getBotones2(2)) {
			op = new Operaciones(this.mivista.getPantalla().getText(),this.mivista.getBotones2(0).getText().charAt(0));
		}
		else if(e.getSource()==this.mivista.getBotones2(3)) {
			op = new Operaciones(this.mivista.getPantalla().getText(),this.mivista.getBotones2(0).getText().charAt(0));
		}
		else if(e.getSource()==this.mivista.getBotones1(11)) {
			//this.mivista.getPantalla().setText(op.Suma(this.mivista.getPantalla().getText())+"");
		}
		else {
			this.mivista.getPantalla().setText(this.mivista.getPantalla().getText()+this.mivista.getBotones1Text(e.getSource()));
		}
	}

	

}
