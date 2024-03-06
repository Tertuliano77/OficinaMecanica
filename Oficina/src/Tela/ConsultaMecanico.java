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

public class ConsultaMecanico extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatriculaMecanico;
	private JTextField txtNomeMecanico;
	private JTextField txtSobrenomeMecanico;
	private JTextField txtEspecialidadeMecanico;
	private JTextField txtTelefoneMecanico;
	private JTextField txtRuaMecanico;
	private JTextField txtBairroMecanico;
	private JTextField txtCidadeMecanico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaMecanico frame = new ConsultaMecanico();
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
	public ConsultaMecanico() {
		setTitle("Consultar Mecânico");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 494, 459);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMatrculaDoMecnico = new JLabel("Matrícula do Mecânico:");
		lblMatrculaDoMecnico.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMatrculaDoMecnico.setBounds(44, 81, 128, 14);
		contentPane.add(lblMatrculaDoMecnico);
		
		txtMatriculaMecanico = new JTextField();
		txtMatriculaMecanico.setColumns(10);
		txtMatriculaMecanico.setBounds(182, 78, 138, 20);
		contentPane.add(txtMatriculaMecanico);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNome.setBounds(137, 127, 35, 14);
		contentPane.add(lblNome);
		
		txtNomeMecanico = new JTextField();
		txtNomeMecanico.setColumns(10);
		txtNomeMecanico.setBounds(182, 124, 138, 20);
		contentPane.add(txtNomeMecanico);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSobrenome.setBounds(103, 152, 69, 14);
		contentPane.add(lblSobrenome);
		
		txtSobrenomeMecanico = new JTextField();
		txtSobrenomeMecanico.setColumns(10);
		txtSobrenomeMecanico.setBounds(182, 149, 138, 20);
		contentPane.add(txtSobrenomeMecanico);
		
		JLabel lblEspecialiade = new JLabel("Especialiade:");
		lblEspecialiade.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEspecialiade.setBounds(101, 177, 71, 14);
		contentPane.add(lblEspecialiade);
		
		txtEspecialidadeMecanico = new JTextField();
		txtEspecialidadeMecanico.setColumns(10);
		txtEspecialidadeMecanico.setBounds(182, 174, 138, 20);
		contentPane.add(txtEspecialidadeMecanico);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTelefone.setBounds(121, 202, 51, 14);
		contentPane.add(lblTelefone);
		
		txtTelefoneMecanico = new JTextField();
		txtTelefoneMecanico.setColumns(10);
		txtTelefoneMecanico.setBounds(182, 199, 138, 20);
		contentPane.add(txtTelefoneMecanico);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblRua.setBounds(146, 227, 26, 14);
		contentPane.add(lblRua);
		
		txtRuaMecanico = new JTextField();
		txtRuaMecanico.setColumns(10);
		txtRuaMecanico.setBounds(182, 224, 138, 20);
		contentPane.add(txtRuaMecanico);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblBairro.setBounds(131, 252, 41, 14);
		contentPane.add(lblBairro);
		
		txtBairroMecanico = new JTextField();
		txtBairroMecanico.setColumns(10);
		txtBairroMecanico.setBounds(182, 249, 138, 20);
		contentPane.add(txtBairroMecanico);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCidade.setBounds(131, 277, 41, 14);
		contentPane.add(lblCidade);
		
		txtCidadeMecanico = new JTextField();
		txtCidadeMecanico.setColumns(10);
		txtCidadeMecanico.setBounds(182, 274, 138, 20);
		contentPane.add(txtCidadeMecanico);
		
		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinamecanica", "root", "alunolab");
					
					String consulta = txtMatriculaMecanico.getText();
					
		            // Executar a consulta
		           PreparedStatement pesquisa = conexao.prepareStatement("SELECT * FROM mecanico where matricula = ?");
		           
		           pesquisa.setString(1, consulta);
		            
		        	ResultSet resultado = pesquisa.executeQuery();


		            // Processar os resultados
		            while (resultado.next()) {
		            	
		                // Supondo que você tenha uma coluna chamada "nome" na tabela
		            	
						String nome = resultado.getString("nome");
						String sobrenome = resultado.getString("sobrenome");
						String especialidade = resultado.getString("especialidade");
						String telefone = resultado.getString("telefone");
						String rua = resultado.getString("rua");
						String bairro = resultado.getString("bairro");
						String cidade = resultado.getString("cidade");
		                
						
						 txtNomeMecanico.setText(nome);
						 txtSobrenomeMecanico.setText(sobrenome);
						 txtEspecialidadeMecanico.setText(especialidade);
						 txtTelefoneMecanico.setText(telefone);
						 txtRuaMecanico.setText(rua);
						 txtBairroMecanico.setText(bairro);
						 txtCidadeMecanico.setText(cidade);
		                
		            }
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
			
			
				
				
			}

			
				
			});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(330, 77, 118, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LIMPAR");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtMatriculaMecanico.setText("");
				 txtNomeMecanico.setText("");
				 txtSobrenomeMecanico.setText("");
				 txtEspecialidadeMecanico.setText("");
				 txtTelefoneMecanico.setText("");
				 txtRuaMecanico.setText("");
				 txtBairroMecanico.setText("");
				 txtCidadeMecanico.setText("");
				
			}
		});
		btnNewButton_1.setBounds(202, 331, 103, 33);
		contentPane.add(btnNewButton_1);
	}
}
