package br.com.sabcolinas.cadastro.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Pessoa;
import br.com.sabcolinas.cadastro.repository.PessoaRepository;
import br.com.sabcolinas.cadastro.service.PessoaService;

@Service("pessoaService")
@Transactional
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepo;

	public void setPessoaRepo(PessoaRepository pessoaRepo) {
		this.pessoaRepo = pessoaRepo;
	}

	@Override
	public Pessoa create(Pessoa pessoa) {
		return pessoaRepo.save(pessoa);
	}

	@Override
	public void delete(Long id) {
		pessoaRepo.deleteById(id);
	}

	@Override
	public void updateNome(String nomeAntigo, String nomeNovo) {
		Pessoa pessoa = pessoaRepo.findByNome(nomeAntigo);
		if (pessoa != null) {
			pessoa.setNome(nomeNovo);
			pessoaRepo.save(pessoa);
		}
	}

	@Override
	public void updateCpf(String cpfAntigo, String cpfNovo) {
		Pessoa pessoa = pessoaRepo.findByCpf(cpfAntigo);
		if (pessoa != null) {
			pessoa.setCpf(cpfNovo);
			pessoaRepo.save(pessoa);
		}
	}

	@Override
	public void updateRg(String rgAntigo, String rgNovo) {
		Pessoa pessoa = pessoaRepo.findByRg(rgAntigo);
		if (pessoa != null) {
			pessoa.setRg(rgNovo);
			pessoaRepo.save(pessoa);
		}
	}

	@Override
	public void updateDataNasc(String dataNascAntigo, String dataNascNovo) {
		Pessoa pessoa = pessoaRepo.findByDataNasc(dataNascAntigo);
		if (pessoa != null) {
			pessoa.setDataNasc(dataNascNovo);
			pessoaRepo.save(pessoa);
		}
	}

	@Override
	public List<Pessoa> todos() {
		List<Pessoa> retorno = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoaRepo.findAll()) {
			retorno.add(pessoa);
		}
		return retorno;
	}

	@Override
	public Pessoa buscarId(Long id) {
		Optional<Pessoa> pessoa = pessoaRepo.findById(id);
		if (pessoa.isPresent()) {
			return pessoa.get();
		}
		return null;
	}

	@Override
	public List<Pessoa> buscarNome(String nome) {
		List<Pessoa> retorno = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoaRepo.findByNomeContains(nome)) {
			retorno.add(pessoa);
		}
		return retorno;
	}

	@Override
	public List<Pessoa> buscarCpf(String cpf) {
		List<Pessoa> retorno = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoaRepo.findByCpfContains(cpf)) {
			retorno.add(pessoa);
		}
		return retorno;
	}

	@Override
	public List<Pessoa> buscarRg(String rg) {
		List<Pessoa> retorno = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoaRepo.findByRgContains(rg)) {
			retorno.add(pessoa);
		}
		return retorno;
	}

	@Override
	public List<Pessoa> buscarDataNasc(String dataNasc) {
		List<Pessoa> retorno = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoaRepo.findByDataNascContains(dataNasc)) {
			retorno.add(pessoa);
		}
		return retorno;
	}

}
