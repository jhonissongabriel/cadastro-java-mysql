package br.com.sabcolinas.cadastro.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sabcolinas.cadastro.model.Empresa;
import br.com.sabcolinas.cadastro.model.Pessoa;
import br.com.sabcolinas.cadastro.model.PrestadorServico;
import br.com.sabcolinas.cadastro.repository.EmpresaRepository;
import br.com.sabcolinas.cadastro.repository.PessoaRepository;
import br.com.sabcolinas.cadastro.repository.PrestadorServicoRepository;
import br.com.sabcolinas.cadastro.service.PrestadorServicoService;

@Service("prestadorServicoService")
public class PrestadorServicoServiceImpl implements PrestadorServicoService {

	@Autowired
	private PrestadorServicoRepository prestadorServicoRepo;

	@Autowired
	private PessoaRepository pessoaRepo;

	@Autowired
	private EmpresaRepository empresaRepo;

	public void setPrestadorServicoRepo(PrestadorServicoRepository prestadorServicoRepo) {
		this.prestadorServicoRepo = prestadorServicoRepo;
	}

	public void setPessoaRepo(PessoaRepository pessoaRepo) {
		this.pessoaRepo = pessoaRepo;
	}

	public void setEmpresaRepo(EmpresaRepository empresaRepo) {
		this.empresaRepo = empresaRepo;
	}

	@Override
	@Transactional
	public PrestadorServico createPrestadorServico(String cpf, String cnpj) {
		Pessoa pessoa = pessoaRepo.findByCpf(cpf);

		if (pessoa != null) {
			PrestadorServico prestadorServico = new PrestadorServico();
			prestadorServico.setPessoa(pessoa);
			Empresa empresa = empresaRepo.findByCnpj(cnpj);

			if (empresa != null) {
				prestadorServico.setEmpresa(empresa);
				prestadorServicoRepo.save(prestadorServico);
				return prestadorServico;
			}
			prestadorServicoRepo.save(prestadorServico);
			return prestadorServico;
		}
		return null;
	}

	@Override
	@Transactional
	public void deletePrestadorServico(Long id) {
		prestadorServicoRepo.deleteById(id);
	}

}
