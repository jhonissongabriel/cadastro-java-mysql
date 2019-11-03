package br.com.sabcolinas.cadastro.service;

import br.com.sabcolinas.cadastro.model.Endereco;

public interface EnderecoService {

	public Endereco createEndereco(String logradouro, int numero, String bairro, String cep, String cidade,
			String estado);

	public void updateEnderecoLogradouro(String logradouroAntigo, String logradouroNovo);

	public void updateEnderecoNumero(int numeroAntigo, int numeroNovo);

	public void updateEnderecoCodigo(String codigoAntigo, String codigoNovo);

	public void updateEnderecoComplemento(String complementoAntigo, String complementoNovo);

	public void updateEnderecoBairro(String bairroAntigo, String bairroNovo);

	public void updateEnderecoCep(String cepAntigo, String cepNovo);

	public void updateEnderecoCidade(String cidadeAntigo, String cidadeNovo);

	public void updateEnderecoEstado(String estadoAntigo, String estadoNovo);
	
	public void deleteEnderecoCodigo(String codigo);

	public void deleteEndereco(String logradouro, int numero, String cep);

}
