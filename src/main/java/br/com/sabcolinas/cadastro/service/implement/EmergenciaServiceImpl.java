package br.com.sabcolinas.cadastro.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Emergencia;
import br.com.sabcolinas.cadastro.repository.EmergenciaRepository;
import br.com.sabcolinas.cadastro.service.EmergenciaService;

@Service("emergenciaService")
@Transactional
public class EmergenciaServiceImpl implements EmergenciaService {

	@Autowired
	private EmergenciaRepository emergenciaRepo;

	public void setEmergenciaRepo(EmergenciaRepository emergenciaRepo) {
		this.emergenciaRepo = emergenciaRepo;
	}

	@Override
	public Emergencia create(Emergencia emergencia) {
		return emergenciaRepo.save(emergencia);

	}

	@Override
	public void delete(Long id) {
		emergenciaRepo.deleteById(id);

	}

	@Override
	public void updateTelefone1(String telefone1Antigo, String telefone1Novo) {
		Emergencia emergencia = emergenciaRepo.findByTelefone1(telefone1Antigo);
		if (emergencia != null) {
			emergencia.setTelefone1(telefone1Novo);
			emergenciaRepo.save(emergencia);
		}
	}

	@Override
	public void updateTelefone2(String telefone2Antigo, String telefone2Novo) {
		Emergencia emergencia = emergenciaRepo.findByTelefone2(telefone2Antigo);
		if (emergencia != null) {
			emergencia.setTelefone2(telefone2Novo);
			emergenciaRepo.save(emergencia);
		}
	}

	@Override
	public void updateNome(String nomeAntigo, String nomeNovo) {
		Emergencia emergencia = emergenciaRepo.findByNome(nomeAntigo);
		if (emergencia != null) {
			emergencia.setNome(nomeNovo);
			emergenciaRepo.save(emergencia);
		}
	}

	@Override
	public List<Emergencia> todos() {
		List<Emergencia> retorno = new ArrayList<Emergencia>();
		for (Emergencia emergencia : emergenciaRepo.findAll()) {
			retorno.add(emergencia);
		}
		return retorno;
	}

	@Override
	public Emergencia buscarId(Long id) {
		Optional<Emergencia> emergencia = emergenciaRepo.findById(id);
		if (emergencia.isPresent()) {
			return emergencia.get();
		}
		return null;
	}

	@Override
	public List<Emergencia> buscarTelefone(String telefone) {
		List<Emergencia> retorno = new ArrayList<Emergencia>();
		for (Emergencia emergencia1 : emergenciaRepo.findByTelefone1Contains(telefone)) {
			if (emergencia1 == null) {
				for (Emergencia emergencia2 : emergenciaRepo.findByTelefone2Contains(telefone)) {
					retorno.add(emergencia2);
				}
			}
			retorno.add(emergencia1);
		}
		return retorno;
	}

	@Override
	public List<Emergencia> buscarNome(String nome) {
		List<Emergencia> retorno = new ArrayList<Emergencia>();
		for (Emergencia emergencia : emergenciaRepo.findByNomeContains(nome)) {
			retorno.add(emergencia);
		}
		return retorno;
	}

}
