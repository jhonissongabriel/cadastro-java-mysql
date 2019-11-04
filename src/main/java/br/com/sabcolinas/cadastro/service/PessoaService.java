package br.com.sabcolinas.cadastro.service;

import java.util.Date;

import br.com.sabcolinas.cadastro.model.Pessoa;

public interface PessoaService {

	public Pessoa createPessoa(String nome, Date dataNasc, String cpf, String rg, String docEmissor, Date acessoInicio,
			Date acessoTermino);

	public void updatePessoaNome(String nomeAntigo, String nomeNovo);

	public void updatePessoaDataNasc(Date dataNascAntigo, Date dataNascNovo);

	public void updatePessoaCpf(String cpfAntigo, String cpfNovo);

	public void updatePessoaRg(String rgAntigo, String rgNovo);

	public void updatePessoaDocEmissor(String docEmissorAntigo, String docEmissorNovo);

	public void deletePessoaCpf(String cpf);

	public void deletePessoaRg(String rg);

	public void deletePessoa(Long id);

}
