package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import classes.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
public class Tela_Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField input_n1;
	private JTextField input_n2;
	private JLabel lbl_resultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_Calculadora frame = new Tela_Calculadora();
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
	public Tela_Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Titulo = new JLabel("Calculadora Java");
		Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		Titulo.setFont(new Font("Arial", Font.PLAIN, 20));
		Titulo.setBounds(0, 10, 416, 24);
		contentPane.add(Titulo);
		
		input_n1 = new JTextField();
		input_n1.setHorizontalAlignment(SwingConstants.CENTER);
		input_n1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				input_n1.setText("");
				input_n1.setFont(new Font("Arial", Font.PLAIN, 10));
			}
			
		});
		input_n1.setText("primeiro valor");
		input_n1.setFont(new Font("Arial", Font.PLAIN, 9));
		input_n1.setBounds(149, 75, 113, 24);
		contentPane.add(input_n1);
		input_n1.setColumns(10);
		
		input_n2 = new JTextField();
		input_n2.setHorizontalAlignment(SwingConstants.CENTER);
		input_n2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				input_n2.setText("");
			}
		});
		input_n2.setText("segundo valor");
		input_n2.setFont(new Font("Arial", Font.PLAIN, 9));
		input_n2.setBounds(149, 104, 113, 24);
		contentPane.add(input_n2);
		input_n2.setColumns(10);
		
		JComboBox cb_operacao = new JComboBox();
		cb_operacao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cb_operacao.getSelectedIndex() == 6) 
				{
					input_n2.setVisible(false);
					if(input_n1.getText().isEmpty()) {input_n1.setText("valor da radiciação");}
					return;
				}
					input_n2.setVisible(true);
					if(input_n1.getText().isEmpty()) {input_n1.setText("primeiro valor");}
	
				
			}
		});
		cb_operacao.setFont(new Font("Arial", Font.PLAIN, 10));
		cb_operacao.setBounds(149, 44, 113, 21);
		cb_operacao.addItem("Escolha uma operação");
		cb_operacao.addItem(new Soma().getNome());
		cb_operacao.addItem(new Subtracao().getNome());
		cb_operacao.addItem(new Multiplicacao().getNome());
		cb_operacao.addItem(new Divisao().getNome());
		cb_operacao.addItem(new Potenciacao().getNome());
		cb_operacao.addItem(new Raiz().getNome());
		contentPane.add(cb_operacao);
		
		JButton bt_calcular = new JButton("Calcular");
		bt_calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lbl_resultado.setForeground(new Color(0, 0, 0));
					int operacao = cb_operacao.getSelectedIndex();
			
					switch(operacao) {
					
					case 0:
						lbl_resultado.setText("Selecione uma operação!");
						lbl_resultado.setForeground(new Color(255, 5, 5));
						break;
					case 1:
						lbl_resultado.setText("Resultado: " + 
							Soma.somar(Integer.parseInt(input_n1.getText()), 
							Integer.parseInt(input_n2.getText())));
						break;
					case 2:
						lbl_resultado.setText("Resultado: " + 
								Subtracao.subtrair(Integer.parseInt(input_n1.getText()), 
								Integer.parseInt(input_n2.getText())));
						break;
					case 3:
						lbl_resultado.setText("Resultado: " + 
								Multiplicacao.multiplicar(Integer.parseInt(input_n1.getText()), 
								Integer.parseInt(input_n2.getText())));
						break;
					case 4:
						lbl_resultado.setText("Resultado: " + 
								Divisao.dividir(Integer.parseInt(input_n1.getText()), 
								Integer.parseInt(input_n2.getText())));
						break;
					case 5:
						lbl_resultado.setText("Resultado: " + 
								Potenciacao.elevar(Integer.parseInt(input_n1.getText()), 
								Integer.parseInt(input_n2.getText())));
						break;
					case 6:
						lbl_resultado.setText("Resultado: " + 
								Raiz.quadradaDe(Integer.parseInt(input_n1.getText())));
						break;
					
					}
				}catch(Exception err) {
					lbl_resultado.setText("ocorreu um erro, verifique os valores inseridos e tente novamente!");
				}
			}
		});
		bt_calcular.setFont(new Font("Arial", Font.PLAIN, 10));
		bt_calcular.setBounds(149, 146, 113, 21);
		contentPane.add(bt_calcular);
		
		lbl_resultado = new JLabel("Resultado:");
		lbl_resultado.setHorizontalAlignment(SwingConstants.CENTER);

		lbl_resultado.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lbl_resultado.setBounds(0, 177, 416, 24);
		contentPane.add(lbl_resultado);
	}
}
