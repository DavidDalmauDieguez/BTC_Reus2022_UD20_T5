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
