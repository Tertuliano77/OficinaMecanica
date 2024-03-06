package Tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ConsultaCarro extends JFrame {

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
					ConsultaCarro frame = new ConsultaCarro();
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
	public ConsultaCarro() {
		setTitle("Consultar Carro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 442);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Placa do Carro:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(71, 68, 89, 14);
		contentPane.add(lblNewLabel);
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(170, 65, 156, 20);
		contentPane.add(txtPlaca);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMarca.setBounds(117, 137, 43, 14);
		contentPane.add(lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(170, 134, 156, 20);
		contentPane.add(txtMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblModelo.setBounds(113, 162, 47, 14);
		contentPane.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(170, 159, 156, 20);
		contentPane.add(txtModelo);
		
		JLabel lblAnoDeFabricao = new JLabel("Ano de Fabricação:");
		lblAnoDeFabricao.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAnoDeFabricao.setBounds(51, 187, 109, 14);
		contentPane.add(lblAnoDeFabricao);
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		txtAno.setBounds(170, 184, 156, 20);
		contentPane.add(txtAno);
		
		JLabel lblCpfDoCliente = new JLabel("CPF do Cliente:");
		lblCpfDoCliente.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCpfDoCliente.setBounds(63, 212, 97, 14);
		contentPane.add(lblCpfDoCliente);
		
		txtCpfCliente = new JTextField();
		txtCpfCliente.setColumns(10);
		txtCpfCliente.setBounds(170, 209, 156, 20);
		contentPane.add(txtCpfCliente);
		
		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinamecanica", "root", "alunolab");
					
					String consulta = txtPlaca.getText();
					
		            // Executar a consulta
		           PreparedStatement pesquisa = conexao.prepareStatement("SELECT * FROM carro WHERE placa = ?");
		           
		           pesquisa.setString(1, consulta);
		            
		        	ResultSet resultado = pesquisa.executeQuery();


		            // Processar os resultados
		            while (resultado.next()) {
		            	
		                // Supondo que você tenha uma coluna chamada "nome" na tabela
		            	
		            	String placa = resultado.getString("placa");
						String marca = resultado.getString("marca");				
						String modelo = resultado.getString("modelo");					
						String ano = resultado.getString("ano_de_fabricacao");
						String cpf_do_cliente = resultado.getString("cpf_do_cliente");
		                
						txtPlaca.setText(placa);
						txtMarca.setText(marca);
						txtModelo.setText(modelo);
						txtAno.setText(ano);
						txtCpfCliente.setText(cpf_do_cliente);
		                
		                
		            }
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
			
			
				
				
			}			
			});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(336, 64, 109, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LIMPAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtPlaca.setText("");
				txtMarca.setText("");
				txtModelo.setText("");
				txtAno.setText("");
				txtCpfCliente.setText("");
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_1.setBounds(191, 272, 97, 40);
		contentPane.add(btnNewButton_1);
	}
}
