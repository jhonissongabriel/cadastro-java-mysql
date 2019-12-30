package br.com.sabcolinas.cadastro.service;

import java.util.List;

import br.com.sabcolinas.cadastro.model.Locacao;

public interface LocacaoService {

	public Locacao create(Locacao locacao);

	public void delete(Long id);

	public void updateNome(String nomeAntigo, String nomeNovo);

	public void updateTelefone(String telefoneAntigo, String telefoneNovo);

	public void updateDataInicio(String dataInicioAntigo, String dataInicioNovo);

	public void updateDataTermino(String dataTerminoAntigo, String dataTerminoNovo);

	public List<Locacao> todos();

	public Locacao buscarId(Long id);

	public List<Locacao> buscarNome(String nome);

	public List<Locacao> buscarTelefone(String telefone);

	public List<Locacao> buscarDataInicio(String dataInicio);

	public List<Locacao> buscarDataTermino(String dataTermino);

}
