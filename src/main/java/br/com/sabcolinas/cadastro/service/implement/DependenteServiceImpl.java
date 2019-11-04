package br.com.sabcolinas.cadastro.service.implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Dependente;
import br.com.sabcolinas.cadastro.model.Pessoa;
import br.com.sabcolinas.cadastro.repository.DependenteRepository;
import br.com.sabcolinas.cadastro.repository.PessoaRepository;
import br.com.sabcolinas.cadastro.service.DependenteService;

@Service("dependenteService")
public class DependenteServiceImpl implements DependenteService {

	@Autowired
	private DependenteRepository dependenteRepo;

	@Autowired
	private PessoaRepository pessoaRepo;

	public void setDependenteRepo(DependenteRepository dependenteRepo) {
		this.dependenteRepo = dependenteRepo;
	}

	public void setPessoaRepo(PessoaRepository pessoaRepo) {
		this.pessoaRepo = pessoaRepo;
	}

	@Override
	@Transactional
	public Dependente createDependente(String rg, String parentesco) {
		Pessoa pessoa = pessoaRepo.findByRg(rg);
		
		if(pessoa != null) {
			Dependente dependente = new Dependente();
			dependente.setPessoa(pessoa);
			dependente.setParentesco(parentesco);
			dependenteRepo.save(dependente);
			return dependente;
		}
		return null;
	}

	@Override
	@Transactional
	public void updateDependenteParentesco(String parentescoAntigo, String parentescoNovo) {
		Dependente dependente = dependenteRepo.findByParentesco(parentescoAntigo);
		
		if(dependente != null) {
			dependente.setParentesco(parentescoNovo);
			dependenteRepo.save(dependente);
		}
	}

	@Override
	@Transactional
	public Optional<Dependente> deleteDependente(Long id) {
		Optional<Dependente> dependente = dependenteRepo.findById(id);
		
		if(dependente != null) {
			dependenteRepo.deleteById(id);
			return dependente;
		}
		return null;
	}

}
