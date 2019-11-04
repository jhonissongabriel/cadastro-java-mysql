package br.com.sabcolinas.cadastro.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sabcolinas.cadastro.model.Funcionario;
import br.com.sabcolinas.cadastro.repository.EnderecoRepository;
import br.com.sabcolinas.cadastro.repository.FuncionarioRepository;
import br.com.sabcolinas.cadastro.service.FuncionarioService;

@Service("funcionarioService")
public class FuncionarioServiceImpl implements FuncionarioService{
	
	@Autowired
	private FuncionarioRepository funcionarioRepo;
	
	@Autowired
	private EnderecoRepository enderecoRepo;

	public void setFuncionarioRepo(FuncionarioRepository funcionarioRepo) {
		this.funcionarioRepo = funcionarioRepo;
	}

	public void setEnderecoRepo(EnderecoRepository enderecoRepo) {
		this.enderecoRepo = enderecoRepo;
	}

	@Override
	public Funcionario createFuncionario() {
		
		return null;
	}

	@Override
	public void deleteFuncionario(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
