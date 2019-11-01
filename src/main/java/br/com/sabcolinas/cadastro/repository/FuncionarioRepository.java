package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>{
	
	// Find
	
	public List<Funcionario> findAll();

}
