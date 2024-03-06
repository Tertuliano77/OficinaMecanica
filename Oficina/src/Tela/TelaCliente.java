package Tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpfCliente;
	private JTextField txtNomeCliente;
	private JTextField txtSobrenomeCliente;
	private JTextField txtTelefoneCliente;
	private JTextField txtEmailCliente;
	private JTextField txtRuaCliente;
	private JTextField txtBairroCliente;
	private JTextField txtCidadeCliente;
	private JButton btnNewButton;
	private JButton btnApagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
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
	public TelaCliente() {
		setTitle("Cadastrar Cliente");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 503, 433);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCpf.setBounds(149, 46, 35, 14);
		contentPane.add(lblCpf);
		
		txtCpfCliente = new JTextField();
		txtCpfCliente.setColumns(10);
		txtCpfCliente.setBounds(194, 43, 138, 20);
		contentPane.add(txtCpfCliente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNome.setBounds(143, 71, 41, 14);
		contentPane.add(lblNome);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(194, 68, 138, 20);
		contentPane.add(txtNomeCliente);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		lblSobrenome.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSobrenome.setBounds(115, 96, 69, 14);
		contentPane.add(lblSobrenome);
		
		txtSobrenomeCliente = new JTextField();
		txtSobrenomeCliente.setColumns(10);
		txtSobrenomeCliente.setBounds(194, 93, 138, 20);
		contentPane.add(txtSobrenomeCliente);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblEmail.setBounds(143, 146, 41, 14);
		contentPane.add(lblEmail);
		
		txtTelefoneCliente = new JTextField();
		txtTelefoneCliente.setColumns(10);
		txtTelefoneCliente.setBounds(194, 118, 138, 20);
		contentPane.add(txtTelefoneCliente);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTelefone.setBounds(125, 121, 59, 14);
		contentPane.add(lblTelefone);
		
		txtEmailCliente = new JTextField();
		txtEmailCliente.setColumns(10);
		txtEmailCliente.setBounds(194, 143, 138, 20);
		contentPane.add(txtEmailCliente);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblRua.setBounds(149, 171, 35, 14);
		contentPane.add(lblRua);
		
		txtRuaCliente = new JTextField();
		txtRuaCliente.setColumns(10);
		txtRuaCliente.setBounds(194, 168, 138, 20);
		contentPane.add(txtRuaCliente);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblBairro.setBounds(143, 196, 41, 14);
		contentPane.add(lblBairro);
		
		txtBairroCliente = new JTextField();
		txtBairroCliente.setColumns(10);
		txtBairroCliente.setBounds(194, 193, 138, 20);
		contentPane.add(txtBairroCliente);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblCidade.setBounds(140, 221, 44, 14);
		contentPane.add(lblCidade);
		
		txtCidadeCliente = new JTextField();
		txtCidadeCliente.setColumns(10);
		txtCidadeCliente.setBounds(194, 218, 138, 20);
		contentPane.add(txtCidadeCliente);
		
		btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
					              try {
										Class.forName("com.mysql.cj.jdbc.Driver");
										
										Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinamecanica", "root", "alunolab");
										
										String cpf = txtCpfCliente.getText();										
										String nome = txtNomeCliente.getText();										
										String sobrenome = txtSobrenomeCliente.getText();										
										String telefone = txtTelefoneCliente.getText();
										String email = txtEmailCliente.getText();
										String rua = txtRuaCliente.getText();
										String bairro = txtBairroCliente.getText();
										String cidade = txtCidadeCliente.getText();
									
										String inserir = "INSERT INTO cliente ( sobrenome, cidade, email, nome, telefone,bairro ,rua,cpf) VALUES (?, ?, ?, ?,?,?,?,?)";
										
										//PREPARANDO PARA ENVIAR:
										
										PreparedStatement statement = conexao.prepareStatement(inserir);
										
										statement.setString(8 , cpf);
										statement.setString(4, nome);
										statement.setString(1, sobrenome);
										statement.setString(5, telefone);
										statement.setString(3, email);
										statement.setString(7, rua);
										statement.setString(6, bairro);
										statement.setString(2, cidade);
										
										int resultado = statement.executeUpdate();
										
										//TRATANDO CONDIÇÃO PARA SABER A A LINHA DO CADASTRO SERÁ PREENCHIDA:
										
										if (resultado > 0) {
											JOptionPane.showMessageDialog(null, "CLIENTE CADASTRADO COM SUCESSO!");
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
		btnNewButton.setBounds(115, 277, 103, 35);
		contentPane.add(btnNewButton);
		
		btnApagar = new JButton("LIMPAR");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCpfCliente.setText("");
				txtNomeCliente.setText("");
				txtSobrenomeCliente.setText("");
				txtTelefoneCliente.setText("");
				txtEmailCliente.setText("");
				txtRuaCliente.setText("");
				txtBairroCliente.setText("");
				txtCidadeCliente.setText("");
				
			}
		});
		btnApagar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnApagar.setBounds(302, 277, 103, 35);
		contentPane.add(btnApagar);
	}

}
