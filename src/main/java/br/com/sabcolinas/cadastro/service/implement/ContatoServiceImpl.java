package br.com.sabcolinas.cadastro.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Contato;
import br.com.sabcolinas.cadastro.repository.ContatoRepository;
import br.com.sabcolinas.cadastro.service.ContatoService;

@Service("contatoService")
public class ContatoServiceImpl implements ContatoService {

	@Autowired
	private ContatoRepository contatoRepo;

	public void setContatoRepo(ContatoRepository contatoRepo) {
		this.contatoRepo = contatoRepo;
	}

	@Override
	@Transactional
	public Contato createContato(String telefone1, String telefone2, String email) {
		Contato contato = new Contato();
		contato.setTelefone1(telefone1);
		contato.setTelefone2(telefone2);
		contato.setEmail(email);
		contatoRepo.save(contato);
		return contato;
	}

	@Override
	@Transactional
	public void updateContatoTelefone1(String telefone1Antigo, String telefone1Novo) {
		Contato contato = contatoRepo.findByTelefone1(telefone1Antigo);

		if (contato != null) {
			contato.setTelefone1(telefone1Novo);
			contatoRepo.save(contato);
		}

	}

	@Override
	@Transactional
	public void updateContatoTelefone2(String telefone2Antigo, String telefone2Novo) {
		Contato contato = contatoRepo.findByTelefone2(telefone2Antigo);

		if (contato != null) {
			contato.setTelefone2(telefone2Novo);
			contatoRepo.save(contato);
		}
	}

	@Override
	@Transactional
	public void updateContatoEmail(String emailAntigo, String emailNovo) {
		Contato contato = contatoRepo.findByEmail(emailAntigo);

		if (contato != null) {
			contato.setEmail(emailNovo);
			contatoRepo.save(contato);
		}
	}

	@Override
	@Transactional
	public void deleteContato(Long id) {
		contatoRepo.deleteById(id);
	}

}
