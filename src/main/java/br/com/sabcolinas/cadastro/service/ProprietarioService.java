package br.com.sabcolinas.cadastro.service;

import java.util.List;

import br.com.sabcolinas.cadastro.model.Proprietario;

public interface ProprietarioService {

	public Proprietario create(Proprietario proprietario);

	public void delete(Long id);

	public void updateEspecial(boolean especialAntigo, boolean especialNovo);

	public List<Proprietario> todos();

	public Proprietario buscarId(Long id);

	public List<Proprietario> buscarEspecial(boolean especial);
}
