package br.com.sabcolinas.cadastro.service;

import br.com.sabcolinas.cadastro.model.Recado;

public interface RecadoService {

	public Recado createRecado(String nome, String parentesco, String telefone);

	public void updateRecadoNome(String nomeAntigo, String nomeNovo);

	public void updateRecadoParentesco(String parentescoAntigo, String parentescoNovo);

	public void updateRecadoTelefone(String telefoneAntigo, String telefoneNovo);

	public void deleteRecado(Long id);
}
