package br.com.sabcolinas.cadastro.service;

import java.util.List;

import br.com.sabcolinas.cadastro.model.Morador;

public interface MoradorService {

	public Morador create(Morador morador);

	public void delete(Long id);

	public void updateParentesco(String parentescoAntigo, String parentescoNovo);

	public List<Morador> todos();

	public List<Morador> buscarParentesco(String parentesco);

	public Morador buscarId(Long id);

}
