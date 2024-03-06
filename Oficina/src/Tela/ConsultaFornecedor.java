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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class ConsultaFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoFornecedor;
	private JTextField txtNomeEmpresa;
	private JTextField txtTelefoneEmpresa;
	private JTextField txtRuaEmpresa;
	private JTextField txtBairroEmpresa;
	private JTextField txtCidadeEmpresa;
	private JTextField txtEmailEmpresa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaFornecedor frame = new ConsultaFornecedor();
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
	public ConsultaFornecedor() {
		setTitle("Consultar Fornecedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 467);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código do Fornecedor:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(68, 75, 126, 14);
		contentPane.add(lblNewLabel);
		
		txtCodigoFornecedor = new JTextField();
		txtCodigoFornecedor.setColumns(10);
		txtCodigoFornecedor.setBounds(204, 72, 135, 20);
		contentPane.add(txtCodigoFornecedor);
		
		JLabel lblNomeDaEmpresa = new JLabel("Nome da Empresa:");
		lblNomeDaEmpresa.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNomeDaEmpresa.setBounds(96, 149, 98, 14);
		contentPane.add(lblNomeDaEmpresa);
		
		txtNomeEmpresa = new JTextField();
		txtNomeEmpresa.setColumns(10);
		txtNomeEmpresa.setBounds(204, 146, 135, 20);
		contentPane.add(txtNomeEmpresa);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTelefone.setBounds(143, 174, 51, 14);
		contentPane.add(lblTelefone);
		
		txtTelefoneEmpresa = new JTextField();
		txtTelefoneEmpresa.setColumns(10);
		txtTelefoneEmpresa.setBounds(204, 171, 135, 20);
		contentPane.add(txtTelefoneEmpresa);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblRua.setBounds(169, 199, 25, 14);
		contentPane.add(lblRua);
		
		txtRuaEmpresa = new JTextField();
		txtRuaEmpresa.setColumns(10);
		txtRuaEmpresa.setBounds(204, 196, 135, 20);
		contentPane.add(txtRuaEmpresa);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblBairro.setBounds(153, 224, 41, 14);
		contentPane.add(lblBairro);
		
		txtBairroEmpresa = new JTextField();
		txtBairroEmpresa.setColumns(10);
		txtBairroEmpresa.setBounds(204, 221, 135, 20);
		contentPane.add(txtBairroEmpresa);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCidade.setBounds(153, 249, 41, 14);
		contentPane.add(lblCidade);
		
		txtCidadeEmpresa = new JTextField();
		txtCidadeEmpresa.setColumns(10);
		txtCidadeEmpresa.setBounds(204, 246, 135, 20);
		contentPane.add(txtCidadeEmpresa);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEmail.setBounds(153, 274, 41, 14);
		contentPane.add(lblEmail);
		
		txtEmailEmpresa = new JTextField();
		txtEmailEmpresa.setColumns(10);
		txtEmailEmpresa.setBounds(204, 271, 135, 20);
		contentPane.add(txtEmailEmpresa);
		
		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinamecanica", "root", "alunolab");
					
					String consulta = txtCodigoFornecedor.getText();
					
		            // Executar a consulta
		           PreparedStatement pesquisa = conexao.prepareStatement("SELECT * FROM fornecedor WHERE codigo = ?");
		           
		           pesquisa.setString(1, consulta);
		            
		        	ResultSet resultado = pesquisa.executeQuery();


		            // Processar os resultados
		            while (resultado.next()) {
		            	
		                // Supondo que você tenha uma coluna chamada "nome" na tabela
		            	
		            	String codigo = resultado.getString("codigo");
						String nome = resultado.getString("nome_da_empresa");				
						String telefone = resultado.getString("telefone");					
						String rua = resultado.getString("rua");
						String bairro = resultado.getString("bairro");
						String cidade = resultado.getString("cidade");
						String email = resultado.getString("email");
						
						txtCodigoFornecedor.setText(codigo);
						txtNomeEmpresa.setText(nome);
						txtTelefoneEmpresa.setText(telefone);
						txtRuaEmpresa.setText(rua);
						txtBairroEmpresa.setText(bairro);
						txtCidadeEmpresa.setText(cidade);
						txtEmailEmpresa.setText(email);
		                
		                
		                
		            }
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
			
			
				
				
			}			
				
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(361, 71, 112, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LIMPAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCodigoFornecedor.setText("");
				txtNomeEmpresa.setText("");
				txtTelefoneEmpresa.setText("");
				txtRuaEmpresa.setText("");
				txtBairroEmpresa.setText("");
				txtCidadeEmpresa.setText("");
				txtEmailEmpresa.setText("");
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_1.setBounds(216, 326, 106, 41);
		contentPane.add(btnNewButton_1);
	}

}
