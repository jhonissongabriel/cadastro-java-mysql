package br.com.sabcolinas.cadastro.service;

import br.com.sabcolinas.cadastro.model.PrestadorServico;

public interface PrestadorServicoService {

	public PrestadorServico createPrestadorServico(String cpf, String cnpj);

	public void deletePrestadorServico(Long id);
}
