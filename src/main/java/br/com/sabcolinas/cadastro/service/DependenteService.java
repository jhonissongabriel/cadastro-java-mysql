package br.com.sabcolinas.cadastro.service;

import br.com.sabcolinas.cadastro.model.Dependente;

public interface DependenteService {

	public Dependente createDependente(String parentesco);

	public void updateDependenteParentesco(String parentescoAntigo, String parentescoNovo);

	public void deleteDependente(Long id);

}
