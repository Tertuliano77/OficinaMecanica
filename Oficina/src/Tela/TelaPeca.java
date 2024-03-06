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

public class TelaPeca extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoPeca;
	private JTextField txtNomePeca;
	private JTextField txtDescricaoPeca;
	private JTextField txtQuantidadePeca;
	private JTextField txtCodigoFornecedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPeca frame = new TelaPeca();
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
	public TelaPeca() {
		setTitle("Cadastrar Peça");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 516, 416);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código da Peça:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(107, 87, 85, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNome.setBounds(157, 112, 35, 14);
		contentPane.add(lblNome);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDescrio.setBounds(137, 137, 55, 14);
		contentPane.add(lblDescrio);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblQuantidade.setBounds(126, 162, 66, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblCdigoDoFornecedor = new JLabel("Código do Fornecedor:");
		lblCdigoDoFornecedor.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCdigoDoFornecedor.setBounds(72, 187, 120, 14);
		contentPane.add(lblCdigoDoFornecedor);
		
		txtCodigoPeca = new JTextField();
		txtCodigoPeca.setBounds(202, 84, 152, 20);
		contentPane.add(txtCodigoPeca);
		txtCodigoPeca.setColumns(10);
		
		txtNomePeca = new JTextField();
		txtNomePeca.setColumns(10);
		txtNomePeca.setBounds(202, 109, 152, 20);
		contentPane.add(txtNomePeca);
		
		txtDescricaoPeca = new JTextField();
		txtDescricaoPeca.setColumns(10);
		txtDescricaoPeca.setBounds(202, 134, 152, 20);
		contentPane.add(txtDescricaoPeca);
		
		txtQuantidadePeca = new JTextField();
		txtQuantidadePeca.setColumns(10);
		txtQuantidadePeca.setBounds(202, 159, 152, 20);
		contentPane.add(txtQuantidadePeca);
		
		txtCodigoFornecedor = new JTextField();
		txtCodigoFornecedor.setColumns(10);
		txtCodigoFornecedor.setBounds(202, 184, 152, 20);
		contentPane.add(txtCodigoFornecedor);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinamecanica", "root", "alunolab");
						
						String codigo = txtCodigoPeca.getText();
						String nome = txtNomePeca.getText();
						String descricao = txtDescricaoPeca.getText();
						String quantidade = txtQuantidadePeca.getText();
						String codigo_do_fornecedor = txtCodigoFornecedor.getText();
					
						String inserir = "INSERT INTO peca (nome, codigo_do_fornecedor, quantidade, descricao,codigo) VALUES (?, ?, ?, ?,?)";
						
						//PREPARANDO PARA ENVIAR:
						
						PreparedStatement statement = conexao.prepareStatement(inserir);
						
						statement.setString(5 , codigo);
						statement.setString(1, nome);
						statement.setString(4, descricao);
						statement.setString(3, quantidade);
						statement.setString(2, codigo_do_fornecedor);
						
						int resultado = statement.executeUpdate();
						
						//TRATANDO CONDIÇÃO PARA SABER A A LINHA DO CADASTRO SERÁ PREENCHIDA:
						
						if (resultado > 0) {
							JOptionPane.showMessageDialog(null, "PEÇA CADASTRADO COM SUCESSO!");
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
		btnNewButton.setBounds(100, 243, 107, 47);
		contentPane.add(btnNewButton);
		
		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCodigoPeca.setText("");
				txtNomePeca.setText("");
				txtDescricaoPeca.setText("");
				txtQuantidadePeca.setText("");
				txtCodigoFornecedor.setText("");
				
			}
		});
		btnLimpar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnLimpar.setBounds(295, 243, 107, 47);
		contentPane.add(btnLimpar);
	}

}
