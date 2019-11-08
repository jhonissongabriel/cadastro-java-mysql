package br.com.sabcolinas.cadastro.service;

import br.com.sabcolinas.cadastro.model.Trabalho;

public interface TrabalhoService {

	public Trabalho createTrabalho(String empresa, String profissao, String telefone);

	public void updateTrabalhoEmpresa(String empresaAntigo, String empresaNovo);

	public void updateTrabalhoProfissao(String profissaoAntigo, String profissaoNovo);

	public void updateTrabalhoTelefone(String telefoneAntigo, String telefoneNovo);

	public void deleteTrabalho(Long is);

}
