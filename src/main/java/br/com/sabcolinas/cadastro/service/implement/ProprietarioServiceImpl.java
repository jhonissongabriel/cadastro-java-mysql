package br.com.sabcolinas.cadastro.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Proprietario;
import br.com.sabcolinas.cadastro.repository.ProprietarioRepository;
import br.com.sabcolinas.cadastro.service.ProprietarioService;

@Service("proprietarioService")
@Transactional
public class ProprietarioServiceImpl implements ProprietarioService {

	@Autowired
	private ProprietarioRepository proprietarioRepo;

	public void setProprietarioRepo(ProprietarioRepository proprietarioRepo) {
		this.proprietarioRepo = proprietarioRepo;
	}

	@Override
	public Proprietario create(Proprietario proprietario) {
		return proprietarioRepo.save(proprietario);
	}

	@Override
	public void delete(Long id) {
		proprietarioRepo.deleteById(id);
	}

	@Override
	public void updateEspecial(boolean especialAntigo, boolean especialNovo) {
		Proprietario proprietario = proprietarioRepo.findByEspecial(especialAntigo);
		if (proprietario != null) {
			proprietario.setEspecial(especialNovo);
			proprietarioRepo.save(proprietario);
		}
	}

	@Override
	public List<Proprietario> todos() {
		List<Proprietario> retorno = new ArrayList<Proprietario>();
		for (Proprietario proprietario : proprietarioRepo.findAll()) {
			retorno.add(proprietario);
		}
		return retorno;
	}

	@Override
	public Proprietario buscarId(Long id) {
		Optional<Proprietario> proprietario = proprietarioRepo.findById(id);
		if (proprietario.isPresent()) {
			return proprietario.get();
		}
		return null;
	}

	@Override
	public List<Proprietario> buscarEspecial(boolean especial) {
		List<Proprietario> retorno = new ArrayList<Proprietario>();
		for (Proprietario proprietario : proprietarioRepo.findByEspecialContains(especial)) {
			retorno.add(proprietario);
		}
		return retorno;
	}

}
