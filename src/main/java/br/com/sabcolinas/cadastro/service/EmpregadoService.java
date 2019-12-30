package br.com.sabcolinas.cadastro.service;

import java.util.List;

import br.com.sabcolinas.cadastro.model.Empregado;

public interface EmpregadoService {

	public Empregado create(Empregado empregado);

	public void delete(Long id);

	public void updateDiaTrabalho(String diaTrabalhoAntigo, String diaTrabalhoNovo);

	public void updateHorarioTrabalho(String horarioTrabalhoAntigo, String horarioTrabalhoNovo);

	public List<Empregado> todos();

	public Empregado buscarId(Long id);

	public List<Empregado> buscarDiaTrabalho(String diaTrabalho);

	public List<Empregado> buscarHorarioTrabalho(String horarioTrabalho);
}
