package br.com.sabcolinas.cadastro.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Conjuge;
import br.com.sabcolinas.cadastro.model.Pessoa;
import br.com.sabcolinas.cadastro.model.Trabalho;
import br.com.sabcolinas.cadastro.repository.ConjugeRepository;
import br.com.sabcolinas.cadastro.repository.PessoaRepository;
import br.com.sabcolinas.cadastro.repository.TrabalhoRepository;
import br.com.sabcolinas.cadastro.service.ConjugeService;

@Service("conjugeService")
public class ConjugeServiceImpl implements ConjugeService {

	@Autowired
	private ConjugeRepository conjugeRepo;

	@Autowired
	private PessoaRepository pessoaRepo;

	@Autowired
	private TrabalhoRepository trabalhoRepo;

	public void setConjugeRepo(ConjugeRepository conjugeRepo) {
		this.conjugeRepo = conjugeRepo;
	}

	public void setPessoaRepo(PessoaRepository pessoaRepo) {
		this.pessoaRepo = pessoaRepo;
	}

	public void setTrabalhoRepo(TrabalhoRepository trabalhoRepo) {
		this.trabalhoRepo = trabalhoRepo;
	}

	@Override
	@Transactional
	public Conjuge createConjuge(String nome, String empresa, String profissao) {
		Pessoa pessoa = pessoaRepo.findByNome(nome);

		if (pessoa != null) {
			Conjuge conjuge = new Conjuge();
			conjuge.setPessoa(pessoa);

			if ((empresa != null) && (profissao != null)) {
				Trabalho trabalho = trabalhoRepo.buscaEmpresaProfissao(empresa, profissao);

				if (trabalho != null) {
					conjuge.setTrabalho(trabalho);
					conjugeRepo.save(conjuge);
					return conjuge;
				}
			}

			conjugeRepo.save(conjuge);
			return conjuge;
		}

		return null;
	}

	@Override
	@Transactional
	public void deleteConjugeRg(String rgConjuge) {
		Pessoa conj = pessoaRepo.buscaRg(rgConjuge);
		Optional<Conjuge> conjugeOpt = conjugeRepo.findById(conj.getId());
		Conjuge conjuge = (conjugeOpt.isPresent()) ? conjugeOpt.get() : null;

		if (conjuge != null) {
			conjugeRepo.delete(conjuge);
		}

	}

	@Override
	@Transactional
	public void deleteConjuge(Long id) {
		conjugeRepo.deleteById(id);

	}

}
