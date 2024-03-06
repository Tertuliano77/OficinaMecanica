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

public class ConsultaPeca extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoPeca;
	private JTextField txtNomePeca;
	private JTextField txtDescricao;
	private JTextField txtQuantidadePeca;
	private JTextField txtCodigoFornecedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaPeca frame = new ConsultaPeca();
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
	public ConsultaPeca() {
		setTitle("Consultar Peça");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 397);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código da Peça:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(85, 56, 85, 14);
		contentPane.add(lblNewLabel);
		
		txtCodigoPeca = new JTextField();
		txtCodigoPeca.setColumns(10);
		txtCodigoPeca.setBounds(180, 53, 137, 20);
		contentPane.add(txtCodigoPeca);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNome.setBounds(135, 123, 35, 14);
		contentPane.add(lblNome);
		
		txtNomePeca = new JTextField();
		txtNomePeca.setColumns(10);
		txtNomePeca.setBounds(180, 120, 152, 20);
		contentPane.add(txtNomePeca);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDescrio.setBounds(115, 148, 55, 14);
		contentPane.add(lblDescrio);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(180, 145, 152, 20);
		contentPane.add(txtDescricao);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblQuantidade.setBounds(104, 173, 66, 14);
		contentPane.add(lblQuantidade);
		
		txtQuantidadePeca = new JTextField();
		txtQuantidadePeca.setColumns(10);
		txtQuantidadePeca.setBounds(180, 170, 152, 20);
		contentPane.add(txtQuantidadePeca);
		
		JLabel lblCdigoDoFornecedor = new JLabel("Código do Fornecedor:");
		lblCdigoDoFornecedor.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCdigoDoFornecedor.setBounds(50, 198, 120, 14);
		contentPane.add(lblCdigoDoFornecedor);
		
		txtCodigoFornecedor = new JTextField();
		txtCodigoFornecedor.setColumns(10);
		txtCodigoFornecedor.setBounds(180, 195, 152, 20);
		contentPane.add(txtCodigoFornecedor);
		
		JButton btnNewButton = new JButton("CONSULTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinamecanica", "root", "alunolab");
					
					String consulta = txtCodigoPeca.getText();
					
		            // Executar a consulta
		           PreparedStatement pesquisa = conexao.prepareStatement("SELECT * FROM peca WHERE codigo = ?");
		           
		           pesquisa.setString(1, consulta);
		            
		        	ResultSet resultado = pesquisa.executeQuery();


		            // Processar os resultados
		            while (resultado.next()) {
		            	
		                // Supondo que você tenha uma coluna chamada "nome" na tabela
		            	
		            	String codigo = resultado.getString("codigo");
						String nome = resultado.getString("nome");				
						String descricao = resultado.getString("descricao");					
						String quantidade = resultado.getString("quantidade");
						String codigoFornecedor = resultado.getString("codigo_do_fornecedor");
		                
						txtCodigoPeca.setText(codigo);
						txtNomePeca.setText(nome);
						txtDescricao.setText(descricao);
						txtQuantidadePeca.setText(quantidade);
						txtCodigoFornecedor.setText(codigoFornecedor);
		                
		                
		            }
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
			
			
				
				
			}			
				
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(327, 52, 111, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LIMPAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCodigoPeca.setText("");
				txtNomePeca.setText("");
				txtDescricao.setText("");
				txtQuantidadePeca.setText("");
				txtCodigoFornecedor.setText("");
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton_1.setBounds(199, 264, 100, 33);
		contentPane.add(btnNewButton_1);
	}

}
