package br.com.sabcolinas.cadastro.service;

import java.sql.Blob;

import br.com.sabcolinas.cadastro.model.Proprietario;

public interface ProprietarioService {

	public Proprietario createProprietario();
	
	public void updateProprietarioFoto(Blob fotoAntigo, Blob fotoNovo);
	
	public void updateProprietarioInformacoes(String informacoesAntigo, String informacoesNovo);
	
	public void deleteProprietario(Long id);
}
