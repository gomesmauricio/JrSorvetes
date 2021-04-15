package controller;

import java.util.List;

import exceptions.BancoVazioException;
import exceptions.RegistroAlteradoException;
import exceptions.RegistroCadastradoComSucessoException;
import exceptions.RegistroExcluidoException;
import model.InterfaceSorvete;
import model.Sorvete;
import model.SorveteDAO;

public class SorveteController implements InterfaceSorvete{
	
	private SorveteDAO sorveteDAL;
	
	public SorveteController() {
		this.sorveteDAL = new SorveteDAO();
	}

	@Override
	public void inserir(Sorvete sorvete) throws RegistroCadastradoComSucessoException {
		sorveteDAL.inserir(sorvete);
		
	}

	@Override
	public void alterar(Sorvete sorvete) throws RegistroAlteradoException {
		sorveteDAL.alterar(sorvete);
		
	}

	@Override
	public void excluir(Sorvete sorvete) throws RegistroExcluidoException {
		sorveteDAL.excluir(sorvete);
		
	}

	@Override
	public List<Sorvete> listar() throws BancoVazioException {
		
		return null;
	}

}
