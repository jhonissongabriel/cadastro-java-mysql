package br.com.sabcolinas.cadastro.service;

import java.util.List;

import br.com.sabcolinas.cadastro.model.Recado;

public interface RecadoService {

	public Recado create(Recado recado);

	public void delete(Long id);

	public void updateNome(String nomeAntigo, String nomeNovo);

	public void updateTelefone1(String telefone1Antigo, String telefone1Novo);

	public void updateTelefone2(String telefone2Antigo, String telefone2Novo);

	public List<Recado> todos();

	public Recado buscarId(Long id);

	public List<Recado> buscarNome(String nome);

	public List<Recado> buscarTelefone(String telefone);

}
