package br.com.sabcolinas.cadastro.service;

import java.sql.Blob;

import br.com.sabcolinas.cadastro.model.Proprietario;

public interface ProprietarioService {

	public Proprietario createProprietario(String cpf, String empresa, String profissao, String cpfConjuge,
			String rgDependente, String codigo, String telefone1, String telefone2, String email, String nomeRecado,
			String parentescoRecado, String telefoneRecado, String placa, String tipo, String raca, String nome,
			String registroAnimal, Blob foto, String informacoes);

	public void updateProprietarioFoto(Blob fotoAntigo, Blob fotoNovo);

	public void updateProprietarioInformacoes(String informacoesAntigo, String informacoesNovo);

	public void deleteProprietario(Long id);
}
