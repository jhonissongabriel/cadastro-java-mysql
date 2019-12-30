package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Emergencia;

public interface EmergenciaRepository extends CrudRepository<Emergencia, Long> {

	public Emergencia findByTelefone1(String telefone1);

	public Emergencia findByTelefone2(String telefone2);

	public Emergencia findByNome(String nome);

	public List<Emergencia> findAll();

	public List<Emergencia> findByTelefone1Contains(String telefone1);

	public List<Emergencia> findByTelefone2Contains(String telefone2);

	public List<Emergencia> findByNomeContains(String nome);

}
