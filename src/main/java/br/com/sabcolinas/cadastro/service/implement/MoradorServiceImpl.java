package br.com.sabcolinas.cadastro.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Morador;
import br.com.sabcolinas.cadastro.repository.MoradorRepository;
import br.com.sabcolinas.cadastro.service.MoradorService;

@Service("moradorService")
@Transactional
public class MoradorServiceImpl implements MoradorService {

	@Autowired
	private MoradorRepository moradorRepo;

	public void setDependenteRepo(MoradorRepository moradorRepo) {
		this.moradorRepo = moradorRepo;
	}

	@Override
	public Morador create(Morador morador) {
		return moradorRepo.save(morador);
	}

	@Override
	public void delete(Long id) {
		moradorRepo.deleteById(id);
	}

	@Override
	public void updateParentesco(String parentescoAntigo, String parentescoNovo) {
		Morador morador = moradorRepo.findByParentesco(parentescoAntigo);
		if (morador != null) {
			morador.setParentesco(parentescoNovo);
			moradorRepo.save(morador);
		}
	}

	@Override
	public List<Morador> todos() {
		List<Morador> retorno = new ArrayList<Morador>();
		for (Morador morador : moradorRepo.findAll()) {
			retorno.add(morador);
		}
		return retorno;
	}

	@Override
	public List<Morador> buscarParentesco(String parentesco) {
		List<Morador> retorno = new ArrayList<Morador>();
		for (Morador morador : moradorRepo.findByParentescoContains(parentesco)) {
			retorno.add(morador);
		}
		return retorno;
	}

	@Override
	public Morador buscarId(Long id) {
		Optional<Morador> morador = moradorRepo.findById(id);
		if (morador.isPresent()) {
			return morador.get();
		}
		return null;
	}

}
