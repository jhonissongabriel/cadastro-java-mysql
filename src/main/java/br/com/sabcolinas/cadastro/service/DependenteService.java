package br.com.sabcolinas.cadastro.service;

import java.util.Optional;

import br.com.sabcolinas.cadastro.model.Dependente;

public interface DependenteService {

	public Dependente createDependente(String nome, String parentesco);

	public void updateDependenteParentesco(String parentescoAntigo, String parentescoNovo);

	public Optional<Dependente> deleteDependente(Long id);

}
