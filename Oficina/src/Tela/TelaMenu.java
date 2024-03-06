package Tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenu frame = new TelaMenu();
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
	public TelaMenu() {
		setTitle("Tela Principal - Oficina Mecânica");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 543, 470);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("CADASTRAR");
		menuBar.add(mnNewMenu);
		
		JMenu mnMecnico = new JMenu("Mecânico");
		mnMecnico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaMecanico abre = new TelaMecanico();
				abre.setVisible(true);
				abre.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnMecnico);
		
		JMenu mnNewMenu_1 = new JMenu("Cliente");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaCliente abre = new TelaCliente();
				abre.setVisible(true);
				abre.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Carro");
		mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaCarro abre = new TelaCarro();
				abre.setVisible(true);
				abre.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnNewMenu_2);
		
		JMenu mnNewMenu_3 = new JMenu("Serviço");
		mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaServico abre = new TelaServico();
				abre.setVisible(true);
				abre.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnNewMenu_3);
		
		JMenu mnNewMenu_4 = new JMenu("Fornecedor");
		mnNewMenu_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaFornecedor abre = new TelaFornecedor();
				abre.setVisible(true);
				abre.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnNewMenu_4);
		
		JMenu mnNewMenu_5 = new JMenu("Peça");
		mnNewMenu_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				TelaPeca abre = new TelaPeca();
				abre.setVisible(true);
				abre.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnNewMenu_5);
		
		JMenu mnNewMenu_6 = new JMenu("Mecânico");
		mnNewMenu_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ConsultaMecanico abre = new ConsultaMecanico();
				abre.setVisible(true);
				abre.setLocationRelativeTo(null);
				
			}
		});
		menuBar.add(mnNewMenu_6);
		
		JMenu mnNewMenu_7 = new JMenu("Cliente");
		mnNewMenu_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ConsultaCliente abre = new ConsultaCliente();
				abre.setVisible(true);
				abre.setLocationRelativeTo(null);
				
			}
		});
		menuBar.add(mnNewMenu_7);
		
		JMenu mnNewMenu_8 = new JMenu("Carro");
		mnNewMenu_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ConsultaCarro abre = new ConsultaCarro();
				abre.setVisible(true);
				abre.setLocationRelativeTo(null);
				
			}
		});
		menuBar.add(mnNewMenu_8);
		
		JMenu mnNewMenu_9 = new JMenu("Serviço");
		mnNewMenu_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ConsultaServico abre = new ConsultaServico();
				abre.setVisible(true);
				abre.setLocationRelativeTo(null);
				
			}
		});
		menuBar.add(mnNewMenu_9);
		
		JMenu mnNewMenu_10 = new JMenu("Fornecedor");
		mnNewMenu_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ConsultaFornecedor abre = new ConsultaFornecedor();
				abre.setVisible(true);
				abre.setLocationRelativeTo(null);
				
			}
		});
		menuBar.add(mnNewMenu_10);
		
		JMenu mnNewMenu_11 = new JMenu("Peça");
		mnNewMenu_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ConsultaPeca abre = new ConsultaPeca();
				abre.setVisible(true);
				abre.setLocationRelativeTo(null);
				
			}
		});
		menuBar.add(mnNewMenu_11);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("POO");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(243, 175, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaMenu.class.getResource("/imagem/logo (1).jpg")));
		lblNewLabel.setBounds(140, 70, 216, 237);
		contentPane.add(lblNewLabel);
	}

}
