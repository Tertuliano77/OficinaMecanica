package Tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class TelaCarro extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlaca;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtAno;
	private JTextField txtCpfCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCarro frame = new TelaCarro();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCarro() {
		setTitle("Cadastrar Carro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 484, 422);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Placa do Carro:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(58, 105, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMarca.setBounds(104, 130, 43, 14);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblModelo.setBounds(100, 155, 47, 14);
		contentPane.add(lblModelo);
		
		JLabel lblAnoDeFabricao = new JLabel("Ano de Fabricação:");
		lblAnoDeFabricao.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAnoDeFabricao.setBounds(38, 180, 109, 14);
		contentPane.add(lblAnoDeFabricao);
		
		JLabel lblCpfDoCliente = new JLabel("CPF do Cliente:");
		lblCpfDoCliente.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCpfDoCliente.setBounds(50, 205, 97, 14);
		contentPane.add(lblCpfDoCliente);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(157, 102, 156, 20);
		contentPane.add(txtPlaca);
		txtPlaca.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(157, 127, 156, 20);
		contentPane.add(txtMarca);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(157, 152, 156, 20);
		contentPane.add(txtModelo);
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		txtAno.setBounds(157, 177, 156, 20);
		contentPane.add(txtAno);
		
		txtCpfCliente = new JTextField();
		txtCpfCliente.setColumns(10);
		txtCpfCliente.setBounds(157, 202, 156, 20);
		contentPane.add(txtCpfCliente);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinamecanica", "root", "alunolab");
						
						String placa = txtPlaca.getText();
						String marca = txtMarca.getText();					
						String modelo = txtModelo.getText();						
						String ano = txtAno.getText();
						String cpf_do_cliente = txtCpfCliente.getText();						
					
						String inserir = "INSERT INTO carro (marca, cpf_do_cliente,ano_de_fabricacao,placa,modelo) VALUES (?, ?, ?, ?,?)";
						
						//PREPARANDO PARA ENVIAR:
						
						PreparedStatement statement = conexao.prepareStatement(inserir);
						
						statement.setString(4 , placa);
						statement.setString(1, marca);
						statement.setString(5, modelo);
						statement.setString(3, ano);
						statement.setString(2, cpf_do_cliente);
						
						int resultado = statement.executeUpdate();
						
						//TRATANDO CONDIÇÃO PARA SABER A A LINHA DO CADASTRO SERÁ PREENCHIDA:
						
						if (resultado > 0) {
							JOptionPane.showMessageDialog(null, "CARRO CADASTRADO COM SUCESSO!");
						}else{
								JOptionPane.showMessageDialog(null, "ERRO DE CADASTRO, CONFIRA OS DADOS E TENTE NOVAMENTE!");
							}
						
						//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:
						
	              }catch (Exception erro) {
							erro.printStackTrace();
							JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
	              }
}
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(91, 266, 103, 41);
		contentPane.add(btnNewButton);
		
		JButton btnApagar = new JButton("LIMPAR");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtPlaca.setText("");
				txtMarca.setText("");
				txtModelo.setText("");
				txtAno.setText("");
				txtCpfCliente.setText("");
				
				
			}
		});
		btnApagar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnApagar.setBounds(280, 266, 103, 41);
		contentPane.add(btnApagar);
	}

}
