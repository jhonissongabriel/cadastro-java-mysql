package br.com.sabcolinas.cadastro.service;

import java.util.Date;

import br.com.sabcolinas.cadastro.model.Acesso;

public interface AcessoService {

	public Acesso createAcesso(Date dataInicio, Date dataTermino);

	public void updateAcessoInicio(Date dataInicioAntigo, Date dataInicioNovo);

	public void updateAcessoTermino(Date dataTerminoAntigo, Date dataTerminoNovo);

	public void deleteAcesso(Long id);

}
