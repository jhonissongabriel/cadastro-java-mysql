package br.com.sabcolinas.cadastro.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Locacao;
import br.com.sabcolinas.cadastro.repository.LocacaoRepository;
import br.com.sabcolinas.cadastro.service.LocacaoService;

@Service("locacaoService")
@Transactional
public class LocacaoServiceImpl implements LocacaoService {

	@Autowired
	private LocacaoRepository locacaoRepo;

	public void setLocacaoRepo(LocacaoRepository locacaoRepo) {
		this.locacaoRepo = locacaoRepo;
	}

	@Override
	public Locacao create(Locacao locacao) {
		return locacaoRepo.save(locacao);
	}

	@Override
	public void delete(Long id) {
		locacaoRepo.deleteById(id);
	}

	@Override
	public void updateNome(String nomeAntigo, String nomeNovo) {
		Locacao locacao = locacaoRepo.findByNome(nomeAntigo);
		if (locacao != null) {
			locacao.setNome(nomeNovo);
			locacaoRepo.save(locacao);
		}

	}

	@Override
	public void updateTelefone(String telefoneAntigo, String telefoneNovo) {
		Locacao locacao = locacaoRepo.findByTelefone(telefoneAntigo);
		if (locacao != null) {
			locacao.setTelefone(telefoneNovo);
			locacaoRepo.save(locacao);
		}
	}

	@Override
	public void updateDataInicio(String dataInicioAntigo, String dataInicioNovo) {
		Locacao locacao = locacaoRepo.findByDataInicio(dataInicioAntigo);
		if (locacao != null) {
			locacao.setDataInicio(dataInicioNovo);
			locacaoRepo.save(locacao);
		}
	}

	@Override
	public void updateDataTermino(String dataTerminoAntigo, String dataTerminoNovo) {
		Locacao locacao = locacaoRepo.findByDataTermino(dataTerminoAntigo);
		if (locacao != null) {
			locacao.setDataTermino(dataTerminoNovo);
			locacaoRepo.save(locacao);
		}
	}

	@Override
	public List<Locacao> todos() {
		List<Locacao> retorno = new ArrayList<Locacao>();
		for (Locacao locacao : locacaoRepo.findAll()) {
			retorno.add(locacao);
		}
		return retorno;
	}

	@Override
	public Locacao buscarId(Long id) {
		Optional<Locacao> locacao = locacaoRepo.findById(id);
		if (locacao.isPresent()) {
			return locacao.get();
		}
		return null;
	}

	@Override
	public List<Locacao> buscarNome(String nome) {
		List<Locacao> retorno = new ArrayList<Locacao>();
		for (Locacao locacao : locacaoRepo.findByNomeContains(nome)) {
			retorno.add(locacao);
		}
		return retorno;
	}

	@Override
	public List<Locacao> buscarTelefone(String telefone) {
		List<Locacao> retorno = new ArrayList<Locacao>();
		for (Locacao locacao : locacaoRepo.findByTelefoneContains(telefone)) {
			retorno.add(locacao);
		}
		return retorno;
	}

	@Override
	public List<Locacao> buscarDataInicio(String dataInicio) {
		List<Locacao> retorno = new ArrayList<Locacao>();
		for (Locacao locacao : locacaoRepo.findByDataInicioContains(dataInicio)) {
			retorno.add(locacao);
		}
		return retorno;
	}

	@Override
	public List<Locacao> buscarDataTermino(String dataTermino) {
		List<Locacao> retorno = new ArrayList<Locacao>();
		for (Locacao locacao : locacaoRepo.findByDataTerminoContains(dataTermino)) {
			retorno.add(locacao);
		}
		return retorno;
	}

}
