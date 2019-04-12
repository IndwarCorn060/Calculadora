package calculadoraProfe;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Vista extends JPanel{

	private static final long serialVersionUID = 1L;

	/**
	 * Variables de instancia
	 */
	private JButton [] bDigitos;  // Array con los dígitos del 0 al 9
	private JButton [] bOperadores;  // Array con los operadores +, -, *, /
	private JButton bPunto, bIgual;
	private JTextField tfRdo;
	
	
	/**
	 * Constructor
	 */
	public Vista() {
		
		// -------------------------------------------------------------
		// Preparar paneles con los distintos componentes
		// -------------------------------------------------------------
		   // Preparar un panel con los dígitos, el punto y el igual
		   JPanel pCentro = preparaPanelCentro(); 
		
		   // Preparar un panel con los operadores
		   JPanel pEste = preparaPanelEste();	
		   
		   // Preparar un panel con el visor de resultados 
		   JPanel pResultado = preparaPanelResultado();
		
		   
		// -------------------------------------------------------------
		// Crear un panel donde colocaremos los paneles anteriores
		// -------------------------------------------------------------
		JPanel panelPrincipal = new JPanel(new BorderLayout(5,5));
		panelPrincipal.add(pCentro, BorderLayout.CENTER);
		panelPrincipal.add(pEste, BorderLayout.EAST);
		panelPrincipal.add(pResultado, BorderLayout.NORTH);
		
		// Colocar el panel principal sobre el panel implícito (this)
		this.add(panelPrincipal);
	}
	
	
	
	/**
	 * Este método se encargará de preparar un panel que ontendrá los 
	 * 10 dígitos numéricos (0 a 9), el operador punto y el igual
	 * 
	 * @return --> JPanel
	 */
	private JPanel preparaPanelCentro() {
		
		// Pedir memoria para el array
		this.bDigitos = new JButton[10];
		
		// Crear los componentes del array de dígitos
		for (int i=0; i<bDigitos.length; i++) {
			bDigitos[i] = new JButton(String.valueOf(i));
			bDigitos[i].setBackground(Color.cyan);
			bDigitos[i].setBorder(new BevelBorder(BevelBorder.RAISED));
		}
		
		// Crear los botones punto e igual
		this.bPunto = new JButton(".");
		this.bIgual = new JButton("=");
		this.bPunto.setBorder(new BevelBorder(BevelBorder.RAISED));
		this.bIgual.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		// Crear un panel para colocar los botones 
		JPanel p = new JPanel(new GridLayout(4,3));
		
		for (int i=1; i<bDigitos.length; i++)  // Añadir los botones del 1 al 9
			p.add(bDigitos[i]);
		
		p.add(bPunto);
		p.add(bDigitos[0]);
		p.add(bIgual);
		
		return p;
		
	}
	
	

	/**
	 * Prepara el panel con los 4 operadores (+, -, *, /)
	 * @return --> JPanel
	 */
	private JPanel preparaPanelEste() {
		
		// Pedir memoria para el array
		this.bOperadores = new JButton[4];
		
		bOperadores[0] = new JButton(" + ");
		bOperadores[1] = new JButton(" - ");
		bOperadores[2] = new JButton(" * ");
		bOperadores[3] = new JButton(" / ");
		
		// Asignar con setActionCommand "alias" o "nombres" a estos
		// botones pra evitar después problemas con los espacios en el 
		// texto de los botones
		bOperadores[0].setActionCommand("+");
		bOperadores[1].setActionCommand("-");
		bOperadores[2].setActionCommand("*");
		bOperadores[3].setActionCommand("/");
		
	/*	for (int i=0; i<bOperadores.length; i++) 
			bOperadores[i].setActionCommand
			    (String.valueOf(bOperadores[i].getText().charAt(1)));
		*/
		
		// Crear un tipo de fuente nuevo
		Font fuente = new Font("Courier", Font.PLAIN, 14);
		
		// Preparar un panel para colocar los botones anteriores
		// También les pondremos un borde a los botones
		JPanel p = new JPanel(new GridLayout(4,1));
		for (int i=0; i<bOperadores.length; i++) {
			bOperadores[i].setBorder(new BevelBorder(BevelBorder.RAISED));
			bOperadores[i].setFont(fuente);
			p.add(bOperadores[i]);
		}
		
		return p;
	}
	
	

	/**
	 * Prepara el panel con el visor de resultados
	 * @return
	 */
	private JPanel preparaPanelResultado() {
		
		// Pedir memoria para el JTextField
		this.tfRdo = new JTextField("",10);
		
		// Poner el JTextField no editable, y alineado a la derecha
		tfRdo.setEditable(false);
		tfRdo.setBackground(Color.white);
		tfRdo.setHorizontalAlignment(SwingConstants.RIGHT);
		
		// Preparar el panel en el que colocar el JTextField
		JPanel p = new JPanel();
		p.setBorder(new TitledBorder("Resultado"));
		p.add(tfRdo);
		
		return p;
	}
	
	
	
	/**
	 * Métodos getter
	 */
	public JButton[] getbDigitos() {return bDigitos;}
	public JButton[] getbOperadores() {return bOperadores;}
	public JButton getbPunto() {return bPunto;}
	public JButton getbIgual() {return bIgual;}
	public JTextField getTfRdo() {return tfRdo;}


	/**
	 * Método añade control a los componentes (de focus, de teclado y de action)
	 * @param ctr
	 */
	public void control(Controlador ctr) {
		
		// Añadir control a los botones de los dígitos
		for (int i=0; i<this.bDigitos.length; i++) {
			bDigitos[i].addActionListener(ctr);
			bDigitos[i].addKeyListener(ctr);
			bDigitos[i].addFocusListener(ctr);
		}
		
		// Añadir control a los botones de los operadores
		for (int i=0; i<this.bOperadores.length; i++) {
			bOperadores[i].addActionListener(ctr);
			bOperadores[i].addKeyListener(ctr);
			bOperadores[i].addFocusListener(ctr);
		}
		
		// Añadir control a los botones punto e igual
		bPunto.addActionListener(ctr);
		bPunto.addKeyListener(ctr);
		bPunto.addFocusListener(ctr);
		bIgual.addActionListener(ctr);
		bIgual.addKeyListener(ctr);
		bIgual.addFocusListener(ctr);
	
		/* 
		 * Hay que añadirle control al JTextField porque sino la 
		 * calculadora no empieza a funcionar con el teclado
		 * hasta que se pulsa algún botón con el ratón
		 */
		tfRdo.addKeyListener(ctr);
	}
}









