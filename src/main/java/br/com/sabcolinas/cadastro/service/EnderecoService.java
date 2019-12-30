package br.com.sabcolinas.cadastro.service;

import java.util.List;

import br.com.sabcolinas.cadastro.model.Endereco;

public interface EnderecoService {

	public Endereco create(Endereco endereco);

	public void delete(Long id);

	public void updateRua(String ruaAntigo, String ruaNovo);

	public void updateNumero(int numeroAntigo, int numeroNovo);

	public void updateCodigo(String codigoAntigo, String codigoNovo);

	public void updateCep(String cepAntigo, String cepNovo);

	public List<Endereco> todos();

	public Endereco buscarId(Long id);

	public List<Endereco> buscarRua(String rua);

	public List<Endereco> buscarNumero(int numero);

	public List<Endereco> buscarCodigo(String codigo);

	public List<Endereco> buscarCep(String cep);

}
