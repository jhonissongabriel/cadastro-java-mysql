package br.com.sabcolinas.cadastro.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Contato;
import br.com.sabcolinas.cadastro.repository.ContatoRepository;
import br.com.sabcolinas.cadastro.service.ContatoService;

@Service("contatoService")
@Transactional
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepository contatoRepo;

	public void setContatoRepo(ContatoRepository contatoRepo) {
		this.contatoRepo = contatoRepo;
	}

	@Override
	public Contato create(Contato contato) {
		return contatoRepo.save(contato);
	}

	@Override
	public void delete(Long id) {
		contatoRepo.deleteById(id);
	}

	@Override
	public void updateTelefone1(String telefone1Antigo, String telefone1Novo) {
		Contato contato = contatoRepo.findByTelefone1(telefone1Antigo);
		if (contato != null) {
			contato.setTelefone1(telefone1Novo);
			contatoRepo.save(contato);
		}
	}

	@Override
	public void updateTelefone2(String telefone2Antigo, String telefone2Novo) {
		Contato contato = contatoRepo.findByTelefone2(telefone2Antigo);
		if (contato != null) {
			contato.setTelefone2(telefone2Novo);
			contatoRepo.save(contato);
		}
	}

	@Override
	public void updateEmail(String emailAntigo, String emailNovo) {
		Contato contato = contatoRepo.findByEmail(emailAntigo);
		if (contato != null) {
			contato.setEmail(emailNovo);
			contatoRepo.save(contato);
		}
	}

	@Override
	public List<Contato> todos() {
		List<Contato> retorno = new ArrayList<Contato>();
		for (Contato contato : contatoRepo.findAll()) {
			retorno.add(contato);
		}
		return retorno;
	}

	@Override
	public Contato buscarId(Long id) {
		Optional<Contato> contato = contatoRepo.findById(id);
		if (contato.isPresent()) {
			return contato.get();
		}
		return null;
	}

	@Override
	public List<Contato> buscarTelefone(String telefone) {
		List<Contato> retorno = new ArrayList<Contato>();
		for (Contato contato1 : contatoRepo.findByTelefone1Contains(telefone)) {
			if (contato1 == null) {
				for (Contato contato2 : contatoRepo.findByTelefone2Contains(telefone)) {
					retorno.add(contato2);
				}
			}
			retorno.add(contato1);
		}
		return retorno;
	}

	@Override
	public List<Contato> buscarEmail(String email) {
		List<Contato> retorno = new ArrayList<Contato>();
		for (Contato contato : contatoRepo.findByEmailContains(email)) {
			retorno.add(contato);
		}
		return retorno;
	}

}
