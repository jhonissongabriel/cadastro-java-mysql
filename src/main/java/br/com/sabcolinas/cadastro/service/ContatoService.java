package br.com.sabcolinas.cadastro.service;

import java.util.List;

import br.com.sabcolinas.cadastro.model.Contato;

public interface ContatoService {

	public Contato create(Contato contato);

	public void delete(Long id);

	public void updateTelefone1(String telefone1Antigo, String telefone1Novo);

	public void updateTelefone2(String telefone2Antigo, String telefone2Novo);

	public void updateEmail(String emailAntigo, String emailNovo);

	public List<Contato> todos();

	public Contato buscarId(Long id);

	public List<Contato> buscarTelefone(String telefone);

	public List<Contato> buscarEmail(String email);

}
