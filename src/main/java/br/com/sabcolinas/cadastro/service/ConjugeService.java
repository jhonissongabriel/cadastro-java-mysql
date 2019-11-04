package br.com.sabcolinas.cadastro.service;

import java.util.Optional;

import br.com.sabcolinas.cadastro.model.Conjuge;

public interface ConjugeService {
	
	public Conjuge createConjuge(String nomeConjuge, String empresa, String profissao);
	
	public void deleteConjuge(Long id);

}
