package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {

	// Find

	public Empresa findByCnpj(String cnpj);

	public Empresa findByRazaoSocial(String razaoSocial);

	public Empresa findByNomeFantasia(String nomeFantasia);

	public List<Empresa> findAll();

	// Find Contains

	public List<Empresa> findByCnpjContains(String cnpj);

	public List<Empresa> findByRazaoSocialContains(String razaoSocial);

	public List<Empresa> findByNomeFantasiaContains(String nomeFantasia);

	// Query

	@Query("select e from Empresa e where e.cnpj like %?1%")
	public List<Empresa> buscaCnpj(String cnpj);

	@Query("select e from Empresa e where e.razaoSocial like %?1%")
	public List<Empresa> buscaRazaoSocial(String razaoSocial);

	@Query("select e from Empresa e where e.nomeFantasia like %?1%")
	public List<Empresa> buscaNomeFantasia(String nomeFantasia);

}
