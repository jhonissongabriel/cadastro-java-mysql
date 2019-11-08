package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {

	// Find

	public Endereco findByLogradouro(String logradouro);

	public Endereco findByNumero(int numero);

	public Endereco findByCodigo(String codigo);

	public Endereco findByComplemento(String complemento);

	public Endereco findByBairro(String bairro);

	public Endereco findByCep(String cep);

	public Endereco findByCidade(String cidade);

	public Endereco findByEstado(String estado);

	public List<Endereco> findAll();

	// Find Contains

	public List<Endereco> findByLogradouroContains(String logradouro);

	public List<Endereco> findByNumeroContains(int numero);

	public List<Endereco> findByCodigoContains(String codigo);

	public List<Endereco> findByComplementoContains(String complemento);

	public List<Endereco> findByBairroContains(String bairro);

	public List<Endereco> findByCepContains(String cep);

	public List<Endereco> findByCidadeContains(String cidade);

	public List<Endereco> findByEstadoContains(String estado);

	// Query

	@Query("select e from Endereco e where e.logradouro like %?1%")
	public List<Endereco> buscaLogradouro(String logradouro);

	@Query("select e from Endereco e where e.numero like %?1%")
	public List<Endereco> buscaNumero(int numero);

	@Query("select e from Endereco e where e.logradouro like %?1%")
	public List<Endereco> buscaCodigo(String codigo);

	@Query("select e from Endereco e where e.complemento like %?1%")
	public List<Endereco> buscaComplemento(String complemento);

	@Query("select e from Endereco e where e.bairro like %?1%")
	public List<Endereco> buscaBairro(String bairro);

	@Query("select e from Endereco e where e.cep like %?1%")
	public List<Endereco> buscaCep(String cep);

	@Query("select e from Endereco e where e.cidade like %?1%")
	public List<Endereco> buscaCidade(String cidade);

	@Query("select e from Endereco e where e.estado like %?1%")
	public List<Endereco> buscaEstado(String estado);

	@Query("select e from Endereco e where e.logradouro = %?1% and e.numero = ?2 and e.cep = ?3")
	public Endereco buscaLogradouroNumeroCep(String logradouro, int numero, String cep);

}
