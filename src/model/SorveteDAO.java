package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import exceptions.RegistroAlteradoException;
import exceptions.RegistroCadastradoComSucessoException;
import exceptions.RegistroExcluidoException;



public class SorveteDAO {
	
	private Connection connection = null;
	private PreparedStatement stm = null;
	
	public void inserir(Sorvete sorvete) throws RegistroCadastradoComSucessoException{
		
		String sql = "INSERT INTO sorvete (tamanho, preco, estoque, sabor, fornecedor) VALUES (S_SORVETE.NEXTVAL, ?,?,?,?,?)";
		
		try {
			this.stm = this.connection.prepareStatement(sql);
			
			this.stm.setInt(1, sorvete.getTamanho());
			this.stm.setDouble(2, sorvete.getPreco());
			this.stm.setInt(3, sorvete.getEstoque());
			this.stm.setString(4, sorvete.getSabor());
			this.stm.setString(5, sorvete.getFornecedor());
			this.stm.execute();
			this.stm.close();

			throw new RegistroCadastradoComSucessoException();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
		}
	}
	
	public void alterar(Sorvete sorvete) throws RegistroAlteradoException {
		
		String sql = "UPDATE sorvete SET tamanho=?, preco=?, estoque=?, sabor=?, fornecedor=? WHERE id=?";
		
		try {
			this.stm = this.connection.prepareStatement(sql);
			this.stm.setInt(1, sorvete.getTamanho());
			this.stm.setDouble(2, sorvete.getPreco());
			this.stm.setInt(3, sorvete.getEstoque());
			this.stm.setString(4, sorvete.getSabor());
			this.stm.setString(5, sorvete.getFornecedor());
			this.stm.execute();
			this.stm.close();

			throw new RegistroCadastradoComSucessoException();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
		}
	}
	
	public void excluir(Sorvete sorvete) throws RegistroExcluidoException {
		
		String sql = "DELETE FROM sorvete WHERE id=?";
		
		try {
			this.connection = new Conexao().getConexao();
			this.stm = this.connection.prepareStatement(sql);
			this.stm.setInt(1, sorvete.getId());
			this.stm.execute();
			this.stm.close();

			throw new RegistroExcluidoException();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			try {
				this.connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	}
		

}
