package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frmSorveteriaJrSorvetes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmSorveteriaJrSorvetes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSorveteriaJrSorvetes = new JFrame();
		frmSorveteriaJrSorvetes.setTitle("Sorveteria Jr. Sorvetes");
		frmSorveteriaJrSorvetes.setResizable(false);
		frmSorveteriaJrSorvetes.setBounds(100, 100, 723, 445);
		frmSorveteriaJrSorvetes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSorveteriaJrSorvetes.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 678, 22);
		frmSorveteriaJrSorvetes.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sorvetes");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar Sorvete");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroSorvete telaCadastroSorvete = new CadastroSorvete();
				telaCadastroSorvete.setModal(true);				
				telaCadastroSorvete.setVisible(true);				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Realizar Venda");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Systemas\\WorkSpace Eclipse\\JrSorvetes\\img\\logo.png"));
		lblNewLabel.setBounds(204, 132, 309, 166);
		frmSorveteriaJrSorvetes.getContentPane().add(lblNewLabel);
	}
}
