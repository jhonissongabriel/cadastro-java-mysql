package br.com.sabcolinas.cadastro.service;

import java.util.List;

import br.com.sabcolinas.cadastro.model.Inquilino;

public interface InquilinoService {

	public Inquilino create(Inquilino inquilino);

	public void delete(Long id);

	public void updateEspecial(boolean especialAntigo, boolean especialNovo);

	public List<Inquilino> todos();

	public Inquilino buscarId(Long id);

	public List<Inquilino> buscarEspecial(boolean especial);

}
