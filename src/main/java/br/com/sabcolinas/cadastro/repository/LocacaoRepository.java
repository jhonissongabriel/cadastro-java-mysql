package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Locacao;

public interface LocacaoRepository extends CrudRepository<Locacao, Long> {

	public List<Locacao> findAll();

	public Locacao findByNome(String nome);

	public Locacao findByTelefone(String telefone);

	public Locacao findByDataInicio(String dataInicio);

	public Locacao findByDataTermino(String dataTermino);

	public List<Locacao> findByNomeContains(String nome);

	public List<Locacao> findByTelefoneContains(String telefone);

	public List<Locacao> findByDataInicioContains(String dataInicio);

	public List<Locacao> findByDataTerminoContains(String dataTermino);

}
