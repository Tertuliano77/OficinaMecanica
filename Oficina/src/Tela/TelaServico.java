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

public class TelaServico extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigoServico;
	private JTextField txtMatriculaMecanico;
	private JTextField txtPlaca;
	private JTextField txtDescricao;
	private JTextField txtCusto;
	private JTextField txtData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaServico frame = new TelaServico();
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
	public TelaServico() {
		setTitle("Cadastrar Serviço");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 431);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código do Serviço:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(86, 85, 99, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblMtriculaDoMecnico = new JLabel("Mátricula do Mecânico:");
		lblMtriculaDoMecnico.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblMtriculaDoMecnico.setBounds(61, 110, 124, 14);
		contentPane.add(lblMtriculaDoMecnico);
		
		JLabel lblPlacaDoCarro = new JLabel("Placa do Carro:");
		lblPlacaDoCarro.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblPlacaDoCarro.setBounds(103, 135, 82, 14);
		contentPane.add(lblPlacaDoCarro);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblData.setBounds(156, 160, 29, 14);
		contentPane.add(lblData);
		
		JLabel lblDescrio = new JLabel("Descrição:");
		lblDescrio.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblDescrio.setBounds(130, 185, 55, 14);
		contentPane.add(lblDescrio);
		
		JLabel lblCustoTotalR = new JLabel("Custo Total: R$");
		lblCustoTotalR.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCustoTotalR.setBounds(119, 210, 98, 14);
		contentPane.add(lblCustoTotalR);
		
		txtCodigoServico = new JTextField();
		txtCodigoServico.setBounds(195, 82, 141, 20);
		contentPane.add(txtCodigoServico);
		txtCodigoServico.setColumns(10);
		
		txtMatriculaMecanico = new JTextField();
		txtMatriculaMecanico.setColumns(10);
		txtMatriculaMecanico.setBounds(195, 107, 141, 20);
		contentPane.add(txtMatriculaMecanico);
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(195, 132, 141, 20);
		contentPane.add(txtPlaca);
		
		txtDescricao = new JTextField();
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(195, 182, 141, 20);
		contentPane.add(txtDescricao);
		
		txtCusto = new JTextField();
		txtCusto.setColumns(10);
		txtCusto.setBounds(205, 207, 130, 20);
		contentPane.add(txtCusto);
		
		txtData = new JTextField();
		txtData.setBounds(195, 157, 140, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JButton btnNewButton = new JButton("CADASTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						
						Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/oficinamecanica", "root", "alunolab");
						
						String codigo = txtCodigoServico.getText();
						String matricula_do_mecanico = txtMatriculaMecanico.getText();
						String placa_do_carro = txtPlaca.getText();
						String data = txtData.getText();
						String descricao = txtDescricao.getText();
						String custo = txtCusto.getText();
					
						String inserir = "INSERT INTO servico (custo_total, placa_do_carro, descricao, matricula_do_mecanico,data,codigo) VALUES (?, ?, ?, ?,?,?)";
						
						//PREPARANDO PARA ENVIAR:
						
						PreparedStatement statement = conexao.prepareStatement(inserir);
						
						statement.setString(6 , codigo);
						statement.setString(4, matricula_do_mecanico);
						statement.setString(2, placa_do_carro);
						statement.setString(5, data);
						statement.setString(3, descricao);
						statement.setString(1, custo);
						
						int resultado = statement.executeUpdate();
						
						//TRATANDO CONDIÇÃO PARA SABER A A LINHA DO CADASTRO SERÁ PREENCHIDA:
						
						if (resultado > 0) {
							JOptionPane.showMessageDialog(null, "SERVIÇO CADASTRADO COM SUCESSO!");
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
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnNewButton.setBounds(104, 269, 98, 36);
		contentPane.add(btnNewButton);
		
		JButton btnApagar = new JButton("LIMPAR");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtCodigoServico.setText("");
				txtMatriculaMecanico.setText("");
				txtPlaca.setText("");
				txtData.setText("");
				txtDescricao.setText("");
				txtCusto.setText("");
				
			}
		});
		btnApagar.setFont(new Font("Times New Roman", Font.BOLD, 10));
		btnApagar.setBounds(268, 269, 98, 36);
		contentPane.add(btnApagar);
	}

}
