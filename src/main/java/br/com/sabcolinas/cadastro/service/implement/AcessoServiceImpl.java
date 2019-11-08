package br.com.sabcolinas.cadastro.service.implement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Acesso;
import br.com.sabcolinas.cadastro.repository.AcessoRepository;
import br.com.sabcolinas.cadastro.service.AcessoService;

@Service("acessoService")
public class AcessoServiceImpl implements AcessoService {

	@Autowired
	private AcessoRepository acessoRepo;

	public AcessoRepository getAcessoRepo() {
		return acessoRepo;
	}

	public void setAcessoRepo(AcessoRepository acessoRepo) {
		this.acessoRepo = acessoRepo;
	}

	@Override
	@Transactional
	public Acesso createAcesso(Date dataInicio, Date dataTermino) {

		if ((dataInicio != null) && (dataTermino != null) && (dataInicio.before(dataTermino))) {
			Acesso acesso = new Acesso();
			acesso.setDataInicio(dataInicio);
			acesso.setDataTermino(dataTermino);
			acessoRepo.save(acesso);
			return acesso;
		}
		return null;
	}

	@Override
	@Transactional
	public void updateAcessoInicio(Date dataInicioAntigo, Date dataInicioNovo) {
		Acesso acesso = acessoRepo.findByDataInicio(dataInicioAntigo);

		if (acesso != null) {
			acesso.setDataInicio(dataInicioNovo);
			acessoRepo.save(acesso);
		}
	}

	@Override
	@Transactional
	public void updateAcessoTermino(Date dataTerminoAntigo, Date dataTerminoNovo) {
		Acesso acesso = acessoRepo.findByDataTermino(dataTerminoAntigo);

		if (acesso != null) {
			acesso.setDataInicio(dataTerminoNovo);
			acessoRepo.save(acesso);
		}
	}

	@Override
	@Transactional
	public void deleteAcesso(Long id) {
		acessoRepo.deleteById(id);
	}

}
