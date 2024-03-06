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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setResizable(false);
		setTitle("Tela de Login - Oficina Mecânica");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 527, 423);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuário:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(124, 203, 52, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSenha.setBounds(133, 228, 43, 14);
		contentPane.add(lblSenha);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(186, 201, 149, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(186, 226, 148, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario = txtUsuario.getText();
				String senha = txtSenha.getText();
				
				if(usuario.equals("mecanico@chefe") & senha.equals("12345")) {
					
					TelaMenu abre = new TelaMenu();
					abre.setVisible(true);
					abre.setLocationRelativeTo(null);
					
				}else if(usuario.equals("mecanico") & senha.equals("12345")) {
					
					TelaMenuMecanico abre = new TelaMenuMecanico();
					abre.setVisible(true);
					abre.setLocationRelativeTo(null);
				}else{
					JOptionPane.showMessageDialog(null, "Usuário ou senha Inválidos");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(201, 272, 122, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagem/avatar.png")));
		lblNewLabel_1.setBounds(167, 11, 195, 181);
		contentPane.add(lblNewLabel_1);
	}
}
