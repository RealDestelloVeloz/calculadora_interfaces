package calculadora;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CalculadoraFinal {
	static JFrame frame;
	JButton b0 = new JButton("0");
	static JTextField pantalla;
	public static void addComponentsToPane(Container pane) {
		pane.setLayout(null);
		//Creo el listener para los botones
		Escuchador botones = new Escuchador();
		pantalla = new JTextField(55);
		// CREO TODOS LOS BOTONES
		JButton b0 = new JButton("0");		
		JButton b1 = new JButton("1");		
		JButton b2 = new JButton("2");
		JButton b3 = new JButton("3");
		JButton b4 = new JButton("4");
		JButton b5 = new JButton("5");
		JButton b6 = new JButton("6");
		JButton b7 = new JButton("7");
		JButton b8 = new JButton("8");
		JButton b9 = new JButton("9");
		JButton C = new JButton("C");
		JButton punto = new JButton(".");
		JButton mas = new JButton("+");
		JButton igual = new JButton("=");
		JButton menos = new JButton("-");
		JButton equis = new JButton("X");
		JButton masMenos = new JButton("+/-");
		JButton dividir = new JButton("/");
		JButton borrar = new JButton("->");
		//////
		/// añado el listener a los botones 
		b0.addActionListener(botones);
		b1.addActionListener(botones);
		b2.addActionListener(botones);
		b3.addActionListener(botones);
		b4.addActionListener(botones);
		b5.addActionListener(botones);
		b6.addActionListener(botones);
		b7.addActionListener(botones);
		b8.addActionListener(botones);
		b9.addActionListener(botones);
		C.addActionListener(botones);
		punto.addActionListener(botones);
		menos.addActionListener(botones);
		igual.addActionListener(botones);
		mas.addActionListener(botones);
		equis.addActionListener(botones);
		masMenos.addActionListener(botones);
		dividir.addActionListener(botones);
		borrar.addActionListener(botones);
		//////
		
		
		
		//AÑADO LOS BOTONES AL PANEL
		
		pane.add(borrar);
		pane.add(masMenos);
		pane.add(dividir);
		pane.add(menos);
		pane.add(igual);
		pane.add(mas);
		pane.add(punto);
		pane.add(C);
		pane.add(b0);
		pane.add(b1);
		pane.add(b2);
		pane.add(b3);
		pane.add(b4);
		pane.add(b5);
		pane.add(b6);
		pane.add(b7);
		pane.add(b8);
		pane.add(b9);
		pane.add(equis);
////
		pane.add(pantalla);

		Insets insets = pane.getInsets();
		Dimension size = b1.getPreferredSize();
		size = pantalla.getPreferredSize();
//// COLOCO LA POSICION DE CADA BOTON
		pantalla.setBounds(25 + insets.left, 80 + insets.top, size.width - 250, size.height + 100);
		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		pantalla.setFont(font1);
		size = C.getPreferredSize();
		size.height = size.height + 15;
		size.width = size.height + 15;
		C.setBounds(25, 600, size.width, size.height);
		b0.setBounds(100, 600, size.width, size.height);
		punto.setBounds(175, 600, size.width, size.height);
		mas.setBounds(250, 600, size.width, size.height);
		igual.setBounds(325, 500, size.width, size.height + 100); // size.height+100
		igual.setBackground(Color.RED);
		b1.setBounds(25, 500, size.width, size.height);
		b2.setBounds(100, 500, size.width, size.height);
		b3.setBounds(175, 500, size.width, size.height);
		menos.setBounds(250, 500, size.width, size.height);
		b4.setBounds(25, 400, size.width, size.height);
		b5.setBounds(100, 400, size.width, size.height);
		b6.setBounds(175, 400, size.width, size.height);

		menos.setBounds(250, 500, size.width, size.height);
		equis.setBounds(250, 400, size.width, size.height);
		dividir.setBounds(325, 400, size.width, size.height);
		b7.setBounds(25, 300, size.width, size.height);
		b8.setBounds(100, 300, size.width, size.height);
		b9.setBounds(175, 300, size.width, size.height);
		masMenos.setBounds(250, 300, size.width, size.height);
		borrar.setBounds(325, 300, size.width, size.height);
////////////
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("AbsoluteLayoutDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addComponentsToPane(frame.getContentPane());

		Insets insets = frame.getInsets();
		frame.setSize(450 + insets.left + insets.right, 700 + insets.top + insets.bottom);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}

class Escuchador implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource(); //Hago un objeto que coja el evento escuchado
		JTextField pantallita = CalculadoraFinal.pantalla;  // Creo un objeto que apunte al JTextField estatico pantalla
		if (source instanceof JButton) { //SI el evento es un JButton
			JButton x = (JButton) source; //Creo un JButton con ese objeto
		String textoBoton = x.getText(); //Cojo su texto 
		
		
		/// AÑADO LOS CASOS EN LOS QUE LOS BOTONES NO SON NUMEROS
		if (textoBoton.equals("C")) {
			pantallita.setText("");
		}
		else if (textoBoton.equals("+/-")) {
			if (pantallita.getText().charAt(0) == '-') {
				StringBuilder build = new StringBuilder(pantallita.getText());
				build.deleteCharAt(0); 
				pantallita.setText(build.toString()); 
			}
			else
			pantallita.setText("-"+pantallita.getText()); 
		}
		
		else if (textoBoton.equals("->")) {
			StringBuilder build = new StringBuilder(pantallita.getText());
			build.deleteCharAt(build.length()-1); 
			pantallita.setText(build.toString()); 
			
		}
		else if (textoBoton.equals("=")) {
			pantallita.setText("Busca una calculadora de verdad");

		}
		//////////////////////
		//CUALQUIER CASO EN EL QUE EL BOTON ES UN NUMERO 
		else {
			pantallita.setText(pantallita.getText()+textoBoton); //Añado a la pantalla el texto 
		}
		
		
		
		}
	}

}