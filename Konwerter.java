package Konwerter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Konwerter {

	private JFrame frame;
	private JTextField textIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Konwerter window = new Konwerter();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Konwerter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textIn = new JTextField();
		textIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textIn.setHorizontalAlignment(SwingConstants.RIGHT);
		textIn.setBounds(28, 28, 175, 32);
		frame.getContentPane().add(textIn);
		textIn.setColumns(10);
		
		JLabel lblOut = new JLabel("0");
		lblOut.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOut.setBounds(28, 87, 175, 32);
		
		frame.getContentPane().add(lblOut);
		
		JLabel lblOutHEX = new JLabel("0");
		lblOutHEX.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOutHEX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOutHEX.setBounds(28, 146, 175, 32);
		frame.getContentPane().add(lblOutHEX);
		
		
		JButton btnConvert = new JButton("Konwertuj");
		btnConvert.addActionListener(new ActionListener() {
			
			

			public void actionPerformed(ActionEvent arg0) {
				
				Integer[] tablicaBIN = new Integer[31];
				char[] tablicaHEX = new char[31];
				Integer userInput, userInputCopy;
				String outputBIN = "";
				String outputHEX = "";
				Integer i=0;
				Integer n=0;
				String symbols = "0123456789ABCDEF";
				
				
				try {
					userInput = Integer.parseInt(textIn.getText());	
					userInputCopy = userInput;
					do {
						tablicaBIN[i] = userInput % 2;
						i++;
						lblOut.setText(userInput.toString());
						userInput /= 2;

					} while (userInput != 0);
					
					for (int j=i-1; j>=0; j--) {
						outputBIN += tablicaBIN[j].toString();
					}
					lblOut.setText(outputBIN);
					
					do {
						
						if (userInputCopy > 15) {
							tablicaHEX[n] = symbols.charAt(userInputCopy%16);
							userInputCopy /= 16;
						} else {
							tablicaHEX[n] = symbols.charAt(userInputCopy);
							userInputCopy = 0;
						}
						n++;
					} while (userInputCopy != 0);
					
					for (int j=n-1; j>=0; j--) {
						outputHEX += tablicaHEX[j];
					}
					lblOutHEX.setText(outputHEX);
					
				}
				catch (Exception e) {
					lblOutHEX.setText("Exception!");
				}
				
			}
		});
		btnConvert.setBounds(273, 33, 89, 23);
		frame.getContentPane().add(btnConvert);
		
		
		
		JLabel lblNewLabel = new JLabel("DEC");
		lblNewLabel.setBounds(213, 46, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBin = new JLabel("BIN");
		lblBin.setBounds(213, 100, 46, 14);
		frame.getContentPane().add(lblBin);
		
		JLabel lblHex = new JLabel("HEX");
		lblHex.setBounds(213, 159, 46, 14);
		frame.getContentPane().add(lblHex);
		
	
	}
}
