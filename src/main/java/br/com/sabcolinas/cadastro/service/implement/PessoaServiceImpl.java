package br.com.sabcolinas.cadastro.service.implement;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Acesso;
import br.com.sabcolinas.cadastro.model.Pessoa;
import br.com.sabcolinas.cadastro.repository.AcessoRepository;
import br.com.sabcolinas.cadastro.repository.PessoaRepository;
import br.com.sabcolinas.cadastro.service.PessoaService;

@Service("pessoaService")
public class PessoaServiceImpl implements PessoaService {

	@Autowired
	private PessoaRepository pessoaRepo;

	@Autowired
	private AcessoRepository acessoRepo;

	public void setPessoaRepo(PessoaRepository pessoaRepo) {
		this.pessoaRepo = pessoaRepo;
	}

	public void setAcessoRepo(AcessoRepository acessoRepo) {
		this.acessoRepo = acessoRepo;
	}

	@Override
	@Transactional
	public Pessoa createPessoa(String nome, Date dataNasc, String cpf, String rg, String docEmissor, Date acessoInicio,
			Date acessoTermino) {
		Pessoa pessoa = pessoaRepo.findByCpf(cpf);

		if (pessoa == null) {
			Acesso acesso = acessoRepo.buscaDataInicioTermino(acessoInicio, acessoTermino);
			pessoa = new Pessoa();
			pessoa.setNome(nome);
			pessoa.setDataNasc(dataNasc);
			pessoa.setCpf(cpf);
			pessoa.setRg(rg);
			pessoa.setDocEmissor(docEmissor);
			
			if (acesso != null) {
				pessoa.setAcesso(acesso);
				pessoaRepo.save(pessoa);
				return pessoa;
			}
			pessoaRepo.save(pessoa);
			return pessoa;
		}
		return null;
	}

	@Override
	@Transactional
	public void updatePessoaNome(String nomeAntigo, String nomeNovo) {
		Pessoa pessoa = pessoaRepo.findByNome(nomeAntigo);

		if (pessoa != null) {
			pessoa.setNome(nomeNovo);
			pessoaRepo.save(pessoa);
		}
	}

	@Override
	@Transactional
	public void updatePessoaDataNasc(Date dataNascAntigo, Date dataNascNovo) {
		Pessoa pessoa = pessoaRepo.findByDataNasc(dataNascAntigo);

		if (pessoa != null) {
			pessoa.setDataNasc(dataNascNovo);
			pessoaRepo.save(pessoa);
		}
	}

	@Override
	@Transactional
	public void updatePessoaCpf(String cpfAntigo, String cpfNovo) {
		Pessoa pessoa = pessoaRepo.findByCpf(cpfAntigo);

		if (pessoa != null) {
			pessoa.setCpf(cpfNovo);
			pessoaRepo.save(pessoa);
		}
	}

	@Override
	@Transactional
	public void updatePessoaRg(String rgAntigo, String rgNovo) {
		Pessoa pessoa = pessoaRepo.findByRg(rgAntigo);

		if (pessoa != null) {
			pessoa.setRg(rgNovo);
			pessoaRepo.save(pessoa);
		}
	}

	@Override
	@Transactional
	public void updatePessoaDocEmissor(String docEmissorAntigo, String docEmissorNovo) {
		Pessoa pessoa = pessoaRepo.findByDocEmissor(docEmissorAntigo);

		if (pessoa != null) {
			pessoa.setDocEmissor(docEmissorNovo);
			pessoaRepo.save(pessoa);
		}
	}

	@Override
	@Transactional
	public void deletePessoaCpf(String cpf) {
		Pessoa pessoa = pessoaRepo.findByCpf(cpf);

		if (pessoa != null) {
			pessoaRepo.delete(pessoa);
		}
	}

	@Override
	@Transactional
	public void deletePessoaRg(String rg) {
		Pessoa pessoa = pessoaRepo.findByRg(rg);

		if (pessoa != null) {
			pessoaRepo.delete(pessoa);
		}
	}

	@Override
	@Transactional
	public void deletePessoa(Long id) {
		pessoaRepo.deleteById(id);
	}

}
