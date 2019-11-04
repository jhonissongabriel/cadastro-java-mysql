package br.com.sabcolinas.cadastro.service;

import br.com.sabcolinas.cadastro.model.Contato;

public interface ContatoService {
	
	public Contato createContato(String telefone1, String telefone2, String email);
	
	public void updateContatoTelefone1(String telefone1Antigo, String telefone1Novo);

	public void updateContatoTelefone2(String telefone2Antigo, String telefone2Novo);
	
	public void updateContatoEmail(String emailAntigo, String emailNovo);
	
	public void deleteContato(Long id);
	
}
