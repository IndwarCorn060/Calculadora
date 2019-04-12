package calculadora;
import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Crear un objeto Vista (Diseña el GUI)
				Vista miVista = new Vista();
				
				// Crear un objeto Controlador (programa los eventos)
				Controlador ctr = new Controlador(miVista);

				// Llamar al método que añade "control" a los componentes
				miVista.control(ctr);
				
				// Crear el objeto Ventana (JFrame)
				JFrame ventana = new JFrame("Eventos tipo check, combo y lista");
				ventana.setContentPane(miVista);
				ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ventana.pack();
				ventana.setVisible(true);

	}

}
