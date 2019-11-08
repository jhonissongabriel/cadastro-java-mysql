package br.com.sabcolinas.cadastro.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Recado;
import br.com.sabcolinas.cadastro.repository.RecadoRepository;
import br.com.sabcolinas.cadastro.service.RecadoService;

@Service("recadoService")
public class RecadoServiceImpl implements RecadoService {

	@Autowired
	private RecadoRepository recadoRepo;

	public void setRecadoRepo(RecadoRepository recadoRepo) {
		this.recadoRepo = recadoRepo;
	}

	@Override
	@Transactional
	public Recado createRecado(String nome, String parentesco, String telefone) {
		Recado recado = new Recado();
		recado.setNome(nome);
		recado.setParentesco(parentesco);
		recado.setTelefone(telefone);
		recadoRepo.save(recado);
		return recado;
	}

	@Override
	@Transactional
	public void updateRecadoNome(String nomeAntigo, String nomeNovo) {
		Recado recado = recadoRepo.findByNome(nomeAntigo);

		if (recado != null) {
			recado.setNome(nomeNovo);
			recadoRepo.save(recado);
		}
	}

	@Override
	@Transactional
	public void updateRecadoParentesco(String nome, String parentescoNovo) {
		Recado recado = recadoRepo.findByNome(nome);

		if (recado != null) {
			recado.setParentesco(parentescoNovo);
			recadoRepo.save(recado);
		}
	}

	@Override
	@Transactional
	public void updateRecadoTelefone(String telefoneAntigo, String telefoneNovo) {
		Recado recado = recadoRepo.findByTelefone(telefoneAntigo);

		if (recado != null) {
			recado.setTelefone(telefoneNovo);
			recadoRepo.save(recado);
		}

	}

	@Override
	@Transactional
	public void deleteRecado(Long id) {
		recadoRepo.deleteById(id);
	}

}
