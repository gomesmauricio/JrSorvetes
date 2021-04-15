package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import conexao.Conexao;
import controller.SorveteController;
import exceptions.RegistroCadastradoComSucessoException;
import model.Sorvete;
import net.proteanit.sql.DbUtils;


public class CadastroSorvete extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textSabor;
	private JTextField textValor;
	private JTextField textEstoque;
	private JTable table;
	
	String[] comboFornecdor = new String[] {"Selecione", "Kibom", "Zecas", "Nestlê", "Da casa" };
	private JTextField texTamanho;
	
	/**
	 * Create the dialog.
	 */
	public CadastroSorvete() {
		setResizable(false);
		setTitle("Cadastro Sorvetes");
		setBounds(100, 100, 684, 435);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("****Gest\u00E3o Sorvetes****");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(197, 11, 228, 21);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 38, 18, 14);
		contentPanel.add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox(comboFornecdor);
		comboBox.setBounds(261, 101, 245, 22);
		contentPanel.add(comboBox);
		
		JLabel ID = new JLabel("ID");
		ID.setEnabled(false);
		ID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ID.setBounds(38, 38, 46, 14);
		contentPanel.add(ID);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!textEstoque.getText().equals("")  && (!textSabor.getText().equals("")) &&
					(!texTamanho.getText().equals("")) && (!texTamanho.getText().equals(""))  ){
					
					Sorvete sorvete = new Sorvete();
					SorveteController controller = new SorveteController();
					
					sorvete.setEstoque(Integer.parseInt(textEstoque.getText()));
					sorvete.setFornecedor(Integer.toString(comboBox.getSelectedIndex()));
					sorvete.setPreco(Double.parseDouble(textValor.getText()));
					sorvete.setSabor(textSabor.getText());
					sorvete.setTamanho(Integer.parseInt(texTamanho.getText()));
					
					try {
						controller.inserir(sorvete);
					}catch(RegistroCadastradoComSucessoException e3) {
						JOptionPane.showMessageDialog(null, e3.getMessage(),"Cadastro", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Necessário preencher todos os campos!", "Atenção", 
							JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		btnCadastrar.setBounds(515, 38, 102, 23);
		contentPanel.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(515, 67, 102, 23);
		contentPanel.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(515, 101, 102, 23);
		contentPanel.add(btnExcluir);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection conexao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "TURMAMV", "turmamv");
					String sql = "select * from sorvete";
					
					PreparedStatement stm = conexao.prepareStatement(sql);
					ResultSet rs = stm.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
				
				
			}
		});
		btnListar.setBounds(515, 129, 102, 23);
		contentPanel.add(btnListar);
		
		JLabel lbSabor = new JLabel("Sabor:");
		lbSabor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbSabor.setBounds(212, 70, 46, 14);
		contentPanel.add(lbSabor);
		
		textSabor = new JTextField();
		textSabor.setBounds(261, 68, 245, 20);
		contentPanel.add(textSabor);
		textSabor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Valor:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 104, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		textValor = new JTextField();
		textValor.setBounds(71, 102, 86, 20);
		contentPanel.add(textValor);
		textValor.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Fornecedor:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(167, 104, 86, 14);
		contentPanel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("Data:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 11, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lbDate = new JLabel("date");
		lbDate.setEnabled(false);
		lbDate.setBounds(59, 11, 46, 14);
		contentPanel.add(lbDate);
		
		JLabel lblNewLabel_4 = new JLabel("Estoque:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 138, 58, 14);
		contentPanel.add(lblNewLabel_4);
		
		textEstoque = new JTextField();
		textEstoque.setBounds(71, 130, 86, 20);
		contentPanel.add(textEstoque);
		textEstoque.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 176, 647, 209);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Tamnho", "Preco", "Estoque", "Sabor", "Forncedor"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_4_1 = new JLabel("Tamanho ml:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(10, 70, 86, 14);
		contentPanel.add(lblNewLabel_4_1);
		
		texTamanho = new JTextField();
		texTamanho.setBounds(94, 68, 63, 20);
		contentPanel.add(texTamanho);
		texTamanho.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
