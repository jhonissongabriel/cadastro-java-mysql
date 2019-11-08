package br.com.sabcolinas.cadastro.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Trabalho;
import br.com.sabcolinas.cadastro.repository.TrabalhoRepository;
import br.com.sabcolinas.cadastro.service.TrabalhoService;

@Service("trabalhoService")
public class TrabalhoServiceImpl implements TrabalhoService {

	@Autowired
	private TrabalhoRepository trabalhoRepo;

	public void setTrabalhoRepo(TrabalhoRepository trabalhoRepo) {
		this.trabalhoRepo = trabalhoRepo;
	}

	@Override
	@Transactional
	public Trabalho createTrabalho(String empresa, String profissao, String telefone) {
		Trabalho trabalho = trabalhoRepo.buscaEmpresaProfissao(empresa, profissao);

		if (trabalho == null) {
			trabalho = new Trabalho();
			trabalho.setEmpresa(empresa);
			trabalho.setProfissao(profissao);
			trabalho.setTelefone(telefone);
			trabalhoRepo.save(trabalho);
			return trabalho;
		}
		return null;

	}

	@Override
	@Transactional
	public void updateTrabalhoEmpresa(String empresaAntigo, String empresaNovo) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void updateTrabalhoProfissao(String profissaoAntigo, String profissaoNovo) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void updateTrabalhoTelefone(String telefoneAntigo, String telefoneNovo) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void deleteTrabalho(Long is) {
		// TODO Auto-generated method stub

	}

}
