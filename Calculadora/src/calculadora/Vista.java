package calculadora;

import java.awt.*;

import javax.swing.*;

public class Vista extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton[] botones1;
	private JButton[] botones2;
	private JLabel res;
	private JTextField pantalla;
	
	private void crearComponentes() {
		this.botones1 = new JButton[12];
		for(int i=1; i<10; i++) {
			this.botones1[i-1]=new JButton(""+i);
		}
		this.botones1[9]=new JButton(""+0);
		this.botones1[10]=new JButton(".");
		this.botones1[11]=new JButton("=");
		JButton[] op= {new JButton("+"), new JButton("-"), new JButton("*"), new JButton("/")};
		this.botones2=op;
		this.res = new JLabel("Resultaod:");
		this.pantalla=new JTextField(15);
		this.pantalla.setEditable(true);
		this.pantalla.setFocusable(false);
		this.pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
	}
	
	public Vista() {
		this.crearComponentes();
		JPanel norte = new JPanel(new BorderLayout());
			norte.add(this.res, BorderLayout.NORTH);
			norte.add(pantalla, BorderLayout.CENTER);
		JPanel centro = new JPanel();
			JPanel izq = new JPanel(new GridLayout(4,3));
				for(int i=0; i<this.botones1.length; i++) {
					izq.add(this.botones1[i]);
				}
			JPanel der = new JPanel(new GridLayout(4,1));
				for(int i=0; i<this.botones2.length; i++) {
					der.add(this.botones2[i]);
				}
			centro.add(izq);
			centro.add(der);
		this.setLayout(new BorderLayout());
		this.add(norte, BorderLayout.NORTH);
		this.add(centro, BorderLayout.CENTER);
	}
	
	public void control(Controlador ctr) {
		for(int i=0; i<this.botones1.length; i++) {
			this.botones1[i].addActionListener(ctr);
		}
		for(int i=0; i<this.botones2.length; i++) {
			this.botones2[i].addActionListener(ctr);
		}
	}

	public JButton[] getBotones1() {
		return botones1;
	}
	
	public JButton getBotones1(int n) {
		return botones1[n];
	}
	
	public String getBotones1Text(Object n) {
		n = (JButton) n;
		return ((AbstractButton) n).getText();
	}

	public JButton[] getBotones2() {
		return botones2;
	}
	
	public JButton getBotones2(int n) {
		return botones2[n];
	}

	public JLabel getRes() {
		return res;
	}

	public JTextField getPantalla() {
		return pantalla;
	}

	public void setBotones1(JButton[] botones1) {
		this.botones1 = botones1;
	}

	public void setBotones2(JButton[] botones2) {
		this.botones2 = botones2;
	}

	public void setRes(JLabel res) {
		this.res = res;
	}

	public void setPantalla(JTextField pantalla) {
		this.pantalla = pantalla;
	}
	
}
