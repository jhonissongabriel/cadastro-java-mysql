package br.com.sabcolinas.cadastro.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Recado;
import br.com.sabcolinas.cadastro.repository.RecadoRepository;
import br.com.sabcolinas.cadastro.service.RecadoService;

@Service("recadoService")
@Transactional
public class RecadoServiceImpl implements RecadoService {

	@Autowired
	private RecadoRepository recadoRepo;

	public void setRecadoRepo(RecadoRepository recadoRepo) {
		this.recadoRepo = recadoRepo;
	}

	@Override
	public Recado create(Recado recado) {
		return recadoRepo.save(recado);
	}

	@Override
	public void delete(Long id) {
		recadoRepo.deleteById(id);
	}

	@Override
	public void updateNome(String nomeAntigo, String nomeNovo) {
		Recado recado = recadoRepo.findByNome(nomeAntigo);
		if (recado != null) {
			recado.setNome(nomeNovo);
			recadoRepo.save(recado);
		}
	}

	@Override
	public void updateTelefone1(String telefone1Antigo, String telefone1Novo) {
		Recado recado = recadoRepo.findByTelefone1(telefone1Antigo);
		if (recado != null) {
			recado.setTelefone1(telefone1Novo);
			recadoRepo.save(recado);
		}
	}

	@Override
	public void updateTelefone2(String telefone2Antigo, String telefone2Novo) {
		Recado recado = recadoRepo.findByTelefone2(telefone2Antigo);
		if (recado != null) {
			recado.setTelefone2(telefone2Novo);
			recadoRepo.save(recado);
		}
	}

	@Override
	public List<Recado> todos() {
		List<Recado> retorno = new ArrayList<Recado>();
		for (Recado recado : recadoRepo.findAll()) {
			retorno.add(recado);
		}
		return retorno;
	}

	@Override
	public Recado buscarId(Long id) {
		Optional<Recado> recado = recadoRepo.findById(id);
		if (recado.isPresent()) {
			return recado.get();
		}
		return null;
	}

	@Override
	public List<Recado> buscarNome(String nome) {
		List<Recado> retorno = new ArrayList<Recado>();
		for (Recado recado : recadoRepo.findByNomeContains(nome)) {
			retorno.add(recado);
		}
		return retorno;
	}

	@Override
	public List<Recado> buscarTelefone(String telefone) {
		List<Recado> retorno = new ArrayList<Recado>();
		for (Recado recado1 : recadoRepo.findByTelefone1Contains(telefone)) {
			if (recado1 == null) {
				for (Recado recado2 : recadoRepo.findByTelefone2Contains(telefone)) {
					retorno.add(recado2);
				}
			}
			retorno.add(recado1);
		}
		return retorno;
	}

}
