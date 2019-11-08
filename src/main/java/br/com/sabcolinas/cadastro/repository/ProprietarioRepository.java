package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Proprietario;

public interface ProprietarioRepository extends CrudRepository<Proprietario, Long> {

	// Find

	public Proprietario findByInformacoes(String informacoes);

	public List<Proprietario> findAll();

	// Find Contains

	public List<Proprietario> findByInformacoesContains(String informacoes);

	// Query

	@Query("select p from Proprietario p where p.informacoes like %?1%")
	public List<Proprietario> buscaInformacoes(String informacoes);

}
