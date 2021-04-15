package model;

import java.util.List;

import exceptions.BancoVazioException;
import exceptions.RegistroAlteradoException;
import exceptions.RegistroCadastradoComSucessoException;
import exceptions.RegistroExcluidoException;

/**
 * Classe que cria a padronização das assinaturas dos métodos.
 * @author José Mauricio
 *
 */
public interface InterfaceSorvete {
	
	/**
	 * Metodo cujo objetivo é inserir o registro de uma sorvete no banco de dados.
	 * @parm sorvete Parametro de entrada um objeto sorvete.
	 * @throws RegitroCadastradoComSucessoException excessao levantada
	 * caso consiga inserir no banco dedados.
	 * 
	 */
	public void inserir(Sorvete sorvete) throws RegistroCadastradoComSucessoException;
	
	/**
	 * Metodo cujo objetivo é alterar o registro de um sorvete ja cadastrado no banco de dados.
	 * @parm sorvete Parametro de entrada um objeto sorvete.
	 * @throws RegistroAlteradoException excessao levantada
	 * caso consiga alterar no banco dedados.
	 * 
	 */
	public void alterar(Sorvete sorvete) throws RegistroAlteradoException;
	
	/**
	 * Metodo cujo objetivo é Excluir o registro de um sorvete no banco de dados.
	 * @parm sorvete Parametro de entrada um objeto sorvete.
	 * @throws RegistroExcluidoException excessao levantada
	 * caso consiga excluir do banco dedados.
	 * 
	 */
	public void excluir(Sorvete sorvete) throws RegistroExcluidoException;
	
	/**
	 * Metodo cujo ojetivo é listar todos os sorvetes cadastradas no banco de dados.
	 * @param sorvete Parametro de entrada um ojeto Sorvete.
	 * @throws BancoVazioException excessao levantada
	 * caso não encontre cadastro no banco de dados.
	 */	
	public List<Sorvete> listar() throws BancoVazioException;
	
	

}
