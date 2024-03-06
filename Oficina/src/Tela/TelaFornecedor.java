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

public class TelaFornecedor extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoFornecedor;
	private JTextField txtNomeEmpresa;
	private JTextField txtTelefoneEmpresa;
	private JTextField txtRuaFornecedor;
	private JTextField txtBairroFornecedor;
	private JTextField txtCidadeFornecedor;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFornecedor frame = new TelaFornecedor();
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
	public TelaFornecedor() {
		setTitle("Cadastrar Fornecedor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 497, 425);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código do Fornecedor:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(83, 87, 126, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeDaEmpresa = new JLabel("Nome da Empresa:");
		lblNomeDaEmpresa.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNomeDaEmpresa.setBounds(111, 112, 98, 14);
		contentPane.add(lblNomeDaEmpresa);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTelefone.setBounds(158, 137, 51, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblBairro.setBounds(168, 187, 41, 14);
		contentPane.add(lblBairro);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblRua.setBounds(184, 162, 25, 14);
		contentPane.add(lblRua);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCidade.setBounds(168, 212, 41, 14);
		contentPane.add(lblCidade);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblEmail.setBounds(168, 237, 41, 14);
		contentPane.add(lblEmail);
		
		txtCodigoFornecedor = new JTextField();
		txtCodigoFornecedor.setBounds(219, 84, 135, 20);
		contentPane.add(txtCodigoFornecedor);
		txtCodigoFornecedor.setColumns(10);
		
		txtNomeEmpresa = new JTextField();
		txtNomeEmpresa.setColumns(10);
		txtNomeEmpresa.setBounds(219, 109, 135, 20);
		contentPane.add(txtNomeEmpresa);
		
		txtTelefoneEmpresa = new JTextField();
		txtTelefoneEmpresa.setColumns(10);
		txtTelefoneEmpresa.setBounds(219, 134, 135, 20);
		contentPane.add(txtTelefoneEmpresa);
		
		txtRuaFornecedor = new JTextField();
		txtRuaFornecedor.setColumns(10);
		txtRuaFornecedor.setBounds(219, 159, 135, 20);
		contentPane.add(txtRuaFornecedor);
		
		txtBairroFornecedor = new JTextField();
		txtBairroFornecedor.setColumns(10);
		txtBairroFornecedor.setBounds(219, 184, 135, 20);
		contentPane.add(txtBairroFornecedor);
		
		txtCidadeFornecedor = new JTextField();
		txtCidadeFornecedor.setColumns(10);
		txtCidadeFornecedor.setBounds(219, 209, 135, 20);
		contentPane.add(txtCidadeFornecedor);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(219, 234, 135, 20);
		contentPane.add(txtEmail);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinamecanica", "root", "alunolab");
						
						String codigo = txtCodigoFornecedor.getText();
						String nome = txtNomeEmpresa.getText();
						String telefone = txtTelefoneEmpresa.getText();
						String rua = txtRuaFornecedor.getText();
						String bairro = txtBairroFornecedor.getText();
						String cidade = txtCidadeFornecedor.getText();
						String email = txtEmail.getText();
					
						String inserir = "INSERT INTO fornecedor (telefone, cidade, codigo, nome_da_empresa, rua,bairro,email) VALUES (?, ?, ?, ?,?,?,?)";
						
						//PREPARANDO PARA ENVIAR:
						
						PreparedStatement statement = conexao.prepareStatement(inserir);
						
						statement.setString(3 , codigo);
						statement.setString(4, nome);
						statement.setString(1, telefone);
						statement.setString(5, rua);
						statement.setString(6, bairro);
						statement.setString(2, cidade);
						statement.setString(7, email);
						
						int resultado = statement.executeUpdate();
						
						//TRATANDO CONDIÇÃO PARA SABER A A LINHA DO CADASTRO SERÁ PREENCHIDA:
						
						if (resultado > 0) {
							JOptionPane.showMessageDialog(null, "FORNECEDOR CADASTRADO COM SUCESSO!");
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
		btnNewButton.setBounds(111, 284, 118, 38);
		contentPane.add(btnNewButton);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCodigoFornecedor.setText("");
				txtNomeEmpresa.setText("");
				txtTelefoneEmpresa.setText("");
				txtRuaFornecedor.setText("");
				txtBairroFornecedor.setText("");
				txtCidadeFornecedor.setText("");
				txtEmail.setText("");
				
			}
		});
		btnLimpar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnLimpar.setBounds(291, 284, 118, 38);
		contentPane.add(btnLimpar);
	}

}
