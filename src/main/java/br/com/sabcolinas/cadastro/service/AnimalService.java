package br.com.sabcolinas.cadastro.service;

import java.util.Optional;

import br.com.sabcolinas.cadastro.model.Animal;

public interface AnimalService {

	public Animal createAnimal(String tipo, String raca, String nome, String registro, String observacao);

	public void updateAnimalTipo(String tipoAntigo, String tipoNovo);

	public void updateAnimalRaca(String racaAntigo, String racaNovo);

	public void updateAnimalNome(String nomeAntigo, String nomeNovo);

	public void updateAnimalRegistro(String registroAntigo, String registroNovo);

	public void updateAnimalObs(String observacaoAntigo, String observacaoNovo);

	public void deleteAnimalRegistro(String registro);

	public Optional<Animal> deleteAnimal(Long id);

}
