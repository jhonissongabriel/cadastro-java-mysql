package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Proprietario;

public interface ProprietarioRepository extends CrudRepository<Proprietario, Long> {

	public Proprietario findByEspecial(boolean especial);

	public List<Proprietario> findByEspecialContains(boolean especial);

	public List<Proprietario> findAll();

}
