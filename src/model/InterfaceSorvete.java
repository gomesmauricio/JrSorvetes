package model;

import java.util.List;

import exceptions.BancoVazioException;
import exceptions.RegistroAlteradoException;
import exceptions.RegistroCadastradoComSucessoException;
import exceptions.RegistroExcluidoException;

/**
 * Classe que cria a padroniza��o das assinaturas dos m�todos.
 * @author Jos� Mauricio
 *
 */
public interface InterfaceSorvete {
	
	/**
	 * Metodo cujo objetivo � inserir o registro de uma sorvete no banco de dados.
	 * @parm sorvete Parametro de entrada um objeto sorvete.
	 * @throws RegitroCadastradoComSucessoException excessao levantada
	 * caso consiga inserir no banco dedados.
	 * 
	 */
	public void inserir(Sorvete sorvete) throws RegistroCadastradoComSucessoException;
	
	/**
	 * Metodo cujo objetivo � alterar o registro de um sorvete ja cadastrado no banco de dados.
	 * @parm sorvete Parametro de entrada um objeto sorvete.
	 * @throws RegistroAlteradoException excessao levantada
	 * caso consiga alterar no banco dedados.
	 * 
	 */
	public void alterar(Sorvete sorvete) throws RegistroAlteradoException;
	
	/**
	 * Metodo cujo objetivo � Excluir o registro de um sorvete no banco de dados.
	 * @parm sorvete Parametro de entrada um objeto sorvete.
	 * @throws RegistroExcluidoException excessao levantada
	 * caso consiga excluir do banco dedados.
	 * 
	 */
	public void excluir(Sorvete sorvete) throws RegistroExcluidoException;
	
	/**
	 * Metodo cujo ojetivo � listar todos os sorvetes cadastradas no banco de dados.
	 * @param sorvete Parametro de entrada um ojeto Sorvete.
	 * @throws BancoVazioException excessao levantada
	 * caso n�o encontre cadastro no banco de dados.
	 */	
	public List<Sorvete> listar() throws BancoVazioException;
	
	

}
