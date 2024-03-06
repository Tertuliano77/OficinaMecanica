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

public class ConsultaServico extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoServico;
	private JTextField txtMatriculaMecanico;
	private JTextField txtPlaca;
	private JTextField txtData;
	private JTextField txtDescricao;
	private JTextField txtCusto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaServico frame = new ConsultaServico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaServico() {
		setTitle("Consultar Serviço");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 451);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código do Serviço:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(89, 81, 99, 14);
		contentPane.add(lblNewLabel);
		
		txtCodigoServico = new JTextField();
		txtCodigoServico.setColumns(10);
		txtCodigoServico.setBounds(198, 78, 141, 20);
		contentPane.add(txtCodigoServico);
		
		JLabel lblMtriculaDoMecnico = new JLabel("Mátricula do Mecânico:");
		lblMtriculaDoMecnico.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMtriculaDoMecnico.setBounds(64, 163, 124, 14);
		contentPane.add(lblMtriculaDoMecnico);
		
		txtMatriculaMecanico = new JTextField();
		txtMatriculaMecanico.setColumns(10);
		txtMatriculaMecanico.setBounds(198, 160, 141, 20);
		contentPane.add(txtMatriculaMecanico);
		
		JLabel lblPlacaDoCarro = new JLabel("Placa do Carro:");
		lblPlacaDoCarro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPlacaDoCarro.setBounds(106, 188, 82, 14);
		contentPane.add(lblPlacaDoCarro);
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(198, 185, 141, 20);
		contentPane.add(txtPlaca);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblData.setBounds(159, 213, 29, 14);
		contentPane.add(lblData);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(198, 210, 140, 20);
		contentPane.add(txtData);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDescrio.setBounds(133, 238, 55, 14);
		contentPane.add(lblDescrio);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(198, 235, 141, 20);
		contentPane.add(txtDescricao);
		
		JLabel lblCustoTotalR = new JLabel("Custo Total: R$");
		lblCustoTotalR.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCustoTotalR.setBounds(122, 263, 98, 14);
		contentPane.add(lblCustoTotalR);
		
		txtCusto = new JTextField();
		txtCusto.setColumns(10);
		txtCusto.setBounds(208, 260, 130, 20);
		contentPane.add(txtCusto);
		
		JButton btnNewButton = new JButton("LIMPAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCodigoServico.setText("");
				txtMatriculaMecanico.setText("");
				txtPlaca.setText("");
				txtData.setText("");
				txtDescricao.setText("");
				txtCusto.setText("");
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnNewButton.setBounds(198, 325, 116, 38);
		contentPane.add(btnNewButton);
		
		JButton btnConsultar = new JButton("CONSULTAR");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					//INVOCAR O CONECTOR DO BANCO DE DADOS:
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					// REALIZAR A CONEXÃO COM BANCO DE DADOS:
					
					Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinamecanica", "root", "alunolab");
					
					String consulta = txtCodigoServico.getText();
					
		            // Executar a consulta
		           PreparedStatement pesquisa = conexao.prepareStatement("SELECT * FROM servico where codigo = ?");
		           
		           pesquisa.setString(1, consulta);
		            
		        	ResultSet resultado = pesquisa.executeQuery();


		            // Processar os resultados
		            while (resultado.next()) {
		            	
		                // Supondo que você tenha uma coluna chamada "nome" na tabela
		            	
		            	
						String matricula_do_mecanico = resultado.getString("matricula_do_mecanico");
						String placa_do_carro = resultado.getString("placa_do_carro");
						String data = resultado.getString("data");
						String descricao = resultado.getString("descricao");
						String custo = resultado.getString("custo_total");
		                
						
						
						txtMatriculaMecanico.setText(matricula_do_mecanico);
						txtPlaca.setText(placa_do_carro);
						txtData.setText(data);
						txtDescricao.setText(descricao);
						txtCusto.setText(custo);
						
		                
		            }
					
					//TRATANDO CONEXÃO COM BANCO DE DADOS SIM OU NÃO:
					
					} catch (Exception erro) {
						erro.printStackTrace();
						JOptionPane.showMessageDialog(null, "ERRO DE CONEXÃO COM BANCO DE DADOS");
					}
			
			
				
				
			}

				
		
		});
		btnConsultar.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnConsultar.setBounds(349, 77, 118, 21);
		contentPane.add(btnConsultar);
	}

}
