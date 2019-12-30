package br.com.sabcolinas.cadastro.service;

import java.util.List;

import br.com.sabcolinas.cadastro.model.Emergencia;

public interface EmergenciaService {

	public Emergencia create(Emergencia emergencia);

	public void delete(Long id);

	public void updateTelefone1(String telefone1Antigo, String telefone1Novo);

	public void updateTelefone2(String telefone2Antigo, String telefone2Novo);

	public void updateNome(String nomeAntigo, String nomeNovo);

	public List<Emergencia> todos();

	public Emergencia buscarId(Long id);

	public List<Emergencia> buscarTelefone(String telefone);

	public List<Emergencia> buscarNome(String nome);

}
