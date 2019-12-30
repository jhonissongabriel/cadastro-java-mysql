package br.com.sabcolinas.cadastro.service;

import java.util.List;

import br.com.sabcolinas.cadastro.model.Pessoa;

public interface PessoaService {

	public Pessoa create(Pessoa pessoa);

	public void delete(Long id);

	public void updateNome(String nomeAntigo, String nomeNovo);

	public void updateCpf(String cpfAntigo, String cpfNovo);

	public void updateRg(String rgAntigo, String rgNovo);

	public void updateDataNasc(String dataNascAntigo, String dataNascNovo);

	public List<Pessoa> todos();

	public Pessoa buscarId(Long id);

	public List<Pessoa> buscarNome(String nome);

	public List<Pessoa> buscarCpf(String cpf);

	public List<Pessoa> buscarRg(String rg);

	public List<Pessoa> buscarDataNasc(String dataNasc);

}
