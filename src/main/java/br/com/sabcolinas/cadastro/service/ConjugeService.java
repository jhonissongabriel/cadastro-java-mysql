package br.com.sabcolinas.cadastro.service;

import br.com.sabcolinas.cadastro.model.Conjuge;

public interface ConjugeService {
	
	public Conjuge createConjuge(String nomeConjuge, String empresa, String profissao);
	
	public void deleteConjugeRg(String rg);

	public void deleteConjuge(Long id);
}
