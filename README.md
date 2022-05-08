<table>
 <tr>
    <td> <img src="https://github.com/OctavioBernalGH/BTC_Reus2022_UD16/blob/main/dou_logo.png" alt="Team DOU"/></td>
    <td><h1>Ejercicio UD20 T05</h1></td>
  
 </tr>
</table>
 
<hr>
 
[![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white&labelColor=101010)]()
[![GitHub](https://img.shields.io/badge/GITHUB-%20-yellow)]()
<br>
Este ejercicio ha sido realizado por los miembros del equipo 1. Dicho equipo esta formado por:

  [- J.Oriol López Bosch](https://github.com/mednologic)<br>
  [- Octavio Bernal](https://github.com/OctavioBernalGH)<br>
  [- David Dalmau](https://github.com/DavidDalmauDieguez)
  

  
<p align="justify">En este ejercicio se pide crear una aplicación gráfica mediante JFrameForm con una ventana que tenga un botón y un área de texto. La aplicación debe reflejar en el área de texto todos los eventos de ratón que se produzcan sobre dicha área de texto por las interacciones del usuario. Haciendo click en el botón se limpiará el contenido del área de texto.</p>

![UD20-T5](https://user-images.githubusercontent.com/103035621/167313536-cf750c24-c7e9-489c-8b4a-bb09557b23e4.png)


<p align="justify">En la imagen anterior se resume de forma breve los eventos generados en la aplicación. Para realizar este ejercicio se han creado dos clases, la clase App.java y la TA5.java</p>

En la siguiente clase se introduce el código necesario para dar visibilidad al JFrame.
<details>
  <summary>En este spoiler se muestra el código creado en la Clase App.java</summary>
<br>

  ```java
package com.dou.ud20.t2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )    {
    	TA5 ta5 = new TA5();
        ta5.setVisible(true);
    }
}

  ```
 </details>
 
En la siguiente clase se introduce el código referente a la vista, a la creación de los componentes y sus eventos. 
 
 <details>
  <summary>En este spoiler se muestra el código creado en la Clase TA5.java</summary>
<br>

  ```java
package com.dou.ud20.t2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class TA5 extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TA5 frame = new TA5();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */	

	public TA5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		MouseListener listenerRaton = new listenerRaton();
		textArea.addMouseListener(listenerRaton);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});		
		
		btnLimpiar.setBounds(217, 11, 89, 23);
		contentPane.add(btnLimpiar);


		textArea.setBounds(10, 39, 520, 303);
		contentPane.add(textArea);		

	}	
	
	class listenerRaton extends MouseInputAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			textArea.append("\nHas hecho clic en");
			textArea.append("\nPosicion X: " + e.getX());
			textArea.append("\nPosicion Y: " + e.getY());

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// Operacion con bits
			if (((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0)) {
				textArea.append("\nPulsado el botón derecho");
			}

			textArea.append("\nSe ha pulsado el botón");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			textArea.append("\nSe ha soltado el botón");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			textArea.append("El ratón ha entrado en el texto \n");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			textArea.append("El ratón ha salido del texto \n");
		}
	}
}

  ```
 </details>
