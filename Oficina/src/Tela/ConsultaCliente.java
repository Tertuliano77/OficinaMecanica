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

public class ConsultaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtCidade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaCliente frame = new ConsultaCliente();
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
	public ConsultaCliente() {
		setTitle("Tela Consulta Servico - Oficina Mecânico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 518, 402);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF do Cliente:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(80, 50, 85, 13);
		contentPane.add(lblNewLabel);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(175, 47, 151, 19);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinamecanica", "root", "alunolab");
					
					String consulta = txtCpf.getText();
					
		            // Executar a consulta
		           PreparedStatement pesquisa = conexao.prepareStatement("SELECT * FROM cliente where cpf = ?");
		           
		           pesquisa.setString(1, consulta);
		            
		        	ResultSet resultado = pesquisa.executeQuery();


		            // Processar os resultados
		            while (resultado.next()) {
		            	
		                // Supondo que você tenha uma coluna chamada "nome" na tabela
		                String cpf = resultado.getString("cpf");
		                String nome = resultado.getString("nome");
		                String sobrenome = resultado.getString("sobrenome");
		                String telefone = resultado.getString("telefone");
		                String email = resultado.getString("email");
		                String rua = resultado.getString("rua");
		                String bairro = resultado.getString("bairro");
		                String cidade = resultado.getString("cidade");
		                
		                txtCpf.setText(cpf);
		                txtNome.setText(nome);
		                txtSobrenome.setText(sobrenome);
		                txtTelefone.setText(telefone); 
		                txtEmail.setText(email);
		                txtRua.setText(rua);
		                txtBairro.setText(bairro);
		                txtCidade.setText(cidade);
		                
		                
		            }
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
			
			
				
				
			}

			}
		);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(359, 46, 109, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNome.setBounds(137, 97, 41, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(188, 94, 138, 20);
		contentPane.add(txtNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSobrenome.setBounds(109, 122, 69, 14);
		contentPane.add(lblSobrenome);
		
		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		txtSobrenome.setBounds(188, 119, 138, 20);
		contentPane.add(txtSobrenome);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTelefone.setBounds(119, 147, 59, 14);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(188, 144, 138, 20);
		contentPane.add(txtTelefone);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEmail.setBounds(137, 172, 41, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(188, 169, 138, 20);
		contentPane.add(txtEmail);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblRua.setBounds(143, 197, 35, 14);
		contentPane.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setColumns(10);
		txtRua.setBounds(188, 194, 138, 20);
		contentPane.add(txtRua);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblBairro.setBounds(137, 222, 41, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(188, 219, 138, 20);
		contentPane.add(txtBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCidade.setBounds(134, 247, 44, 14);
		contentPane.add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(188, 244, 138, 20);
		contentPane.add(txtCidade);
		
		JButton btnNewButton_1 = new JButton("LIMPAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 txtCpf.setText("");
	                txtNome.setText("");
	                txtSobrenome.setText("");
	                txtTelefone.setText(""); 
	                txtEmail.setText("");
	                txtRua.setText("");
	                txtBairro.setText("");
	                txtCidade.setText("");
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_1.setBounds(210, 285, 99, 35);
		contentPane.add(btnNewButton_1);
	}
}
