package br.com.sabcolinas.cadastro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sabcolinas.cadastro.model.Empregado;

public interface EmpregadoRepository extends CrudRepository<Empregado, Long> {

	public Empregado findByDiaTrabalho(String diaTrabalho);

	public Empregado findByHorarioTrabalho(String horarioTrabalho);

	public List<Empregado> findAll();

	public List<Empregado> findByDiaTrabalhoContains(String diaTrabalho);

	public List<Empregado> findByHorarioTrabalhoContains(String horarioTrabalho);

}
