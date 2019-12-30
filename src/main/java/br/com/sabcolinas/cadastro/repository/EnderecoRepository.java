package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

	public Endereco findByRua(String rua);

	public Endereco findByNumero(int numero);

	public Endereco findByCodigo(String codigo);

	public Endereco findByCep(String cep);

	public List<Endereco> findAll();

	public List<Endereco> findByRuaContains(String rua);

	public List<Endereco> findByNumeroContains(int numero);

	public List<Endereco> findByCodigoContains(String codigo);

	public List<Endereco> findByCepContains(String cep);

}
