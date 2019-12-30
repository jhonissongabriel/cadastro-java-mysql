package br.com.sabcolinas.cadastro.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Inquilino;
import br.com.sabcolinas.cadastro.repository.InquilinoRepository;
import br.com.sabcolinas.cadastro.service.InquilinoService;

@Service("inquilinoService")
@Transactional
public class InquilinoServiceImpl implements InquilinoService {

	@Autowired
	private InquilinoRepository inquilinoRepo;

	public void setInquilinoRepo(InquilinoRepository inquilinoRepo) {
		this.inquilinoRepo = inquilinoRepo;
	}

	@Override
	public Inquilino create(Inquilino inquilino) {
		return inquilinoRepo.save(inquilino);
	}

	@Override
	public void delete(Long id) {
		inquilinoRepo.deleteById(id);
	}

	@Override
	public void updateEspecial(boolean especialAntigo, boolean especialNovo) {
		Inquilino inquilino = inquilinoRepo.findByEspecial(especialAntigo);
		if (inquilino != null) {
			inquilino.setEspecial(especialNovo);
			inquilinoRepo.save(inquilino);
		}
	}

	@Override
	public List<Inquilino> todos() {
		List<Inquilino> retorno = new ArrayList<Inquilino>();
		for (Inquilino inquilino : inquilinoRepo.findAll()) {
			retorno.add(inquilino);
		}
		return retorno;
	}

	@Override
	public Inquilino buscarId(Long id) {
		Optional<Inquilino> inquilino = inquilinoRepo.findById(id);
		if (inquilino.isPresent()) {
			return inquilino.get();
		}
		return null;
	}

	@Override
	public List<Inquilino> buscarEspecial(boolean especial) {
		List<Inquilino> retorno = new ArrayList<Inquilino>();
		for (Inquilino inquilino : inquilinoRepo.findByEspecialContains(especial)) {
			retorno.add(inquilino);
		}
		return retorno;
	}

}
