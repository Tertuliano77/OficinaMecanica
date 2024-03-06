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

public class TelaMecanico extends JFrame {

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
					TelaMecanico frame = new TelaMecanico();
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
	public TelaMecanico() {
		setTitle("Cadastrar Mecânico");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 406);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Matrícula:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setBounds(73, 56, 58, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNome.setBounds(96, 81, 35, 14);
		contentPane.add(lblNome);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSobrenome.setBounds(62, 106, 69, 14);
		contentPane.add(lblSobrenome);
		
		JLabel lblEspecialiade = new JLabel("Especialiade:");
		lblEspecialiade.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEspecialiade.setBounds(60, 131, 71, 14);
		contentPane.add(lblEspecialiade);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTelefone.setBounds(80, 156, 51, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblRua.setBounds(105, 181, 26, 14);
		contentPane.add(lblRua);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblBairro.setBounds(90, 206, 41, 14);
		contentPane.add(lblBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCidade.setBounds(90, 231, 41, 14);
		contentPane.add(lblCidade);
		
		txtMatriculaMecanico = new JTextField();
		txtMatriculaMecanico.setBounds(141, 53, 138, 20);
		contentPane.add(txtMatriculaMecanico);
		txtMatriculaMecanico.setColumns(10);
		
		txtNomeMecanico = new JTextField();
		txtNomeMecanico.setColumns(10);
		txtNomeMecanico.setBounds(141, 78, 138, 20);
		contentPane.add(txtNomeMecanico);
		
		txtSobrenomeMecanico = new JTextField();
		txtSobrenomeMecanico.setColumns(10);
		txtSobrenomeMecanico.setBounds(141, 103, 138, 20);
		contentPane.add(txtSobrenomeMecanico);
		
		txtEspecialidadeMecanico = new JTextField();
		txtEspecialidadeMecanico.setColumns(10);
		txtEspecialidadeMecanico.setBounds(141, 128, 138, 20);
		contentPane.add(txtEspecialidadeMecanico);
		
		txtTelefoneMecanico = new JTextField();
		txtTelefoneMecanico.setColumns(10);
		txtTelefoneMecanico.setBounds(141, 153, 138, 20);
		contentPane.add(txtTelefoneMecanico);
		
		txtRuaMecanico = new JTextField();
		txtRuaMecanico.setColumns(10);
		txtRuaMecanico.setBounds(141, 178, 138, 20);
		contentPane.add(txtRuaMecanico);
		
		txtBairroMecanico = new JTextField();
		txtBairroMecanico.setColumns(10);
		txtBairroMecanico.setBounds(141, 203, 138, 20);
		contentPane.add(txtBairroMecanico);
		
		txtCidadeMecanico = new JTextField();
		txtCidadeMecanico.setColumns(10);
		txtCidadeMecanico.setBounds(141, 228, 138, 20);
		contentPane.add(txtCidadeMecanico);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinamecanica", "root", "alunolab");
						
						String matricula = txtMatriculaMecanico.getText();
						String nome = txtNomeMecanico.getText();
						String sobrenome = txtSobrenomeMecanico.getText();
						String especialidade = txtEspecialidadeMecanico.getText();
						String telefone = txtTelefoneMecanico.getText();
						String rua = txtRuaMecanico.getText();
						String bairro = txtBairroMecanico.getText();
						String cidade = txtCidadeMecanico.getText();
			
						String inserir = "INSERT INTO mecanico (especialidade, sobrenome, cidade,nome, bairro,telefone,rua,matricula) VALUES (?,?,?,?,?,?,?,?)";
						
						//PREPARANDO PARA ENVIAR:
						
						PreparedStatement statement = conexao.prepareStatement(inserir);
						
						statement.setString(8 , matricula);
						statement.setString(4, nome);
						statement.setString(2, sobrenome);
						statement.setString(1, especialidade);
						statement.setString(5, telefone);
						statement.setString(6, telefone);
						statement.setString(7, rua);
						statement.setString(5, bairro);
						statement.setString(3, cidade);
						
						int resultado = statement.executeUpdate();
						
						//TRATANDO CONDIÇÃO PARA SABER A A LINHA DO CADASTRO SERÁ PREENCHIDA:
						
						if (resultado > 0) {
							JOptionPane.showMessageDialog(null, "MECÂNICO CADASTRADO COM SUCESSO!");
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
		btnNewButton.setBounds(98, 282, 105, 32);
		contentPane.add(btnNewButton);
		
		JButton btnApagar = new JButton("LIMPAR");
		btnApagar.addActionListener(new ActionListener() {
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
		btnApagar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnApagar.setBounds(280, 282, 105, 32);
		contentPane.add(btnApagar);
	}

}
