package br.com.sabcolinas.cadastro.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Animal;
import br.com.sabcolinas.cadastro.repository.AnimalRepository;
import br.com.sabcolinas.cadastro.service.AnimalService;

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalRepository animalRepo;

	public AnimalRepository getAnimalRepo() {
		return animalRepo;
	}

	public void setAnimalRepo(AnimalRepository animalRepo) {
		this.animalRepo = animalRepo;
	}

	@Override
	@Transactional
	public Animal createAnimal(String tipo, String raca, String nome, String registro, String observacao) {
		Animal animal = animalRepo.findByRegistro(registro);

		if ((animal == null) || registro.isEmpty()) {
			animal = new Animal();
			animal.setTipo(tipo);
			animal.setRaca(raca);
			animal.setNome(nome);
			animal.setRegistro(registro);
			animal.setObs(observacao);
			animalRepo.save(animal);
			return animal;
		}
		return null;
	}

	@Override
	@Transactional
	public void updateAnimalTipo(String tipoAntigo, String tipoNovo) {
		Animal animal = animalRepo.findByTipo(tipoAntigo);

		if (animal != null) {
			animal.setTipo(tipoNovo);
			animalRepo.save(animal);
		}
	}

	@Override
	@Transactional
	public void updateAnimalRaca(String racaAntigo, String racaNovo) {
		Animal animal = animalRepo.findByRaca(racaAntigo);

		if (animal != null) {
			animal.setTipo(racaNovo);
			animalRepo.save(animal);
		}
	}

	@Override
	@Transactional
	public void updateAnimalNome(String nomeAntigo, String nomeNovo) {
		Animal animal = animalRepo.findByNome(nomeAntigo);

		if (animal != null) {
			animal.setTipo(nomeNovo);
			animalRepo.save(animal);
		}
	}

	@Override
	@Transactional
	public void updateAnimalRegistro(String registroAntigo, String registroNovo) {
		Animal animal = animalRepo.findByRegistro(registroAntigo);

		if (animal != null) {
			animal.setTipo(registroNovo);
			animalRepo.save(animal);
		}
	}

	@Override
	@Transactional
	public void updateAnimalObs(String observacaoAntigo, String observacaoNovo) {
		Animal animal = animalRepo.findByObservacao(observacaoAntigo);

		if (animal != null) {
			animal.setTipo(observacaoNovo);
			animalRepo.save(animal);
		}
	}

	@Override
	@Transactional
	public void deleteAnimalRegistro(String registro) {
		Animal animal = animalRepo.findByRegistro(registro);

		if (animal != null) {
			animalRepo.delete(animal);
		}
	}

	@Override
	@Transactional
	public Optional<Animal> deleteAnimal(Long id) {
		Optional<Animal> animal = animalRepo.findById(id);

		if (animal != null) {
			animalRepo.deleteById(id);
		}
		return animal;
	}

}
